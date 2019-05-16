package com.sdut.product.pojo;

/**
 * @ClassName Production
 * @Discription /TODO 溯源 生产信息
 * @Author yinyuchen
 * @Date 2019/3/28 11:38
 **/
public class Production {
    private String id;
    private String productId;
    private String time;
    private String place;
    private String status;
    private String people;
    private String picture;
    private String video;
    private String introduction;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "Production{" +
                "id='" + id + '\'' +
                ", productId='" + productId + '\'' +
                ", time='" + time + '\'' +
                ", place='" + place + '\'' +
                ", status='" + status + '\'' +
                ", people='" + people + '\'' +
                ", picture='" + picture + '\'' +
                ", video='" + video + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
