# 📘 Projeto: Avaliador de Expressões em Notação Polonesa

## 🔎 Descrição
Este projeto implementa um avaliador de expressões matemáticas escritas em **notação polonesa (prefixa)** utilizando uma **pilha (buffer)**.  
A ideia central é percorrer a expressão da **direita para a esquerda**, empilhando operandos e aplicando operadores conforme aparecem.

---

## 🧮 Pseudocódigo
criar pilha buffer para cada token da expressão da direita para esquerda: se token é operando: buffer.empilhar(token) senão
se token é operador: op1 = buffer.desempilhar() op2 = buffer.desempilhar() resultado = op1 operador op2 buffer.empilhar(resultado)
resultado final = topo da pilha


---

## 💻 Implementação em Java

```java
import java.util.Stack;

public class AvaliadorExpressao {

    public static int avaliar(String[] tokens) {
        Stack<Integer> buffer = new Stack<>();

        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];

            if (ehOperando(token)) {
                buffer.push(Integer.parseInt(token));
            } else {
                int op1 = buffer.pop();
                int op2 = buffer.pop();
                int resultado = aplicarOperador(token, op1, op2);
                buffer.push(resultado);
            }
        }

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

    public static void main(String[] args) {
        String[] expressao = {"+", "3", "*", "2", "4"}; // + 3 * 2 4
        int resultado = avaliar(expressao);
        System.out.println("Resultado final: " + resultado); // Saída: 11
    }
}

📊 Exemplo de Execução
Entrada (prefixa):
+ 3 * 2 4

Processo:
• 	Empilha , , 
• 	Aplica 
• 	Aplica 
Saída:
Resultado final: 11

🚀 Como Executar
1. 	Compile o arquivo:
javac AvaliadorExpressao.java
2. 	Execute:
java AvaliadorExpressao

📚 Conceitos Envolvidos
• 	Estrutura de dados Pilha (Stack)
• 	Notação Polonesa Prefixa
• 	Manipulação de tokens (operandos e operadores)
• 	Algoritmos de avaliação de expressões


---

# 📘 Projeto: Avaliador de Expressões em Notação Polonesa

Este projeto apresenta duas abordagens para avaliação de expressões matemáticas usando **pilha (Stack)** em Java:

- **Notação Polonesa Prefixa (Prefix)** → leitura da direita para a esquerda  
- **Notação Polonesa Pós-fixa (Postfix)** → leitura da esquerda para a direita  

---

## 🧮 Pseudocódigo (Prefixa)
criar pilha buffer para cada token da expressão da direita para esquerda: se token é operando: buffer.empilhar(token)
senão se token é operador: op1 = buffer.desempilhar() op2 = buffer.desempilhar() resultado = op1 operador op2 buffer.empilhar(resultado)
resultado final = topo da pilha


---

## 💻 Implementação em Java (Prefixa)

```java
import java.util.Stack;

public class AvaliadorPrefixo {

    public static int avaliar(String[] tokens) {
        Stack<Integer> buffer = new Stack<>();

        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];

            if (ehOperando(token)) {
                buffer.push(Integer.parseInt(token));
            } else {
                int op1 = buffer.pop();
                int op2 = buffer.pop();
                int resultado = aplicarOperador(token, op1, op2);
                buffer.push(resultado);
            }
        }

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

    public static void main(String[] args) {
        String[] expressao = {"+", "3", "*", "2", "4"}; // + 3 * 2 4
        int resultado = avaliar(expressao);
        System.out.println("Resultado final (Prefixa): " + resultado); // Saída: 11
    }
}

🧮 Pseudocódigo (Pós-fixa)

criar pilha buffer
para cada token da expressão da esquerda para direita:
    se token é operando:
        buffer.empilhar(token)
    senão se token é operador:
        op2 = buffer.desempilhar()
        op1 = buffer.desempilhar()
        resultado = op1 operador op2
        buffer.empilhar(resultado)
resultado final = topo da pilha

💻 Implementação em Java (Pós-fixa)

import java.util.Stack;

public class AvaliadorPosfixo {

    public static int avaliar(String[] tokens) {
        Stack<Integer> buffer = new Stack<>();

        for (String token : tokens) {
            if (ehOperando(token)) {
                buffer.push(Integer.parseInt(token));
            } else {
                int op2 = buffer.pop();
                int op1 = buffer.pop();
                int resultado = aplicarOperador(token, op1, op2);
                buffer.push(resultado);
            }
        }

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

    public static void main(String[] args) {
        String[] expressao = {"3", "2", "4", "*", "+"}; // 3 2 4 * +
        int resultado = avaliar(expressao);
        System.out.println("Resultado final (Pós-fixa): " + resultado); // Saída: 11
    }
}

📊 Exemplos de Execução
Prefixa
Entrada:
+ 3 * 2 4
Saída:
Resultado final (Prefixa): 11

Pós-fixa
Entrada:
3 2 4 * +
Resultado final (Pós-fixa): 11

🚀 Como Executar
1. 	Compile os arquivos:
javac AvaliadorPrefixo.java AvaliadorPosfixo.java
2. 	Execute:
java AvaliadorPrefixo
java AvaliadorPosfixo

📚 Conceitos Envolvidos
• 	Estrutura de dados Pilha (Stack)
• 	Notação Polonesa Prefixa e Pós-fixa
• 	Manipulação de tokens (operandos e operadores)
• 	Algoritmos de avaliação de expressões

# 📘 Projeto: Avaliador de Expressões em Notação Polonesa

## 🔎 Visualização com Pilha (ASCII)

### 🔹 Prefixa (direita → esquerda)
Expressão:
• 	3 * 2 4
Passos:
Tokens: [+, 3, *, 2, 4]
Lendo da direita para a esquerda:
Token 4 → empilha Pilha: [4]
Token 2 → empilha Pilha: [4, 2]
Token * → desempilha 2 e 4 → calcula 2*4=8 → empilha Pilha: [8]
Token 3 → empilha Pilha: [8, 3]
Token + → desempilha 3 e 8 → calcula 3+8=11 → empilha Pilha: [11]
Resultado final = topo da pilha = 11
---

### 🔹 Pós-fixa (esquerda → direita)
Expressão:
3 2 4 * +

Passos:
Tokens: [3, 2, 4, *, +]
Lendo da esquerda para a direita:
Token 3 → empilha Pilha: [3]
Token 2 → empilha Pilha: [3, 2]
Token 4 → empilha Pilha: [3, 2, 4]
Token * → desempilha 4 e 2 → calcula 2*4=8 → empilha Pilha: [3, 8]
Token + → desempilha 8 e 3 → calcula 3+8=11 → empilha Pilha: [11]
Resultado final = topo da pilha = 11

---

## 📊 Comparação Visual
Prefixa: direita → esquerda
• 	3 * 2 4 Resultado: 11
Pós-fixa: esquerda → direita 3 2 4 * + Resultado: 11

---

## 📚 Conceitos Envolvidos
- Estrutura de dados **Pilha (Stack)**
- **Notação Polonesa Prefixa e Pós-fixa**
- Avaliação de expressões matemáticas










