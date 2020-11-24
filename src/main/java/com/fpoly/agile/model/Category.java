package com.fpoly.agile.model;

import javax.persistence.*;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CategoryID;
    private String Name;
    private String Image;

    public Category(){
    }

    public Category(Integer categoryID, String name, String image) {
        CategoryID = categoryID;
        Name = name;
        Image = image;
    }

    @Override
    public String toString() {
        return "Category{" +
                "CategoryID=" + CategoryID +
                ", Name='" + Name + '\'' +
                ", Image=" + Image +
                '}';
    }

    public Integer getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(Integer categoryID) {
        CategoryID = categoryID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
