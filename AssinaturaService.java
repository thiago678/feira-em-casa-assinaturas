import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class AssinaturaService {

    private List<Plano> planos;
    private Catalogo catalogo;
    private long sequenciaCesta = 1;
    private long sequenciaAssinatura = 1;

    public AssinaturaService() {

        // carregar planos do CSV
        this.planos = CSVLoader.carregarPlanos("Plano.csv");

        // fallback
        if (this.planos == null || this.planos.isEmpty()) {
            System.out.println("Falha ao carregar Plano.csv. Usando dados padrão.");
        }

        this.catalogo = new Catalogo(1L, LocalDate.now());

        // carregar produtos do CSV
        List<Produto> produtos = CSVLoader.carregarProdutos("Produto.csv");
        if (produtos == null || produtos.isEmpty()) {
            System.out.println("Falha ao carregar Produto.csv.");
        } else {
            for (Produto p : produtos) {
                this.catalogo.adicionarProduto(p);
            }
        }
    }

    public boolean validarCodigoSms(String codigoDigitado, String codigoGerado) {
        return codigoDigitado.equals(codigoGerado);
    }

    public List<Plano> listarPlanos() {
        return planos;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public Cesta criarCesta() {
        return new Cesta(sequenciaCesta++, LocalDate.now());
    }

    public BigDecimal calcularValorTotal(Plano plano) {
        return plano.getValorBase();
    }

    public Assinatura criarAssinatura(Assinante assinante, Plano plano,
                                      Cesta cesta, Endereco endereco,
                                      Pagamento pagamento, String protocolo) {

        return new Assinatura(
                sequenciaAssinatura++,
                assinante,
                plano,
                cesta,
                endereco,
                pagamento,
                protocolo
        );
    }

    public Entrega agendarEntrega(Assinatura assinatura) {
        Entrega entrega = new Entrega(1L,
                LocalDate.now().plusDays(3),
                "08:00 - 12:00");

        assinatura.setEntrega(entrega);
        return entrega;
    }

    public String gerarProtocolo() {
        return "PRT-" + System.currentTimeMillis();
    }
}
