package mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/02/21
 */
@Mapper(uses = TypeMapper.class)
public interface Converter2 {
    Converter2 INSTANCE = Mappers.getMapper(Converter2.class);
    @Mappings({
            @Mapping(source = "type", target = "type"),
            @Mapping(source = "id", target = "id")
    })
    TargetDto source2target(SourceDto person);
}
