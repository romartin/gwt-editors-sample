package org.roger600.gwt.editorsample.shared.model;

import javax.validation.constraints.NotNull;

public class DataSetDef {
    @NotNull
    protected String UUID;
    @NotNull
    protected String name;
    
    protected boolean isPublic = true;
    protected Integer pushMaxSize = 1024;
    
    @NotNull
    protected DataSetProviderType provider;
    
    
    
    
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

    public DataSetProviderType getProvider() {
        return provider;
    }

    public void setProvider(DataSetProviderType provider) {
        this.provider = provider;
    }
}
