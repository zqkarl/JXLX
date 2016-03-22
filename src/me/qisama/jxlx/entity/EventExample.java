package me.qisama.jxlx.entity;

import java.util.ArrayList;
import java.util.List;

public class EventExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EventExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdIsNull() {
            addCriterion("attachment_id is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdIsNotNull() {
            addCriterion("attachment_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdEqualTo(String value) {
            addCriterion("attachment_id =", value, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdNotEqualTo(String value) {
            addCriterion("attachment_id <>", value, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdGreaterThan(String value) {
            addCriterion("attachment_id >", value, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("attachment_id >=", value, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdLessThan(String value) {
            addCriterion("attachment_id <", value, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdLessThanOrEqualTo(String value) {
            addCriterion("attachment_id <=", value, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdLike(String value) {
            addCriterion("attachment_id like", value, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdNotLike(String value) {
            addCriterion("attachment_id not like", value, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdIn(List<String> values) {
            addCriterion("attachment_id in", values, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdNotIn(List<String> values) {
            addCriterion("attachment_id not in", values, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdBetween(String value1, String value2) {
            addCriterion("attachment_id between", value1, value2, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdNotBetween(String value1, String value2) {
            addCriterion("attachment_id not between", value1, value2, "attachmentId");
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