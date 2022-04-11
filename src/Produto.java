

public class Produto {
    private int codigoProduto;
    private String nomeProduto;
    private float valorProduto;
    private int quantidadeProduto;

    public Produto(int codigoProduto, String nomeProduto, float valorProduto, int quantidadeProduto) {
        this.codigoProduto = codigoProduto;
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.quantidadeProduto = quantidadeProduto;
    }

    public Produto(){}

    public int getCodigoProduto() {
        return codigoProduto;
    }
    public void setCodigoProduto(int codigoProduto) {

        this.codigoProduto = codigoProduto;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    public float getValorProduto() {
        return valorProduto;
    }
    public void setValorProduto(float valorProduto) {
        this.valorProduto = valorProduto;
    }
    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }
    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }
    @Override
    public String toString() {
        return " | Código.: " + codigoProduto + "        | Produto.: " + nomeProduto + "         | Quantidade.: "
                + quantidadeProduto + "        | Preço.: " + valorProduto + "R$        |"; 
    }

    


    
}
