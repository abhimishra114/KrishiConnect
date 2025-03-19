package com.example.KrishiConnect.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class BuyerRequests {
    @Id
    private int requestId;
    private int businessId;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Category category;
    private int requiredQuantity;
    @Enumerated(EnumType.STRING)
    private Unit unit;
    private BigDecimal maxPrice;
    private String location;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime createdAt;


    public enum Status{
        OPEN,CLOSED;
        @JsonCreator
        public static Status fromString(String value){
            return Status.valueOf(value.toUpperCase());
        }
    }

    public enum Unit {
        KG, QUINTAL, TON, LITRE, DOZEN, UNIT;
        @JsonCreator
        public static Unit fromString(String value) {
            return Unit.valueOf(value.toUpperCase());
        }
    }

    public enum Category {
        GRAINS, FRUITS, VEGETABLES, DAIRY, MEAT, LIVESTOCK, OTHERS;
        @JsonCreator
        public static Category fromString(String value) {
            return value == null ? null : Category.valueOf(value.toUpperCase());
        }
    }

    @Override
    public String toString() {
        return "BuyerRequests{" +
                "requestId=" + requestId +
                ", businessId=" + businessId +
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

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getRequiredQuantity() {
        return requiredQuantity;
    }

    public void setRequiredQuantity(int requiredQuantity) {
        this.requiredQuantity = requiredQuantity;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
