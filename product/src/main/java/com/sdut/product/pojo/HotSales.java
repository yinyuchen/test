package com.sdut.product.pojo;

/**
 * @ClassName HotSales
 * @Discription
 * @Author yinyuchen
 * @Date 2019/4/15 10:33
 **/
public class HotSales {
    private String id;
    private String picture;
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "HotSales{" +
                "id='" + id + '\'' +
                ", picture='" + picture + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
