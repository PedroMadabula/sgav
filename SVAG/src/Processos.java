
import java.io.*;
import java.util.*;


public class Processos implements Serializable {
    private Validacao v;
    private Anuncios a;
    private Ficheiro f;
    private Usuario user;
    private Vector listaAnuncios;
    private Vector listaUsuarios;
    private String datAnuncios, datUsuarios;
    
    private int quantidadeUsuarios;
    
    
    public Processos(){
        datAnuncios = "Anuncios.dat";
        datUsuarios = "Usuarios.dat";
        listaAnuncios = new Vector(); 
        listaUsuarios = new Vector();
        v = new Validacao();
        f = new Ficheiro();
        lerDatUsuarioAnuncios();
        lerDatAnuncios();
        quantidadeUsuarios = listaUsuarios.size();
             
    }
    
    public void visualizarAnuncios(){
       try{ 
           FileInputStream fin = new FileInputStream(datAnuncios);
           ObjectInputStream oin = new ObjectInputStream(fin);
           listaAnuncios = (Vector)oin.readObject();
           oin.close();
           listaAnuncios.trimToSize();
           System.out.println(listaAnuncios.size());
           System.out.println("-------------[LISTA DE IMOVEIS]-------------");
           for(int i = 0; i<listaAnuncios.size(); i++){
               System.out.println((listaAnuncios.elementAt(i)).toString()+"\n_____________________________________");
               
           }
           
          
        }
        
        catch (ClassNotFoundException e1) {System.out.println(e1.getMessage());}
        catch (FileNotFoundException e2) {System.out.println("Nao ha imoveis desponiveis!");}
        catch (IOException e3) {System.out.println(e3.getMessage());}
   
    }
    
    public void verificacao(){
     byte op;
     int ultimoUsuario,quantAnuncios_Pub;
      
       op = (byte) v.validarLong("1-Login\n2-Criar conta\n3-Voltar", (byte)1,(byte)3);
       
      switch(op){
          case 1:
              login();              
              break;
              
          case 2:
              ultimoUsuario = ultimoNrConta()+1;
              user= new Usuario(ultimoUsuario);
              listaUsuarios.addElement(user);
              f.escreverFicheiroDat(listaUsuarios, datUsuarios);
              quantAnuncios_Pub = (int)v.validarLong("Quantos anuncios pretende publicar? ",1,5);             
                  for(int k=0; k<quantAnuncios_Pub; k++){
                        System.out.print("-------------------------["+(k+1)+"o Anuncio]------------------------------");
                        criarAnuncio();
                         System.out.println(a+"\n______________________________________________________");
                        listaAnuncios.addElement(a);
                    }
                  f.escreverFicheiroDat(listaAnuncios, datAnuncios);
                 
              break;       
        }
    }
    private int ultimoNrConta() {
        int ultimo = 0;
        Usuario aux;
     try{
        aux = (Usuario) listaUsuarios.elementAt(quantidadeUsuarios-1);
        ultimo = aux.getNrConta();
     }   catch(IndexOutOfBoundsException e1){ System.out.println(e1.getMessage());}
       return ultimo; 
    }
     
    
    
    
    private void lerDatAnuncios(){
       try{ 
        FileInputStream fin  = new FileInputStream(datAnuncios);
        ObjectInputStream oin = new ObjectInputStream(fin);
        listaAnuncios = (Vector)oin.readObject();
        oin.close();
        listaAnuncios.trimToSize();
        
       
        }
        catch (ClassNotFoundException e1) {System.out.println(e1.getMessage());}
        catch (FileNotFoundException e2) {System.out.println("Ficheiro nao encontrado! A execucao pode nao ocorrer devidamente.");}
        catch (IOException e3) {System.out.println(e3.getMessage());}
    } 
    
    
    
    private void lerDatUsuarioAnuncios(){
       try{ 
        FileInputStream fin  = new FileInputStream(datUsuarios);
        ObjectInputStream oin = new ObjectInputStream(fin);
        listaUsuarios = (Vector)oin.readObject();
        oin.close();
        listaUsuarios.trimToSize();
        
       
        }
        catch (ClassNotFoundException e1) {System.out.println(e1.getMessage());}
        catch (FileNotFoundException e2) {System.out.println("Ficheiro nao encontrado! A execucao pode nao ocorrer devidamente.");}
        catch (IOException e3) {System.out.println(e3.getMessage());}
    } 
     
