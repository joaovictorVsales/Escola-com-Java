import java.util.Scanner;


public class Main {
   public static void main(String[] args) throws Exception {

       Scanner input = new Scanner(System.in);
       Aluno[] alunos = new Aluno[5];
       Professor[] professores = new Professor[5];
       int totalAlunos = 0;
       int totalProfessores = 0;
       boolean run = true;

       do {
           System.out.println("---------------------");
           System.out.println("MENU");
           System.out.println("1 - Cadastrar aluno");
           System.out.println("2 - Cadastrar professor");
           System.out.println("3 - Listar alunos");
           System.out.println("4 - Listar professores");
           System.out.println("5 - Buscar aluno por nome");
           System.out.println("6 - Buscar professor por nome");
           System.out.println("7 - Exibir dados completos");
           System.out.println("8 - Sair");
               
           System.out.print("O que deseja fazer: ");
           int opcao = Integer.parseInt(input.nextLine());

           switch (opcao) {
                case 1: {
                   if (totalAlunos < 5) {
                       System.out.println("---------------------");
                       System.out.println("CADASTRO DE ALUNO");
                     
                       System.out.print("Nome: ");
                       String nome = input.nextLine();
                     
                       System.out.print("Idade: ");
                       int idade = input.nextInt();
                       input.nextLine();

                       if (idade < 0 ){
                            System.out.println("ERROR! O aluno não pode ter idade negativa");
                            break;
                       }
                       else if(idade < 4){
                            System.out.println("ERROR! O aluno é muito novo para se cadastrar");
                            break;
                       }
                       
                       System.out.print("Matrícula: ");
                       String matricula = input.nextLine();
                       
                       System.out.print("Nota: ");
                       double nota = input.nextDouble();
                       input.nextLine();

                       if (nota < 0 || nota > 10){
                            System.out.println("ERROR! A nota do aluno deve estar entre 0 e 10");
                            break;
                       }

                       Aluno aluno = new Aluno(nome, idade, matricula, nota);
                       System.out.println("Analisando...");
                       System.out.println("Status: " + aluno.verificarAprovacao());
                       System.out.println("Aluno cadastrado com sucesso!");
                       alunos[totalAlunos] = aluno;
                       totalAlunos++;
                       break;  
                   }
                   else {
                       System.out.println("ERRO!!! O limite de alunos foi alcançado");
                       break;
                   }
                }
               case 2: {
                   if (totalProfessores < 5) {
                       System.out.println("---------------------");
                       System.out.println("CADASTRO DE PROFESSOR");
                     
                       System.out.print("Nome: ");
                       String nome = input.nextLine();
                     
                       System.out.print("Idade: ");
                       int idade = input.nextInt();
                       input.nextLine();

                       if (idade < 0 ){
                            System.out.println("ERROR! O professor não pode ter a idade nagativa ");
                            break;
                       }
                       else if(idade < 18){
                            System.out.println("Para se cadastrar como professor é necessário ter no mínimo 18 anos");
                            break;
                       }
                       
                       System.out.print("Disciplina: ");
                       String disciplina = input.nextLine();
                       
                       System.out.print("Salário: R$ ");
                       double salario = input.nextDouble();
                       input.nextLine();

                       if (salario < 0){
                            System.out.println("ERROR! O salário não pode ser negativo");
                            break;
                       }

                       Professor professor = new Professor(nome, idade, disciplina, salario);
                       System.out.println("Professor cadastrado com sucesso!");
                       professores[totalProfessores] = professor;
                       totalProfessores++;
                       break;
                   }
                   
                   else {
                       System.out.println("ERRO!!! O limite de professores foi atingido");
                       break;
                   }
                }
               case 3: {
                   if (totalAlunos > 0){
                        System.out.println("---------------------");
                        System.out.println("LISTA DE ALUNOS");
                        for (int i = 0; i < totalAlunos; i++) {
                            System.out.println("---------------------");
                            System.out.println("Aluno: " + (i + 1));
                            System.out.println("Nome: " + alunos[i].getNome());
                            System.out.println("Idade: " + alunos[i].getIdade());
                            System.out.println("Matrícula: " + alunos[i].getMatricula());
                            System.out.println("Nota: " + alunos[i].getNota());
                            System.out.println("Status: " + alunos[i].verificarAprovacao());
                        }

                        System.out.println("---------------------");
                        System.out.println("Alunos cadastrados: " + totalAlunos);
                        if (totalAlunos == 5){
                            System.out.println("Alerta! O número máximo de alunos foi atingido!");
                        }
                    }
                   
                    else {
                         System.out.println("ERRO!!! Nenhum aluno foi cadastrado ainda");
                       break;
                    }

                    System.out.println("---------------------");
                    System.out.println("1 - Alterar nota de aluno");
                    System.out.println("2 - Voltar");
                    System.out.print("O que deseja fazer? ");
                    int segunda_opcao = Integer.parseInt(input.nextLine());

                    switch (segunda_opcao) {
                        case 1: {
                            System.out.print("Digite o número do aluno que deseja alterar a nota: ");
                            int aluno_nota = input.nextInt();
                            input.nextLine();
                            boolean achou = false;

                            for(int i = 0; i < totalAlunos; i++){
                                if ((i+1) == aluno_nota) {
                                    achou = true;
                                    System.out.println("---------------------");
                                    System.out.println("Nome: " + alunos[i].getNome());
                                    System.out.println("Nota: " + alunos[i].getNota());
                                    System.out.println("---------------------");

                                    System.out.print("Qual será a nova nota? ");
                                    double nova_nota = input.nextDouble();
                                    input.nextLine();

                                    if (nova_nota < 0 || nova_nota > 10){
                                        System.out.println("ERROR! A nota deve estar entre 0 a 10");
                                    }

                                    else{
                                    alunos[i].alterarNota(nova_nota);
                                    System.out.println("Nota do aluno alterada com sucesso!");
                                    break;
                                    }
                                }
                            }

                            if (achou == false) {
                                    System.out.println("ERROR! o Aluno não foi encontrado...");
                                    break;
                                }
                            break;
                        }

                        case 2: {break;}

                    }
                    break;
                }

                case 4: {
                    if (totalProfessores > 0){
                        System.out.println("---------------------");
                        System.out.println("LISTA DE PROFESSORES");
                        for (int i = 0; i < totalProfessores; i++) {
                            System.out.println("---------------------");
                            System.out.println("Professor: " + (i + 1));
                            System.out.println("Nome: " + professores[i].getNome());
                            System.out.println("Idade: " + professores[i].getIdade());
                            System.out.println("Disciplina: " + professores[i].getDisciplina());
                            System.out.println("Salário: R$ " + professores[i].getSalario());
                            System.out.println("Salário anual: R$ " + professores[i].calcularSalario());
                        }
                        System.out.println("---------------------");
                        System.out.println("Professores cadastrados: " + totalProfessores);
                        if (totalProfessores == 5){
                            System.out.println("Alerta! O número máximo de professores foi atingido!");
                        }
                    }
                   
                    else {
                         System.out.println("ERROR!!! Nenhum professor foi cadastrado ainda");
                       break;
                    }

                    System.out.println("---------------------");
                    System.out.println("1 - Aumentar salário do professor");
                    System.out.println("2 - Voltar");
                    System.out.print("O que deseja fazer? ");
                    int segunda_opcao = Integer.parseInt(input.nextLine());
                    boolean achou = false;

                    switch (segunda_opcao) {
                        case 1: {
                            System.out.print("Digite o número do professor que deseja aumentar o salário: ");
                            int prof_salario = input.nextInt();
                            input.nextLine();

                            for(int i = 0; i < totalProfessores; i++){
                                if ((i+1) == prof_salario) {
                                    achou = true;
                                    System.out.println("---------------------");
                                    System.out.println("Nome: " + professores[i].getNome());
                                    System.out.println("Salário: R$ " + professores[i].getSalario());
                                    System.out.println("---------------------");

                                    System.out.print("Quanto será o aumento? ");
                                    double aumento = input.nextDouble();
                                    input.nextLine();

                                    if (aumento < 0){
                                        System.out.println("ERROR! O aumento não pode ser negativo! ");
                                    }

                                    else{
                                        professores[i].aumentarSalario(aumento);
                                        System.out.println("Aumento de R$" + aumento + " realizado com sucesso!");
                                        break;
                                        }
                                }
                            }

                            if (achou == false) {
                                System.out.println("ERROR! O professor não foi encontrado...");
                                break;
                                }
                            break;
                        }
                        case 2: {break;}
                    }
                    break;
                }

                case 5: {
                     if (totalAlunos > 0){
                       System.out.println("---------------------");
                       System.out.println("BUSCA DE ALUNO");
                       System.out.print("Digite o nome do aluno: ");
                       String aluno_busca = input.nextLine();
                       boolean achou = false;
                       
                       for (int i = 0; i < totalAlunos; i++) {
                           if(alunos[i].getNome().equalsIgnoreCase(aluno_busca)){
                               System.out.println("---------------------");
                               System.out.println("Número: " + (i + 1));
                               System.out.println("Nome: " + alunos[i].getNome());
                               System.out.println("Idade: " + alunos[i].getIdade());
                               System.out.println("Matrícula: " + alunos[i].getMatricula());
                               System.out.println("Nota: " + alunos[i].getNota());
                               System.out.println("Status: " + alunos[i].verificarAprovacao());
                               achou = true;
                               
                               System.out.println("---------------------");
                               System.out.println("1 - Alterar nota de aluno");
                               System.out.println("2 - Voltar");
                               System.out.print("O que deseja fazer? ");
                               int segunda_opcao = Integer.parseInt(input.nextLine());

                               switch (segunda_opcao){
                                  case 1: {
                                        System.out.print("Qual será a nova nota? ");
                                        double nova_nota = input.nextDouble();
                                        input.nextLine();

                                        if (nova_nota < 0 || nova_nota > 10){
                                            System.out.println("ERROR! A nota deve estar entre 0 a 10");
                                        }

                                        else{
                                            alunos[i].alterarNota(nova_nota);
                                            System.out.println("Nota do aluno alterada com sucesso!");
                                            achou = true;
                                            break;
                                        }
                                        break;
                                    }

                                  case 2: {break;}
                               }
                           }
                       }
                    if (achou == false) {
                            System.out.println("ERRO!!! Nenhum aluno com esse nome encontrado");
                            break;
                        }
                   }
                    else{
                       System.out.println("ERRO!!! Nenhum aluno foi cadastrado ainda");
                       break;
                   }
                   break;
                }

                case 6:{
                    if (totalProfessores > 0){
                       System.out.println("---------------------");
                       System.out.println("BUSCA DE PROFESSOR");
                       System.out.print("Digite o nome do professor: ");
                       String prof_busca = input.nextLine();
                       boolean achou = false;
                       
                       for (int i = 0; i < totalProfessores; i++) {
                           if(professores[i].getNome().equalsIgnoreCase(prof_busca)){
                               System.out.println("---------------------");
                               System.out.println("Número: " + (i + 1));
                               System.out.println("Nome: " + professores[i].getNome());
                               System.out.println("Idade: " + professores[i].getIdade());
                               System.out.println("Disciplina: " + professores[i].getDisciplina());
                               System.out.println("Salário: R$ " + professores[i].getSalario());
                               System.out.println("Salário anual: R$ " + professores[i].calcularSalario());
                               achou = true;

                               System.out.println("---------------------");
                               System.out.println("1 - Aumentar salário do professor");
                               System.out.println("2 - Voltar");
                               System.out.print("O que deseja fazer? ");
                               int segunda_opcao = Integer.parseInt(input.nextLine());

                               switch (segunda_opcao){
                                   case 1: {
                                       System.out.print("Quanto será o aumento? ");
                                       double aumento = input.nextDouble();
                                       input.nextLine();

                                       if (aumento < 0){
                                            System.out.println("ERROR! O aumento não pode ser negativo! ");
                                        }

                                       else{
                                            professores[i].aumentarSalario(aumento);
                                            System.out.println("Aumento de R$" + aumento + " realizado com sucesso!");
                                            break;
                                        }
                                        break;
                                    }
                                    case 2: {break;}
                                }
                           }
                       }

                    if (achou == false) {
                            System.out.println("ERRO!!! Nenhum professor com esse nome encontrado");
                            break;
                        }
                   }
                    else{
                       System.out.println("ERRO!!! Nenhum professor foi cadastrado ainda");
                       break;
                    }
                break;
                }

               case 7: {
                    if (totalAlunos == 0 && totalProfessores == 0) {
                        System.out.println("ERRO!!! Nenhum dado foi cadastrado ainda.");
                        break;
                    }

                    else {
                        if (totalAlunos > 0){
                            System.out.println("---------------------");
                            System.out.println("ALUNOS");
                        for (int i = 0; i < totalAlunos; i++) {
                            System.out.println("---------------------");
                            System.out.println("Aluno: " + (i + 1));
                            System.out.println("Nome: " + alunos[i].getNome());
                            System.out.println("Idade: " + alunos[i].getIdade());
                            System.out.println("Matrícula: " + alunos[i].getMatricula());
                            System.out.println("Nota: " + alunos[i].getNota());
                            System.out.println("Status: " + alunos[i].verificarAprovacao());
                        }
                        System.out.println("---------------------");
                        System.out.println("Alunos cadastrados: " + totalAlunos);
                    }

                    if (totalProfessores > 0){
                        System.out.println("---------------------");
                        System.out.println("PROFESSORES");
                        for (int i = 0; i < totalProfessores; i++) {
                            System.out.println("---------------------");
                            System.out.println("Professor: " + (i + 1));
                            System.out.println("Nome: " + professores[i].getNome());
                            System.out.println("Idade: " + professores[i].getIdade());
                            System.out.println("Disciplina: " + professores[i].getDisciplina());
                            System.out.println("Salário: R$ " + professores[i].getSalario());
                            System.out.println("Salário anual: R$ " + professores[i].calcularSalario());
                        }
                        System.out.println("---------------------");
                        System.out.println("Professores cadastrados: " + totalProfessores);
                    }
                    break;
                }
               }

               case 8: {
                   System.out.println("Obrigado por utilizar o sistema!");
                   run = false;
                   break;
               }
               default: {
                   System.out.println("Opção inválida!!!");
                   break;
               }
           }
                   
        }while(run);
   input.close();
   }
}