package com.platenomor.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PlateService {

    private static final Map<String, String> platKeDaerah;

    static {
        platKeDaerah = new HashMap<>();
        
        // Menambahkan data plat nomor Indonesia
        platKeDaerah.put("AB", "Banda Aceh");
        platKeDaerah.put("BA", "Bali");
        platKeDaerah.put("B", "Jakarta");
        platKeDaerah.put("D", "Bandung");
        platKeDaerah.put("E", "Medan");
        platKeDaerah.put("F", "Bogor");
        platKeDaerah.put("G", "Makassar");
        platKeDaerah.put("H", "Surabaya");
        platKeDaerah.put("I", "Palembang");
        platKeDaerah.put("J", "Malang");
        platKeDaerah.put("K", "Yogyakarta");
        platKeDaerah.put("L", "Pontianak");
        platKeDaerah.put("M", "Denpasar");
        platKeDaerah.put("N", "Padang");
        platKeDaerah.put("P", "Medan");
        platKeDaerah.put("R", "Aceh");
        platKeDaerah.put("S", "Semarang");
        platKeDaerah.put("T", "Bandung");
        platKeDaerah.put("U", "Jakarta");
        platKeDaerah.put("V", "Bengkulu");
        platKeDaerah.put("W", "Sulawesi Selatan");
        platKeDaerah.put("X", "Nusa Tenggara");
        platKeDaerah.put("Y", "Aceh");
        platKeDaerah.put("BK", "Medan");
        platKeDaerah.put("Z", "Sumbawa");
        platKeDaerah.put("BP", "Kepulauan Riau");
        // Tambahkan semua data plat nomor lainnya sesuai kebutuhan...
    }

    public String cariNamaDaerah(String platNomor) {
        return platKeDaerah.getOrDefault(platNomor, "Daerah tidak ditemukan");
    }

    public long perhitunganIteratif(String platNomor) {
        // Pencarian iteratif menggunakan while
        long startTime = System.nanoTime();
        var iterator = platKeDaerah.keySet().iterator();
        while (iterator.hasNext()) {
            String plat = iterator.next();
            if (plat.equals(platNomor)) {
                break;
            }
        }
        return System.nanoTime() - startTime;
    }

    public long perhitunganRekursif(String platNomor) {
        String[] platArray = platKeDaerah.keySet().toArray(new String[0]);
        return perhitunganRekursifHelper(platNomor, 0, platArray);
    }
    
    private long perhitunganRekursifHelper(String platNomor, int index, String[] platArray) {
        long startTime = System.nanoTime();
        if (index < platArray.length) {
            if (platArray[index].equals(platNomor)) {
                return System.nanoTime() - startTime;
            } else {
                return perhitunganRekursifHelper(platNomor, index + 1, platArray);
            }
        }
        return System.nanoTime() - startTime;
    }
}
