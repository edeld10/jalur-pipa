package id.doddee.jalurpipa.service.impl;

import id.doddee.jalurpipa.domain.Area;
import id.doddee.jalurpipa.domain.Pipe;
import id.doddee.jalurpipa.repository.PipeRepository;
import id.doddee.jalurpipa.service.PipeService;
import id.doddee.jalurpipa.service.dto.PipeDTO;
import id.doddee.jalurpipa.service.mapper.PipeMapper;
import id.doddee.jalurpipa.utils.PipeExcelImporter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Pipe}.
 */
@Service
@Transactional
public class PipeServiceImpl implements PipeService {
    private final Logger log = LoggerFactory.getLogger(PipeServiceImpl.class);

    private final PipeRepository pipeRepository;

    private final PipeMapper pipeMapper;

    public PipeServiceImpl(PipeRepository pipeRepository, PipeMapper pipeMapper) {
        this.pipeRepository = pipeRepository;
        this.pipeMapper = pipeMapper;
    }

    @Override
    public boolean upsert(byte[] file, Long areaId, String areaName) {
        try {
            List<Pipe> pipes = new PipeExcelImporter(file)
                .importToList()
                .stream()
                .peek(
                    pipe -> {
                        Area area = new Area();
                        area.setId(areaId);
                        area.setName(areaName);
                        pipe.setArea(area);
                    }
                )
                .collect(Collectors.toList());
            return pipeRepository.bulkUpsert(pipes);
        } catch (IOException e) {
            log.error("Error upsert pipes by excel file -> ", e);
            return false;
        }
    }

    @Override
    public PipeDTO save(PipeDTO pipeDTO) {
        log.debug("Request to save Pipe : {}", pipeDTO);
        Pipe pipe = pipeMapper.toEntity(pipeDTO);
        pipe = pipeRepository.save(pipe);
        return pipeMapper.toDto(pipe);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PipeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Pipes");
        return pipeRepository.findAll(pageable).map(pipeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PipeDTO> findOne(Long id) {
        log.debug("Request to get Pipe : {}", id);
        return pipeRepository.findById(id).map(pipeMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Pipe : {}", id);
        pipeRepository.deleteById(id);
    }
}
