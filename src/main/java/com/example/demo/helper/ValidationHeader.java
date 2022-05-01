package com.example.demo.helper;

import java.util.Map;


import com.example.demo.entity.ROLE;
import io.jsonwebtoken.Claims;

public class ValidationHeader {
	
	public static Boolean IsAdmin(Map<String, String> headers) {
		return IsAdmin(GetInforRequest(headers));
	}

	public static Boolean IsAdmin(ROLE request) {

		if (request != null && request.getTenQuyen().contains("ADMIN")) {
			return true;
		}

		return false;
	}

	public static Boolean IsUser(Map<String, String> headers) {
		return IsUser(GetInforRequest(headers));
	}

	public static Boolean IsUser(ROLE request) {

		if (request != null && request.getTenQuyen().contains("USER")) {
			return true;
		}

		return false;
	}

	public static ROLE GetInforRequest(Map<String, String> headers) {

		if (headers.containsKey("authorization")) {
			String value = headers.get("authorization");
			String token = value.replace("Bearer ", "");
			System.out.println(token);
			if (!JwtTokenProvider.validateToken(token)) {
				return null;
			}

			Claims claims = JwtTokenProvider.getClaims(token);

			if (claims == null) {
				return null;
			}

			String roles = claims != null && claims.get("roles") != null ? claims.get("roles").toString() : "";
			String userid = claims != null && claims.get("userid") != null ? claims.get("userid").toString() : "";

			ROLE infor = new ROLE();
			infor.setMaQuyen(roles);
			infor.setTenQuyen(userid);
			return infor;
		}

		return null;
	}
}
