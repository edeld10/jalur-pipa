package id.doddee.jalurpipa.service;

import id.doddee.jalurpipa.service.dto.PipeDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link id.doddee.jalurpipa.domain.Pipe}.
 */
public interface PipeService {
    boolean upsert(byte[] file, Long areaId, String areaName);

    /**
     * Save a pipe.
     *
     * @param pipeDTO the entity to save.
     * @return the persisted entity.
     */
    PipeDTO save(PipeDTO pipeDTO);

    /**
     * Get all the pipes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<PipeDTO> findAll(Pageable pageable);

    /**
     * Get the "id" pipe.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PipeDTO> findOne(Long id);

    /**
     * Delete the "id" pipe.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
