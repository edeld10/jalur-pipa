package id.doddee.jalurpipa.service.mapper;

import id.doddee.jalurpipa.domain.*;
import id.doddee.jalurpipa.service.dto.PipeDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Pipe} and its DTO {@link PipeDTO}.
 */
@Mapper(componentModel = "spring", uses = { AreaMapper.class })
public interface PipeMapper extends EntityMapper<PipeDTO, Pipe> {
    @Mapping(source = "area.id", target = "areaId")
    @Mapping(source = "area.name", target = "areaName")
    PipeDTO toDto(Pipe pipe);

    @Mapping(source = "areaId", target = "area")
    Pipe toEntity(PipeDTO pipeDTO);

    default Pipe fromId(Long id) {
        if (id == null) {
            return null;
        }
        Pipe pipe = new Pipe();
        pipe.setId(id);
        return pipe;
    }
}
