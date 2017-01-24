package com.learncassandra.domain;

import java.util.Date;

/**
 * Created by z001qgd on 1/23/17.
 */
public class CourseVO {



    private String id;
    private String courseName;
    private String author;
    private Integer audience;
    private Integer duration;
    private boolean cc;
    private Date releaseDate;
    private Integer moduleId;
    private String moduleName;
    private Integer moduleDuration;

    @Override
    public String toString() {
        return "CourseVO{" +
                "id='" + id + '\'' +
                ", courseName='" + courseName + '\'' +
                ", author='" + author + '\'' +
                ", audience=" + audience +
                ", duration=" + duration +
                ", cc=" + cc +
                ", released=" + releaseDate +
                ", moduleId=" + moduleId +
                ", moduleName='" + moduleName + '\'' +
                ", moduleDuration=" + moduleDuration +
                '}';
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getId() {
        return id;

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getAudience() {
        return audience;
    }

    public void setAudience(Integer audience) {
        this.audience = audience;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public boolean isCc() {
        return cc;
    }

    public void setCc(boolean cc) {
        this.cc = cc;
    }

   

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Integer getModuleDuration() {
        return moduleDuration;
    }

    public void setModuleDuration(Integer moduleDuration) {
        this.moduleDuration = moduleDuration;
    }
}
