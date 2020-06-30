
import java.util.*;
import java.io.*;

public class Usuario implements Serializable  {
    
    private String bi, nome, apelido,rua,bairro,nomeUsuario,email, dadosUser, dadosConta;
    private int celular, quarteirao,nrConta,senha;
    
    private Validacao v;
    private Usuario user;
    private String txtUsuario;
    
    public Usuario(int contUsuario) {
         
         v= new Validacao();
         txtUsuario= "Usuarios.txt";
         
         System.out.println("\n-------------------------[DADOS DO USUARIO]------------------------");
        bi = v.validarBI();
        System.out.println("_________________________________________________________");
        nome = v.validarString("Introduza o primeiro nome: ",(byte)3,(byte)10);
        System.out.println("_________________________________________________________");
        apelido = v.validarString("Introduza o apelido: ",(byte)3,(byte)10);
        System.out.println("_________________________________________________________");
        bairro = v.validarString("ENDERECO \nBairro: ", (byte)3, (byte)15);
        System.out.println("_________________________________________________________");
        quarteirao = (int) v.validarLong ("ENDERECO \nQuarteirao: ",1,50);
        System.out.println("_________________________________________________________");
        rua = v.validarString("ENDERECO \nRua: ",(byte)3,(byte)10);
        System.out.println("_________________________________________________________");
        System.out.println("\n--------------------[DADOS DA CONTA]------------------------------");
        nomeUsuario = v.validarString("Introduza o nome do usuario (username): ",(byte)3,(byte)25);
     
        System.out.println("_________________________________________________________");
        email = v.validarEmail();
     
        System.out.println("_________________________________________________________");
        senha = (int) v.validarLong ("Digite uma senha para a conta(apenas algarismos): ",0000,9999);
        System.out.println("_________________________________________________________");
        celular = (int) v.validarLong ("Digite o seu numero de celular: ",820000000,879999999);
        System.out.println("_________________________________________________________");
        nrConta = contUsuario;
      
      System.out.println("--------------------[CONTA CRIADA!]------------------------");
         dadosUser = "\n--------------------[DADOS DO USUARIO]------------------------------\nBI: "+bi+"\nNome: "+nome+" "+apelido+"\nENDERECO\nQuarteirao: "+quarteirao+"\nRua: "+rua+"\nBairro: "+bairro+"\n";
         dadosConta = "\n--------------------[DADOS DA CONTA]------------------------------\nNome do Usuario: "+nomeUsuario+"\nEmail: "+email+"\nNumero de celular: "+celular+"\nNumero da conta: "+nrConta+"\n";
       
    }
    
    
    public String getBi() { return bi; }
    public String getNome() {return nome; }
    public String getApelido() {return apelido; }
    public String getBairro() {return bairro; }
    public String getRua() { return rua; }
    public int getQuarteirao() {return quarteirao; }
    public String getNomeUsuario() { return nomeUsuario; }
    public String getEmail() {return email; }
    public int getCelular() { return celular; }
    public int getNrConta() { return nrConta; } 
    public int getSenha() {return senha; }
    
    public String toString(){
       return dadosUser+dadosConta;
   } 
  
}
