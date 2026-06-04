import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class main {
   public static void main(String[] args) throws Exception {


       Scanner input = new Scanner(System.in);
       String[] nome = new String[5];
       Integer[] idade = new Integer[5]; //É mais lento e gasta mais memória do que o int, porém possui mais recursos e métodos e pode manipular arrays melhor utilizando o arraylist e autoboxing.
       int alunos = 0;
       boolean run = true;


       do { //o do while garante que o meu sistema sempre vai rodar o loop no mínimo uma vez antes de "travar", com isso eu estou garantido que o menu sempre vai aparecer no mínimo uma vez.
       
           System.out.print("\nMENU\n1 - Cadastrar aluno\n2 - Listar alunos\n3 - Buscar aluno nome\n4 - Calcular média de idades\n5 - Exibir data/hora\n6 - Sair\n");
           
           if (alunos > 0){ 
               System.out.println("~~~~~~~~~~~~~~~~~~~~~");
               System.out.println("Alunos cadastrados: " + alunos);
               if (alunos == 5){
                   System.out.println("Alerta! número máximo de alunos foi atingidos");
               }
               System.out.println("~~~~~~~~~~~~~~~~~~~~~");
           }
           
           System.out.print("O que deseja fazer: ");
           int opcao = Integer.parseInt(input.nextLine());


           switch (opcao) {
               case 1:
                   if (alunos < 5) {
                       System.out.println("~~~~~~~~~~~~~~~~~~~~~");
                       System.out.println("CADASTRO DE ALUNO");
                      
                       System.out.print("Digite seu nome: ");
                       nome[alunos] = input.nextLine();
                      
                       System.out.print("Digite sua idade: ");
                       int aluno_idade = input.nextInt();
                       if (aluno_idade > 4 && aluno_idade <= 18){
                           idade[alunos] = aluno_idade;
                           System.out.println("Aluno cadastrado com sucesso!");
                           alunos++;
                       }
                       
                       else if (aluno_idade > 0 && aluno_idade < 4){ //4 anos é a idade minima para se cadastrar numa escola
                           System.out.println("ERRO!!! O aluno é muito novo para se cadastrar");
                       }
                       
                       else if (aluno_idade > 18){
                           System.out.println("ERRO!!! só é permitido o cadastro de estudantes de até 18 anos");
                       }
                       
                       else{
                           System.out.println("ERRO!!! Idade negativa!");
                       }
                       
                       input.nextLine();
                       break;   
                   }
                   
                   else {
                       System.out.println("ERRO!!! O limite de alunos foi alcançado");
                       break;
                   }
                  
               case 2:
                    if (alunos > 0){
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("LISTA DE ALUNOS");
                        for (int i = 0; i < alunos; i++) {
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~");
                            System.out.println("Aluno: " + (i + 1));
                            System.out.println("Nome: " + nome[i]);
                            System.out.println("Idade: " + idade[i]);
                        }
                        break;
                    }
                    
                    else {
                         System.out.println("ERRO!!! Nenhum aluno foi cadastrado ainda");
                       break;
                    }
                
               case 3:
                   if (alunos > 0){
                       System.out.println("~~~~~~~~~~~~~~~~~~~~~");
                       System.out.println("BUSCA DE ALUNO");
                       System.out.print("Digite o nome do aluno: ");
                       String aluno_busca = input.nextLine();
                       Boolean achou = false;
                       
                       for (int i = 0; i < alunos; i++) {
                           if(nome[i].equals(aluno_busca)){
                               System.out.println("~~~~~~~~~~~~~~~~~~~~~");
                               System.out.println("Aluno encontrado!");
                               System.out.println("Número: " + (i+1));
                               System.out.println("Nome: " + nome[i]);
                               System.out.println("Idade: " + idade[i]);
                               achou = true;
                           }
                       }
                       
                       if (achou == false) {
                               System.out.println("ERRO!!! Nenhum aluno com esse nome encontrado");
                               break;
                           }
                       
                      break;
                   }
                   
                   else{
                       System.out.println("ERRO!!! Nenhum aluno foi cadastrado ainda");
                       break;
                   }
                
               case 4:
                   if (alunos > 0){
                       System.out.println("~~~~~~~~~~~~~~~~~~~~~");
                       System.out.println("MEDIA DAS IDADES");
                       System.out.println("~~~~~~~~~~~~~~~~~~~~~");
                       System.out.println("Alunos - Idades")
                       ;
                       for (int i = 0; i < alunos; i++){
                           System.out.println((i + 1) + " - " + idade[i]);
                       }
                       
                       int soma = 0;
                       for (int i = 0; i < alunos; i++) {
                           soma += idade[i];
                       } 
                       int media = soma/alunos;
                       System.out.println("A média das idades é igual a " + media);
                       break;
                   }
                   
                   else {
                         System.out.println("ERRO!!! Nenhum aluno foi cadastrado ainda");
                       break;
                    }
                    
               case 5:
                   LocalDateTime data = LocalDateTime.now().minusHours(3); //fuso horário do brasil 
                   DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss", new Locale("pt", "BR"));
                   
                   String agora = data.format(formatter);
                   System.out.println("~~~~~~~~~~~~~~~~~~~~~");
                   System.out.println("Data e hora atual: " + agora);
                   break;
              
               case 6:
                   System.out.println("Obrigado por utilizar o sistema!");
                   run = false;
                   break;
  
               default:
                   System.out.println("Opção inválida!!!");
                   break;
           }
       } while(run);
   input.close();
   }
}