import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Vendas {
    
    private LocalDate dataVenda;
    private Produto produtoVendido;
    private int quantidadeVendida;
    private float valorTotalVenda;
    private float valorTodasVendas;

    


    public DateTimeFormatter getDtf() {
        return dtf;
    }
    public void setDtf(DateTimeFormatter dtf) {
        this.dtf = dtf;
    }

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
    
    public float getValorTodasVendas() {
        return valorTodasVendas;
    }
    public void setValorTodasVendas(float valorTodasVendas) {
        this.valorTodasVendas = valorTodasVendas;
    }
    
    public LocalDate getDataVenda() {
        return dataVenda;
    }
    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }
    public Produto getProdutoVendido() {
        return produtoVendido;
    }
    public void setProdutoVendido(Produto produtoVendido) {
        this.produtoVendido = produtoVendido;
    }
    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }
    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public float getValorTotalVenda() {
        return valorTotalVenda;
    }
    public void setValorTotalVenda(float valorTotalVenda) {
        this.valorTotalVenda = valorTotalVenda;
    }


    @Override
    public String toString() {
        return "|Data da Venda.: " +dtf.format(dataVenda) + "| Produto Vendido.: " + produtoVendido.getNomeProduto() + "|Quantidade Vendida.: "
                + quantidadeVendida + "|Valor Total da Venda.: " + valorTotalVenda + "R$|";
    }

    
}
