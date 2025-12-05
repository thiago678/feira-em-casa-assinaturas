import java.math.BigDecimal;

public class PagamentoService {

    public Pagamento processarPagamento(Cartao cartao, BigDecimal valor) {

        Pagamento pagamento = new Pagamento(1L, valor, cartao);

        // Aqui poderia ter validação real de cartão.
        // Para o projeto, vamos assumir que sempre aprova:
        pagamento.aprovar();

        return pagamento;
    }
}
