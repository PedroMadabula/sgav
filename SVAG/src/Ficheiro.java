
import java.io.*;
import java.util.*;

public class Ficheiro implements Serializable {
    

    
    
    public Ficheiro() {
        
    }     

    public int lerFicheiroTxt(String ficheiro){
        String umaLinha ="";
        int cont=0;
        try{
             FileReader fr = new FileReader(ficheiro);
             BufferedReader br = new BufferedReader(fr);
             umaLinha = br.readLine();
             
             while(umaLinha!=null){
               cont++;
               umaLinha = br.readLine();
             }
             br.close();
        
        }
        catch(FileNotFoundException e1) {System.out.println("Ficheiro "+ficheiro+" nao  encontrado");}
        catch(NumberFormatException e2) { System.out.println(e2.getMessage());}
        catch(IOException e2) {System.out.println(e2.getMessage());} 
        
       return cont; 
    }    
        
    public void escreverFicheiroTxt(String mensagem, String ficheiro){
        
        try{
            FileWriter fw = new FileWriter(ficheiro, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(mensagem);
            bw.close();
        }
        catch(FileNotFoundException e1) {System.out.println("O ficheiro nao "+ficheiro+" foi encontrado");}
        catch(IOException e2) {System.out.println(e2.getMessage());}
    
    
    
    }
    
    public void escreverFicheiroDat(Vector a, String ficheiro){
       
        
        
        try{
            
            FileOutputStream fout = new FileOutputStream(ficheiro);
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(a);
                
            oout.close();
        }
        catch(FileNotFoundException e1) {System.out.println("O ficheiro nao foi encontrado");}
        catch(IOException e3) {System.out.println(e3.getMessage());}
    
    
    
    }

}