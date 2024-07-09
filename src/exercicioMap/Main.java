package exercicioMap;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Criar o mapa
        Map<String, Aluno> alunos = new HashMap<>();

        // Adicionar os alunos
        alunos.put("João", new Aluno("João", 95.5));
        alunos.put("Maria", new Aluno("Maria", 89.0));
        alunos.put("Pedro", new Aluno("Pedro", 72.2));
        alunos.put("Ana", new Aluno("Ana", 60.0));
        alunos.put("Lucas", new Aluno("Lucas", 45.5));

        System.out.println("ALUNOS");
        // Exibir o conteúdo do mapa usando forEach
        alunos.forEach((nome, aluno) -> {
            System.out.println("Nome: " + aluno.getNome() + " | Nota: " + aluno.getNota());
        });

        System.out.println("============================");

        // Acessar valores no map
        String nomeBuscado = "Maria";

        Aluno alunoEncontrado = alunos.get(nomeBuscado);

        System.out.println("Procurando a aluna Maria na lista:");
        if (alunoEncontrado != null) {
            double notaDoAluno = alunoEncontrado.getNota();
            System.out.println("Nota de " + nomeBuscado + ": " + notaDoAluno);
        } else {
            System.out.println("Aluno não encontrado.");
        }

        System.out.println("============================");

        // Filtrando os alunos com nota maior que 60
        List<Aluno> alunosComNotaMaiorQue60 = alunos.values().stream()
                .filter(aluno -> aluno.getNota() > 60.0)
                .toList();

        // Exibindo os alunos encontrados
        System.out.println("Alunos com nota maior que 60:");
        for (Aluno aluno : alunosComNotaMaiorQue60) {
            System.out.println("Nome: " + aluno.getNome() + " | Nota: " + aluno.getNota());
        }

        System.out.println("============================");

        List<Aluno> removendoAlunosComNotaMenorQue60 = new ArrayList<>();
        alunos.values().removeIf(aluno -> {
            if (aluno.getNota() <= 60.0) {
                removendoAlunosComNotaMenorQue60.add(aluno);
                return true;
            }
            return false;
        });

        // Exibindo os alunos removidos
        System.out.println("Alunos removidos com nota menor que 60:");
        for (Aluno aluno : removendoAlunosComNotaMenorQue60) {
            System.out.println("Nome: " + aluno.getNome() + " | Nota: " + aluno.getNota());
        }
        System.out.println("============================");

        // Convertendo o mapa para uma lista de entradas
        List<Map.Entry<String, Aluno>> listaDeAlunos = new ArrayList<>(alunos.entrySet());

        // Ordenando a lista de entradas com base nas notas em ordem decrescente
        listaDeAlunos.sort((entry1, entry2) -> Double.compare(entry2.getValue().getNota(), entry1.getValue().getNota()));

        // Exibindo os elementos ordenados
        for (Map.Entry<String, Aluno> entry : listaDeAlunos) {
            String nome = entry.getKey();
            Aluno aluno = entry.getValue();
            System.out.println("Aluno: " + nome + " | Nota: " + aluno.getNota());
        }

        System.out.println("============================");

        // Agrupar alunos por faixa de nota
        Map<String, List<Aluno>> alunosPorFaixaDeNota = new HashMap<>();

        for (Aluno aluno : alunos.values()) {
            String faixa = obterFaixaDeNota(aluno.getNota());
            alunosPorFaixaDeNota.putIfAbsent(faixa, new ArrayList<>());
            alunosPorFaixaDeNota.get(faixa).add(aluno);
        }

        // Exibir os grupos de alunos por faixa de nota
        for (Map.Entry<String, List<Aluno>> entry : alunosPorFaixaDeNota.entrySet()) {
            System.out.println("Faixa de nota: " + entry.getKey());
            for (Aluno aluno : entry.getValue()) {
                System.out.println("Nome: " + aluno.getNome() + " | Nota: " + aluno.getNota());
            }
        }
    }

    private static String obterFaixaDeNota(double nota) {
        if (nota >= 90) {
            return "A";
        } else if (nota >= 80) {
            return "B";
        } else if (nota >= 70) {
            return "C";
        } else if (nota >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
