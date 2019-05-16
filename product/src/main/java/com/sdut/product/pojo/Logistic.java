package com.sdut.product.pojo;

import lombok.Data;

/**
 * @ClassName Logistic
 * @Discription  /TODO 溯源 物流信息
 * @Author yinyuchen
 * @Date 2019/3/28 11:43
 **/
@Data
public class Logistic {
    private String id;
    private String productId;
    private String productName;
    private String name;
    private String time;
    private String kuaidinum;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getKuaidinum() {
        return kuaidinum;
    }

    public void setKuaidinum(String kuaidinum) {
        this.kuaidinum = kuaidinum;
    }

}
