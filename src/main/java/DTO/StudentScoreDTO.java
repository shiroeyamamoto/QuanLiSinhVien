/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.List;

/**
 *
 * @author anhkh
 */
public class StudentScoreDTO {

    private int studentId;
    private int bangDiemid;
    private int subjectCode;
    private String subjectName;
    private float diemGiuaki;
    private float diemCuoiKi;
    private List<Float> otherScore;

    public StudentScoreDTO() {
    }

    public int getStudentId() {
        return studentId;
    }

    public int getBangDiemid() {
        return bangDiemid;
    }

    public void setBangDiemid(int bangDiemid) {
        this.bangDiemid = bangDiemid;
    }

    public List<Float> getOtherScore() {
        return otherScore;
    }

    public void setOtherScore(List<Float> otherScore) {
        this.otherScore = otherScore;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(int subjectCode) {
        this.subjectCode = subjectCode;
    }

    public float getDiemGiuaki() {
        return diemGiuaki;
    }

    public void setDiemGiuaki(float diemGiuaki) {
        this.diemGiuaki = diemGiuaki;
    }

    public float getDiemCuoiKi() {
        return diemCuoiKi;
    }

    public void setDiemCuoiKi(float diemCuoiKi) {
        this.diemCuoiKi = diemCuoiKi;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

}
