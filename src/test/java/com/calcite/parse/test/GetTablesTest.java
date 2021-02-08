package com.calcite.parse.test;

import com.calcite.example.calcite.IckCalciteCatalogReader;
import com.calcite.example.calcite.IckCalciteSqlValidator;
import com.calcite.example.parser.dql.SqlGetTables;
import com.calcite.example.parser.impl.IckSqlParserImpl;
import com.calcite.example.schema.IckSchema;
import org.apache.calcite.config.CalciteConnectionConfigImpl;
import org.apache.calcite.config.CalciteConnectionProperty;
import org.apache.calcite.config.Lex;
import org.apache.calcite.jdbc.CalciteSchema;
import org.apache.calcite.jdbc.CalciteSchemaBuilder;
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
import org.apache.calcite.rel.RelRoot;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.parser.SqlParser;
import org.apache.calcite.sql.validate.SqlConformanceEnum;
import org.apache.calcite.tools.FrameworkConfig;
import org.apache.calcite.tools.Frameworks;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Properties;

/**
 * 测试Calcite自定义SQL
 *
 * @author zhangap
 * @version 1.0, 2021/1/26
 */
public class GetTablesTest {


    @Test
    public void testGetTables() throws Exception {
        String sql = "get tables";
        final SqlNode parsed = parseStatement(sql);
        System.out.println(parsed);

        // 验证
        final SqlNode validated = validator(
                parseStatement("select e_name,e_age from emps"));
        System.out.println(validated);
    }

    /**
     * 验证SqlNode
     */
    private SqlNode validator(SqlNode sqlNode) {
        //创建CalciteFramework
        final FrameworkConfig frameworkConfig = Frameworks.newConfigBuilder()
                .parserConfig(getSqlParserConfig()).build();

        // 创建catalogReader
        final Properties props = new Properties();
        props.setProperty(CalciteConnectionProperty.CASE_SENSITIVE.camelName(), "false");
        final CalciteSchema rootSchema = CalciteSchemaBuilder.asRootSchema(new IckSchema());
        final IckCalciteCatalogReader catalogReader = new IckCalciteCatalogReader(rootSchema,
                new ArrayList<>(),
                new JavaTypeFactoryImpl(),
                new CalciteConnectionConfigImpl(props));

        // 创建validator
        final IckCalciteSqlValidator validator = new IckCalciteSqlValidator(frameworkConfig.getOperatorTable(),
                catalogReader, new JavaTypeFactoryImpl());


        // 验证SQL
        if (sqlNode instanceof SqlGetTables) {
            return sqlNode;
        }
        return validator.validate(sqlNode);
    }

    /**
     * 解析成SqlNode
     */
    private SqlNode parseStatement(String sql) throws Exception {
        return getSqlParser(sql).parseStmt();
    }

    private SqlParser getSqlParser(String sql) {
        return SqlParser.create(sql, getSqlParserConfig());
    }

    /**
     * 获取解析配置
     */
    private SqlParser.Config getSqlParserConfig() {
        return SqlParser
                .configBuilder()
                .setParserFactory(IckSqlParserImpl.FACTORY)
                .setConformance(SqlConformanceEnum.DEFAULT)
                .setLex(Lex.JAVA)
                .setIdentifierMaxLength(256)
                .build();
    }

}