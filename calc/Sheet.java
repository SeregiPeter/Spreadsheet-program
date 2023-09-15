package calc;
import calc.util.*;
import calc.*;

public class Sheet {
    private Evaluable[][] table;
    int numOfCols;
    int numOfRows;
    public Sheet(int numOfRows, int numOfCols) {
        if(numOfRows < 1 || numOfCols < 1 || numOfCols > CellName.colIndexes.length()) throw new IllegalArgumentException("The number of rows and cols should be positive.");
        table = new Evaluable[numOfRows][numOfCols];
        this.numOfCols = numOfCols;
        this.numOfRows = numOfRows;
    }

    public void insertToSheet(String cellName, Evaluable eval) {
        int colIndex = 0;
        int rowIndex = 0;
        try {
            colIndex = CellName.getColIndexFromCellName(cellName);
            rowIndex = CellName.getRowIndexFromCellName(cellName);
        } catch(SheetException e) {
            System.out.println("Bad cell name.");
        }
        table[rowIndex][colIndex] = eval;
    }

    public Evaluable getFromSheet(String cellName) {
        int colIndex = 0;
        int rowIndex = 0;
        try {
            colIndex = CellName.getColIndexFromCellName(cellName);
            rowIndex = CellName.getRowIndexFromCellName(cellName);
        } catch(SheetException e) {
            System.out.println("Bad cell name.");
        }
        return table[rowIndex][colIndex];
    }

    public static int constructIntFromOperandStr(String operandStr, Sheet sheet) {
        Evaluable eval = null;
        if(CellName.colIndexes.contains(String.valueOf(operandStr.charAt(0)))) {
            eval = sheet.getFromSheet(operandStr);
            int a = 0;
            try {
                a = eval.eval(sheet);
            } catch(SheetException e) {
                System.out.println("XD");
            }
            return a;

        } else {
            return Integer.parseInt(operandStr);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numOfRows; i++) {
            for(int j = 0; j < numOfCols; j++) {
                try {
                    if(table[i][j] == null) sb.append("null");
                    else sb.append(table[i][j].eval(this));
                } catch(Exception e) {
                    System.out.println("XDDDD");
                }
                sb.append(" ");
            }
            if(i < numOfRows-1) sb.append("\n");
        }
        return sb.toString();
    }
    
}