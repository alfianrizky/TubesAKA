package com.example.roti.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class RotiService {
    
    // Model untuk menyimpan data perbandingan
    public static class AlgorithmComparison {
        private int n;
        private long iterativeTime;
        private long recursiveTime;
        
        public AlgorithmComparison(int n, long iterativeTime, long recursiveTime) {
            this.n = n;
            this.iterativeTime = iterativeTime;
            this.recursiveTime = recursiveTime;
        }
        
        // Getters
        public int getN() { return n; }
        public long getIterativeTime() { return iterativeTime; }
        public long getRecursiveTime() { return recursiveTime; }
    }

    // Faktorial Iteratif
    public long factorialIterative(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Faktorial Rekursif
    public long factorialRecursive(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorialRecursive(n - 1);
    }

    // Mengukur waktu eksekusi
    public long measureExecutionTime(String method, int n) {
        long startTime = System.nanoTime();
        if (method.equals("iterative")) {
            factorialIterative(n);
        } else if (method.equals("recursive")) {
            factorialRecursive(n);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Generate data perbandingan untuk grafik
    public List<AlgorithmComparison> generateComparisonData(int maxN) {
        List<AlgorithmComparison> comparisons = new ArrayList<>();
        for (int i = 1; i <= maxN; i++) {
            long iterativeTime = measureExecutionTime("iterative", i);
            long recursiveTime = measureExecutionTime("recursive", i);
            comparisons.add(new AlgorithmComparison(i, iterativeTime, recursiveTime));
        }
        return comparisons;
    }
}
