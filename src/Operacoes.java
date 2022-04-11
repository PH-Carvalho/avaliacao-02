import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Operacoes implements Ferramentas {

    
    List<Produto> listaProdutos =new ArrayList<>();
    List<Vendas> vendasProdutos = new ArrayList<>();
    Scanner teclado = new Scanner(System.in);
   

    @Override
    public void menu() {
        {
            System.out.println("*-----------MENU-----------*");
            System.out.println("1 ==> Incluir Produto");
            System.out.println("2 ==> Consultar Produto");
            System.out.println("3 ==> Listagem de Produtos");
            System.out.println("4 ==> Realizar Venda ");
            System.out.println("5 ==> Vendas por Período");
            System.out.println("6 ==> Sair");
            System.out.print("Opção.: ");
        }
        
    }

    @Override
    public void listarProdutos() {
        listaProdutos.stream()
        .forEach(p-> System.out.println(p.toString()));
        
    }


    @Override
    public void buscaCodigoProduto(int codigoProdutoBusca){
        
        boolean encontrado=false;
        
        if(listaProdutos.isEmpty()){
            System.out.println("A lista de produtos está vazia.");
        }
        else{

            for (Produto produtos : listaProdutos) {

                if(produtos.getCodigoProduto()==codigoProdutoBusca){
                    encontrado=true;
                   System.out.println(produtos.toString());
                }
            }

            if(encontrado==false){
                System.out.println("Produto não encontrado");
            }      
        }
    }

    @Override
    public void buscaNomeProduto(String nomeProdutoBusca) {
        
            boolean encontrado=false;

            if(listaProdutos.isEmpty()){
                System.out.println("A lista de produtos está vazia.");
            }
            else{

                for (Produto produtos : listaProdutos) {
                    if(produtos.getNomeProduto().equals(nomeProdutoBusca)){
                        encontrado=true;
                       System.out.println( produtos.toString());    
                    }
                }
                if(encontrado==false){
                    System.out.println("Produto não encontrado");
                }
            }
        
    }

    @Override
    public void cadastroProdutos(Produto produto) {
  
        listaProdutos.add(produto);
        
    }

    @Override
    public void venderProduto() {
    try{
        Vendas venda = new Vendas();

        if(listaProdutos.isEmpty()){
            System.out.println("Lista vazia");
        }
        else{

            boolean encontrado=false;
            Produto produtoBuscado=new Produto();

            String nomeProdutoBusca;

                System.out.print("Digite o nome do Produto que você deseja adicionar comprar.: ");
                    nomeProdutoBusca=teclado.next();
        
            for (Produto produtos : listaProdutos) {

                if(produtos.getNomeProduto().equals(nomeProdutoBusca)  ){

                    encontrado=true;   
                    
                    produtoBuscado=produtos;

                        
                }else{
                    System.out.println("Produto não encontrado.");
                }

            }
                if(encontrado==true ){

                    System.out.println("Quantos produtos você deseja comprar");
                    int qtdCompra=teclado.nextInt();

                            if(qtdCompra<=produtoBuscado.getQuantidadeProduto()){

                                System.out.println("Qual a data que você está efetuando a compra.\n Lembrando que o padrão é dd/MM/yyyy");
                                System.out.print("Dia.:");
                                String dia=teclado.next();
                                System.out.print("Mês.:");
                                String mes= teclado.next();
                                System.out.print("Ano.:");
                                String ano= teclado.next();

                                LocalDate data = LocalDate.parse(ano+"-"+mes+"-"+dia);

                                venda.setQuantidadeVendida(qtdCompra);

                                venda.setValorTotalVenda(produtoBuscado.getValorProduto()*venda.getQuantidadeVendida());

                                produtoBuscado.setQuantidadeProduto(produtoBuscado.getQuantidadeProduto() - venda.getQuantidadeVendida());

                                venda.setProdutoVendido(produtoBuscado);

                                venda.setDataVenda(data);
                                venda.setValorTotal(venda.getValorTotal()+venda.getValorTotalVenda());

                                vendasProdutos.add(venda);
                            }
                            else{
                                System.out.println("Quntidade insuficiente no estoque.");
                            }    
                           
                 }
        }
    }catch(Exception e){
        System.out.println(e);
    }

        


        
    }

    @Override
    public void relatorioDeVendas() {
        
        if(vendasProdutos.isEmpty()){
            System.out.println("Não há vendas cadastradas no sistema.");
        }
        else{
         System.out.println("*-----------Relatorio das vendas-----------*");

         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
         System.out.println("Data de emisão do relatorio de vendas.:  "+dtf.format(LocalDateTime.now()));

         
        try{
         System.out.println("Qual é a data inicial de sua pesquisa?");

         System.out.print("Dia.:");
         String diaInicial=teclado.next();
         System.out.print("Mês.:");
         String mesInicial= teclado.next();
         System.out.print("Ano.:");
         String anoIncial= teclado.next();

         LocalDate dataInicial = LocalDate.parse(anoIncial+"-"+mesInicial+"-"+diaInicial);

         System.out.println("Qual é a data  Final de sua pesquisa?");

         System.out.print("Dia.:");
         String diaFinal=teclado.next();
         System.out.print("Mês.:");
         String mesFinal= teclado.next();
         System.out.print("Ano.:");
         String anoFinal= teclado.next();

         LocalDate dataFinal = LocalDate.parse(anoFinal+"-"+mesFinal+"-"+diaFinal);

         vendasProdutos.stream()
         .filter( p -> p.getDataVenda().compareTo(dataInicial) >= 0 && p.getDataVenda().compareTo(dataFinal) <= 0 ) 
         .forEach( p -> System.out.printf(p.toString()));

         vendasProdutos.stream()
         .filter( p -> p.getDataVenda().compareTo(dataInicial) >= 0 && p.getDataVenda().compareTo(dataFinal) <= 0 ) 
         .forEach(p->p.getValorTotal());
        }catch(Exception e ){

            System.out.println(e);

        }


            


         
        }


    }
    
}
