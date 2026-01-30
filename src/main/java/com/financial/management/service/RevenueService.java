package com.financial.management.service;

import com.financial.management.domain.Revenue;
import com.financial.management.dto.request.RevenueRequest;
import com.financial.management.dto.response.RevenueResponse;
import com.financial.management.repository.RevenueRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RevenueService {

    private final RevenueRepository repository;

    public RevenueService(RevenueRepository repository) {
        this.repository = repository;
    }

    public Revenue createRevenue(RevenueRequest request) {
        Revenue revenue = new Revenue();
        revenue.setDescription(request.getDescription());
        revenue.setValue(request.getValue());
        revenue.setCategory(request.getCategory());
        return repository.save(revenue);
    }

    public List<RevenueResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public RevenueResponse findById(Long id) {
        Revenue revenue = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Revenue não encontrada"));
        return toResponse(revenue);
    }

    public Revenue updateRevenue(Long id, RevenueRequest request) {
        Revenue revenue = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Revenue não encontrada"));

        revenue.setDescription(request.getDescription());
        revenue.setValue(request.getValue());
        revenue.setCategory(request.getCategory());

        return repository.save(revenue);
    }

    public void deleteRevenue(Long id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Receita não encontrada!");
        }
    }

    private RevenueResponse toResponse(Revenue revenue) {
        RevenueResponse response = new RevenueResponse();
        response.setId(revenue.getId());
        response.setDescription(revenue.getDescription());
        response.setValue(revenue.getValue());
        response.setCategory(revenue.getCategory());
        return response;
    }
}
