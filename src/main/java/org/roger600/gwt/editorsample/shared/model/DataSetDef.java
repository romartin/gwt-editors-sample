package org.roger600.gwt.editorsample.shared.model;

import javax.validation.constraints.NotNull;

public class DataSetDef {
    @NotNull
    protected String UUID;
    @NotNull
    protected String name;
    protected boolean isPublic = true;
    protected Integer pushMaxSize = 1024;

    public DataSetDef() {
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public Integer getPushMaxSize() {
        return pushMaxSize;
    }

    public void setPushMaxSize(Integer pushMaxSize) {
        this.pushMaxSize = pushMaxSize;
    }
}
