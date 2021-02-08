package com.calcite.example.calcite;

import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.sql.SqlOperatorTable;
import org.apache.calcite.sql.validate.SqlConformanceEnum;
import org.apache.calcite.sql.validate.SqlValidatorCatalogReader;
import org.apache.calcite.sql.validate.SqlValidatorImpl;

/**
 * 自定义Sql校验
 *
 * @author zhangap
 * @version 1.0, 2021/1/26
 */
public class IckCalciteSqlValidator extends SqlValidatorImpl {

    public IckCalciteSqlValidator(SqlOperatorTable opTab,
                                  SqlValidatorCatalogReader catalogReader,
                                  RelDataTypeFactory typeFactory) {
        super(opTab, catalogReader, typeFactory, SqlConformanceEnum.DEFAULT);
    }
}
