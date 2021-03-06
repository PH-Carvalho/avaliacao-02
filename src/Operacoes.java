import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


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

        DoubleSummaryStatistics resumo = listaProdutos.stream()
        .collect(Collectors.summarizingDouble(Produto::getValorProduto));

        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.printf("Maior valor.: %.2f  Menor valor %.2f  Media dos valores %.2f ",resumo.getMax(),resumo.getMin(),resumo.getAverage());
        
        
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

                if(produtos.getNomeProduto().equalsIgnoreCase(nomeProdutoBusca)  ){

                    encontrado=true;   
                    
                    produtoBuscado=produtos;

                        
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

                                vendasProdutos.add(venda);
                            }
                            else{
                                System.out.println("Quntidade insuficiente no estoque.");
                            }    
                           
                 }else{
                    System.out.println("Produto não encontrado.");
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

                System.out.println("Qual é a data da venda?");
               
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
             .filter(v -> v.getDataVenda().compareTo(dataInicial) >= 0 && v.getDataVenda().compareTo(dataFinal) <= 0)
             .forEach(v->v.toString());
               
             System.out.println("-----------------------------------------------------");
               
             DoubleSummaryStatistics mediaPorPeriodo =vendasProdutos.stream()
             .filter( v -> v.getDataVenda().compareTo(dataInicial) >= 0 && v.getDataVenda().compareTo(dataFinal) <= 0 ) 
             .collect(Collectors.summarizingDouble(Vendas::getValorTotalVenda));
               
             System.out.printf("A media de vendas do periodo %s até %s é de %.2fR$",dataInicial,dataFinal,mediaPorPeriodo.getAverage());
               
               
               
               
            }catch(Exception e ){
            
                System.out.println(e.getMessage());
            }
    
        }


    }

    @Override
    public void pularLinha() {
      
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
    
}