      private void login(){
      int contTent, auxSenha, quantAnuncios_Pub;
      String auxEmail;
      boolean verificadorSenha;
      Usuario aux;
      
      contTent=3;
      verificadorSenha = true;
      do{  
                    
        System.out.println("-------------------------[LOGIN]------------------------------");
        auxEmail = v.validarEmail();
        System.out.println("_________________________________________________________");
        auxSenha = (int)v.validarLong("Introduza a senha: ",1111,9999);
        System.out.println("_________________________________________________________");
       
   
        try{
            for (int j=0; j<quantidadeUsuarios; j++){
               aux = (Usuario)listaUsuarios.elementAt(j);
                if((auxEmail.equals(aux.getEmail())) && (auxSenha==(aux.getSenha()))){
                    verificadorSenha=false;
                    quantAnuncios_Pub = (int)v.validarLong("Quantos anuncios pretende Publicar? ",1,5);
                    for(int k=0; k<quantAnuncios_Pub; k++){
                        System.out.print("-------------------------["+(k+1)+"o Anuncio]------------------------------");
                        criarAnuncio();
                        System.out.println(a+"\n______________________________________________________"); 
                        listaAnuncios.addElement(a);
                          
                    }
                        
                    f.escreverFicheiroDat(listaAnuncios, datAnuncios);
                }
            }
        }catch(IndexOutOfBoundsException e1){ System.out.println(e1.getMessage());}
         
        if (verificadorSenha){ 
            contTent-=1;
            System.out.println("E-mail e/ou password invalido(s)\n"+(contTent)+" tentativas restantes");  
        }
        
                 
      } while(verificadorSenha && contTent>=1); 
   
       
  } 
      
      private void criarAnuncio(){
      int auxNrQuartos,auxQuarteirao,auxNrCa,auxAndar=0, auxEstacionamento=0;
      float auxPreco;
      String auxTipo,auxBairro,auxRua,auxTipAnu,auxArea="";
      System.out.println("\n-------------------------[ANUNCIO]------------------------------");
      auxTipAnu= v.validarStringEspecifica("Indique o tipo de Anuncio\n1-Anuncio para venda\n2-Anuncio para aluguer\n3-Anuncio para venda e/ou aluguer ","Anuncio para venda","Anuncio para aluguer","Anuncio para venda e/ou aluguer");
      System.out.println("\n-------------------[INFORMACOES SOBRE O IMOVEL]------------------------------");
      auxBairro= v.validarString("Indique o bairro onde o imovel se localiza: ",(byte) 3, (byte) 10);
      System.out.println("_________________________________________________________");
      auxRua= v.validarString("Indique a rua onde o imovel se localiza: ",(byte) 3, (byte) 10);
      System.out.println("_________________________________________________________");
      auxQuarteirao = (int)v.validarLong("Indique o quarteirao onde se localiza o imovel: ", 1, 500);
      System.out.println("_________________________________________________________");
      auxNrCa= (int)v.validarLong("Indique o numero do imovel: ", 1, 9999);
      System.out.println("_________________________________________________________");
      auxNrQuartos= (int)v.validarLong("Indique o numero de quartos do imovel: ", 1, 8);
      System.out.println("_________________________________________________________");
      auxTipo= v.validarStringEspecifica("Indique o tipo de imovel\n1-Casa\n2-Flat","Casa","Flat","Casa");
      System.out.println("_________________________________________________________");
      if(auxTipo.equals("Flat")){
          auxEstacionamento = (int) v.validarLong("Introduza o numero de vagas de que o estacionamento dispoe: ", 0, 33);
          System.out.println("_________________________________________________________");
          auxAndar = (int)v.validarLong("Indique o andar da flat em que o apartamento se localiza: ", 1, 33);
          System.out.println("_________________________________________________________");
      }
      else
          auxArea = v.validarArea();
      System.out.println("_________________________________________________________");
      auxPreco= (float)v.validarDouble("Indique o preco do imovel: ", 2000, 10000);
      System.out.println("_________________________________________________________");
      a = new Anuncios(auxBairro, auxRua, auxQuarteirao, auxNrCa, auxNrQuartos, auxTipo, auxPreco, auxTipAnu,auxAndar,auxArea,auxEstacionamento);     
      System.out.println("\n--------------------[ANUNCIO PUBLICADO!]------------------------");  
     // System.out.println(a+"\n______________________________________________________");
  }
  
  
 
    
}


