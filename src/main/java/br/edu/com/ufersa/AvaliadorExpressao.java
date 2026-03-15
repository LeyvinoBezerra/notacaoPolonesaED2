package br.edu.com.ufersa;

import java.util.Stack;

public class AvaliadorExpressao {

    public static int avaliar(String[] tokens) {
        Stack<Integer> buffer = new Stack<>();

        // Percorre da direita para a esquerda
        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];

            if (ehOperando(token)) {
                buffer.push(Integer.parseInt(token));
            } else { // é operador
                int op1 = buffer.pop();
                int op2 = buffer.pop();
                int resultado = aplicarOperador(token, op1, op2);
                buffer.push(resultado);
            }
        }

        // Resultado final é o topo da pilha
        return buffer.peek();
    }

    private static boolean ehOperando(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int aplicarOperador(String operador, int op1, int op2) {
        switch (operador) {
            case "+": return op1 + op2;
            case "-": return op1 - op2;
            case "*": return op1 * op2;
            case "/": return op1 / op2;
            default: throw new IllegalArgumentException("Operador inválido: " + operador);
        }
    }


}