package com.example.Atividade.Java;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LivoRepository extends JpaRepository<Livro, Long> {
    Optional<Livro> findByIsbn(String isbn);
}
