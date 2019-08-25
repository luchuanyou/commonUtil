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
@Mapper
public interface Converter {
    Converter INSTANCE = Mappers.getMapper(Converter.class);
    @Mappings({
            @Mapping(source = "sName", target = "tName"),
            @Mapping(source = "sAge", target = "tAge"),
//            @Mapping(target = "address", ignore = true)
//            @Mapping(source = "birthday", target = "birthDateFormat", dateFormat = "yyyy-MM-dd HH:mm:ss"),
//            @Mapping(target = "birthExpressionFormat", expression = "java(org.apache.commons.lang3.time.DateFormatUtils.format(person.getBirthday(),\"yyyy-MM-dd HH:mm:ss\"))"),
//            @Mapping(source = "user.age", target = "age"),
//            @Mapping(target = "email", ignore = true)
    })
    TargetDto source2target(SourceDto person);

    List<TargetDto> source2target(List<SourceDto> people);
}
