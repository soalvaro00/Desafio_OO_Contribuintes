package Application;

import Entities.TaxPayer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


public class Calculator {
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);

        System.out.print("Quantos contribuintes você vai digitar? ");
        int n = sc.nextInt();

        List<TaxPayer> taxPayers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.printf("Digite os dados do %dº contribuinte: ", i + 1);

            System.out.print("Renda anual com salário: ");
            double salaryIncome = sc.nextDouble();

            System.out.print("Renda anual com prestação de serviço: ");
            double servicesIncome = sc.nextDouble();

            System.out.print("Renda anual com ganho de capital: ");
            double capitalIncome = sc.nextDouble();

            System.out.print("Gastos médicos: ");
            double healthSpending = sc.nextDouble();

            System.out.print("Gastos educacionais: ");
            double educationSpending = sc.nextDouble();

            TaxPayer taxPayer = new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending);
            taxPayers.add(taxPayer);
        }

        for (int i = 0; i < taxPayers.size(); i++) {
            TaxPayer tp = taxPayers.get(i);
            System.out.println();
            System.out.printf("Resumo do %dº contribuinte: ", i + 1);
            System.out.printf("Imposto bruto total: %.2f%n", tp.grossTax());
            System.out.printf("Abatimento: %.2f%n", tp.taxRebate());
            System.out.printf("Imposto devido: %.2f%n", tp.netTax());
        }

        sc.close();
    }
}