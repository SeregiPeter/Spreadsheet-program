package calc.util;

public class CellName {
    public static final String colIndexes = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static boolean isCellNameValid(String cellName) {
        int number = 0;
        try {
            number = Integer.parseInt(cellName.substring(1));
        } catch(Exception e) {
            return false;
        }
        if(!(colIndexes.contains(String.valueOf(cellName.charAt(0)))) || number < 0) { return false; }
        return true;
    }

    public static int getRowIndexFromCellName(String cellName) throws SheetException {
        if(!isCellNameValid(cellName)) throw new SheetException("Bad cell name.");
        return Integer.parseInt(cellName.substring(1));
    }
    
    public static int getColIndexFromCellName(String cellName) throws SheetException {
        if(!isCellNameValid(cellName)) throw new SheetException("Bad cell name.");
        return colIndexes.indexOf(cellName.charAt(0));
    }
}