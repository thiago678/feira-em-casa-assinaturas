import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CSVLoader {

    public static List<Plano> carregarPlanos(String caminho) {
        List<Plano> planos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

            String linha = br.readLine(); // pula cabeçalho

            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;

                // Formato esperado:
                // id,nome,valorBase,qtdFrutas,qtdLegumes,qtdVerduras
                String[] partes = linha.split(",");

                Long id = Long.parseLong(partes[0].trim());
                String nome = partes[1].trim();
                BigDecimal valor = new BigDecimal(partes[2].trim());
                int qtdFrutas = Integer.parseInt(partes[3].trim());
                int qtdLegumes = Integer.parseInt(partes[4].trim());
                int qtdVerduras = Integer.parseInt(partes[5].trim());

                Plano plano = new Plano(id, nome, valor, qtdFrutas, qtdLegumes, qtdVerduras);
                planos.add(plano);
            }

        } catch (IOException e) {
            System.out.println("Erro ao carregar planos (" + caminho + "): " + e.getMessage());
        }

        return planos;
    }

    public static List<Produto> carregarProdutos(String caminho) {
        List<Produto> produtos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

            String linha = br.readLine(); // pula cabeçalho

            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;

                // Formato esperado:
                // id,nome,tipo
                String[] partes = linha.split(",");

                Long id = Long.parseLong(partes[0].trim());
                String nome = partes[1].trim();
                String tipoStr = partes[2].trim().toLowerCase();

                TipoProduto tipo;
                if (tipoStr.contains("fruta")) {
                    tipo = TipoProduto.FRUTA;
                } else if (tipoStr.contains("legume")) {
                    tipo = TipoProduto.LEGUME;
                } else {
                    tipo = TipoProduto.VERDURA;
                }

                Produto produto = new Produto(id, nome, tipo);
                produtos.add(produto);
            }

        } catch (IOException e) {
            System.out.println("Erro ao carregar produtos (" + caminho + "): " + e.getMessage());
        }

        return produtos;
    }
}
