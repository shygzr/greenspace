package com.greenspace.model;

public class AuthRolePermission {
    private Long id;

    private Long authPermissionId;

    private Long authRoleId;

    @Override
    public String toString() {
        return "AuthRolePermission{" +
                "id=" + id +
                ", authPermissionId=" + authPermissionId +
                ", authRoleId=" + authRoleId +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthPermissionId() {
        return authPermissionId;
    }

    public void setAuthPermissionId(Long authPermissionId) {
        this.authPermissionId = authPermissionId;
    }

    public Long getAuthRoleId() {
        return authRoleId;
    }

    public void setAuthRoleId(Long authRoleId) {
        this.authRoleId = authRoleId;
    }
}