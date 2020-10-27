/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancarioaula;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mateus
 */
public class GerenciadoraClientesTest {
    
    public GerenciadoraClientesTest() {
    }
    
    @Test
    public void testPesquisaCliente() {
        // criando alguns clientes?
        Cliente cliente01 = new Cliente(1, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
        Cliente cliente02 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 2, true);
        
        // inserindo os clientes criados na lista de clientes do banco?
        List<Cliente> clientesDoBanco = new ArrayList<>();
        clientesDoBanco.add(cliente01);
        clientesDoBanco.add(cliente02);
        
        GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientesDoBanco);
        
        Cliente cliente = gerClientes.pesquisaCliente(1);
        
        assertThat(cliente.getId(), is(1));
        assertThat(cliente.getEmail(), is("gugafarias@gmail.com"));
    }
    
    @Test
    public void testRemoverCliente(){
        Cliente cliente01 = new Cliente(1, "Mateus Almeida", 20, "mateuzinho@gmail.com", 1, true);
        Cliente cliente02 = new Cliente(2, "Gabriel Pinheiro", 19, "andonipinheiro@gmail.com", 2, true);
        
        List<Cliente> clientesDoBanco = new ArrayList<>();
        clientesDoBanco.add(cliente01);
        clientesDoBanco.add(cliente02);
        
        GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientesDoBanco);
        
        boolean clienteRemovido = gerClientes.removeCliente(1);
        
        assertThat(clienteRemovido, is(true));
        assertThat(gerClientes.getClientesDoBanco().size(), is(1));
        assertNull(gerClientes.pesquisaCliente(1));
    }
    
}