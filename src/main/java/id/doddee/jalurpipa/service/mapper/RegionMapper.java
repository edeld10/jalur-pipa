package id.doddee.jalurpipa.service.mapper;


import id.doddee.jalurpipa.domain.*;
import id.doddee.jalurpipa.service.dto.RegionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Region} and its DTO {@link RegionDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface RegionMapper extends EntityMapper<RegionDTO, Region> {


    @Mapping(target = "areas", ignore = true)
    @Mapping(target = "removeArea", ignore = true)
    Region toEntity(RegionDTO regionDTO);

    default Region fromId(Long id) {
        if (id == null) {
            return null;
        }
        Region region = new Region();
        region.setId(id);
        return region;
    }
}
