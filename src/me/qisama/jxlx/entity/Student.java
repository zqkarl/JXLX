package me.qisama.jxlx.entity;

public class Student {
    private Long id;

    private String studentName;

    private String password;

    private String salt;

    private String classId;

    private Integer contactPhone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
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

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }

    public Integer getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(Integer contactPhone) {
        this.contactPhone = contactPhone;
    }
    
    public String getCredentialsSalt() {
    	return id.toString()+salt;
    }
    
    public String getUsername() {
    	return id.toString();
    }
}