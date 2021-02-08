/**
* Parse a "Get Tables" metadata query command.
*/
SqlGetTables SqlGetTables():
{
}

{
    <GET> <TABLES>
    {
        return new SqlGetTables(getPos());
    }
}

SqlNode SqlFlinkJob():
{
 SqlNode stringNode;
}

{
    <FLINK> <JOB>
    stringNode = StringLiteral()
    {
        return new SqlFlinkJob(getPos(), token.image);
    }
}
