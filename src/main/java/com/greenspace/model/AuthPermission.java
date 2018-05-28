package com.greenspace.model;

public class AuthPermission {
    private Long id;

    private String permCode;

    private String name;

    private Boolean enabled;

    private String type;

    private String url;

    private Long appId;

    private String description;

    private Long moduleId;

    @Override
    public String toString() {
        return "AuthPermission{" +
                "id=" + id +
                ", permCode='" + permCode + '\'' +
                ", name='" + name + '\'' +
                ", enabled=" + enabled +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", appId=" + appId +
                ", description='" + description + '\'' +
                ", moduleId=" + moduleId +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermCode() {
        return permCode;
    }

    public void setPermCode(String permCode) {
        this.permCode = permCode == null ? null : permCode.trim();
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }
}