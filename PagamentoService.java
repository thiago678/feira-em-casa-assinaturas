import java.math.BigDecimal;

public class PagamentoService {

    public Pagamento processarPagamento(Cartao cartao, BigDecimal valor) {

        // Apenas simulação de aprovação automática
        boolean aprovado = validarCartao(cartao) && valor.compareTo(BigDecimal.ZERO) > 0;

        if (aprovarPagamentoMock()) {
            return new Pagamento(1L, valor, Pagamento.StatusPagamento.APROVADO);
        } else {
            return new Pagamento(1L, valor, Pagamento.StatusPagamento.REPROVADO);
        }
    }

    private boolean validarCartao(Cartao cartao) {
        return cartao != null
                && cartao.getNumero().length() >= 12
                && cartao.getNomeTitular() != null;
    }

    private boolean aprovarPagamentoMock() {
        // 100% aprovado para fins de projeto
        return true;
    }
}
