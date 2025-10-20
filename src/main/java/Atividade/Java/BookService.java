package Atividade.Java;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<Book> findAll() {
        return repo.findAll();
    }

    public Optional<Book> findById(Long id) {
        return repo.findById(id);
    }

    public Book create(Book b) {
        b.setId(null);
        return repo.save(b);
    }

    public Optional<Book> update(Long id, Book b) {
        return repo.findById(id).map(existing -> {
            existing.setTitle(b.getTitle());
            existing.setAuthor(b.getAuthor());
            existing.setIsbn(b.getIsbn());
            existing.setDescription(b.getDescription());
            return repo.save(existing);
        });
    }

    public boolean delete(Long id) {
        return repo.findById(id).map(b -> { repo.delete(b); return true; }).orElse(false);
    }
}
