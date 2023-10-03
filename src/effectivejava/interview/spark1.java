package effectivejava.interview;

import javax.swing.table.TableColumn;

public class spark1 {
    public Dataset<Row> select(Dataset<row> input, StructType outputSchema){
        StructType inputSchema = input.getSchema();
        List<Column> colDiff = getSchemaDiff(outputSchema,inputSchema);
        List<Column> colCommon = getCommonCols(outputSchema,inputSchema);
        Dataset<Row> output;
        for (Column col : colCommon) {
            output=output.withColumns(col);
        }
        for (Column col : colDiff) {
            output=output.withColumns(col.name,null);
        }
        return output;
    }

    private List<Column> getSchemaDiff(StructType structType1, StructType structType2) {
        structType1 = sort(structType1);
        structType2 = sort(structType2);

    }
    private List<Column> getCommonCols(StructType structType1, StructType structType2) {
        structType1 = sort(structType1);
        structType2 = sort(structType2);
    }
}
