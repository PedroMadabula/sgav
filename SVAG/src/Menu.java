
public class Menu {
       
    private Validacao v;
    private Processos p;
    
    
    public Menu(){
         
         v= new Validacao();
         
      
    }
    public void menu() {
        byte opcao;
        
        
        do{
            p= new Processos();
            opcao = (byte) v.validarLong("1.Visualiza anuncios disponiveis\n2.Publicar anuncio de imovel \n3.Sair\n",1,3);
            System.out.println("_________________________________________________________");
            switch(opcao) {
                case 1: 
                   p.visualizarAnuncios();        
                   break;
                case 2: 
                   System.out.println("Para publicar um anuncio e' necessario possuir uma conta");
                   p.verificacao();  
                   break;
                case 3: 
                   System.out.println("Volte sempre...");
                   break;
            }        
        } while (opcao != 3);
    }
    
        
    
}