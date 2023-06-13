
import br.com.rick.desafio.dominio.*;
import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author rickt
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Set<Conteudo> meusCursos = new LinkedHashSet<>();
    private static final Set<Conteudo> minhasMentorias = new LinkedHashSet<>();
    private static final Set<Bootcamp> meusBootcamps = new LinkedHashSet<>();
    private static final Set<Dev> meusDevs = new LinkedHashSet<>();

    public static void main(String[] args) {
        boolean quit = false;
        System.out.println("Pressione:");        
        imprimirInstrucoes();
        while (!quit) {
            try {
                System.out.println("(0 - para imprimir instruções)");
                System.out.print("Entrada: ");
                int entrada = scanner.nextInt();
                scanner.nextLine();
                switch (entrada) {
                    case 0:
                        imprimirInstrucoes();
                        break;
                    case 1:
                        imprimirCursos();
                        break;
                    case 2:
                        imprimirMentorias();
                        break;
                    case 3:
                        imprimirBootcamps();
                        break;
                    case 4:
                        imprimirDevs();
                        break;
                    case 5:
                        imprimirInformacoesDevs();
                        break;
                    case 6:
                        adicionarCurso();
                        break;
                    case 7:
                        adicionarMentoria();
                        break;
                    case 8:
                        adicionarBootcamp();
                        break;
                    case 9:
                        adicionarDev();
                        break;
                    case 10:
                        removerCurso();
                        break;
                    case 11:
                        removerMentoria();
                        break;
                    case 12:
                        removerBootcamp();
                        break;
                    case 13:
                        removerDev();
                        break;
                    case 14:
                        pesquisarCurso();
                        break;
                    case 15:
                        pesquisarMentoria();
                        break;
                    case 16:
                        pesquisarBootcamp();
                        break;
                    case 17:
                        pesquisarDev();
                        break;
                    case 18:
                        atualizarDev();
                        break;
                    case 19:
                        imprimirBootcampsInformacoes();
                        break;
                    case 20:
                        quit = true;
                        break;
                    default:
                        System.out.println("Entrada inválida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada deve ser apenas números inteiros");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void imprimirInstrucoes() {
        System.out.println("\n\t1 - Para imprimir cursos"
                + "\t2 - Para imprimir mentorias"
                + "\t3 - Para imprimir bootcamps"
                + "\t4 - Para imprimir devs"
                + "\t5 - Para imprimir informações dos devs"
                + "\n\t6 - Para adicionar cursos"
                + "\t7 - Para adicionar mentorias"
                + "\t8 - Para adicionar bootcamps"
                + "\t9 - Para adicionar devs"
                + "\n\t10 - Para remover cursos"
                + "\t11 - Para remover mentorias"
                + "\t12 - Para remover bootcamps"
                + "\t13 - Para remover devs"
                + "\n\t14 - Para pesquisar por cursos"
                + "\t15 - Para pesquisar por mentorias"
                + "\t16 - Para pesquisar por bootcamps"
                + "\t17 - Para pesquisar por devs"
                + "\n\t18 - Para atualizar dev"
                + "\t\t19 - Para imprimir informações de cada bootcamp"
                + "\n\t20 - Para sair da aplicação");
    }

    private static void imprimirCursos() {
        if (meusCursos.isEmpty()) {
            System.out.println("Não existe cursos");
            return;
        }
        System.out.println("Cursos:");
        for (Conteudo i : meusCursos) {
            System.out.println(i.toString());
        }
        System.out.println("==========================");
    }

    private static void imprimirMentorias() {
        if (minhasMentorias.isEmpty()) {
            System.out.println("Não existe mentorias");
            return;
        }
        System.out.println("Mentorias:");
        for (Conteudo i : minhasMentorias) {
            System.out.println(i.toString());
        }
        System.out.println("==========================");
    }

    private static void imprimirBootcamps() {
        if (meusBootcamps.isEmpty()) {
            System.out.println("Não existe bootcamps");
            return;
        }
        System.out.println("Bootcamps:");
        for (Bootcamp i : meusBootcamps) {
            System.out.println(i.getNome());
        }
        System.out.println("==========================");
    }

    private static void imprimirBootcampsInformacoes() {
        if (meusBootcamps.isEmpty()) {
            System.out.println("Não existe bootcamps");
            return;
        }
        System.out.println("Bootcamps:");
        for (Bootcamp i : meusBootcamps) {
            System.out.println(i.toString());
        }
        System.out.println("==========================");
    }

    private static void imprimirDevs() {
        if (meusDevs.isEmpty()) {
            System.out.println("Não existe devs");
            return;
        }
        System.out.println("Devs:");
        for (Dev i : meusDevs) {
            System.out.println(i.getNome());
        }
        System.out.println("==========================");
    }

    private static void imprimirInformacoesDevs() {
        if (meusDevs.isEmpty()) {
            System.out.println("Não existe devs");
            return;
        }
        System.out.println("Devs:");
        for (Dev i : meusDevs) {
            System.out.println(i.toString());
        }
        System.out.println("==========================");
    }

    private static void adicionarCurso() throws InputMismatchException {
        System.out.print("Insira carga horária do curso que deseja adicionar: ");
        int cargaHoraria = scanner.nextInt();
        scanner.nextLine();
        Conteudo curso = new Curso(cargaHoraria);
        System.out.print("Insira título do curso que deseja adicionar: ");
        String titulo = scanner.nextLine();
        Conteudo cursoExistente = pesquisarCursoOuMentoria(titulo, meusCursos);
        if (cursoExistente != null) {
            System.out.println("Erro ao adicionar curso. Curso já existe");
            return;
        }
        curso.setTitulo(titulo);
        System.out.print("Insira descrição do curso: ");
        String descricao = scanner.nextLine();
        curso.setDescricao(descricao);
        meusCursos.add(curso);
        System.out.println("Curso adicionado com sucesso");
    }

    private static void adicionarMentoria() {
        Conteudo mentoria = new Mentoria(LocalDate.now());
        System.out.print("Insira título da mentoria que deseja adicionar: ");
        String titulo = scanner.nextLine();
        Conteudo mentoriaExistente = pesquisarCursoOuMentoria(titulo, minhasMentorias);
        if (mentoriaExistente != null) {
            System.out.println("Erro ao adicionar mentoria. Mentoria já existe");
            return;
        }
        mentoria.setTitulo(titulo);
        System.out.print("Insira descrição da mentoria: ");
        String descricao = scanner.nextLine();
        mentoria.setDescricao(descricao);
        minhasMentorias.add(mentoria);
    }

    private static void adicionarBootcamp() {
        System.out.print("Insira nome do bootcamp que deseja adicionar: ");
        String nome = scanner.nextLine();
        Bootcamp bootcampExistente = pesquisarBootcamp(nome);
        if (bootcampExistente != null) {
            System.out.println("Erro ao adicionar bootcamp. Bootcamp já existe");
            return;
        }
        System.out.print("Insira descrição do bootcamp: ");
        String descricao = scanner.nextLine();
        Bootcamp bootcamp = new Bootcamp(nome, descricao);
        boolean quit = false;
        while (!quit) {
            try {
                System.out.println("Deseja adicionar um curso para esse bootcamp?"
                        + " (1 - Sim | 2 - Não)");
                System.out.print("Entrada: ");
                int entrada = scanner.nextInt();
                scanner.nextLine();
                switch (entrada) {
                    case 1:
                        imprimirCursos();
                        System.out.println("Insira curso que deseja adicionar a esse boodcamp: ");
                        String titulo = scanner.nextLine();
                        Conteudo curso = pesquisarCursoOuMentoria(titulo, meusCursos);
                        if (curso == null) {
                            System.out.println("Erro. Curso não existe");
                        } else {
                            bootcamp.getConteudos().add(curso);
                            System.out.println("Curso adicionado ao bootcamp com sucesso");
                        }
                        break;
                    case 2:
                        quit = true;
                        break;
                    default:
                        System.out.println("Entrada inválida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada deve ser apenas números inteiros: "
                        + "adicionarBootcamp()");
                scanner.nextLine();
            }

        }
        quit = false;
        while (!quit) {
            try {
                System.out.println("Deseja adicionar uma mentoria para esse bootcamp?"
                        + " (1 - Sim | 2 - Não)");
                System.out.print("Entrada: ");
                int entrada = scanner.nextInt();
                scanner.nextLine();
                switch (entrada) {
                    case 1:
                        imprimirMentorias();
                        System.out.println("Insira mentoria que deseja adicionar a esse boodcamp: ");
                        String titulo = scanner.nextLine();
                        Conteudo mentoria = pesquisarCursoOuMentoria(titulo, minhasMentorias);
                        if (mentoria == null) {
                            System.out.println("Erro. Mentoria não existe");
                        } else {
                            bootcamp.getConteudos().add(mentoria);
                            System.out.println("Mentoria adicionada ao bootcamp com sucesso");
                        }
                        break;
                    case 2:
                        quit = true;
                        break;
                    default:
                        System.out.println("Entrada inválida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada deve ser apenas números inteiros: "
                        + "adicionarBootcamp()");
                scanner.nextLine();
            }
        }
        meusBootcamps.add(bootcamp);
        System.out.println("Bootcamp adicionado com sucesso");
    }

    private static void adicionarDev() {
        System.out.print("Insira nome do Dev que deseja adicionar: ");
        String nome = scanner.nextLine();
        Dev devExistente = pesquisarDev(nome);
        if (devExistente != null) {
            System.out.println("Erro ao adicionar Dev. Dev já existe");
            return;
        }
        Dev dev = new Dev(nome);
        meusDevs.add(dev);
        System.out.println("Dev adicionado com sucesso");
    }

    private static void atualizarDev() {
        imprimirDevs();
        System.out.print("Insira nome do Dev que deseja atualizar: ");
        String nome = scanner.nextLine();
        Dev devExistente = pesquisarDev(nome);
        if (devExistente == null) {
            System.out.println("Erro ao atualizar. Dev não existe");
            return;
        }
        boolean quit = false;
        while (!quit) {
            try {
                System.out.println("Deseja adicionar Dev em um Bootcamp?"
                        + " (1 - Sim | 2 - Não)");
                System.out.print("Entrada: ");
                int entrada = scanner.nextInt();
                scanner.nextLine();
                switch (entrada) {
                    case 1:
                        imprimirBootcamps();
                        System.out.print("Insira o bootcamp que deseja que o Dev se inscreva: ");
                        String titulo = scanner.nextLine();
                        Bootcamp bootcamp = pesquisarBootcamp(titulo);
                        if (bootcamp == null) {
                            System.out.println("Erro. Bootcamp não existe");
                        } else {
                            devExistente.inscreverBootcamp(bootcamp);
                            System.out.println("Dev inscrito com sucesso");
                        }
                        break;
                    case 2:
                        quit = true;
                        break;
                    default:
                        System.out.println("Entrada inválida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada deve ser apenas números inteiros: "
                        + "atualizarDev()");
                scanner.nextLine();
            }

        }
        quit = false;
        while (!quit) {
            try {
                System.out.println("Deseja avançar progresso do Dev?"
                        + " (1 - Sim | 2 - Não)");
                System.out.print("Entrada: ");
                int entrada = scanner.nextInt();
                scanner.nextLine();
                switch (entrada) {
                    case 1:
                        devExistente.progredir();
                        System.out.println("Progresso feito com sucesso");
                        break;
                    case 2:
                        quit = true;
                        break;
                    default:
                        System.out.println("Entrada inválida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada deve ser apenas números inteiros: "
                        + "atualizarDev()");
                scanner.nextLine();
            }
        }
    }

    private static void removerCurso() {
        imprimirCursos();
        System.out.print("Insira título do curso que deseja remover: ");
        String titulo = scanner.nextLine();
        Conteudo curso = pesquisarCursoOuMentoria(titulo, meusCursos);
        if (curso == null) {
            System.out.println("Falha ao remover curso. Curso não encontrado");
            return;
        }
        meusCursos.remove(curso);
        System.out.println("Curso removido com sucesso");
    }

    private static void removerMentoria() {
        imprimirMentorias();
        System.out.print("Insira título da mentoria que deseja remover: ");
        String titulo = scanner.nextLine();
        Conteudo mentoria = pesquisarCursoOuMentoria(titulo, minhasMentorias);
        if (mentoria == null) {
            System.out.println("Falha ao remover mentoria. Mentoria não encontrada");
            return;
        }
        minhasMentorias.remove(mentoria);
        System.out.println("Mentoria removida com sucesso");
    }

    private static void removerBootcamp() {
        imprimirBootcamps();
        System.out.print("Insira nome do bootcamp que deseja remover: ");
        String nome = scanner.nextLine();
        Bootcamp bootcamp = pesquisarBootcamp(nome);
        if (bootcamp == null) {
            System.out.println("Falha ao remover bootcamp. Bootcamp não encontrado");
            return;
        }
        meusBootcamps.remove(bootcamp);        
        System.out.println("Bootcamp removido com sucesso");
    }

    private static void removerDev() {
        imprimirDevs();
        System.out.print("Insira nome do dev que deseja remover: ");
        String nome = scanner.nextLine();
        Dev dev = pesquisarDev(nome);
        if (dev == null) {
            System.out.println("Falha ao remover dev. Dev não encontrado");
            return;
        }
        meusDevs.remove(dev);
        System.out.println("Dev removido com sucesso");
    }

    private static void pesquisarCurso() {
        System.out.print("Insira título do curso que deseja pesquisar: ");
        String titulo = scanner.nextLine();
        Conteudo curso = pesquisarCursoOuMentoria(titulo, meusCursos);
        if (curso == null) {
            System.out.println("Falha ao encontrar curso. Curso não encontrado");
            return;
        }
        System.out.println("Curso encontrado com sucesso");
        System.out.println(curso.toString());
    }

    private static void pesquisarMentoria() {
        System.out.print("Insira título da mentoria que deseja pesquisar: ");
        String titulo = scanner.nextLine();
        Conteudo mentoria = pesquisarCursoOuMentoria(titulo, minhasMentorias);
        if (mentoria == null) {
            System.out.println("Falha ao encontrar mentoria. Mentoria não encontrada");
            return;
        }
        System.out.println("Mentoria encontrada com sucesso");
        System.out.println(mentoria.toString());
    }

    private static Conteudo pesquisarCursoOuMentoria(String titulo, Set<Conteudo> objeto) {
        for (Conteudo conteudo : objeto) {
            if (conteudo.getTitulo().equals(titulo)) {
                return conteudo;
            }
        }
        return null;
    }

    private static void pesquisarBootcamp() {
        System.out.print("Insira nome do bootcamp que deseja pesquisar: ");
        String nome = scanner.nextLine();
        Bootcamp bootcamp = pesquisarBootcamp(nome);
        if (bootcamp == null) {
            System.out.println("Falha ao encontrar bootcamp. Bootcamp não encontrado");
            return;
        }
        System.out.println("Bootcamp encontrado com sucesso");
        System.out.println(bootcamp.toString());
    }

    private static Bootcamp pesquisarBootcamp(String nome) {
        for (Bootcamp bootcamp : meusBootcamps) {
            if (bootcamp.getNome().equals(nome)) {
                return bootcamp;
            }
        }
        return null;
    }

    private static void pesquisarDev() {
        System.out.print("Insira nome do dev que deseja pesquisar: ");
        String nome = scanner.nextLine();
        Dev dev = pesquisarDev(nome);
        if (dev == null) {
            System.out.println("Falha ao encontrar dev. Dev não encontrado");
            return;
        }
        System.out.println("Dev encontrado com sucesso");
        System.out.println(dev.toString());
    }

    private static Dev pesquisarDev(String nome) {
        for (Dev dev : meusDevs) {
            if (dev.getNome().equals(nome)) {
                return dev;
            }
        }
        return null;
    }

}
