package org.roger600.gwt.editorsample.shared.model;

import javax.validation.constraints.NotNull;
import java.util.List;

public class DataSetDef {
    @NotNull
    protected String UUID;
    @NotNull
    protected String name;
    
    @NotNull
    protected DataSetProviderType provider;
    
    @NotNull
    protected List<DataColumnDef> columns;
    
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

    public DataSetProviderType getProvider() {
        return provider;
    }

    public void setProvider(DataSetProviderType provider) {
        this.provider = provider;
    }

    public List<DataColumnDef> getColumns() {
        return columns;
    }

    public void setColumns(List<DataColumnDef> columns) {
        this.columns = columns;
    }
}
