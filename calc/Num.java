package calc;
import calc.util.*;
import calc.*;

public class Num implements Evaluable {
    private int number;
    public Num(int number) {
        if(number < 0) throw new IllegalArgumentException("The number must be non-negative.");
        this.number = number;
    }

    @Override
    public int eval(Sheet sheet) throws SheetException {
        return number;
    }
}