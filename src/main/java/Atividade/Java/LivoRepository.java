package com.example.Atividade.Java;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LivoRepository extends JpaRepository<LivroEntity, Long> {
    Optional<LivroEntity> findByIsbn(String isbn);
}
