package com.Car_Rental.Car_RentalService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

    @Entity
    @Table(name = "users")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long user_id;

        private String firstName;

        private String lastName;

        private String email;

        private String password;

        private String mobile;

        private String role;

        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
        private List<Address> addresses;
// we will be using payment info as embeddable which will hepl to create object of it when its needed instead of creating separate entity
//@=elementcollectin is used to instructs jpa to store the collection in a separate table
//@collection table is used for providing details about the table
@ElementCollection
@CollectionTable(name = "payment", joinColumns = @JoinColumn(name = "user_id"))
 List<Payment>pay_info=new ArrayList<>();

        @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
        @JsonIgnore
        private List<Rating>rating=new ArrayList<>();
        @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
        @JsonIgnore
        private List<Review>review=new ArrayList<>();
        private LocalDateTime createdAt;
        public User(){}

        public User(Long id,String firstName, String lastName, String email, String password, String mobile, String role, List<Address> addresses, List<Payment> pay_info, List<Rating> rating, List<Review> review, LocalDateTime createdAt) {
            this.user_id=id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.password = password;
            this.mobile = mobile;
            this.role = role;
            this.addresses = addresses;
            this.pay_info = pay_info;
            this.rating = rating;
            this.review = review;
            this.createdAt = createdAt;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public Long getUser_id() {
            return user_id;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public List<Address> getAddresses() {
            return addresses;
        }

        public void setAddresses(List<Address> addresses) {
            this.addresses = addresses;
        }

        public List<Payment> getPay_info() {
            return pay_info;
        }

        public void setPay_info(List<Payment> pay_info) {
            this.pay_info = pay_info;
        }

        public List<Rating> getRating() {
            return rating;
        }

        public void setRating(List<Rating> rating) {
            this.rating = rating;
        }

        public List<Review> getReview() {
            return review;
        }

        public void setReview(List<Review> review) {
            this.review = review;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }
    }

