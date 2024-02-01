package main.java.edu.DesafioControleFluxo.contador;

import java.util.Scanner;

import main.java.edu.DesafioControleFluxo.exceptions.ParametrosInvalidosException;

public class Contador {
  final static Scanner sc = new Scanner(System.in);

  public static void contador() throws ParametrosInvalidosException {
    try {
      int numeroUm, numeroDois, diferencaEntreUmeDois;

      System.out.println(
          "\n=-=-=-=-=-=-= Você está utilizando uma aplicação que conta a quantidade de números entre dois valores. =-=-=-=-=-=-=\n\n\tInsira o primeiro número:");
      numeroUm = sc.nextInt();
      System.out.println("\tInsira o segundo número:");
      numeroDois = sc.nextInt();

      try {
        if (numeroUm < numeroDois) {
          diferencaEntreUmeDois = numeroDois - numeroUm;

          System.out.printf("\nNúmero Inicial %d, Número Final %d.\nNúmeros do %d ao %d: %d.", numeroUm,
              numeroDois, numeroUm, numeroDois, diferencaEntreUmeDois);

          contagem(numeroUm, numeroDois, diferencaEntreUmeDois);
        } else {
          throw new ParametrosInvalidosException();
        }
      } catch (ParametrosInvalidosException e) {
        System.err.println(
            "\nErro na aplicação. O primeiro número é maior que o segundo. O primeiro número deve ser menor que o segundo número.\n Exemplo: 0 | 10");
      }

    } catch (Exception e) {
      System.err.println(
          "\nErro ao receber os números. Verifique se você inseriu somente números inteiros. Não utilize espaços para inserir múltiplos números ao mesmo tempo.");
    } finally {
      boolean continuaAplicacao = true;

      do {
        System.out.println(
            "\nVocê gostaria de rodar a aplicação mais uma vez?\n Digite \"Y\" para Sim e \"N\" para Não.\n");

        switch (sc.next().toLowerCase()) {

          case "y":
            contador();
            break;

          case "n":
            sc.close();
            continuaAplicacao = false;
            System.out.println("\tFim do Programa.");
            break;

          default:
            System.err.println("\n!-!-! Sua resposta é inválida, Tente novamente !-!-!");
            break;
        }
      } while (continuaAplicacao == true);
    }
  }

  public static void contagem(int numeroUm, int numeroDois, int diferencaEntreUmeDois) {
    System.out.printf("\n\nVocê quer ver a contagem do Número %d ao %d?\n Digite \"Y\" para Sim e \"N\" para Não.\n",
        numeroUm, numeroDois);

    switch (sc.next().toLowerCase()) {

      case "y":
        for (int i = 0; i <= diferencaEntreUmeDois; i++) {
          System.out.printf("\n Número intermediário %d.", numeroUm + i);
        }
        break;

      case "n":
        break;

      default:
        System.err.println("\n!-!-! Sua resposta é inválida, Tente novamente !-!-!");
        contagem(numeroUm, numeroDois, diferencaEntreUmeDois);
        break;
    }
  }
}