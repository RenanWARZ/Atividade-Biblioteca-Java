package com.example.Atividade.Java;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class LivroService {
    private final LivoRepository repo;

    public LivroService(LivoRepository repo) {
        this.repo = repo;
    }

    public List<Livro> findAll() {
        return repo.findAll();
    }

    public Optional<Livro> findById(Long id) {
        return repo.findById(id);
    }

    public Livro create(Livro b) {
        b.setId(null);
        return repo.save(b);
    }

    public Optional<Livro> update(Long id, Livro b) {
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
