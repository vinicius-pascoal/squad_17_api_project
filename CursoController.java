private CursoDAO cursoDAO;

@GetMapping
public List<Curso> getCursos() {
    return cursoDAO.findAll();
}import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired


    @GetMapping("/{id}")
    public Curso getCurso(@PathVariable int id) {
        return cursoDAO.findById(id).orElse(null);
    }

    @PostMapping
    public Curso addCurso(@RequestBody Curso curso) {
        return cursoDAO.save(curso);
    }

    @PutMapping("/{id}")
    public Curso updateCurso(@RequestBody Curso curso) {
        curso.setIdCurso(id);
        return cursoDAO.save(curso);
    }

    @DeleteMapping("/{id}")
    public void deleteCurso(@PathVariable int id) {
        cursoDAO.deleteById(id);
    }
}
