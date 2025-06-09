package com.example.KrishiConnect.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Listings {
    @Id
    private int listingId;
    private int farmerId;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Category category;
    private BigDecimal price;
    private int quantity;
    @Enumerated(EnumType.STRING)
    private Unit unit;
    private String location;
    private String imageUrl;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime createdAt;

    @Override
    public String toString() {
        return "Listings{" +
                "listingId=" + listingId +
                ", farmerId=" + farmerId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", quantity=" + quantity +
                ", unit=" + unit +
                ", location='" + location + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                '}';
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public enum Status {
        AVAILABLE, SOLD;

        @JsonCreator
        public static BuyerRequests.Status fromString(String value) {
            return BuyerRequests.Status.valueOf(value.toUpperCase());
        }
    }

    public enum Unit {
        KG, QUINTAL, TON, LITRE, DOZEN, UNIT;

        @JsonCreator
        public static BuyerRequests.Unit fromString(String value) {
            return BuyerRequests.Unit.valueOf(value.toUpperCase());
        }
    }

    public enum Category {
        GRAINS, FRUITS, VEGETABLES, DAIRY, MEAT, LIVESTOCK, OTHERS;

        @JsonCreator
        public static BuyerRequests.Category fromString(String value) {
            return value == null ? null : BuyerRequests.Category.valueOf(value.toUpperCase());
        }
    }

    public int getListingId() {
        return listingId;
    }

    public void setListingId(int listingId) {
        this.listingId = listingId;
    }

    public int getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(int farmerId) {
        this.farmerId = farmerId;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
