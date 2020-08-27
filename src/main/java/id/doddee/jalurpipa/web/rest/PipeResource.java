package id.doddee.jalurpipa.web.rest;

import id.doddee.jalurpipa.service.PipeService;
import id.doddee.jalurpipa.service.dto.PipeDTO;
import id.doddee.jalurpipa.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * REST controller for managing {@link id.doddee.jalurpipa.domain.Pipe}.
 */
@RestController
@RequestMapping("/api")
public class PipeResource {
    private final Logger log = LoggerFactory.getLogger(PipeResource.class);

    private static final String ENTITY_NAME = "pipe";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PipeService pipeService;

    public PipeResource(PipeService pipeService) {
        this.pipeService = pipeService;
    }

    /**
     * {@code POST  /pipes} : Create a new pipe.
     *
     * @param pipeDTO the pipeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new
     * pipeDTO, or with status {@code 400 (Bad Request)} if the pipe has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/pipes")
    public ResponseEntity<Boolean> createPipe(@Valid @RequestBody PipeDTO pipeDTO) throws URISyntaxException {
        log.debug("REST request to save Pipe : {}", pipeDTO);
        if (pipeDTO.getId() != null) {
            throw new BadRequestAlertException("A new pipe cannot already have an ID", ENTITY_NAME, "idexists");
        }
        boolean result = pipeService.upsert(pipeDTO.getFile(), pipeDTO.getAreaId(), pipeDTO.getAreaName());
        return ResponseEntity.ok().headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, "")).body(result);
    }

    /**
     * {@code PUT  /pipes} : Updates an existing pipe.
     *
     * @param pipeDTO the pipeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated
     * pipeDTO, or with status {@code 400 (Bad Request)} if the pipeDTO is not valid, or with status
     * {@code 500 (Internal Server Error)} if the pipeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/pipes")
    public ResponseEntity<PipeDTO> updatePipe(@Valid @RequestBody PipeDTO pipeDTO) throws URISyntaxException {
        log.debug("REST request to update Pipe : {}", pipeDTO);
        if (pipeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PipeDTO result = pipeService.save(pipeDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, pipeDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /pipes} : get all the pipes.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of pipes in body.
     */
    @GetMapping("/pipes")
    public ResponseEntity<List<PipeDTO>> getAllPipes(Pageable pageable) {
        log.debug("REST request to get a page of Pipes");
        Page<PipeDTO> page = pipeService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /pipes/:id} : get the "id" pipe.
     *
     * @param id the id of the pipeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the pipeDTO, or
     * with status {@code 404 (Not Found)}.
     */
    @GetMapping("/pipes/{id}")
    public ResponseEntity<PipeDTO> getPipe(@PathVariable Long id) {
        log.debug("REST request to get Pipe : {}", id);
        Optional<PipeDTO> pipeDTO = pipeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(pipeDTO);
    }

    /**
     * {@code DELETE  /pipes/:id} : delete the "id" pipe.
     *
     * @param id the id of the pipeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/pipes/{id}")
    public ResponseEntity<Void> deletePipe(@PathVariable Long id) {
        log.debug("REST request to delete Pipe : {}", id);
        pipeService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
