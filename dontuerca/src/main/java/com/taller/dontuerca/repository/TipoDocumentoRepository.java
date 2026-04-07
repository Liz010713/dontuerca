// TipoDocumentoRepository.java
package com.taller.dontuerca.repository;

import com.taller.dontuerca.entity.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {
}