package com.Car_Rental.Car_RentalService.Request;

public class AddItemRequest {
    private Long product_id;
    private String size;
    private int quantity;
    private int price;
    public AddItemRequest(){}

    public AddItemRequest(Long product_id, String size, int quantity, int price) {
        this.product_id = product_id;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
