package com.greenspace.model;

public class Cabinet {

    @Override
    public String toString() {
        return "Cabinet{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", caninetNumbet=" + caninetNumbet +
                ", capacity=" + capacity +
                ", availableNumber=" + availableNumber +
                ", status=" + status +
                '}';
    }

    private Long id;

    private String password;

    private Byte caninetNumbet;

    private Byte capacity;

    private Byte availableNumber;

    private Byte status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Byte getCaninetNumbet() {
        return caninetNumbet;
    }

    public void setCaninetNumbet(Byte caninetNumbet) {
        this.caninetNumbet = caninetNumbet;
    }

    public Byte getCapacity() {
        return capacity;
    }

    public void setCapacity(Byte capacity) {
        this.capacity = capacity;
    }

    public Byte getAvailableNumber() {
        return availableNumber;
    }

    public void setAvailableNumber(Byte availableNumber) {
        this.availableNumber = availableNumber;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}