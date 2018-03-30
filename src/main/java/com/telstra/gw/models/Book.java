package com.telstra.gw.models;

import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


/**
 * Created by abhishek.vangala on 3/22/2018.
 */

@XmlRootElement(name="book")
public class Book {

    private String title;

    private float price;

    private int year;

    @XmlPath(value = "author/text()")
    private List<String> author ;

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @XmlPath(value="title/@lang")
    private String lang;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString(){
        return this.getTitle()+" "+this.getAuthor()+" "+this.getLang();
    }
}
