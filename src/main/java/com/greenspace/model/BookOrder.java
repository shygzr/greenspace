package com.greenspace.model;

import java.util.Date;

public class BookOrder {
    private Long id;

    private Long userId;

    private Long bookId;

    private Long cabinetId;

    private Date createTime;

    private Byte status;

    @Override
    public String toString() {
        return "BookOrder{" +
                "id=" + id +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", cabinetId=" + cabinetId +
                ", createTime=" + createTime +
                ", status=" + status +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getCabinetId() {
        return cabinetId;
    }

    public void setCabinetId(Long cabinetId) {
        this.cabinetId = cabinetId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}