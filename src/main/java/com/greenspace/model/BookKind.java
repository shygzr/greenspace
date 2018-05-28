package com.greenspace.model;

public class BookKind {
    private Long id;

    private String bookKindName;

    private Long parentBookKindId;

    private Long cabinetId;

    private Byte status;

    //association
    private Cabinet cabinet;

    @Override
    public String toString() {
        return "BookKind{" +
                "id=" + id +
                ", bookKindName='" + bookKindName + '\'' +
                ", parentBookKindId=" + parentBookKindId +
                ", cabinetId=" + cabinetId +
                ", status=" + status +
                ", cabinet=" + cabinet +
                '}';
    }

    public Cabinet getCabinet() {
        return cabinet;
    }

    public void setCabinet(Cabinet cabinet) {
        this.cabinet = cabinet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookKindName() {
        return bookKindName;
    }

    public void setBookKindName(String bookKindName) {
        this.bookKindName = bookKindName == null ? null : bookKindName.trim();
    }

    public Long getParentBookKindId() {
        return parentBookKindId;
    }

    public void setParentBookKindId(Long parentBookKindId) {
        this.parentBookKindId = parentBookKindId;
    }

    public Long getCabinetId() {
        return cabinetId;
    }

    public void setCabinetId(Long cabinetId) {
        this.cabinetId = cabinetId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}