package me.qisama.jxlx.entity;

import java.util.ArrayList;
import java.util.List;

public class ScoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScoreExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andExamIdIsNull() {
            addCriterion("exam_id is null");
            return (Criteria) this;
        }

        public Criteria andExamIdIsNotNull() {
            addCriterion("exam_id is not null");
            return (Criteria) this;
        }

        public Criteria andExamIdEqualTo(Integer value) {
            addCriterion("exam_id =", value, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdNotEqualTo(Integer value) {
            addCriterion("exam_id <>", value, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdGreaterThan(Integer value) {
            addCriterion("exam_id >", value, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("exam_id >=", value, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdLessThan(Integer value) {
            addCriterion("exam_id <", value, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdLessThanOrEqualTo(Integer value) {
            addCriterion("exam_id <=", value, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdIn(List<Integer> values) {
            addCriterion("exam_id in", values, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdNotIn(List<Integer> values) {
            addCriterion("exam_id not in", values, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdBetween(Integer value1, Integer value2) {
            addCriterion("exam_id between", value1, value2, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdNotBetween(Integer value1, Integer value2) {
            addCriterion("exam_id not between", value1, value2, "examId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNull() {
            addCriterion("student_id is null");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNotNull() {
            addCriterion("student_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudentIdEqualTo(Long value) {
            addCriterion("student_id =", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotEqualTo(Long value) {
            addCriterion("student_id <>", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThan(Long value) {
            addCriterion("student_id >", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("student_id >=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThan(Long value) {
            addCriterion("student_id <", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThanOrEqualTo(Long value) {
            addCriterion("student_id <=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIn(List<Long> values) {
            addCriterion("student_id in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotIn(List<Long> values) {
            addCriterion("student_id not in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdBetween(Long value1, Long value2) {
            addCriterion("student_id between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotBetween(Long value1, Long value2) {
            addCriterion("student_id not between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andTeacherCommentIsNull() {
            addCriterion("teacher_comment is null");
            return (Criteria) this;
        }

        public Criteria andTeacherCommentIsNotNull() {
            addCriterion("teacher_comment is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherCommentEqualTo(String value) {
            addCriterion("teacher_comment =", value, "teacherComment");
            return (Criteria) this;
        }

        public Criteria andTeacherCommentNotEqualTo(String value) {
            addCriterion("teacher_comment <>", value, "teacherComment");
            return (Criteria) this;
        }

        public Criteria andTeacherCommentGreaterThan(String value) {
            addCriterion("teacher_comment >", value, "teacherComment");
            return (Criteria) this;
        }

        public Criteria andTeacherCommentGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_comment >=", value, "teacherComment");
            return (Criteria) this;
        }

        public Criteria andTeacherCommentLessThan(String value) {
            addCriterion("teacher_comment <", value, "teacherComment");
            return (Criteria) this;
        }

        public Criteria andTeacherCommentLessThanOrEqualTo(String value) {
            addCriterion("teacher_comment <=", value, "teacherComment");
            return (Criteria) this;
        }

        public Criteria andTeacherCommentLike(String value) {
            addCriterion("teacher_comment like", value, "teacherComment");
            return (Criteria) this;
        }

        public Criteria andTeacherCommentNotLike(String value) {
            addCriterion("teacher_comment not like", value, "teacherComment");
            return (Criteria) this;
        }

        public Criteria andTeacherCommentIn(List<String> values) {
            addCriterion("teacher_comment in", values, "teacherComment");
            return (Criteria) this;
        }

        public Criteria andTeacherCommentNotIn(List<String> values) {
            addCriterion("teacher_comment not in", values, "teacherComment");
            return (Criteria) this;
        }

        public Criteria andTeacherCommentBetween(String value1, String value2) {
            addCriterion("teacher_comment between", value1, value2, "teacherComment");
            return (Criteria) this;
        }

        public Criteria andTeacherCommentNotBetween(String value1, String value2) {
            addCriterion("teacher_comment not between", value1, value2, "teacherComment");
            return (Criteria) this;
        }

        public Criteria andParentCommentStateIsNull() {
            addCriterion("parent_comment_state is null");
            return (Criteria) this;
        }

        public Criteria andParentCommentStateIsNotNull() {
            addCriterion("parent_comment_state is not null");
            return (Criteria) this;
        }

        public Criteria andParentCommentStateEqualTo(Integer value) {
            addCriterion("parent_comment_state =", value, "parentCommentState");
            return (Criteria) this;
        }

        public Criteria andParentCommentStateNotEqualTo(Integer value) {
            addCriterion("parent_comment_state <>", value, "parentCommentState");
            return (Criteria) this;
        }

        public Criteria andParentCommentStateGreaterThan(Integer value) {
            addCriterion("parent_comment_state >", value, "parentCommentState");
            return (Criteria) this;
        }

        public Criteria andParentCommentStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_comment_state >=", value, "parentCommentState");
            return (Criteria) this;
        }

        public Criteria andParentCommentStateLessThan(Integer value) {
            addCriterion("parent_comment_state <", value, "parentCommentState");
            return (Criteria) this;
        }

        public Criteria andParentCommentStateLessThanOrEqualTo(Integer value) {
            addCriterion("parent_comment_state <=", value, "parentCommentState");
            return (Criteria) this;
        }

        public Criteria andParentCommentStateIn(List<Integer> values) {
            addCriterion("parent_comment_state in", values, "parentCommentState");
            return (Criteria) this;
        }

        public Criteria andParentCommentStateNotIn(List<Integer> values) {
            addCriterion("parent_comment_state not in", values, "parentCommentState");
            return (Criteria) this;
        }

        public Criteria andParentCommentStateBetween(Integer value1, Integer value2) {
            addCriterion("parent_comment_state between", value1, value2, "parentCommentState");
            return (Criteria) this;
        }

        public Criteria andParentCommentStateNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_comment_state not between", value1, value2, "parentCommentState");
            return (Criteria) this;
        }

        public Criteria andParentCommentIsNull() {
            addCriterion("parent_comment is null");
            return (Criteria) this;
        }

        public Criteria andParentCommentIsNotNull() {
            addCriterion("parent_comment is not null");
            return (Criteria) this;
        }

        public Criteria andParentCommentEqualTo(String value) {
            addCriterion("parent_comment =", value, "parentComment");
            return (Criteria) this;
        }

        public Criteria andParentCommentNotEqualTo(String value) {
            addCriterion("parent_comment <>", value, "parentComment");
            return (Criteria) this;
        }

        public Criteria andParentCommentGreaterThan(String value) {
            addCriterion("parent_comment >", value, "parentComment");
            return (Criteria) this;
        }

        public Criteria andParentCommentGreaterThanOrEqualTo(String value) {
            addCriterion("parent_comment >=", value, "parentComment");
            return (Criteria) this;
        }

        public Criteria andParentCommentLessThan(String value) {
            addCriterion("parent_comment <", value, "parentComment");
            return (Criteria) this;
        }

        public Criteria andParentCommentLessThanOrEqualTo(String value) {
            addCriterion("parent_comment <=", value, "parentComment");
            return (Criteria) this;
        }

        public Criteria andParentCommentLike(String value) {
            addCriterion("parent_comment like", value, "parentComment");
            return (Criteria) this;
        }

        public Criteria andParentCommentNotLike(String value) {
            addCriterion("parent_comment not like", value, "parentComment");
            return (Criteria) this;
        }

        public Criteria andParentCommentIn(List<String> values) {
            addCriterion("parent_comment in", values, "parentComment");
            return (Criteria) this;
        }

        public Criteria andParentCommentNotIn(List<String> values) {
            addCriterion("parent_comment not in", values, "parentComment");
            return (Criteria) this;
        }

        public Criteria andParentCommentBetween(String value1, String value2) {
            addCriterion("parent_comment between", value1, value2, "parentComment");
            return (Criteria) this;
        }

        public Criteria andParentCommentNotBetween(String value1, String value2) {
            addCriterion("parent_comment not between", value1, value2, "parentComment");
            return (Criteria) this;
        }

        public Criteria andEntryTeacherIdIsNull() {
            addCriterion("entry_teacher_id is null");
            return (Criteria) this;
        }

        public Criteria andEntryTeacherIdIsNotNull() {
            addCriterion("entry_teacher_id is not null");
            return (Criteria) this;
        }

        public Criteria andEntryTeacherIdEqualTo(Long value) {
            addCriterion("entry_teacher_id =", value, "entryTeacherId");
            return (Criteria) this;
        }

        public Criteria andEntryTeacherIdNotEqualTo(Long value) {
            addCriterion("entry_teacher_id <>", value, "entryTeacherId");
            return (Criteria) this;
        }

        public Criteria andEntryTeacherIdGreaterThan(Long value) {
            addCriterion("entry_teacher_id >", value, "entryTeacherId");
            return (Criteria) this;
        }

        public Criteria andEntryTeacherIdGreaterThanOrEqualTo(Long value) {
            addCriterion("entry_teacher_id >=", value, "entryTeacherId");
            return (Criteria) this;
        }

        public Criteria andEntryTeacherIdLessThan(Long value) {
            addCriterion("entry_teacher_id <", value, "entryTeacherId");
            return (Criteria) this;
        }

        public Criteria andEntryTeacherIdLessThanOrEqualTo(Long value) {
            addCriterion("entry_teacher_id <=", value, "entryTeacherId");
            return (Criteria) this;
        }

        public Criteria andEntryTeacherIdIn(List<Long> values) {
            addCriterion("entry_teacher_id in", values, "entryTeacherId");
            return (Criteria) this;
        }

        public Criteria andEntryTeacherIdNotIn(List<Long> values) {
            addCriterion("entry_teacher_id not in", values, "entryTeacherId");
            return (Criteria) this;
        }

        public Criteria andEntryTeacherIdBetween(Long value1, Long value2) {
            addCriterion("entry_teacher_id between", value1, value2, "entryTeacherId");
            return (Criteria) this;
        }

        public Criteria andEntryTeacherIdNotBetween(Long value1, Long value2) {
            addCriterion("entry_teacher_id not between", value1, value2, "entryTeacherId");
            return (Criteria) this;
        }

        public Criteria andEntryTimeIsNull() {
            addCriterion("entry_time is null");
            return (Criteria) this;
        }

        public Criteria andEntryTimeIsNotNull() {
            addCriterion("entry_time is not null");
            return (Criteria) this;
        }

        public Criteria andEntryTimeEqualTo(String value) {
            addCriterion("entry_time =", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeNotEqualTo(String value) {
            addCriterion("entry_time <>", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeGreaterThan(String value) {
            addCriterion("entry_time >", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeGreaterThanOrEqualTo(String value) {
            addCriterion("entry_time >=", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeLessThan(String value) {
            addCriterion("entry_time <", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeLessThanOrEqualTo(String value) {
            addCriterion("entry_time <=", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeLike(String value) {
            addCriterion("entry_time like", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeNotLike(String value) {
            addCriterion("entry_time not like", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeIn(List<String> values) {
            addCriterion("entry_time in", values, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeNotIn(List<String> values) {
            addCriterion("entry_time not in", values, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeBetween(String value1, String value2) {
            addCriterion("entry_time between", value1, value2, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeNotBetween(String value1, String value2) {
            addCriterion("entry_time not between", value1, value2, "entryTime");
            return (Criteria) this;
        }

        public Criteria andModifyTeacherIdIsNull() {
            addCriterion("modify_teacher_id is null");
            return (Criteria) this;
        }

        public Criteria andModifyTeacherIdIsNotNull() {
            addCriterion("modify_teacher_id is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTeacherIdEqualTo(Long value) {
            addCriterion("modify_teacher_id =", value, "modifyTeacherId");
            return (Criteria) this;
        }

        public Criteria andModifyTeacherIdNotEqualTo(Long value) {
            addCriterion("modify_teacher_id <>", value, "modifyTeacherId");
            return (Criteria) this;
        }

        public Criteria andModifyTeacherIdGreaterThan(Long value) {
            addCriterion("modify_teacher_id >", value, "modifyTeacherId");
            return (Criteria) this;
        }

        public Criteria andModifyTeacherIdGreaterThanOrEqualTo(Long value) {
            addCriterion("modify_teacher_id >=", value, "modifyTeacherId");
            return (Criteria) this;
        }

        public Criteria andModifyTeacherIdLessThan(Long value) {
            addCriterion("modify_teacher_id <", value, "modifyTeacherId");
            return (Criteria) this;
        }

        public Criteria andModifyTeacherIdLessThanOrEqualTo(Long value) {
            addCriterion("modify_teacher_id <=", value, "modifyTeacherId");
            return (Criteria) this;
        }

        public Criteria andModifyTeacherIdIn(List<Long> values) {
            addCriterion("modify_teacher_id in", values, "modifyTeacherId");
            return (Criteria) this;
        }

        public Criteria andModifyTeacherIdNotIn(List<Long> values) {
            addCriterion("modify_teacher_id not in", values, "modifyTeacherId");
            return (Criteria) this;
        }

        public Criteria andModifyTeacherIdBetween(Long value1, Long value2) {
            addCriterion("modify_teacher_id between", value1, value2, "modifyTeacherId");
            return (Criteria) this;
        }

        public Criteria andModifyTeacherIdNotBetween(Long value1, Long value2) {
            addCriterion("modify_teacher_id not between", value1, value2, "modifyTeacherId");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(String value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(String value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(String value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(String value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(String value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(String value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLike(String value) {
            addCriterion("modify_time like", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotLike(String value) {
            addCriterion("modify_time not like", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<String> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<String> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(String value1, String value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(String value1, String value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}