import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CatalogoDeDiscos {
    private static List<Genero> generos = new ArrayList<>();
    private static List<Disco> discos = new ArrayList<>();
    private static List<Artista> artistas = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            exibirMenu();
        }
    }

    private static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Cadastrar novo gênero");
        System.out.println("2. Cadastrar novo disco");
        System.out.println("3. Cadastrar novo artista");
        System.out.println("4. Listar todos");
        System.out.println("5. Editar");
        System.out.println("6. Remover");
        System.out.println("7. Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1 -> cadastrarGenero();
            case 2 -> cadastrarDisco();
            case 3 -> cadastrarArtista();
            case 4 -> listarTodos();
            case 5 -> editar();
            case 6 -> remover();
            case 7 -> System.exit(0);
            default -> System.out.println("Opção inválida!");
        }
    }

    private static void cadastrarGenero() {
        System.out.print("Nome do gênero: ");
        String nome = sc.nextLine();
        Genero genero = new Genero(nome);
        generos.add(genero);
        System.out.println("Gênero cadastrado com sucesso!");
    }
    
    private static void cadastrarDisco() {
        System.out.print("Título do disco: ");
        String titulo = sc.nextLine();
        System.out.print("Ano de lançamento: ");
        int ano = sc.nextInt();
        sc.nextLine();
    
        Disco disco = new Disco(titulo, ano);
    
        System.out.print("Quantas faixas deseja adicionar? ");
        int qtdFaixas = sc.nextInt();
        sc.nextLine();
    
        for (int i = 0; i < qtdFaixas; i++) {
            System.out.print("Título da faixa " + (i + 1) + ": ");
            String faixa = sc.nextLine();
            disco.adicionarFaixa(faixa);
        }
    
        discos.add(disco);
        System.out.println("Disco cadastrado com sucesso!");
    }
    
    private static void cadastrarArtista() {
        System.out.print("Nome do artista: ");
        String nome = sc.nextLine();
    
        System.out.println("Gêneros disponíveis:");
        listarGeneros();
        System.out.print("Escolha o gênero do artista: ");
        String nomeGenero = sc.nextLine();
        Genero genero = buscarGeneroNome(nomeGenero);
    
        if (genero == null) {
            System.out.println("Gênero não encontrado. Por favor, cadastre-o primeiro.");
            return;
        }
    
        Artista artista = new Artista(nome, genero);
    
        System.out.println("Discos disponíveis para associar:");
        listarDiscos();
        System.out.print("Deseja associar algum disco a este artista? (s/n): ");
        String resposta = sc.nextLine();
    
        if (resposta.equalsIgnoreCase("s")) {
            System.out.print("Informe o título do disco a associar: ");
            String tituloDisco = sc.nextLine();
            Disco disco = buscarDiscoTitulo(tituloDisco);
    
            if (disco != null) {
                artista.adicionarDisco(disco);
                System.out.println("Disco associado ao artista com sucesso!");
            } else {
                System.out.println("Disco não encontrado.");
            }
        }
    
        artistas.add(artista);
        System.out.println("Artista cadastrado com sucesso!");
    }

    private static void listarTodos() {
        System.out.println("\nGêneros:");
        for (Genero genero : generos) {
            genero.detalhes();
        }

        System.out.println("\nDiscos:");
        for (Disco disco : discos) {
            disco.detalhes();
        }

        System.out.println("\nArtistas:");
        for (Artista artista : artistas) {
            artista.detalhes();
        }
    }

    private static void editar() {
        System.out.println("\nEditar:");
        System.out.println("1. Gênero");
        System.out.println("2. Disco");
        System.out.println("3. Artista");
        System.out.print("Escolha uma opção: ");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1 -> editarGenero();
            case 2 -> editarDisco();
            case 3 -> editarArtista();
            default -> System.out.println("Opção inválida!");
        }
    }

    private static void remover() {
        System.out.println("\nRemover:");
        System.out.println("1. Gênero");
        System.out.println("2. Disco");
        System.out.println("3. Artista");
        System.out.print("Escolha uma opção: ");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1 -> removerGenero();
            case 2 -> removerDisco();
            case 3 -> removerArtista();
            default -> System.out.println("Opção inválida!");
        }
    }

    private static void editarGenero() {
        System.out.println("Gêneros disponíveis:");
        listarGeneros();
        System.out.print("Digite o nome do gênero que deseja editar: ");
        String nome = sc.nextLine();
        Genero genero = buscarGeneroNome(nome);

        if (genero != null) {
            System.out.print("Digite o novo nome do gênero: ");
            String novoNome = sc.nextLine();
            genero.setTitulo(novoNome);
            System.out.println("Gênero editado com sucesso!");
        } else {
            System.out.println("Gênero não encontrado.");
        }
    }

    private static void editarDisco() {
        System.out.println("Discos disponíveis:");
        listarDiscos();
        System.out.print("Digite o título do disco que deseja editar: ");
        String titulo = sc.nextLine();
        Disco disco = buscarDiscoTitulo(titulo);

        if (disco != null) {
            System.out.print("Digite o novo título do disco: ");
            String novoTitulo = sc.nextLine();
            disco.setTitulo(novoTitulo);

            System.out.print("Digite o novo ano de lançamento: ");
            int novoAno = sc.nextInt();
            sc.nextLine();
            disco.setAno(novoAno);

            System.out.println("Disco editado com sucesso!");
        } else {
            System.out.println("Disco não encontrado.");
        }
    }

    private static void editarArtista() {
        System.out.println("Artistas disponíveis:");
        listarArtistas();
        System.out.print("Digite o nome do artista que deseja editar: ");
        String nome = sc.nextLine();
        Artista artista = buscarArtistaNome(nome);

        if (artista != null) {
            System.out.print("Digite o novo nome do artista: ");
            String novoNome = sc.nextLine();
            artista.setTitulo(novoNome);

            System.out.println("Gêneros disponíveis:");
            listarGeneros();
            System.out.print("Digite o novo gênero do artista: ");
            String nomeGenero = sc.nextLine();
            Genero genero = buscarGeneroNome(nomeGenero);

            if (genero != null) {
                artista.setGenero(genero);
                System.out.println("Artista editado com sucesso!");
            } else {
                System.out.println("Gênero não encontrado. Nenhuma alteração feita no gênero.");
            }
        } else {
            System.out.println("Artista não encontrado.");
        }
    }

    private static void removerGenero() {
        System.out.println("Gêneros disponíveis:");
        listarGeneros();
        System.out.print("Digite o nome do gênero que deseja remover: ");
        String nome = sc.nextLine();
        Genero genero = buscarGeneroNome(nome);

        if (genero != null) {
            generos.remove(genero);
            System.out.println("Gênero removido com sucesso!");
        } else {
            System.out.println("Gênero não encontrado.");
        }
    }

    private static void removerDisco() {
        System.out.println("Discos disponíveis:");
        listarDiscos();
        System.out.print("Digite o título do disco que deseja remover: ");
        String titulo = sc.nextLine();
        Disco disco = buscarDiscoTitulo(titulo);

        if (disco != null) {
            discos.remove(disco);
            System.out.println("Disco removido com sucesso!");
        } else {
            System.out.println("Disco não encontrado.");
        }
    }

    private static void removerArtista() {
        System.out.println("Artistas disponíveis:");
        listarArtistas();
        System.out.print("Digite o nome do artista que deseja remover: ");
        String nome = sc.nextLine();
        Artista artista = buscarArtistaNome(nome);

        if (artista != null) {
            artistas.remove(artista);
            System.out.println("Artista removido com sucesso!");
        } else {
            System.out.println("Artista não encontrado.");
        }
    }

    private static void listarGeneros() {
        for (Genero genero : generos) {
            System.out.println("- " + genero.getTitulo());
        }
    }

    private static void listarDiscos() {
        for (Disco disco : discos) {
            System.out.println("- " + disco.getTitulo());
        }
    }

    private static void listarArtistas() {
        for (Artista artista : artistas) {
            System.out.println("- " + artista.getTitulo());
        }
    }

    private static Genero buscarGeneroNome(String nome) {
        return generos.stream().filter(g -> g.getTitulo().equalsIgnoreCase(nome)).findFirst().orElse(null);
    }

    private static Disco buscarDiscoTitulo(String titulo) {
        return discos.stream().filter(d -> d.getTitulo().equalsIgnoreCase(titulo)).findFirst().orElse(null);
    }

    private static Artista buscarArtistaNome(String nome) {
        return artistas.stream().filter(a -> a.getTitulo().equalsIgnoreCase(nome)).findFirst().orElse(null);
    }
}
