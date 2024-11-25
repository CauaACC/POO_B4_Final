import java.util.List;
import java.util.ArrayList;

class Disco extends Base {
    private int ano;
    private List<String> faixas;

    public Disco(String titulo, int ano) {
        super(titulo);
        this.ano = ano;
        this.faixas = new ArrayList<>();
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public List<String> getFaixas() {
        return faixas;
    }

    public void adicionarFaixa(String faixa) {
        faixas.add(faixa);
    }

    public void removerFaixa(String faixa) {
        faixas.removeIf(f -> f.equalsIgnoreCase(faixa));
    }

    @Override
    public void detalhes() {
        System.out.println("Disco: " + getTitulo() + " (Ano: " + ano + ")");
        System.out.println("Faixas:");
        for (String faixa : faixas) {
            System.out.println(" - " + faixa);
        }
    }
}