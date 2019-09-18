/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testandorestfull;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import javax.swing.JOptionPane;
import org.classes.Alunos;
import org.classes.Counter;

/**
 *
 * @author DELL-Fabio
 */
public class deletar {
    public static void main(String[] args) {
        
        int aux = 0;
        while (aux <= 10){
            // TODO code application logic here    
            Counter contador = new Counter();
            Client c = Client.create();
            Alunos a = new Alunos();
            Gson gson = new Gson();


            String nome = "Mateus";
            int cont = 36;

            WebResource wr2 = c.resource("https://exemplo-firebase-d269b.firebaseio.com/alunos/" + cont + ".json");
            String response2 = wr2.get(String.class);
            Alunos b = gson.fromJson(response2, Alunos.class);

            if(b.getNome().equals(nome)){
                WebResource wr = c.resource("https://exemplo-firebase-d269b.firebaseio.com/alunos/" + cont + ".json");
                String response = wr.delete(String.class); 
                //JOptionPane.showMessageDialog(null, "Usuário deletado! :(");
                System.out.println("Interação: " + aux + "---- Deletou");
            }
            else{
                System.out.println("Interação: " + aux + "---- Não Deletou");
              //JOptionPane.showMessageDialog(null, "Não foi possível deletar :(");  
            }
            aux = aux + 1;
        } 
    }
}
