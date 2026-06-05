

public class Pessoa {

    private String nome;
    private int idade;

    public Pessoa(){
        this.nome = "";
        this.idade = 0;
    }

    public Pessoa(String n, int i){
        this.nome = n;
        this.idade = i;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String n){
        this.nome = n;
    }

    public int getIdade(){
        return idade;
    }

    public void setIdade(int i){
        this.idade = i;
    }

    public void exibirDados(){
        System.out.println("Dados pessoais");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
    }
}