package com.bookStore.service;

import com.bookStore.entity.ChiTietHoaDon;
import com.bookStore.entity.HoaDon;
import com.bookStore.repository.HoaDonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class HoaDonService {

    @Autowired
    private HoaDonRepository hoaDonRepository;
    public HoaDon createHoaDon(List<ChiTietHoaDon> chiTietHoaDonList, BigDecimal totalAmount) {
        HoaDon hoaDon = new HoaDon();
        hoaDon.setTotalAmount(totalAmount);
        hoaDon.setCreatedAt(LocalDateTime.now());
        hoaDon.setInvoiceDetails(chiTietHoaDonList);
        chiTietHoaDonList.forEach(detail -> detail.setHoaDon(hoaDon));
        return hoaDonRepository.save(hoaDon);
    }

    public List<HoaDon> getAllHoaDon() {
        return hoaDonRepository.findAll();
    }
    
}
