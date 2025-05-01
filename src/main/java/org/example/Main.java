package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Operations operations = new Operations();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Введите команду (calc, history, clear history, exit)");
            String command = scanner.nextLine();

            switch (command){
                case "calc":
                    System.out.println("Введите выражение");
                    String expression = scanner.nextLine();
                    operations.calculate(expression);
                    break;
                case "history":
                    operations.showHistory();
                    break;
                case "clear history":
                    operations.clearHistory();
                    System.out.println("История очищена");
                    break;
                case "exit":
                    System.out.println("Выход...");
                    return;
                default:
                    System.out.println("Неизвестная команда!");
            }
        }
    }
}