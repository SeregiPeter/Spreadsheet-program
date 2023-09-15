package calc;
import calc.util.*;

public class Equation implements Evaluable {
    String operand1;
    String operand2;
    char operator;
    public Equation(String formula) {
        operator = 'a';
        for(int i = 0; i < formula.length(); i++) {
            switch(formula.charAt(i)){
                case '+':
                    operator = formula.charAt(i);
                    break;
                case '-':
                    operator = formula.charAt(i);
                    break;
                case '/':
                    operator = formula.charAt(i);
                    break;
                case '*':
                    operator = formula.charAt(i);
                    break;
            }
        }
        if(operator == 'a') throw new IllegalArgumentException("There is no operator.");
        String[] splitted = formula.split(("\\" + String.valueOf(operator)));
        for(String operand : splitted) {
            try {
                Integer.parseInt(operand);
            } catch(Exception e) {
                if(!CellName.isCellNameValid(operand)) throw new IllegalArgumentException("Invalid operand.");
            }
        }
        operand1 = splitted[0];
        operand2 = splitted[1];
    }

    public int eval(Sheet sheet) throws SheetException, ArithmeticException {
        int operand1;
        int operand2;
        try {
            operand1 = Integer.parseInt(this.operand1);
        } catch(Exception e) {
            operand1 = sheet.constructIntFromOperandStr(this.operand1, sheet);
        }
        try {
            operand2 = Integer.parseInt(this.operand2);
        } catch(Exception e) {
            operand2 = sheet.constructIntFromOperandStr(this.operand2, sheet);
        }
        if(operator == '+') return operand1 + operand2;
        if(operator == '*') return operand1 * operand2;
        if(operator == '/') {
            if(operand2 == 0) {
                throw new ArithmeticException();
            } else {
                return operand1 / operand2;
            }
        }
        if(operator == '-') {
            if(operand1 - operand2 < 0) {
                throw new ArithmeticException();
            } else {
                return operand1 - operand2;
            }
        }
        return 0;
    }
}