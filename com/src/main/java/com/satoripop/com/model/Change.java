package com.satoripop.com.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.satoripop.com.model.enumeration.Status;
import jakarta.persistence.*;

@Entity
@Table(name = "changes")
public class Change {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "initiator")
    private String initiator;

    @Column(name = "description")
    private String description;

    @Column(name = "impact")
    private String impact;

    @Column(name = "cost")
    private Float cost;

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
    private UserInfo madeBy;

    @ManyToOne
    @JsonIgnoreProperties(value = { "resourcesPlanning", "projects", "changes", "responsable", "bu" }, allowSetters = true)
    private Projet project;



    public Change() {
    }

    public Change(Long id, String type, String initiator, String description, String impact, Float cost, Status status, String createdBy, String lastModifiedBy, int createdDate, int lastModifiedDate) {
        this.id = id;
        this.type = type;
        this.initiator = initiator;
        this.description = description;
        this.impact = impact;
        this.cost = cost;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
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

    public UserInfo getMadeBy() {
        return this.madeBy;
    }

    public void setMadeBy(UserInfo userInfo) {
        this.madeBy = userInfo;
    }

    public Change madeBy(UserInfo userInfo) {
        this.setMadeBy(userInfo);
        return this;
    }

    public Projet getProject() {
        return this.project;
    }

    public void setProject(Projet project) {
        this.project = project;
    }

    public Change project(Projet project) {
        this.setProject(project);
        return this;
    }



}
