/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicio;

import entidades.Caixa;
import entidades.Usuario;
import janelas.TelaLogin;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.Banco;


/**
 *
 * @author brunn
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Usuario usuario = Banco.getBanco().getUsuario("admin");
        if(usuario == null){
            Banco.getBanco().gerarDados();
        }
        
        TelaLogin janela = new TelaLogin();
        janela.setVisible(true);
        
        /*Hashing hash = new Hashing();
        //System.out.println(hash.HashSHA512("admin"));
        
        Usuario usuario = new Usuario();
        usuario.setLogin("bruno");
        usuario.setNome("Bruno Vicente");
        usuario.setEmail("brunnovicente@gmail.com");
        usuario.setSenha(hash.HashSHA512("admin"));
        
        Banco banco = new Banco();
        banco.cadastrar(usuario);
        System.out.println("Cadastrado com sucesso!");*/
        
        
   }
    
}
