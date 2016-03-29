package me.qisama.jxlx.entity;

public class Score {
    private Long id;

    private Integer examId;

    private Long studentId;

    private Integer score;

    private String teacherComment;

    private Integer parentCommentState;

    private String parentComment;

    private Long entryTeacherId;

    private String entryTime;

    private Long modifyTeacherId;

    private String modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getTeacherComment() {
        return teacherComment;
    }

    public void setTeacherComment(String teacherComment) {
        this.teacherComment = teacherComment == null ? null : teacherComment.trim();
    }

    public Integer getParentCommentState() {
        return parentCommentState;
    }

    public void setParentCommentState(Integer parentCommentState) {
        this.parentCommentState = parentCommentState;
    }

    public String getParentComment() {
        return parentComment;
    }

    public void setParentComment(String parentComment) {
        this.parentComment = parentComment == null ? null : parentComment.trim();
    }

    public Long getEntryTeacherId() {
        return entryTeacherId;
    }

    public void setEntryTeacherId(Long entryTeacherId) {
        this.entryTeacherId = entryTeacherId;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime == null ? null : entryTime.trim();
    }

    public Long getModifyTeacherId() {
        return modifyTeacherId;
    }

    public void setModifyTeacherId(Long modifyTeacherId) {
        this.modifyTeacherId = modifyTeacherId;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime == null ? null : modifyTime.trim();
    }
}