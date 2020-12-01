package com.fpoly.agile.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "News")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer NewsID;
    private String Title;
    private String Description;
    private String Image;
    private String Content;
    private Date DateRelease;
    private Integer UsersID;

    public News(){
    }

    public News(Integer newsID, String title, String description, String image, String content, Date dateRelease, Integer usersID) {
        NewsID = newsID;
        Title = title;
        Description = description;
        Image = image;
        Content = content;
        DateRelease = dateRelease;
        UsersID = usersID;
    }

    @Override
    public String toString() {
        return "News{" +
                "NewsID=" + NewsID +
                ", Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", Image='" + Image + '\'' +
                ", Content='" + Content + '\'' +
                ", DateRelease=" + DateRelease +
                ", UsersID=" + UsersID +
                '}';
    }

    public Integer getNewsID() {
        return NewsID;
    }

    public void setNewsID(Integer newsID) {
        NewsID = newsID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Date getDateRelease() {
        return DateRelease;
    }

    public void setDateRelease(Date dateRelease) {
        DateRelease = dateRelease;
    }

    public Integer getUsersID() {
        return UsersID;
    }

    public void setUsersID(Integer usersID) {
        UsersID = usersID;
    }
}
