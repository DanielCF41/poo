/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package engtelecom.poo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    Agenda agenda;
    Scanner teclado = new Scanner(System.in);

    public App(){
        this.agenda = new Agenda();
    }

    public void menu(){
        Contato novo = null;
        int op;
        do{
        System.out.println("...:: AGENDA TELEFÔNICA ::...");
        System.out.println("1 - Criar novo contato");
        System.out.println("2 - Adicionar telefone");
        System.out.println("3 - Adicionar email");
        System.out.println("4 - Atualizar telefone");
        System.out.println("5 - Atualizar email");
        System.out.println("6 - Remover telefone");
        System.out.println("7 - Remover email");
        System.out.println("8 - Remover contato");
        System.out.println("9 - Listar todos os contatos");
        System.out.println("10 - Sair");
        op = teclado.nextInt();
        teclado.nextLine();
            switch (op) {
                case 1:
                    System.out.print("Nome:");
                    String nome = teclado.nextLine();

                    System.out.print("Sobrenome:");
                    String sobrenome = teclado.nextLine();

                    System.out.print("Data de nascimento:");
                    LocalDate data = LocalDate.of(2000, 10, 20);
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String d = teclado.nextLine();

                    data = LocalDate.parse(d, df);
                    novo = new Contato(nome, sobrenome, data);
                    agenda.adicionarContato(novo);
                    break;
                case 2:
                    System.out.print("Índice do contato:");
                    int idAdicionaTelefone = teclado.nextInt();
                    teclado.nextLine();
                    novo = agenda.contatos.get(idAdicionaTelefone);

                    System.out.print("Telefone:");
                    String telefone = teclado.nextLine();

                    System.out.print("Rótulo:");
                    String rotuloTelefone = teclado.nextLine();

                    if(!agenda.adicionarTelefone(rotuloTelefone, telefone, novo)){
                        System.out.println("Algo de errado aconteceu!");
                        System.out.println("Telefone já existente, contato não encontrado, ou número de digitos incorreto!");
                    }
                    break;
                case 3:
                    System.out.print("Índice do contato:");
                    int idAdicionaEmail = teclado.nextInt();
                    teclado.nextLine();
                    novo = agenda.contatos.get(idAdicionaEmail);

                    System.out.print("Email:");
                    String email = teclado.nextLine();

                    System.out.print("Rótulo:");
                    String rotuloEmail = teclado.nextLine();

                    if(!agenda.adicionarEmail(rotuloEmail, email, novo)){
                        System.out.println("Algo de errado aconteceu!");
                        System.out.println("Email já existente, contato não encontrado, ou formato incorreto!");
                    }
                    break;
                case 4:
                    System.out.print("Índice do contato:");
                    int idAtualizaTelefone = teclado.nextInt();
                    teclado.nextLine();
                    novo = agenda.contatos .get(idAtualizaTelefone);

                    System.out.print("Novo telefone:");
                    String telefoneNovo = teclado.nextLine();

                    System.out.print("Rótulo:");
                    String rotuloBuscaTelefone = teclado.nextLine();

                    if(!agenda.atualizarTelefone(rotuloBuscaTelefone, telefoneNovo, novo)){
                        System.out.println("Rótulo indicado, não encontrado! Ou número de digitos incorreto.");
                    }
                    break;
                case 5:
                    System.out.print("Índice do contato:");
                    int idAtualizaEmail = teclado.nextInt();
                    teclado.nextLine();
                    novo = agenda.contatos.get(idAtualizaEmail);

                    System.out.print("Email:");
                    String emailNovo = teclado.nextLine();

                    System.out.print("Rótulo:");
                    String rotuloBuscaEmail = teclado.nextLine();

                    if(!agenda.atualizarEmail(rotuloBuscaEmail, emailNovo, novo)){
                        System.out.println("Rótulo indicado, não encontrado! Ou formato incorreto.");
                    }
                    break;
                case 6:
                    System.out.print("Índice do contato:");
                    int idRemoveTelefone = teclado.nextInt();
                    teclado.nextLine();
                    novo = agenda.contatos.get(idRemoveTelefone);

                    System.out.print("Rótulo:");
                    String rotuloRemoveTelefone = teclado.nextLine();

                    if(!agenda.removeTelefone(rotuloRemoveTelefone, novo)){
                        System.out.println("Rótulo indicado, não encontrado!");
                    }
                    break;
                case 7:
                    System.out.print("Índice do contato:");
                    int idRemoveEmail= teclado.nextInt();
                    teclado.nextLine();
                    novo = agenda.contatos.get(idRemoveEmail);

                    System.out.print("Rótulo:");
                    String rotuloRemoveEmail = teclado.nextLine();

                    if(!agenda.removeEmail(rotuloRemoveEmail, novo)){
                        System.out.println("Rótulo indicado, não encontrado!");
                    }
                    break;
                case 8:
                    System.out.print("Nome:");
                    String nomeRemover = teclado.nextLine();

                    System.out.print("Sobrenome:");
                    String sobrenomeRemover = teclado.nextLine();

                    if(!agenda.removerContato(nomeRemover, sobrenomeRemover)){
                        System.out.println("Contato não encontrado!");
                    }
                    break;
                case 9:
                    agenda.listarContatos();
                    break;
                default:
                    System.out.println("Finalizando");
            }
        }while(op != 10);
    }

    public static void main(String[] args) {
        App app = new App();
        app.menu();

    }
}
