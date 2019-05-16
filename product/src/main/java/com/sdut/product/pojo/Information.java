package com.sdut.product.pojo;

/**
 * @ClassName Information
 * @Discription   /TODO 产品信息
 * @Author yinyuchen
 * @Date 2019/3/26 16:17
 **/
public class Information {
    private String id;
    private String name;
    private double price;
    private String weight;
    private String material;
    private String brand;
    private String place;
    private String type;
    private String standard;
    private String licenseKey;
    private String keeping;
    private String productDate;
    private String qualityDate;
    private String introduction;
    private String picture;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getLicenseKey() {
        return licenseKey;
    }

    public void setLicenseKey(String licenseKey) {
        this.licenseKey = licenseKey;
    }

    public String getKeeping() {
        return keeping;
    }

    public void setKeeping(String keeping) {
        this.keeping = keeping;
    }

    public String getProductDate() {
        return productDate;
    }

    public void setProductDate(String productDate) {
        this.productDate = productDate;
    }

    public String getQualityDate() {
        return qualityDate;
    }

    public void setQualityDate(String qualityDate) {
        this.qualityDate = qualityDate;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Information{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", weight='" + weight + '\'' +
                ", material='" + material + '\'' +
                ", brand='" + brand + '\'' +
                ", place='" + place + '\'' +
                ", type='" + type + '\'' +
                ", standard='" + standard + '\'' +
                ", license_key='" + licenseKey + '\'' +
                ", keeping='" + keeping + '\'' +
                ", product_date='" + productDate + '\'' +
                ", quality_date='" + qualityDate + '\'' +
                ", introduction='" + introduction + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
