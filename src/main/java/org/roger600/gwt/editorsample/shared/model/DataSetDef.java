package org.roger600.gwt.editorsample.shared.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.roger600.gwt.editorsample.client.validation.group.DataSetDefBasicAttributesValidationGroup;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import java.util.List;

public class DataSetDef {
    
    @NotNull(groups = {Default.class, DataSetDefBasicAttributesValidationGroup.class})
    protected String UUID;
    
    @NotNull(groups = {Default.class, DataSetDefBasicAttributesValidationGroup.class})
    protected String name;
    
    @NotNull
    protected DataSetProviderType provider;
    
    @NotEmpty
    @Valid
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
