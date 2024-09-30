package com.example.demo.repositories;

import com.example.demo.models.Metadata;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MetadataRepository extends JpaRepository<Metadata, Long> {

    Optional<Metadata> findByFileId(Long fileId);
}
