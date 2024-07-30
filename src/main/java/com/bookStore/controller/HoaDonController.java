/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookStore.controller;

/**
 *
 * @author DUC
 */
import org.springframework.ui.Model;
import com.bookStore.entity.ChiTietHoaDon;
import com.bookStore.entity.HoaDon;
import com.bookStore.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/hoaDon")
public class HoaDonController {
    @Autowired
    private HoaDonService hoaDonService;

    @PostMapping("/checkout")
    public ResponseEntity<Void> checkout(@RequestBody List<ChiTietHoaDon> chiTietHoaDons) {
        BigDecimal totalAmount = chiTietHoaDons.stream()
            .map(detail -> detail.getPrice().multiply(new BigDecimal(detail.getQuantity())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        hoaDonService.createHoaDon(chiTietHoaDons, totalAmount);
        return ResponseEntity.ok().build();
    }
      @GetMapping("/hoa_don")
        public String getAllHoaDon(Model model) {
        List<HoaDon> hoaDonList = hoaDonService.getAllHoaDon();
        model.addAttribute("hoaDonList", hoaDonList);
        return "chitiethoadon"; // Trả về view hiển thị tất cả các hóa đơn
    }

}
