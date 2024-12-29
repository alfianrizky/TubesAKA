package com.platenomor.controller;

import com.platenomor.service.PlateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlateController {

    @Autowired
    private PlateService platNomorService;

    @PostMapping("/search")
    public String searchPlatNomor(@RequestParam("platNomor") String platNomor, Model model) {
        // Memanggil service untuk mendapatkan hasil pencarian dan waktu
        String namaDaerah = platNomorService.cariNamaDaerah(platNomor);
        long waktuIteratif = platNomorService.perhitunganIteratif(platNomor);
        long waktuRekursif = platNomorService.perhitunganRekursif(platNomor);

        // Menambahkan data yang akan digunakan di HTML (result.html)
        model.addAttribute("platNomor", platNomor);
        model.addAttribute("namaDaerah", namaDaerah);
        model.addAttribute("waktuIteratif", waktuIteratif);
        model.addAttribute("waktuRekursif", waktuRekursif);
        model.addAttribute("waktuIteratifChart", waktuIteratif);  // Pastikan model ini ada
        model.addAttribute("waktuRekursifChart", waktuRekursif);  // Pastikan model ini ada

        return "result";  // Menampilkan template result.html
    }
}
