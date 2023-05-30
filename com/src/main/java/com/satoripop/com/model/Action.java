package com.satoripop.com.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.satoripop.com.model.enumeration.Status;
import jakarta.persistence.*;

@Entity
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "deadline")
    private String deadline;

    @Column(name = "effort")
    private Float effort;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @Column(name = "created_date")
    private int createdDate;

    @Column(name = "last_modified_date")
    private int lastModifiedDate;

    @ManyToOne
    private UserInfo assignedTo;

    @ManyToOne
    @JsonIgnoreProperties(value = { "actions", "epic" }, allowSetters = true)
    private Epic epic;

    public Action() {
    }

    public Action(Long id, String description,String deadline,Float effort, Status status, String createdBy, String lastModifiedBy, int createdDate, int lastModifiedDate) {
        this.id = id;
        this.description = description;
        this.deadline = deadline;
        this.effort = effort;
        this.status = status;
        this.createdBy = createdBy;
        this.lastModifiedBy = lastModifiedBy;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getEffort() {
        return effort;
    }

    public void setEffort(Float effort) {
        this.effort = effort;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public int getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(int createdDate) {
        this.createdDate = createdDate;
    }

    public int getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(int lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
    public UserInfo getAssignedTo() {
        return this.assignedTo;
    }

    public void setAssignedTo(UserInfo userInfo) {
        this.assignedTo = userInfo;
    }

    public Action assignedTo(UserInfo userInfo) {
        this.setAssignedTo(userInfo);
        return this;
    }

    public Epic getEpic() {
        return this.epic;
    }

    public void setEpic(Epic epic) {
        this.epic = epic;
    }

    public Action epic(Epic epic) {
        this.setEpic(epic);
        return this;
    }
}
