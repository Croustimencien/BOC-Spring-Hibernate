package com.school.BOC.dto.model;

public class SchoolDto {
    String name;
    static long schoolOwnerId;

    public SchoolDto(String name, long schoolOwnerId) {
        this.name = name;
        this.schoolOwnerId = schoolOwnerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static long getSchoolOwnerId() {
        return schoolOwnerId;
    }

    public void setSchoolOwnerId(long schoolOwnerId) {
        this.schoolOwnerId = schoolOwnerId;
    }
}
