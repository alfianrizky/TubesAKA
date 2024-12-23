package com.example.roti.controller;

import com.example.roti.service.RotiService;
import com.example.roti.service.RotiService.AlgorithmComparison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class RotiController {

    @Autowired
    private RotiService rotiService;

    @GetMapping("/")
    public String inputPage() {
        return "input";
    }

    @PostMapping("/calculate")
    public String calculate(
        @RequestParam("jumlahRoti") int jumlahRoti,
        @RequestParam("metode") String metode,
        Model model
    ) {
        // Hitung hasil faktorial
        long hasil = 0;
        if (metode.equals("iterative")) {
            hasil = rotiService.factorialIterative(jumlahRoti);
        } else if (metode.equals("recursive")) {
            hasil = rotiService.factorialRecursive(jumlahRoti);
        }

        // Ukur waktu eksekusi
        long waktuIterative = rotiService.measureExecutionTime("iterative", jumlahRoti);
        long waktuRecursive = rotiService.measureExecutionTime("recursive", jumlahRoti);

        // Generate data perbandingan untuk grafik
        List<AlgorithmComparison> comparisonData = rotiService.generateComparisonData(jumlahRoti);

        model.addAttribute("jumlahRoti", jumlahRoti);
        model.addAttribute("metode", metode);
        model.addAttribute("hasil", hasil);
        model.addAttribute("waktuIterative", waktuIterative);
        model.addAttribute("waktuRecursive", waktuRecursive);
        model.addAttribute("comparisonData", comparisonData);

        return "result";
    }
}