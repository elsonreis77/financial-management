package com.financial.management.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_revenue")
@Getter
@Setter
public class Revenue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long revenueId;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double value;

    @ManyToOne
    @JoinColumn(name = "fkCategoryId", nullable = false)
    private Category category;

    @Column(name = "createdDate")
    private LocalDateTime createdDate;

    @PrePersist
    public void prePersist(){
        this.createdDate = LocalDateTime.now();
    }

}
