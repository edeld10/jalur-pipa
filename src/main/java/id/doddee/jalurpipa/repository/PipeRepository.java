package id.doddee.jalurpipa.repository;

import id.doddee.jalurpipa.domain.Pipe;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Pipe entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PipeRepository extends JpaRepository<Pipe, Long>, PipeRepositoryCustom {}
