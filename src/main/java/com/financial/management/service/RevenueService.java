package com.financial.management.service;

import com.financial.management.domain.Revenue;
import com.financial.management.dto.request.RevenueRequest;
import com.financial.management.repository.RevenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RevenueService {

    @Autowired
    private final RevenueRepository repository;

    public RevenueService(RevenueRepository repository){
        this.repository = repository;
    }

    public Revenue createRevenue(RevenueRequest revenueRequest) {

        Revenue revenueEntity = new Revenue();

        revenueEntity.setCategory(revenueRequest.getCategory());
        revenueEntity.setValue(revenueRequest.getValue());
        revenueEntity.setDescription(revenueRequest.getDescription());

        return repository.save(revenueEntity);
    }
}
