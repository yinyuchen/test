package com.sdut.product.pojo;

import lombok.Data;

/**
 * @ClassName Sales
 * @Discription  /TODO 溯源 销售信息
 * @Author yinyuchen
 * @Date 2019/3/28 11:53
 **/
@Data
public class Sales {
    private String id;
    private String productId;
    private String productName;
    private String website;
    private String address;
    private String time;
    private String saler;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSaler() {
        return saler;
    }

    public void setSaler(String saler) {
        this.saler = saler;
    }
}
