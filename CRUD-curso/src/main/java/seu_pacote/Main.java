package seu_pacote;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criando instância de CursoDAO
        CursoDAO cursoDAO = new CursoDAO();

        // Adicionando um novo curso
        Curso novoCurso = new Curso();
        novoCurso.setNomeCurso("Programação em Java");
        novoCurso.setDescricaoCurso("Curso de introdução à linguagem Java");
        novoCurso.setAtivo(true);
        cursoDAO.adicionarCurso(novoCurso);
        System.out.println("Curso adicionado com sucesso!");

        // Buscando um curso pelo ID
        int idCursoParaBuscar = 1;
        Curso cursoBuscado = cursoDAO.buscarCurso(idCursoParaBuscar);
        if (cursoBuscado != null) {
            System.out.println("\nCurso encontrado:");
            System.out.println(cursoBuscado.getNomeCurso() + " - " + cursoBuscado.getDescricaoCurso());
        } else {
            System.out.println("\nCurso não encontrado.");
        }

        // Listando todos os cursos
        System.out.println("\nTodos os cursos:");
        List<Curso> cursos = cursoDAO.listarCursos();
        for (Curso curso : cursos) {
            System.out.println(curso.getNomeCurso() + " - " + curso.getDescricaoCurso());
        }

        // Atualizando um curso
        if (cursoBuscado != null) {
            cursoBuscado.setNomeCurso("Programação em Java Avançada");
            cursoBuscado.setDescricaoCurso("Curso avançado de Java");
            cursoBuscado.setAtivo(false);
            cursoDAO.atualizarCurso(cursoBuscado);
            System.out.println("\nCurso atualizado com sucesso!");
        } else {
            System.out.println("\nCurso não encontrado para atualizar.");
        }

        // Deletando um curso
        if (cursoBuscado != null) {
            cursoDAO.deletarCurso(cursoBuscado.getIdCurso());
            System.out.println("\nCurso deletado com sucesso!");
        } else {
            System.out.println("\nCurso não encontrado para deletar.");
        }
    }
}
