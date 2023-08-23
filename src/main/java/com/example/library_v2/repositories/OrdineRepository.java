package com.example.library_v2.repositories;

import com.example.library_v2.domain.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdineRepository extends JpaRepository<Ordine, Long> {
}