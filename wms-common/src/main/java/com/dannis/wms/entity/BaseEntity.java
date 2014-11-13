package com.dannis.wms.entity;

import java.util.Date;

/**
 * Base entity class
 *
 * Created by: Dannis
 * Created on: 2014-11-09 13:51
 */
public class BaseEntity {
    /**
     * The id of entity
     */
    protected int id;
    /**
     * The name of entity
     */
    protected String name;
    /**
     * The time of creation
     */
    protected Date createdOn;
    /**
     * The id of creator
     */
    protected int createdBy;
    /**
     * The time of modification
     */
    protected Date modifiedOn;
    /**
     * The id of modifier
     */
    protected int modifiedBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public int getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(int modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
