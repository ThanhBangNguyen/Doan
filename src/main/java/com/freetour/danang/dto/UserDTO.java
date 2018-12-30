package com.freetour.danang.dto;

public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private RoleDTO  role;
    private RestaurantDTO restaurantUs;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }

    public RestaurantDTO getRestaurantUs() {
        return restaurantUs;
    }

    public void setRestaurantUs(RestaurantDTO restaurantUs) {
        this.restaurantUs = restaurantUs;
    }
}
