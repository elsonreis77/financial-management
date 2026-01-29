package com.financial.management.controller;

import com.financial.management.domain.Revenue;
import com.financial.management.dto.request.RevenueRequest;
import com.financial.management.service.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/revenue")
@CrossOrigin
public class RevenueController {

    @Autowired
    private RevenueService service;

    public RevenueController(RevenueService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Revenue> createRevenue(@RequestBody RevenueRequest revenueRequest){
        Revenue revenue = service.createRevenue(revenueRequest);
        return ResponseEntity.status(201).body(revenue);
    }

}
