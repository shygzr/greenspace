package com.greenspace.model;

public class ClothesKind {
    private Long id;

    private String clothesName;

    private Byte clothesClass;

    private Long cabinetId;

    private Byte status;

    //association
    private Cabinet cabinet;

    @Override
    public String toString() {
        return "ClothesKind{" +
                "id=" + id +
                ", clothesName='" + clothesName + '\'' +
                ", clothesClass=" + clothesClass +
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

    public String getClothesName() {
        return clothesName;
    }

    public void setClothesName(String clothesName) {
        this.clothesName = clothesName == null ? null : clothesName.trim();
    }

    public Byte getClothesClass() {
        return clothesClass;
    }

    public void setClothesClass(Byte clothesClass) {
        this.clothesClass = clothesClass;
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