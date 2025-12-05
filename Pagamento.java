import java.math.BigDecimal;

public class Pagamento {

    public enum StatusPagamento {
        APROVADO,
        REPROVADO
    }

    private Long idPagamento;
    private BigDecimal valor;
    private StatusPagamento status;

    public Pagamento(Long idPagamento, BigDecimal valor, StatusPagamento status) {
        this.idPagamento = idPagamento;
        this.valor = valor;
        this.status = status;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Pagamento: R$ " + valor + " - Status: " + status;
    }
}
