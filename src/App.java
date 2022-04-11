
import java.util.List;
import java.util.Scanner;


public class App  {

    public static void main(String[] args) throws Exception {
        
       
        Operacoes operacoes = new Operacoes();

        Scanner teclado = new Scanner(System.in);

        int opcao=0;

        do{
        try{
            operacoes.menu();

            opcao=teclado.nextInt();
        }catch(Exception e){
            System.out.println(e);
            
            
            System.out.println("Tente novamente");
            System.out.println();
            teclado.next();
        }

            switch(opcao){    

             case 1: 

                    Produto produto = new Produto();
                    boolean CodigoExistente  =false;
                     try{
                          System.out.print("Qual é o nome do Produto.: ");
                          produto.setNomeProduto(teclado.next());
                    
                          System.out.print("Qual é o código numérico do Produto.: ");
                          int codigoProduto =teclado.nextInt();

                            for (Produto item : operacoes.listaProdutos) {

                                if(item.getCodigoProduto()==codigoProduto){
                                    System.out.println("Esse codigo já pertence ao produto "+item.getNomeProduto());
                                    CodigoExistente=true;
                                }
                            }
                        
                            if(CodigoExistente==false){

                            produto.setCodigoProduto(codigoProduto);
                             System.out.print("Qual o valor do produto.: ");
                             produto.setValorProduto(teclado.nextFloat());
                            
                             System.out.print("Quantidade do produto.: ");
                             produto.setQuantidadeProduto(teclado.nextInt());
                            
                             operacoes.cadastroProdutos(produto);
                             System.out.println(produto.getNomeProduto() + " Produto Adiconado com sucesso! ");
                            }
                          
                         }catch(Exception InputMismatchException){
                    
                            System.out.println("Digito invalido!");
                        }
 
                 
                     
             break;

             case 2: 
                 try{      
                        System.out.println("*-----------Consultar Produto-----------*");
                        System.out.println("Como você deseja realizar sua busca?");
                        System.out.println("1==> Nome do Produto \n2==>Código do Produto ");
                        System.out.println("Opção.: ");

                        opcao=teclado.nextInt();

                           if(opcao==1){

                              String nomeProdutoBusca;

                              System.out.print("Digite o nome do Produto que você deseja pesquisar.: ");
                              nomeProdutoBusca=teclado.next();

                              operacoes.buscaNomeProduto(nomeProdutoBusca);

                           } else if(opcao==2){

                               int codigoProdutoBusca;

                              System.out.print("Digite o codigo do Produto que você deseja pesquisar.: ");
                              codigoProdutoBusca=teclado.nextInt();

                              operacoes.buscaCodigoProduto(codigoProdutoBusca);

                           }
                    } catch(Exception e ){
                         System.out.println(e);
                    }
                    
                break;
                
                     

             case 3: 
                        operacoes.listarProdutos();

             break;

             case 4:  
                 if (operacoes.listaProdutos.isEmpty()) {
                             
                             System.out.println("Não há produtos na loja");
               } 
               else{
    
                    operacoes.venderProduto();

                }
                break;

                case 5:
                operacoes.relatorioDeVendas();
                break;

            }
       

        }while(opcao!=6);

        System.out.println(":):):):)-----Muito obrigado por utilizar nosso sistema volte sempre-----(:(:(:(:");


        teclado.close();
    }

    public static void cadastroProdutos(List<Produto>listaProdutos){
    
            
    }


   


}
