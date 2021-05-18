package ua.wishtime.yukon.model;

import org.apache.commons.net.ntp.TimeStamp;

public class Wish {

    private String wishName;

    private String wishCategory;

    private String linkToProduct;

    private String price;

    private String fullName;

    private String phoneNumber;

    private Address address;

    public String getWishName() {
        return wishName;
    }

    public String getWishCategory() {
        return wishCategory;
    }

    public String getLinkToProduct() {
        return linkToProduct;
    }

    public String getPrice() {
        return price;
    }

    public String getFullName() {
        return fullName;
    }

    public Wish(String wishName, String wishCategory, String linkToProduct, String price, String fullName, String phoneNumber, Address address) {
        this.wishName = wishName;
        this.wishCategory = wishCategory;
        this.linkToProduct = linkToProduct;
        this.price = price;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

}
