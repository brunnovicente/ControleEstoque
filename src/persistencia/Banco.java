/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Caixa;
import entidades.Cliente;
import entidades.Produto;
import entidades.Usuario;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author brunn
 */
public class Banco {
    private static Banco banco;
    private static Cliente clientePadrao;
    public static Usuario usuario;
    public static Caixa caixa = null;
    
    EntityManagerFactory factory;// = Persistence.createEntityManagerFactory("bancopecas");
    EntityManager em;// = factory.createEntityManager();
    
//    public Banco(){
//        this.abrirInstancia();
//        this.fecharInstancia();
//    }
    
    public static Banco getBanco() {
        if (banco == null) {
            banco = new Banco();
        }
        return banco;
    }
    
    /**
     * Retorna o usuário logado no sistema
     * @return Objeto usuário
     */
    public static Usuario getUsuarioLogado(){
        return usuario;
    }
    
    public static Caixa getCaixa(){
        return caixa;
    }
    
    public static Cliente getCliente(){
        return clientePadrao;
    }
    /**
     * Conecta a classe ao banco de dados
     */
    public void abrirInstancia(){
       factory = Persistence.createEntityManagerFactory("estoque");
       em = factory.createEntityManager();
   }
   
    /**
     * Fecha a conexão com o Banco de Dados
     */
    public void fecharInstancia(){
        this.factory.close();
    }
    
    
    public void cadastrar(Object objeto){
        this.abrirInstancia();
        this.em.getTransaction().begin();
        this.em.persist(objeto);
        this.em.getTransaction().commit();
        this.fecharInstancia();
    }
    
    public void editarProduto(Produto produto){
        this.abrirInstancia();
        this.em.getTransaction().begin();
        this.em.merge(produto);
        this.em.getTransaction().commit();
        this.fecharInstancia();
    }
    
    public void editarCliente(Cliente cliente){
        this.abrirInstancia();
        this.em.getTransaction().begin();
        this.em.merge(cliente);
        this.em.getTransaction().commit();
        this.fecharInstancia();
    }
    
    public void editarUsuario(Usuario usuario){
        this.abrirInstancia();
        this.em.getTransaction().begin();
        this.em.merge(usuario);
        this.em.getTransaction().commit();
        this.fecharInstancia();
    }
    
    public List<Produto> consultaProduto(String chave){
        this.abrirInstancia();
        em = factory.createEntityManager();
        List<Produto> lista = null;

        Query res = em.createQuery("SELECT "
                + "p "
                + "FROM Produto as p "
                + "WHERE (p.descricao LIKE '%"+chave+"%' OR p.codigobarras = '"+chave+"')AND p.status = 1 ORDER BY p.descricao");
        lista = res.getResultList();
        
        em.clear();
        em.close();
        this.fecharInstancia();
        return lista;
    }
    
    public Produto consultaProdutoCodigo(String codigo){
        this.abrirInstancia();
        em = factory.createEntityManager();
        List<Produto> lista = null;

        Query res = em.createQuery("SELECT "
                + "p "
                + "FROM Produto as p "
                + "WHERE p.codigobarras = '"+codigo+"' AND p.status = 1");
        lista = res.getResultList();
        
        em.clear();
        em.close();
        this.fecharInstancia();
        if(lista.isEmpty()){
            return null;
        }
        return lista.get(0);
    }
    
    public List<Cliente> consultaCliente(String nome){
        this.abrirInstancia();
        em = factory.createEntityManager();
        List<Cliente> lista = null;

        Query res = em.createQuery("SELECT "
                + "c "
                + "FROM Cliente as c "
                + "WHERE c.nome LIKE '%"+nome+"%' AND c.status = 1 ORDER BY c.nome");
        lista = res.getResultList();
        
        em.clear();
        em.close();
        this.fecharInstancia();
        return lista;
    }
    
    public List<Caixa> consultaCaixa(String nome){
        this.abrirInstancia();
        em = factory.createEntityManager();
        List<Caixa> lista = null;

        Query res = em.createQuery("SELECT "
                + "c "
                + "FROM Caixa as c "
                + " ORDER BY c.data");
        lista = res.getResultList();
        
        em.clear();
        em.close();
        this.fecharInstancia();
        return lista;
    }
    
