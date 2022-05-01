package com.example.demo.repository;

import com.example.demo.entity.THUONG_HIEU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import javax.persistence.Column;
import javax.transaction.Transactional;

public interface ThuongHieuRepository extends JpaRepository<THUONG_HIEU, String> {
    @Modifying
    @Transactional
    @Query("UPDATE THUONG_HIEU t SET t.tenThuongHieu =:tenThuongHieu  WHERE t.maThuongHieu=:maThuongHieu")
    void editByMa(@Param("maThuongHieu") String maThuongHieu, @Param("tenThuongHieu") String tenThuongHieu);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO THUONG_HIEU (MA_THUONG_HIEU, TEN_THUONG_HIEU ) VALUES  (:maThuongHieu, :tenThuongHieu)",nativeQuery = true)
    void insert(@Param("maThuongHieu") String ma, @Param("tenThuongHieu") String ten);

    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM THUONG_HIEU t WHERE t.MA_THUONG_HIEU=:id", nativeQuery = true)
    List<THUONG_HIEU> selectbyID(@Param("id") String id);
}
