package com.calcite.example;

import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.schema.impl.AbstractTable;
import org.apache.calcite.sql.type.SqlTypeName;
import org.apache.calcite.util.Pair;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangap
 * @version 1.0, 2021/1/22
 */
public class TutorialTable extends AbstractTable implements Serializable {
    private static final long serialVersionUID = -3894120004397074940L;

    private String name;

    private List<TutorialColumn> columnList;

    @Override
    public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        List<String> names = new ArrayList<>();
        List<RelDataType> types = new ArrayList<>();
        for (TutorialColumn sqlExecuteColumn : columnList) {
            names.add(sqlExecuteColumn.getName());
            final RelDataType sqlType = typeFactory.createSqlType(SqlTypeName.get(sqlExecuteColumn.getType().toUpperCase()));
            types.add(sqlType);
        }
        return typeFactory.createStructType(Pair.zip(names, types));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TutorialColumn> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<TutorialColumn> columnList) {
        this.columnList = columnList;
    }
}
