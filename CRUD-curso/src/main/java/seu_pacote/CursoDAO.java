package seu_pacote;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;

public class CursoDAO {
    private final SessionFactory sessionFactory;

    public CursoDAO() {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    public void adicionarCurso(Curso curso) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(curso);
            transaction.commit();
        }
    }

    public Curso buscarCurso(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Curso.class, id);
        }
    }

    public List<Curso> listarCursos() {
        try (Session session = sessionFactory.openSession()) {
            Query<Curso> query = session.createQuery("from Curso", Curso.class);
            return query.list();
        }
    }

    public void atualizarCurso(Curso curso) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(curso);
            transaction.commit();
        }
    }

    public void deletarCurso(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Curso curso = session.get(Curso.class, id);
            if (curso != null) {
                session.delete(curso);
                transaction.commit();
            }
        }
    }
}
