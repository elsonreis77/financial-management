package com.financial.management.controller;

import com.financial.management.domain.Revenue;
import com.financial.management.dto.request.RevenueRequest;
import com.financial.management.dto.response.RevenueResponse;
import com.financial.management.service.RevenueService;
import jakarta.annotation.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/revenue")
@CrossOrigin
public class RevenueController {

    private final RevenueService service;

    public RevenueController(RevenueService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Revenue> createRevenue(@RequestBody RevenueRequest revenueRequest){
        Revenue revenue = service.createRevenue(revenueRequest);
        return ResponseEntity.status(201).body(revenue);
    }

    @GetMapping
    public ResponseEntity<List<RevenueResponse>> findAll() {
        List<RevenueResponse> revenues = service.findAll();
        return ResponseEntity.ok(revenues);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RevenueResponse> findById(@PathVariable Long id) {
        RevenueResponse revenue = service.findById(id);
        return ResponseEntity.ok(revenue);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Revenue> updateRevenue(@PathVariable Long id, @RequestBody RevenueRequest request) {
        Revenue updateRevenue = service.updateRevenue(id, request);
        return ResponseEntity.ok(updateRevenue);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRevenue(@PathVariable Long id) {
        service.deleteRevenue(id);
        return ResponseEntity.ok("Deletado com sucesso!");
    }

}
