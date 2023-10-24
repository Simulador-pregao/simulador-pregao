import java.math.BigInteger;

import javax.swing.*;

import dados.DatabaseManager;
import entidades.Cliente;
import entidades.Empresa;
import estruturasDeDados.ListaEncadeada;

public class Programa extends JFrame{
    public static void main(String[] args) {
        // Programa window = new Programa();
        // window.setSize(500,500);
        // window.setVisible(true);
        // window.setTitle("My JFrame");

        // window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Cliente jujuba = new Cliente (new BigInteger("67861448954"), "Jujuba Yukina Tamashiro Yorinori");
        // DatabaseManager.gravarCliente(jujuba);
        
        DatabaseManager dbManager = new DatabaseManager();
        ListaEncadeada<Empresa> listaDeEmpresas = dbManager.lerEmpresas();
        for(int i = 0; i <= listaDeEmpresas.getTamanho(); i++){
            listaDeEmpresas.get(i);
        }
    }
}