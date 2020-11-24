package com.fpoly.agile.model;

import javax.persistence.*;

@Entity
@Table(name = "Products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ProductsID;
    private String Name;
    private Integer Quantity;
    private Integer Price;
    private String Image;
    private Integer Size;
    private Boolean Sex;
    private String Description;
    private Boolean Status;
    private Integer CategoryID;

    public Products(){
    }

    public Products(Integer productsID, String name, Integer quantity, Integer price, String image, Integer size, Boolean sex, String description, Boolean status, Integer categoryID) {
        ProductsID = productsID;
        Name = name;
        Quantity = quantity;
        Price = price;
        Image = image;
        Size = size;
        Sex = sex;
        Description = description;
        Status = status;
        CategoryID = categoryID;
    }

    @Override
    public String toString() {
        return "Products{" +
                "ProductsID=" + ProductsID +
                ", Name='" + Name + '\'' +
                ", Quantity=" + Quantity +
                ", Price=" + Price +
                ", Image='" + Image + '\'' +
                ", Size=" + Size +
                ", Sex=" + Sex +
                ", Description=" + Description +
                ", Status=" + Status +
                ", CategoryID=" + CategoryID +
                '}';
    }

    public Integer getProductsID() {
        return ProductsID;
    }

    public void setProductsID(Integer productsID) {
        ProductsID = productsID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public Integer getSize() {
        return Size;
    }

    public void setSize(Integer size) {
        Size = size;
    }

    public Boolean getSex() {
        return Sex;
    }

    public void setSex(Boolean sex) {
        Sex = sex;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }

    public Integer getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(Integer categoryID) {
        CategoryID = categoryID;
    }
}
