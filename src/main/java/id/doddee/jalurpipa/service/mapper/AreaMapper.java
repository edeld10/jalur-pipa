package id.doddee.jalurpipa.service.mapper;

import id.doddee.jalurpipa.domain.*;
import id.doddee.jalurpipa.service.dto.AreaDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Area} and its DTO {@link AreaDTO}.
 */
@Mapper(componentModel = "spring", uses = { RegionMapper.class })
public interface AreaMapper extends EntityMapper<AreaDTO, Area> {
    @Mapping(source = "region.id", target = "regionId")
    @Mapping(source = "region.name", target = "regionName")
    AreaDTO toDto(Area area);

    @Mapping(target = "customers", ignore = true)
    @Mapping(target = "removeCustomer", ignore = true)
    @Mapping(source = "regionId", target = "region")
    Area toEntity(AreaDTO areaDTO);

    default Area fromId(Long id) {
        if (id == null) {
            return null;
        }
        Area area = new Area();
        area.setId(id);
        return area;
    }
}
