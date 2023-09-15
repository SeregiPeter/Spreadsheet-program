package main;
import calc.*;
import calc.util.*;

public class Main {
    public static void main(String[] args) {
        Sheet sheet = new Sheet(3,4);
        sheet.insertToSheet("A0", new Num(6));
        sheet.insertToSheet("A1", new Num(2));
        sheet.insertToSheet("A2", new Num(2));
        sheet.insertToSheet("B0", new Num(5));
        sheet.insertToSheet("B1", new Num(6));
        sheet.insertToSheet("B2", new Num(9));
        sheet.insertToSheet("C0", new Equation("A0+B0"));
        sheet.insertToSheet("C1", new Equation("A1+B1"));
        sheet.insertToSheet("C2", new Equation("A2+B2"));
        sheet.insertToSheet("D0", new Equation("C0/2"));
        sheet.insertToSheet("D1", new Equation("C1/2"));
        sheet.insertToSheet("D2", new Equation("C2/2"));

        System.out.println(sheet);


    }
}