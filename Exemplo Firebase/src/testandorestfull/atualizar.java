package testandorestfull;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import javax.swing.JOptionPane;
import org.classes.Alunos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL-Fabio
 */
public class atualizar {
    public static void main(String[] args) {
        int aux = 0;
        while (aux <= 10){
            // TODO code application logic here    
            Alunos a = new Alunos();
            Client c = Client.create();
            Gson gson = new Gson();

            int contador = 5;
            int idAluno = 0;
            String nome = "Mateus";
            int idade = 22;
            String ra = "124";


            a.setIdaluno(45);
            a.setNome("Roberto");
            a.setIdade(66);
            a.setRA("147");

            WebResource wr2 = c.resource("https://exemplo-firebase-d269b.firebaseio.com/alunos/" + contador + ".json");
            String response2 = wr2.get(String.class);
            Alunos b = gson.fromJson(response2, Alunos.class);

            if(b.getNome().equals(nome) && b.getRA().equals(ra) && b.getIdade() == idade && b.getIdaluno() == idAluno){
                WebResource wr = c.resource("https://exemplo-firebase-d269b.firebaseio.com/alunos/"+ contador +".json");
                String response = wr.type("application/json").put(String.class, gson.toJson(a));
                System.out.println("Interação: " + aux + "---- Alterou");
                //JOptionPane.showMessageDialog(null, "Usuário alterado! :(");
            }else{
                System.out.println("Interação: " + aux + "---- Não Alterou");
                //JOptionPane.showMessageDialog(null, "Usuário nao pode ser alterado! :(");
            }                
            //System.out.println(response);
            aux = aux + 1;
        }
    }  
}
