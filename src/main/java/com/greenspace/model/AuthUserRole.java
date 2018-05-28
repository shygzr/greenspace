package com.greenspace.model;

public class AuthUserRole {
    private Long id;

    private Long authRoleId;

    private Long authUserId;

    @Override
    public String toString() {
        return "AuthUserRole{" +
                "id=" + id +
                ", authRoleId=" + authRoleId +
                ", authUserId=" + authUserId +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthRoleId() {
        return authRoleId;
    }

    public void setAuthRoleId(Long authRoleId) {
        this.authRoleId = authRoleId;
    }

    public Long getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(Long authUserId) {
        this.authUserId = authUserId;
    }
}