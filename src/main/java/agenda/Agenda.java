package agenda;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contato> contatos;

    public Agenda() {
        contatos = new ArrayList<Contato>();
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    public void salvarAgendaComoJson(String arquivo) {
        try (JsonWriter writer = Json.createWriter(new FileWriter(arquivo))) {
            JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
            for (Contato contato : contatos) {
                JsonObjectBuilder objectBuilder = Json.createObjectBuilder()
                        .add("codigo", contato.getCodigo())
                        .add("nome", contato.getNome())
                        .add("dataNascimento", contato.getDataNascimento().toString())
                        .add("telefone", contato.getTelefone())
                        .add("email", contato.getEmail());
                arrayBuilder.add(objectBuilder);
            }
            JsonArray array = arrayBuilder.build();
            writer.writeArray(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void salvarAgendaComoXML(String arquivo) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            
            // Cria o documento XML
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("agenda");
            doc.appendChild(rootElement);
            
            for (Contato contato : contatos) {
                // Cria o elemento 'contato'
                Element elementoContato = doc.createElement("contato");
                rootElement.appendChild(elementoContato);
                
                // Cria os elementos filhos dentro do elemento 'contato'
                Element elementoCodigo = doc.createElement("codigo");
                elementoCodigo.appendChild(doc.createTextNode(String.valueOf(contato.getCodigo())));
                elementoContato.appendChild(elementoCodigo);
                
                
                Element elementoNome = doc.createElement("nome");
                elementoNome.appendChild(doc.createTextNode(contato.getNome()));
                elementoContato.appendChild(elementoNome);
                
                Element elementoDataNascimento = doc.createElement("dataNascimento");
                elementoDataNascimento.appendChild(doc.createTextNode(contato.getDataNascimento().toString()));
                elementoContato.appendChild(elementoDataNascimento);
                
                Element elementoTelefone = doc.createElement("telefone");
                elementoTelefone.appendChild(doc.createTextNode(contato.getTelefone()));
                elementoContato.appendChild(elementoTelefone);
                
                Element elementoEmail = doc.createElement("email");
                elementoEmail.appendChild(doc.createTextNode(contato.getEmail()));
                elementoContato.appendChild(elementoEmail);
            }
            
            // Salva o documento XML em um arquivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(arquivo));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void salvarAgendaComoCSV(String arquivo) {
        try (FileWriter writer = new FileWriter(arquivo)) {
            // Escreve o cabeçalho do CSV
            writer.append("Codigo, Nome,Data de Nascimento,Telefone,E-mail\n");
            
            for (Contato contato : contatos) {
                // Escreve cada contato no formato CSV
            	writer.append(String.valueOf(contato.getCodigo()))
                .append(",")
                .append(contato.getNome())
                .append(",")
                .append(contato.getDataNascimento().toString())
                .append(",")
                .append(contato.getTelefone())
                .append(",")
                .append(contato.getEmail())
                .append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}