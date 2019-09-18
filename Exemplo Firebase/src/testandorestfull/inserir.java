/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testandorestfull;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.swing.JOptionPane;
import org.classes.Alunos;
import org.classes.Counter;

/**
 *
 * @author DELL-Fabio
 */
public class inserir {

    public static void main(String[] args) {
        int aux = 0;
        while (aux <= 10){
            // TODO code application logic here
            Alunos a = new Alunos();
            Gson gson = new Gson();

            String nome = "Matheus Bertonha";
            int idade = 22;
            String ra = "120116";

            a.setNome(nome);
            a.setIdade(idade);
            a.setRA(ra);

            Counter contador = new Counter();


            Client c = Client.create();
            //int pegacont = 30;
            int pegacont = contador.getContador();

            WebResource wr2 = c.resource("https://exemplo-firebase-d269b.firebaseio.com/alunos/" + pegacont + ".json");
            String response2 = wr2.get(String.class);
            Alunos b = gson.fromJson(response2, Alunos.class);

            if(response2.equals("null"))
            {
                WebResource wr = c.resource("https://exemplo-firebase-d269b.firebaseio.com/alunos/"+ pegacont +  ".json");
                String response = wr.type("application/json").put(String.class, gson.toJson(a));
                //JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!"); 
                System.out.println("Interação: " + aux + "---- Cadastrou");
            }else{
                //JOptionPane.showMessageDialog(null, "Não foi possível efetuar o cadastro :(");
                System.out.println("Interação: " + aux + "---- Não Cadastrou");
            }
            //System.out.println("Contador: " + pegacont);  
            aux = aux + 1;
        }  
    }
}
