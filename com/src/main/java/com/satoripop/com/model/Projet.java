package com.satoripop.com.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "estimation")
    private int estimation;

    @Column(name = "deadline")
    private int deadline;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @Column(name = "created_date")
    private int createdDate;

    @Column(name = "last_modified_date")
    private int lastModifiedDate;

    @JsonIgnoreProperties(value = { "user", "Projet" }, allowSetters = true)
    @OneToOne
    @JoinColumn(unique = true)
    private ResourcePlanning resourcesPlanning;

    @OneToMany(mappedBy = "epic")
    @JsonIgnoreProperties(value = { "actions", "epic" }, allowSetters = true)
    private Set<Epic> Projets = new HashSet<>();

    @OneToMany(mappedBy = "project")
    @JsonIgnoreProperties(value = { "madeBy", "project" }, allowSetters = true)
    private Set<Change> changes = new HashSet<>();

    @ManyToOne
    private UserInfo responsable;

    @ManyToOne
    @JsonIgnoreProperties(value = { "Projets", "responsable" }, allowSetters = true)
    private BU bu;

    public Projet() {
    }

    public Projet(Long id, String name, String type, int estimation, int deadline, String createdBy, String lastModifiedBy, int createdDate, int lastModifiedDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.estimation = estimation;
        this.deadline = deadline;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEstimation() {
        return estimation;
    }

    public void setEstimation(int estimation) {
        this.estimation = estimation;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
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

    public ResourcePlanning getResourcesPlanning() {
        return this.resourcesPlanning;
    }

    public void setResourcesPlanning(ResourcePlanning resourcePlanning) {
        this.resourcesPlanning = resourcePlanning;
    }

    public Projet resourcesPlanning(ResourcePlanning resourcePlanning) {
        this.setResourcesPlanning(resourcePlanning);
        return this;
    }

    public Set<Epic> getProjets() {
        return this.Projets;
    }

    public void setProjets(Set<Epic> epics) {
        if (this.Projets != null) {
            this.Projets.forEach(i -> i.setEpic(null));
        }
        if (epics != null) {
            epics.forEach(i -> i.setEpic(this));
        }
        this.Projets = epics;
    }

    public Projet Projets(Set<Epic> epics) {
        this.setProjets(epics);
        return this;
    }

    public Projet addProjet(Epic epic) {
        this.Projets.add(epic);
        epic.setEpic(this);
        return this;
    }

    public Projet removeProjet(Epic epic) {
        this.Projets.remove(epic);
        epic.setEpic(null);
        return this;
    }

    public Set<Change> getChanges() {
        return this.changes;
    }

    public void setChanges(Set<Change> changes) {
        if (this.changes != null) {
            this.changes.forEach(i -> i.setProject(null));
        }
        if (changes != null) {
            changes.forEach(i -> i.setProject(this));
        }
        this.changes = changes;
    }

    public Projet changes(Set<Change> changes) {
        this.setChanges(changes);
        return this;
    }

    public Projet addChanges(Change change) {
        this.changes.add(change);
        change.setProject(this);
        return this;
    }

    public Projet removeChanges(Change change) {
        this.changes.remove(change);
        change.setProject(null);
        return this;
    }

    public UserInfo getResponsable() {
        return this.responsable;
    }

    public void setResponsable(UserInfo userInfo) {
        this.responsable = userInfo;
    }

    public Projet responsable(UserInfo userInfo) {
        this.setResponsable(userInfo);
        return this;
    }

    public BU getBu() {
        return this.bu;
    }

    public void setBu(BU bU) {
        this.bu = bU;
    }

    public Projet bu(BU bU) {
        this.setBu(bU);
        return this;
    }
}
