package pl.urtica.wktmulti.controller.mapper;

import pl.urtica.wktmulti.entity.EntityClass;

public interface Mapper<Entity extends EntityClass, DTO> {

    Entity map(DTO dto);

    DTO map(Entity entity);
}
