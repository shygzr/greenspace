package com.greenspace.model;

import java.math.BigDecimal;
import java.util.Date;

public class Book {
    private Long id;

    private Long isbn;

    private Long cabinetId;

    private String title;

    private String author;

    private BigDecimal price;

    private BigDecimal rating;

    private String binding;

    private Short pages;

    private Date pubdate;

    private String publisher;

    private Byte number;

    private String image;

    private Byte status;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                "isbn=" + isbn +
                ", cabinetId=" + cabinetId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", binding='" + binding + '\'' +
                ", pages=" + pages +
                ", pubdate=" + pubdate +
                ", publisher='" + publisher + '\'' +
                ", number=" + number +
                ", image=" + image +
                ", status=" + status +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIsbn() { return isbn; }

    public void setIsbn(Long isbn)  {
        this.isbn = isbn;
    }

    public Long getCabinetId() {
        return cabinetId;
    }

    public void setCabinetId(Long cabinetId) {
        this.cabinetId = cabinetId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding == null ? null : binding.trim();
    }

    public Short getPages() {
        return pages;
    }

    public void setPages(Short pages) {
        this.pages = pages;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public Byte getNumber() {
        return number;
    }

    public void setNumber(Byte number) {
        this.number = number;
    }

    public String getImage() { return image; }

    public void setImage(String image)  {
        this.image = image == null ? null : image.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}