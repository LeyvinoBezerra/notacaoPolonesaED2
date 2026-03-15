package br.edu.com.ufersa;

import static br.edu.com.ufersa.AvaliadorExpressao.avaliar;

public class Main {
    public static void main(String[] args) {
        // Exemplo: expressão prefixa: + 3 * 2 4
        String[] expressao = {"+", "3", "*", "2", "4"};
        int resultado = avaliar(expressao);
        System.out.println("Resultado final: " + resultado); // Saída: 11
    }
}
