package com.greenspace.model;

public class AuthRole {
    private Long id;

    private String roleCode;

    private String name;

    private Boolean enabled;

    private Long appId;

    private String description;

    @Override
    public String toString() {
        return "AuthRole{" +
                "id=" + id +
                ", roleCode='" + roleCode + '\'' +
                ", name='" + name + '\'' +
                ", enabled=" + enabled +
                ", appId=" + appId +
                ", description='" + description + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}