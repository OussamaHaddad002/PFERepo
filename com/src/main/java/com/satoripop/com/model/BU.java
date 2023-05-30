package com.satoripop.com.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class BU {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @Column(name = "created_date")
    private int createdDate;

    @Column(name = "last_modified_date")
    private int lastModifiedDate;

    @OneToMany(mappedBy = "bu")
    @JsonIgnoreProperties(value = { "resourcesPlanning", "projects", "changes", "responsable", "bu" }, allowSetters = true)
    private Set<Projet> projects = new HashSet<>();

    @ManyToOne
    private UserInfo responsable;

    public BU(Long id, String name, String createdBy, String lastModifiedBy, int createdDate, int lastModifiedDate) {
        this.id = id;
        this.name = name;
        this.createdBy = createdBy;
        this.lastModifiedBy = lastModifiedBy;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public BU() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public BU createdDate(int createdDate) {
        this.setCreatedDate(createdDate);
        return this;
    }


    public BU lastModifiedDate(int lastModifiedDate) {
        this.setLastModifiedDate(lastModifiedDate);
        return this;
    }


    public Set<Projet> getProjects() {
        return this.projects;
    }

    public void setProjects(Set<Projet> projects) {
        if (this.projects != null) {
            this.projects.forEach(i -> i.setBu(null));
        }
        if (projects != null) {
            projects.forEach(i -> i.setBu(this));
        }
        this.projects = projects;
    }

    public BU projects(Set<Projet> projects) {
        this.setProjects(projects);
        return this;
    }

    public BU addProjects(Projet project) {
        this.projects.add(project);
        project.setBu(this);
        return this;
    }

    public BU removeProjects(Projet project) {
        this.projects.remove(project);
        project.setBu(null);
        return this;
    }

    public UserInfo getResponsable() {
        return this.responsable;
    }

    public void setResponsable(UserInfo userInfo) {
        this.responsable = userInfo;
    }

    public BU responsable(UserInfo userInfo) {
        this.setResponsable(userInfo);
        return this;
    }
}
