import java.io.*;
import java.text.DecimalFormat;

public class Anuncios implements Serializable   {
  private String tipoAnuncio, verifica;
  private Apartamento ap;
  private Casa c;
  Validacao v;
  
 

  public Anuncios(String bairro, String rua, int quarteirao, int nrCasa, int nrQuartos, String tipo, float preco, String tipoAnuncio,int andar, String  area, int estacionamento) {
  
    if(tipo.equals("Flat")){
      ap = new Apartamento ();
      ap.setBairro(bairro);
      ap.setRua(rua);
      ap.setQuarteirao(quarteirao);
      ap.setNrCasa(nrCasa);
      ap.setNrQuartos(nrQuartos);
      ap.setTipo(tipo);
      ap.setPreco(preco);
      ap.setAndar(andar);
      ap.setEstacionamento(estacionamento);
      verifica = "Flat"; 
      
    }
      
    else{
      c = new Casa (bairro,rua,quarteirao,nrCasa,nrQuartos,preco, area);
      c = new Casa ();
      c.setBairro(bairro);
      c.setRua(rua);
      c.setQuarteirao(quarteirao);
      c.setNrCasa(nrCasa);
      c.setNrQuartos(nrQuartos);
      c.setTipo(tipo);
      c.setPreco(preco);
      c.setArea(area);
      verifica = "Casa";
    }    
     this.tipoAnuncio = tipoAnuncio;
  }
  
  public Anuncios(){
      this("", "", 0, 0, 0, "", 0,"",0,"", 0);
  }
  
  public void setTipoAnuncio(String tipoAnuncio){
      tipoAnuncio = this.tipoAnuncio;
  }
    
  
  public String getTipoAnuncio(){
      return tipoAnuncio;
  }
  public String toString() {
      if (verifica.equals("Flat"))
         return tipoAnuncio+"\n"+ap.toString();
      else
          return tipoAnuncio+"\n"+c.toString();
    }
}  