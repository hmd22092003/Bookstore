package com.bookStore.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bookStore.entity.HoaDon;


@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Long> {
    HoaDon findById(long id);
}
