package com.financial.management.dto.response;

import com.financial.management.domain.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RevenueResponse {

    private String description;
    private Double value;
    private Category category;

}
