package com.sdut.product.pojo;

import lombok.Data;

/**
 * @ClassName FeedBack
 * @Discription
 * @Author yinyuchen
 * @Date 2019/4/15 16:46
 **/
@Data
public class FeedBack {
    private String id;
    private String productId;
    private String productName;
    private String people;
    private String phone;
    private String problem;
    private String suggest;
    private String status;

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

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FeedBack{" +
                "id='" + id + '\'' +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", people='" + people + '\'' +
                ", phone='" + phone + '\'' +
                ", problem='" + problem + '\'' +
                ", suggest='" + suggest + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
