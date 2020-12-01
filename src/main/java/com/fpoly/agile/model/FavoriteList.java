package com.fpoly.agile.model;

import javax.persistence.*;

@Entity
@Table(name = "FavoriteList")
public class FavoriteList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer FavoriteID;
    private Integer ProductsID;
    private Integer UsersID;

    public FavoriteList(){
    }


    public FavoriteList(Integer favoriteID, Integer productsID, Integer usersID) {
        FavoriteID = favoriteID;
        ProductsID = productsID;
        UsersID = usersID;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "FavoriteID=" + FavoriteID +
                ", ProductsID=" + ProductsID +
                ", UsersID=" + UsersID +
                '}';
    }

    public Integer getFavoriteID() {
        return FavoriteID;
    }

    public void setFavoriteID(Integer favoriteID) {
        FavoriteID = favoriteID;
    }

    public Integer getProductsID() {
        return ProductsID;
    }

    public void setProductsID(Integer productsID) {
        ProductsID = productsID;
    }

    public Integer getUsersID() {
        return UsersID;
    }

    public void setUsersID(Integer usersID) {
        UsersID = usersID;
    }
}
