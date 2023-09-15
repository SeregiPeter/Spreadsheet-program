package tests;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import calc.util.*;
import calc.*;

public class Tests {
    @Test
    public void testvalid1() {
        assertEquals(false, CellName.isCellNameValid("A 1"));
    }
    @Test
    public void testvalid2() {
        assertEquals(false, CellName.isCellNameValid("a1"));
    }
    @Test
    public void testvalid3() {
        assertEquals(false, CellName.isCellNameValid("A1XD"));
    }
    @Test
    public void testvalid4() {
        assertEquals(true, CellName.isCellNameValid("A1"));
    }
    @Test
    public void testvalid5() {
        assertEquals(true, CellName.isCellNameValid("A11"));
    }
    @Test
    public void testRowIndex() {
        try {
        assertEquals(1, CellName.getRowIndexFromCellName("A1"));
        assertEquals(11, CellName.getRowIndexFromCellName("A11"));
        } catch (SheetException e) {

        }
    }
    @Test
    public void testColIndex() {
        try {
        assertEquals(0, CellName.getRowIndexFromCellName("A1"));
        assertEquals(1, CellName.getRowIndexFromCellName("B11"));
        } catch (SheetException e){
            
        }
    }

    @Test
    public void testNumClass() {
        try {
        Num num = new Num(11);
        assertEquals(11, num.eval(null));
        } catch(SheetException e) {

        }
    }

    @Test
    public void testEquationClass1() {
        assertThrows(IllegalArgumentException.class, () -> {new Equation("2 + 1");});
    }
    @Test
    public void testEquationClass2() {
        assertThrows(IllegalArgumentException.class, () -> {new Equation("a1+2");});
    }
    @Test
    public void testEquationClass3() {
        assertThrows(IllegalArgumentException.class, () -> {new Equation("!+!");});
    }
    
}