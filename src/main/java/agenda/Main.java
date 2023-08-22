package agenda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
				Scanner entrada = new Scanner(System.in);
		        Agenda agenda = new Agenda();
		        
		        
				System.out.println("+-----------------------------------+");
				System.out.println("|         ESCOLHA UMA OPCAO         |");
				System.out.println("|-----------------------------------|");
				System.out.println("| OP 1: ADICIONAR CONTATOS A AGENDA |");
				System.out.println("| OP 2: SALVAR JSON                 |");
				System.out.println("| OP 3: SALVAR XML                  |");
				System.out.println("| OP 4: SALVAR CSV                  |");
				System.out.println("| OP 5: INSERIR AO BANCO            |");
				System.out.println("| OP 6: EXCLUIR CONTATO             |");
				System.out.println("| OP 7: PROCURAR POR NOME           |");
				System.out.println("| OP 8: PESQUISAR TODOS OS CONTATOS |");
				System.out.println("| OP 9: VER SE CONTATO EXISTE       |");
				System.out.println("|-----------------------------------|");
				System.out.println("| OP 0: SAIR                        |");
				System.out.println("+-----------------------------------+");

		        
		        boolean ok = true;
		        
        		ContatoBO contatoBO = new ContatoBO(); 
        		
        		Contato contato1 = new Contato(1, "Joao", LocalDate.of(1990, 1, 1), "123456789", "joao@example.com");
		        Contato contato2 = new Contato(2, "Maria", LocalDate.of(1995, 2, 2), "987654321", "maria@example.com");
		        Contato contato3 = new Contato(3, "Bob", LocalDate.of(1984, 11, 1), "12356789", "bob@example.com");
		        Contato contato4 = new Contato(4, "Joana", LocalDate.of(1999, 6, 9), "987333321", "joana@example.com");
		        Contato contato5 = new Contato(5, "Jaco", LocalDate.of(1977, 10, 1), "12377789", "Jaco@example.com");
		        Contato contato6 = new Contato(6, "Marcos", LocalDate.of(2001, 5, 7), "9888821", "Marcos@example.com");
		
		        
		        while (ok) {
		        	int op = entrada.nextInt();
		        	
		        	if (op==0) {
		        		
		        		ok=false;
		        		
		        	}
		        	
		        	if (op==1) {
		        		
				        // Adiciona os contatos à agenda
					    agenda.adicionarContato(contato1);
					    agenda.adicionarContato(contato2);
					    agenda.adicionarContato(contato3);
					    agenda.adicionarContato(contato4);
					    agenda.adicionarContato(contato5);
					    agenda.adicionarContato(contato6);
		        	}
		        	
		        	
		        	if (op==2) {
		        		// Salve a agenda como JSON
		 		       agenda.salvarAgendaComoJson("agenda.json");
		 		       System.out.println("Salvo como JSON com sucesso!");	        		
		        	}
		        	
		        	
		        	if (op==3) {
		        		// Salve a agenda como XML
		 		       agenda.salvarAgendaComoXML("agenda.xml");
		 		       System.out.println("Salvo como XML com sucesso!");	
		        	}
		        	
		        	
		        	if (op==4) {
		        		// Salve a agenda como CSV
		 		       agenda.salvarAgendaComoCSV("agenda.csv");
		 		       System.out.println("Salvo como CSV com sucesso!");	
		        	}
		        	
		        	
		        	if (op==5) {
		        		 // Inserir contatos no Banco
		        				        	
		 		       if (contatoBO.inserir(contato1))
		 					System.out.println("Inserido com Sucesso");
		 				else
		 					System.out.println("Erro ao Inserir");
		 		       
		 		       
		 		       if (contatoBO.inserir(contato2))
		 		    	   System.out.println("Inserido com Sucesso");
		 		       else
		 		    	   System.out.println("Erro ao Inserir");
		 		       
		 		       
		 		       if (contatoBO.inserir(contato3))
		 		    	   System.out.println("Inserido com Sucesso");
		 		       else
		 		    	   System.out.println("Erro ao Inserir");
		 		       
		 		       
		 		       if (contatoBO.inserir(contato4))
		 		    	   System.out.println("Inserido com Sucesso");
		 		       else
		 		    	   System.out.println("Erro ao Inserir");
		 		       
		 		       
		 		       if (contatoBO.inserir(contato5))
		 		    	   System.out.println("Inserido com Sucesso");
		 		       else
		 		    	   System.out.println("Erro ao Inserir");
		 		       
		 		       
		 		       if (contatoBO.inserir(contato6))
		 		    	   System.out.println("Inserido com Sucesso");
		 		       else
		 		    	   System.out.println("Erro ao Inserir");	
		        	}
		        	if (op==6) {
		        		
		        		// Excluir contatos do Banco
		        		
		        		
						if (contatoBO.excluir(contato1))
							System.out.println("Excluido Contato com Sucesso");
						else
							System.out.println("Erro ao Excluir Contato");

						if (contatoBO.excluir(contato2))
							System.out.println("Excluido Contato com Sucesso");
						else
							System.out.println("Erro ao Excluir Contato");

						if (contatoBO.excluir(contato3))
							System.out.println("Excluido Contato com Sucesso");
						else
							System.out.println("Erro ao Excluir Contato");

						if (contatoBO.excluir(contato4))
							System.out.println("Excluido Contato com Sucesso");
						else
							System.out.println("Erro ao Excluir Contato");

						if (contatoBO.excluir(contato5))
							System.out.println("Excluido Contato com Sucesso");
						else
							System.out.println("Erro ao Excluir Contato");

						if (contatoBO.excluir(contato6))
							System.out.println("Excluido Contato com Sucesso");
						else
							System.out.println("Erro ao Excluir Contato");
	
		        	}
		        	
		        	
		        	if (op==7) {
		        		
		        		//Procurar por nome
		        		
		        	
		        	if (contato1 != null) {
		        	    System.out.println("Contato encontrado:");
		        	    System.out.println(contato1.toString());
		        	} else {
		        	    System.out.println("Contato não encontrado.");
		        	}
		        	
		        	}
		        	if (op==8) {
		        		//pesquisar contato
		        		
						List<Contato> lista = new ArrayList<Contato>();
						
						lista = contatoBO.pesquisarTodos();
						
						for (Contato contato : lista) {
							System.out.println(contato.toString());
						}
		        	}
		        	
		        	if (op==9) {
						// Ver se existe
						
        
						if (contatoBO.existe(contato1))
							System.out.println("Contato Encontrada");
						else
							System.out.println("**Contato Nao Encontrada**");	
		        	}
		        	
		        }
		        
		        entrada.close();
	}


	
}