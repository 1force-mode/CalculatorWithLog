package org.example;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.util.ArrayList;
import java.util.List;

public class Operations {
    private List<String> history;

    public Operations() {
        this.history = HistoryManager.loadFromFile();
    }

    public void calculate(String mathExpr) {
        Expression expr = new ExpressionBuilder(mathExpr).build();
        double result = expr.evaluate();
        System.out.println("Результат: " + result);

        String historyEntry = mathExpr + " = " + result;
        history.add(historyEntry);
        HistoryManager.saveToFile(history);
    }

    public void showHistory(){
        if (history.isEmpty()){
            System.out.println("История пуста");
            return;
        }
        System.out.println("История операций");
        for (String entry : history){
            System.out.println(entry);
        }
    }

    public void clearHistory(){
        history.clear();
        HistoryManager.clearFile();
    }
}
