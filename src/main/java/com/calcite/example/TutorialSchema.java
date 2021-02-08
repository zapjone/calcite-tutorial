package com.calcite.example;

import org.apache.calcite.schema.Table;
import org.apache.calcite.schema.impl.AbstractSchema;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangap
 * @version 1.0, 2021/1/22
 */
public class TutorialSchema extends AbstractSchema implements Serializable {
    private static final long serialVersionUID = -1045528235193719832L;

    private String name;

    private List<TutorialTable> tableList;


    public TutorialSchema(String name, List<TutorialTable> tableList) {
        this.name = name;
        this.tableList = tableList;
    }

    @Override
    protected Map<String, Table> getTableMap() {
        Map<String,Table> tableMap = new HashMap<>();
        for (TutorialTable table : this.tableList) {
            tableMap.put(table.getName(), table);
        }
        return tableMap;
    }
}
