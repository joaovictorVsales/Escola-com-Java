public class Aluno extends Pessoa {

    private String matricula;
    private double nota;

    public Aluno(){
        super();
        this.matricula = "";
        this.nota = 0;
    }

    public Aluno(String nome, int idade, String matricula, double nota){
        super(nome, idade);
        this.matricula = matricula;
        this.nota = nota;
    }

    public String getMatricula(){
        return matricula;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public double getNota(){
        return nota;
    }

    public void setNota(double nota){
        this.nota = nota;
    }

    public String verificarAprovacao(){
        if (nota >= 6){
            return "Aprovado";
        }
        else{
            return "Reprovado";
        }
    }

    public double alterarNota(double n){
        nota = n;
        return nota;
    }
}