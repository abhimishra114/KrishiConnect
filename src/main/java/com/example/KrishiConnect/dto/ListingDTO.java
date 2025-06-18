package com.example.KrishiConnect.dto;

import com.example.KrishiConnect.model.Listings;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ListingDTO {
    private int listingId;
    private int farmerId;
    private String farmerName;
    private String title;
    private String description;
    private String category;
    private BigDecimal price;
    private int quantity;
    private String unit;
    private String location;
    private String imageUrl;
    private String status;
    private LocalDateTime createdAt;

    public ListingDTO(int listingId, int farmerId, String farmerName, String title, String description, String category, BigDecimal price, int quantity, String unit, String location, String imageUrl, String status, LocalDateTime createdAt) {
        this.listingId = listingId;
        this.farmerId = farmerId;
        this.farmerName = farmerName;
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
        this.location = location;
        this.imageUrl = imageUrl;
        this.status = status;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "ListingDTO{" +
                "listingId=" + listingId +
                ", farmerId=" + farmerId +
                ", farmerName='" + farmerName + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                ", location='" + location + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                '}';
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

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
