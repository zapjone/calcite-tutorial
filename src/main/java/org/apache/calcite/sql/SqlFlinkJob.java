package org.apache.calcite.sql;

import org.apache.calcite.sql.parser.SqlParserPos;
import org.apache.calcite.sql.util.SqlVisitor;
import org.apache.calcite.sql.validate.SqlValidator;
import org.apache.calcite.sql.validate.SqlValidatorScope;
import org.apache.calcite.util.Litmus;

/**
 * @author zhangap
 * @version 1.0, 2021/2/7
 */
public class SqlFlinkJob extends SqlNode {

    private SqlParserPos pos;
    private String jobName;

    public SqlFlinkJob(SqlParserPos pos, String jobName) {
        super(pos);
        this.pos = pos;
        this.jobName = jobName;
    }

    @Override
    public SqlNode clone(SqlParserPos pos) {
        System.out.println("clone");
        return null;
    }

    @Override
    public void unparse(SqlWriter writer, int leftPrec, int rightPrec) {
        writer.keyword("flink");
        writer.keyword("job");
        writer.print("\n");
        writer.keyword(this.jobName);
    }

    @Override
    public void validate(SqlValidator validator, SqlValidatorScope scope) {
        System.out.println("validate...");
    }

    @Override
    public <R> R accept(SqlVisitor<R> visitor) {
        System.out.println("accept...");
        return visitor.visit(SqlLiteral.createCharString(this.jobName, this.pos));
    }

    @Override
    public boolean equalsDeep(SqlNode node, Litmus litmus) {
        System.out.println("equalsDeep...");
        return false;
    }

    public String getJobName() {
        return this.jobName;
    }
}
