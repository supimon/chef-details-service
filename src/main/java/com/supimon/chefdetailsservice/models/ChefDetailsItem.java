package com.supimon.chefdetailsservice.models;

public class ChefDetailsItem {

    private String phoneNumber;
    private String speciality;
    private String desc;
    private int expectedSalary;
    private String motherTongue;
    private String emailId;
    private int noticePeriod;

    public ChefDetailsItem(String phoneNumber, String speciality, String desc, int expectedSalary, String motherTongue, String emailId, int noticePeriod) {
        this.phoneNumber = phoneNumber;
        this.speciality = speciality;
        this.desc = desc;
        this.expectedSalary = expectedSalary;
        this.motherTongue = motherTongue;
        this.emailId = emailId;
        this.noticePeriod = noticePeriod;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(int expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public String getMotherTongue() {
        return motherTongue;
    }

    public void setMotherTongue(String motherTongue) {
        this.motherTongue = motherTongue;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getNoticePeriod() {
        return noticePeriod;
    }

    public void setNoticePeriod(int noticePeriod) {
        this.noticePeriod = noticePeriod;
    }
}
