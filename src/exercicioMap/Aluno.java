package exercicioMap;

public class Aluno {

    //atributos solicitados
    private String nome;
    private double nota;

    //construtor
    public Aluno(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    //get e set
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
