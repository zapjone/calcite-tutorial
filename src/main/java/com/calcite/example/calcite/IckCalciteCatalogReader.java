package com.calcite.example.calcite;

import org.apache.calcite.config.CalciteConnectionConfig;
import org.apache.calcite.jdbc.CalciteSchema;
import org.apache.calcite.prepare.CalciteCatalogReader;
import org.apache.calcite.rel.type.RelDataTypeFactory;

import java.util.List;

/**
 * @author zhangap
 * @version 1.0, 2021/1/26
 */
public class IckCalciteCatalogReader extends CalciteCatalogReader {

    public IckCalciteCatalogReader(CalciteSchema rootSchema,
                                   List<String> defaultSchema,
                                   RelDataTypeFactory typeFactory,
                                   CalciteConnectionConfig config) {
        super(rootSchema, defaultSchema, typeFactory, config);
    }


}
