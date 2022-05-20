package com.example.demo.helper;

public class ApiResponse<T> {

	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRole(){
		return role;
	}
	public void setRole(String role){
		this.role = role;
	}

	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

	public ApiResponse(boolean success, String message, String role, T data) {
		super();
		this.success = success;
		this.message = message;
		this.role = role;
		this.data = data;
	}

	public ApiResponse(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	private boolean success;
	private String message;
	private String role;
	private T data;
}






//package com.example.demo.helper;
//
//public class ApiResponse<T> {
//
//	public boolean isSuccess() {
//		return success;
//	}
//	public void setSuccess(boolean success) {
//		this.success = success;
//	}
//	public String getMessage() {
//		return message;
//	}
//	public void setMessage(String message) {
//		this.message = message;
//	}
//	public T getData() {
//		return data;
//	}
//	public void setData(T data) {
//		this.data = data;
//	}
//
//	public ApiResponse(boolean success, String message, T data) {
//		super();
//		this.success = success;
//		this.message = message;
//		this.data = data;
//	}
//
//	public ApiResponse(boolean success, String message) {
//		super();
//		this.success = success;
//		this.message = message;
//	}
//
//	private boolean success;
//	private String message;
//	private T data;
//}
