package me.qisama.jxlx.entity;

public class Role {
    private Long id;

    private String role;

    private String roleDesc;

    private Boolean states = Boolean.TRUE;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }

    public Boolean getStates() {
        return states;
    }

    public void setStates(Boolean states) {
        this.states = states;
    }
}