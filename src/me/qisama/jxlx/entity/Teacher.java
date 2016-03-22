package me.qisama.jxlx.entity;

public class Teacher {
    private Long id;

    private String teacherName;

    private String password;

    private String salt;

    private Integer subjectId;

    private Boolean states = Boolean.TRUE;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Boolean getStates() {
        return states;
    }

    public void setStates(Boolean states) {
        this.states = states;
    }
    
    public String getCredentialsSalt() {
        return id.toString() + salt;
    }
    
    public String getUsername() {
    	return id.toString();
    }
}