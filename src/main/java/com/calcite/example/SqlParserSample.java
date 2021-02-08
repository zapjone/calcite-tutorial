package com.calcite.example;

import org.apache.calcite.config.Lex;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.dialect.OracleSqlDialect;
import org.apache.calcite.sql.parser.SqlParseException;
import org.apache.calcite.sql.parser.SqlParser;

/**
 * Calcite SQL解析
 *
 * @author zhangap
 * @version 1.0, 2021/1/22
 */
public class SqlParserSample {


    public static void main(String[] args) throws SqlParseException {
        String sql = "select * from emps where id = 1";

        final SqlParser.Config config = SqlParser.configBuilder().setLex(Lex.MYSQL).build();
        final SqlParser sqlParser = SqlParser.create(sql, config);

        final SqlNode sqlNode = sqlParser.parseQuery();

        System.out.println(sqlNode.toSqlString(OracleSqlDialect.DEFAULT));
    }


}
