package org.apache.calcite.jdbc;

import org.apache.calcite.schema.Schema;

/**
 * @author zhangap
 * @version 1.0, 2021/1/26
 */
public class CalciteSchemaBuilder {

    public static CalciteSchema asRootSchema(Schema root) {
        return new SimpleCalciteSchema(null, root, "");
    }

    private CalciteSchemaBuilder() {
    }

}
