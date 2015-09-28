package org.roger600.gwt.editorsample.shared.model;

import javax.validation.constraints.NotNull;

public class DataColumnDef {

    @NotNull
    private String id;
    @NotNull
    private ColumnType columnType;

    public DataColumnDef() {
    }

    public DataColumnDef(String id, ColumnType columnType) {
        this.id = id;
        this.columnType = columnType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ColumnType getColumnType() {
        return columnType;
    }

    public void setColumnType(ColumnType columnType) {
        this.columnType = columnType;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getId() == null) return false;

        try {
            DataColumnDef d = (DataColumnDef) obj;
            return getId().equals(d.getId());
        } catch (ClassCastException e) {
            return false;
        }
    }
}
