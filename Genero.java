class Genero extends Base {
    public Genero(String titulo) {
        super(titulo);
    }

    @Override
    public void detalhes() {
        System.out.println("Gênero: " + getTitulo());
    }
}