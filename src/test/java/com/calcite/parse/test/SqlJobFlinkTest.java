package com.calcite.parse.test;

import com.calcite.example.parser.impl.IckSqlParserImpl;
import org.apache.calcite.rel.RelRoot;
import org.apache.calcite.schema.SchemaPlus;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.parser.SqlParser;
import org.apache.calcite.tools.FrameworkConfig;
import org.apache.calcite.tools.Frameworks;
import org.apache.calcite.tools.Planner;
import org.junit.Test;

/**
 * @author zhangap
 * @version 1.0, 2021/2/7
 */
public class SqlJobFlinkTest {

    /**
     * 测试自定义Sql信息解析
     */
    @Test
    public void testJobFlink() throws Exception {
        final SchemaPlus rootSchema = Frameworks.createRootSchema(true);
        final FrameworkConfig config = Frameworks.newConfigBuilder()
                .defaultSchema(rootSchema)
                .parserConfig(SqlParser.configBuilder()
                        .setParserFactory(IckSqlParserImpl.FACTORY)
                        .build()
                ).build();

        String sql = "flink job 'select name,age from persons where age >= 18 and age <= 23'";
        final Planner planner = Frameworks.getPlanner(config);

        //parse
        final SqlNode sqlNode = planner.parse(sql);
        System.out.println(sqlNode);

        //valid
        final SqlNode validated = planner.validate(sqlNode);
        System.out.println(validated);

        // rel
        //final RelRoot relNode = planner.rel(validated);
        //System.out.println(relNode);

        // Calcite窗口解析
        System.out.println("\nCalcite window parser...");
        final SqlParser parser = SqlParser.create(
                "select tumble_start(t, interval '10' second)as window_start," +
                        "tumble_end(t, interval '10' second)as window_end," +
                        "sum(age)as sum_age " +
                        "from t_name group by tumble(t, interval '10' second)",
                config.getParserConfig());
        final SqlNode tumbleSqlNode = parser.parseStmt();
        System.out.println(tumbleSqlNode);
    }

}