    public List<Usuario> consultaUsuario(){
        this.abrirInstancia();
        em = factory.createEntityManager();
        List<Usuario> lista = null;

        Query res = em.createQuery("SELECT "
                + "u "
                + "FROM Usuario as u WHERE status = "+Usuario.ATIVO
                + " ORDER BY u.nome");
        lista = res.getResultList();
        
        em.clear();
        em.close();
        this.fecharInstancia();
        return lista;
    }
    
    public void verificarCaixaAberto(){
        this.abrirInstancia();
        em = factory.createEntityManager();
        List<Caixa> lista = null;

        Query res = em.createQuery("SELECT "
                + "c "
                + "FROM Caixa as c WHERE c.status = '"+Caixa.ABERTO+"'");
        lista = res.getResultList();
        
        em.clear();
        em.close();
        this.fecharInstancia();
        if(lista.isEmpty()){
            caixa = null;
        }else{
            caixa = lista.get(0);
        }
    }
    
    public void clientePadrao(){
        this.abrirInstancia();
        em = factory.createEntityManager();
        List<Cliente> lista = null;

        Query res = em.createQuery("SELECT "
                + "c "
                + "FROM Cliente as c WHERE c.cpf = '000.000.000-00'");
        lista = res.getResultList();
        
        em.clear();
        em.close();
        this.fecharInstancia();
        clientePadrao = lista.get(0);
    }
    
    public void abrirCaixa() throws SQLException {
        this.abrirInstancia();
        em = factory.createEntityManager();
        em.getTransaction().begin();
        Caixa caixa = new Caixa();
        caixa.setVendido(0);
        caixa.setDatainicio(new Date());
        caixa.setStatus(Caixa.ABERTO);
        em.persist(caixa);
        em.getTransaction().commit();
        em.clear();
        em.close();
        this.fecharInstancia();
        this.verificarCaixaAberto();
    }
    
    public void fecharCaixa(){
        this.abrirInstancia();
        em = factory.createEntityManager();
        em.getTransaction().begin();
        caixa.setDatafinal(new Date());
        caixa.setStatus(Caixa.FECHADO);
        em.merge(caixa);
        em.getTransaction().commit();
        em.clear();
        em.close();
        this.fecharInstancia();
        caixa = null;
    }
    
    public Usuario getUsuario(String login){
        this.abrirInstancia();
        em = factory.createEntityManager();
        
        List<Usuario> lista = null;

        Query res = em.createQuery("SELECT "
                + "u "
                + "FROM Usuario as u "
                + "WHERE u.login = '"+login+"'");

        lista = res.getResultList();
        
        em.clear();
        em.close();
        this.fecharInstancia();
        
        if(lista.isEmpty()){
            return null;
        }
        
        return lista.get(0);
    }
    
    public boolean fazerLogin(String login, String senha) throws Exception{
       
        Usuario user = this.getUsuario(login);
        
        if(user != null){
            if(user.getSenha().equals(Criptografia.getCriptografia().HashSHA512(senha))){
                usuario = user;
                this.verificarCaixaAberto();
                this.clientePadrao();
                return true;
            }else{
                throw new Exception("Senha Inválida!");
            }
        }else{
            throw new Exception("Usuário inválido!");
        }
    
    }
    
    public void gerarDados(){
        
        Cliente cliente = new Cliente();
        cliente.setCpf("000.000.000-00");
        cliente.setNome("Padrão");
        cliente.setStatus(Cliente.ATIVO);
        this.cadastrar(cliente);
        
        Usuario user = new Usuario();
        user.setEmail("user@user.com");
        user.setLogin("admin");
        user.setSenha(Criptografia.getCriptografia().HashSHA512("admin"));
        user.setNome("Admin");
        user.setStatus(Usuario.ATIVO);
        this.cadastrar(user);
    }
    
}//Fim da Classe
