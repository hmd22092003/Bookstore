/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookStore.controller;

/**
 *
 * @author admin
 */
import com.bookStore.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TotalPriceController {

    private final BookService bookService;

    public TotalPriceController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/totalPrice")
    public String getTotalPrice(Model model) {
        double totalPrice = bookService.calculateTotalPrice();
        model.addAttribute("totalPrice", totalPrice);
        return "totalPricePage";
    }
}

