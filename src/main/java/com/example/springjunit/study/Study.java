package com.example.springjunit.study;

public class Study {

    private StudyStatus status;
    private int limit;

    public Study(StudyStatus status, int limit) {
        this.status = status;
        if (limit < 0) {
            throw new IllegalArgumentException("limit은 0보다 커야한다.");
        }
        this.limit = limit;
    }

    public StudyStatus getStatus() {
        return status;
    }

    public int getLimit() {
        return limit;
    }
}
