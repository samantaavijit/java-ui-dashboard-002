package com.raven.model;

import com.raven.swing.table.EventAction;
import com.raven.swing.table.ModelAction;
import com.raven.swing.table.ModelProfile;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ModelStudent {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Icon getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(Icon profileImage) {
        this.profileImage = profileImage;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getAddmissionDate() {
        return addmissionDate;
    }

    public void setAddmissionDate(String addmissionDate) {
        this.addmissionDate = addmissionDate;
    }

    public ModelStudent() {
    }

    public ModelStudent(String uid, String courseName, String branchName, String name, String fathersName, String mothersName, String presentAddress, String permanentAddress, String dob, String bloodGroup, String contactNo, String nationality, Icon profileImage, String qualification, String addmissionDate) {
        this.uid = uid;
        this.courseName = courseName;
        this.branchName = branchName;
        this.name = name;
        this.fathersName = fathersName;
        this.mothersName = mothersName;
        this.presentAddress = presentAddress;
        this.permanentAddress = permanentAddress;
        this.dob = dob;
        this.bloodGroup = bloodGroup;
        this.contactNo = contactNo;
        this.nationality = nationality;
        this.profileImage = profileImage;
        this.qualification = qualification;
        this.addmissionDate = addmissionDate;
    }

    private String uid;
    private String courseName;
    private String branchName;
    private String name;
    private String fathersName;
    private String mothersName;
    private String presentAddress;
    private String permanentAddress;
    private String dob;
    private String bloodGroup;
    private String contactNo;
    private String nationality;
    private Icon profileImage;
    private String qualification;
    private String addmissionDate;

    public Object[] toRowTable(EventAction event) {

        return new Object[]{new ModelProfile(profileImage, name), addmissionDate, courseName, branchName, presentAddress, new ModelAction(this, event)};
    }

    @Override
    public String toString() {
        return "ModelStudent{" + "uid=" + uid + ", courseName=" + courseName + ", branchName=" + branchName + ", name=" + name + ", fathersName=" + fathersName + ", mothersName=" + mothersName + ", presentAddress=" + presentAddress + ", permanentAddress=" + permanentAddress + ", dob=" + dob + ", bloodGroup=" + bloodGroup + ", contactNo=" + contactNo + ", nationality=" + nationality + ", profileImage=" + profileImage + ", qualification=" + qualification + ", addmissionDate=" + addmissionDate + '}';
    }

}
