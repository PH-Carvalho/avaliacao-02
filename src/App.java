
import java.util.List;


public class App  {

    public static void main(String[] args) throws Exception {
        
       
        Operacoes operacoes = new Operacoes();

        int opcao=0;

        do{

           
        try{
            operacoes.pularLinha();
            operacoes.menu();
            opcao=operacoes.teclado.nextInt();
            operacoes.pularLinha();
        }catch(Exception e){
            System.out.println(e);
            
            
            System.out.println("Tente novamente");
            System.out.println();
            operacoes.teclado.next();
        }

            switch(opcao){    

             case 1: 

                    Produto produto = new Produto();
                    boolean codigoExistente  =false;
                    boolean nomeExistente = false;
                     try{
                         System.out.println("*-----------Cadastro-----------*");
                          System.out.print("Qual é o nome do Produto.: ");
                          String nomeProduto= operacoes.teclado.next();
                          produto.setNomeProduto(nomeProduto);

                          for (Produto item : operacoes.listaProdutos) {

                            if(item.getNomeProduto().equals(nomeProduto)){
                                System.out.println("Esse Nome já está sendo usado. ");
                                nomeExistente = true;
                            }
                        }
                        if(nomeExistente==false){
                    
                          System.out.print("Qual é o código numérico do Produto.: ");
                          int codigoProduto =operacoes.teclado.nextInt();

                            for (Produto item : operacoes.listaProdutos) {

                                if(item.getCodigoProduto()==codigoProduto){
                                    System.out.println("Esse codigo já pertence ao produto "+item.getNomeProduto());
                                    codigoExistente=true;
                                }
                            }
                        
                            if(codigoExistente==false){

                            produto.setCodigoProduto(codigoProduto);
                             System.out.print("Qual o valor do produto.: ");
                             produto.setValorProduto(operacoes.teclado.nextFloat());
                            
                             System.out.print("Quantidade do produto.: ");
                             produto.setQuantidadeProduto(operacoes.teclado.nextInt());
                            
                             operacoes.cadastroProdutos(produto);
                             System.out.println("\n"+produto.getNomeProduto() + " Produto Adiconado com sucesso! ");
                            }
                        } 
                         }catch(Exception InputMismatchException){
                    
                            System.out.println("Digito invalido!");
                        }
                        operacoes.teclado.nextLine();  
                        System.out.println("Pressione ENTER para continuar!");
                        operacoes.teclado.nextLine();            
                     
             break;

             case 2: 
                 try{      
                        System.out.println("*-----------Consultar Produto-----------*");
                        System.out.println("Como você deseja realizar sua busca?");
                        System.out.println("1==> Nome do Produto \n2==>Código do Produto ");
                        System.out.println("Opção.: ");

                        opcao=operacoes.teclado.nextInt();

                           if(opcao==1){

                              String nomeProdutoBusca;

                              System.out.print("Digite o nome do Produto que você deseja pesquisar.: ");
                              nomeProdutoBusca=operacoes.teclado.next();

                              operacoes.buscaNomeProduto(nomeProdutoBusca);

                           } else if(opcao==2){

                               int codigoProdutoBusca;

                              System.out.print("Digite o codigo do Produto que você deseja pesquisar.: ");
                              codigoProdutoBusca=operacoes.teclado.nextInt();

                              operacoes.buscaCodigoProduto(codigoProdutoBusca);

                           }
                    } catch(Exception e ){
                         System.out.println(e);
                    }

                    operacoes.teclado.nextLine();  
                    System.out.println("\nPressione ENTER para continuar!");
                    operacoes.teclado.nextLine();            
                    
                break;
                
                     

             case 3: 
                        operacoes.listarProdutos();
                        operacoes.teclado.nextLine();  
                        System.out.println("\nPressione ENTER para continuar!");
                        operacoes.teclado.nextLine();           
                  

             break;

             case 4:  
                    System.out.println("*-----------VENDA-----------*");
                 if (operacoes.listaProdutos.isEmpty()) {
                             
                             System.out.println("Não há produtos na loja");
               } 
               else{
    
                    operacoes.venderProduto();

                }

                operacoes.teclado.nextLine();  
                System.out.println("\nPressione ENTER para continuar!");
                operacoes.teclado.nextLine();           
                break;

                case 5:
                operacoes.relatorioDeVendas();

                operacoes.teclado.nextLine();  
                System.out.println("\nPressione ENTER para continuar!");
                operacoes.teclado.nextLine();           
                break;

            }
       

        }while(opcao!=6);

        System.out.println(":):):):)-----Muito obrigado por utilizar nosso sistema volte sempre-----(:(:(:(:");


        operacoes.teclado.close();
    }

    public static void cadastroProdutos(List<Produto>listaProdutos){
    
            
    }


   


}
