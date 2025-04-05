package com.example.KrishiConnect.dto;

import com.example.KrishiConnect.model.BuyerRequests;
import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class BuyerRequestDTO {
    private int requestId;
    private String businessName;
    private String title;
    private String description;
    private BuyerRequests.Category category;
    private int requiredQuantity;
    private BuyerRequests.Unit unit;
    private BigDecimal maxPrice;
    private String location;
    private BuyerRequests.Status status;
    private LocalDateTime createdAt;

    @Override
    public String toString() {
        return "BuyerRequestDTO{" +
                "requestId=" + requestId +
                ", businessName='" + businessName + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", requiredQuantity=" + requiredQuantity +
                ", unit=" + unit +
                ", maxPrice=" + maxPrice +
                ", location='" + location + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                '}';
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BuyerRequests.Category getCategory() {
        return category;
    }

    public void setCategory(BuyerRequests.Category category) {
        this.category = category;
    }

    public int getRequiredQuantity() {
        return requiredQuantity;
    }

    public void setRequiredQuantity(int requiredQuantity) {
        this.requiredQuantity = requiredQuantity;
    }

    public BuyerRequests.Unit getUnit() {
        return unit;
    }

    public void setUnit(BuyerRequests.Unit unit) {
        this.unit = unit;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BuyerRequests.Status getStatus() {
        return status;
    }

    public void setStatus(BuyerRequests.Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
