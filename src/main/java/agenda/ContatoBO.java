package agenda;

import java.util.List;

public class ContatoBO {
	
	
	public boolean inserir(Contato contato){
        if (existe(contato) != true) {
        	ContatoDAO contatoDAO = new ContatoDAO();
            return contatoDAO.inserir(contato);
        }
        return false;
    }
	
    public boolean alterar(Contato contato){
    	ContatoDAO contatoDAO = new ContatoDAO();
        return contatoDAO.alterar(contato);
    }
    
    public boolean excluir(Contato contato){
    	ContatoDAO contatoDAO = new ContatoDAO();
        return contatoDAO.excluir(contato);
    }

   
    public boolean existe(Contato contato){
    	ContatoDAO contatoDAO = new ContatoDAO();
        return contatoDAO.existe(contato);
    }
    public List<Contato> pesquisarTodos(){
    	ContatoDAO contatoDAO = new ContatoDAO();
        return contatoDAO.pesquisarTodos();
    }
    
    public Contato procurarPorNome(String nome){
        ContatoDAO contatoDAO = new ContatoDAO();
        List<Contato> contatosEncontrados = contatoDAO.procurarPorNome(nome);

        if (contatosEncontrados != null && !contatosEncontrados.isEmpty()) {
            
            return contatosEncontrados.get(0);
        } else {
            return null; 
        }
    }

    
}
