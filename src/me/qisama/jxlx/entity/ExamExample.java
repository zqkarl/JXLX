package me.qisama.jxlx.entity;

import java.util.ArrayList;
import java.util.List;

public class ExamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExamExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIsNull() {
            addCriterion("subject_id is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIsNotNull() {
            addCriterion("subject_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdEqualTo(Integer value) {
            addCriterion("subject_id =", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotEqualTo(Integer value) {
            addCriterion("subject_id <>", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThan(Integer value) {
            addCriterion("subject_id >", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("subject_id >=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThan(Integer value) {
            addCriterion("subject_id <", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("subject_id <=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIn(List<Integer> values) {
            addCriterion("subject_id in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotIn(List<Integer> values) {
            addCriterion("subject_id not in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdBetween(Integer value1, Integer value2) {
            addCriterion("subject_id between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("subject_id not between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andGradeIdIsNull() {
            addCriterion("grade_id is null");
            return (Criteria) this;
        }

        public Criteria andGradeIdIsNotNull() {
            addCriterion("grade_id is not null");
            return (Criteria) this;
        }

        public Criteria andGradeIdEqualTo(Integer value) {
            addCriterion("grade_id =", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdNotEqualTo(Integer value) {
            addCriterion("grade_id <>", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdGreaterThan(Integer value) {
            addCriterion("grade_id >", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("grade_id >=", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdLessThan(Integer value) {
            addCriterion("grade_id <", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdLessThanOrEqualTo(Integer value) {
            addCriterion("grade_id <=", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdIn(List<Integer> values) {
            addCriterion("grade_id in", values, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdNotIn(List<Integer> values) {
            addCriterion("grade_id not in", values, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdBetween(Integer value1, Integer value2) {
            addCriterion("grade_id between", value1, value2, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("grade_id not between", value1, value2, "gradeId");
            return (Criteria) this;
        }

        public Criteria andExamStartTimeIsNull() {
            addCriterion("exam_start_time is null");
            return (Criteria) this;
        }

        public Criteria andExamStartTimeIsNotNull() {
            addCriterion("exam_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andExamStartTimeEqualTo(String value) {
            addCriterion("exam_start_time =", value, "examStartTime");
            return (Criteria) this;
        }

        public Criteria andExamStartTimeNotEqualTo(String value) {
            addCriterion("exam_start_time <>", value, "examStartTime");
            return (Criteria) this;
        }

        public Criteria andExamStartTimeGreaterThan(String value) {
            addCriterion("exam_start_time >", value, "examStartTime");
            return (Criteria) this;
        }

        public Criteria andExamStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("exam_start_time >=", value, "examStartTime");
            return (Criteria) this;
        }

        public Criteria andExamStartTimeLessThan(String value) {
            addCriterion("exam_start_time <", value, "examStartTime");
            return (Criteria) this;
        }

        public Criteria andExamStartTimeLessThanOrEqualTo(String value) {
            addCriterion("exam_start_time <=", value, "examStartTime");
            return (Criteria) this;
        }

        public Criteria andExamStartTimeLike(String value) {
            addCriterion("exam_start_time like", value, "examStartTime");
            return (Criteria) this;
        }

        public Criteria andExamStartTimeNotLike(String value) {
            addCriterion("exam_start_time not like", value, "examStartTime");
            return (Criteria) this;
        }

        public Criteria andExamStartTimeIn(List<String> values) {
            addCriterion("exam_start_time in", values, "examStartTime");
            return (Criteria) this;
        }

        public Criteria andExamStartTimeNotIn(List<String> values) {
            addCriterion("exam_start_time not in", values, "examStartTime");
            return (Criteria) this;
        }

        public Criteria andExamStartTimeBetween(String value1, String value2) {
            addCriterion("exam_start_time between", value1, value2, "examStartTime");
            return (Criteria) this;
        }

        public Criteria andExamStartTimeNotBetween(String value1, String value2) {
            addCriterion("exam_start_time not between", value1, value2, "examStartTime");
            return (Criteria) this;
        }

        public Criteria andExamEndTimeIsNull() {
            addCriterion("exam_end_time is null");
            return (Criteria) this;
        }

        public Criteria andExamEndTimeIsNotNull() {
            addCriterion("exam_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andExamEndTimeEqualTo(String value) {
            addCriterion("exam_end_time =", value, "examEndTime");
            return (Criteria) this;
        }

        public Criteria andExamEndTimeNotEqualTo(String value) {
            addCriterion("exam_end_time <>", value, "examEndTime");
            return (Criteria) this;
        }

        public Criteria andExamEndTimeGreaterThan(String value) {
            addCriterion("exam_end_time >", value, "examEndTime");
            return (Criteria) this;
        }

        public Criteria andExamEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("exam_end_time >=", value, "examEndTime");
            return (Criteria) this;
        }

        public Criteria andExamEndTimeLessThan(String value) {
            addCriterion("exam_end_time <", value, "examEndTime");
            return (Criteria) this;
        }

        public Criteria andExamEndTimeLessThanOrEqualTo(String value) {
            addCriterion("exam_end_time <=", value, "examEndTime");
            return (Criteria) this;
        }

        public Criteria andExamEndTimeLike(String value) {
            addCriterion("exam_end_time like", value, "examEndTime");
            return (Criteria) this;
        }

        public Criteria andExamEndTimeNotLike(String value) {
            addCriterion("exam_end_time not like", value, "examEndTime");
            return (Criteria) this;
        }

        public Criteria andExamEndTimeIn(List<String> values) {
            addCriterion("exam_end_time in", values, "examEndTime");
            return (Criteria) this;
        }

        public Criteria andExamEndTimeNotIn(List<String> values) {
            addCriterion("exam_end_time not in", values, "examEndTime");
            return (Criteria) this;
        }

        public Criteria andExamEndTimeBetween(String value1, String value2) {
            addCriterion("exam_end_time between", value1, value2, "examEndTime");
            return (Criteria) this;
        }

        public Criteria andExamEndTimeNotBetween(String value1, String value2) {
            addCriterion("exam_end_time not between", value1, value2, "examEndTime");
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