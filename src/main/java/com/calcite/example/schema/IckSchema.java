package com.calcite.example.schema;

import com.calcite.example.TutorialColumn;
import com.calcite.example.TutorialTable;
import org.apache.calcite.schema.Table;
import org.apache.calcite.schema.impl.AbstractSchema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangap
 * @version 1.0, 2021/1/26
 */
public class IckSchema extends AbstractSchema {

    @Override
    protected Map<String, Table> getTableMap() {
        Map<String, Table> tableMaps = new HashMap<>(1);

        List<TutorialColumn> columnList = new ArrayList<>();
        columnList.add(new TutorialColumn("e_name", "Varchar"));
        columnList.add(new TutorialColumn("e_age", "Integer"));

        final TutorialTable empsTable = new TutorialTable();
        empsTable.setColumnList(columnList);

        tableMaps.put("emps", empsTable);

        return tableMaps;
    }
}
