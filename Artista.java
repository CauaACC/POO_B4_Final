import java.util.List;
import java.util.ArrayList;

class Artista extends Base {
    private Genero genero;
    private List<Disco> discos;

    public Artista(String nome, Genero genero) {
        super(nome);
        this.genero = genero;
        this.discos = new ArrayList<>();
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Disco> getDiscos() {
        return discos;
    }

    public void adicionarDisco(Disco disco) {
        discos.add(disco);
    }

    public void removerDisco(String titulo) {
        discos.removeIf(d -> d.getTitulo().equalsIgnoreCase(titulo));
    }

    @Override
    public void detalhes() {
        System.out.println("Artista: " + getTitulo() + " (Gênero: " + genero.getTitulo() + ")");
        System.out.println("Discos:");
        for (Disco disco : discos) {
            System.out.println(" - " + disco.getTitulo());
        }
    }
}