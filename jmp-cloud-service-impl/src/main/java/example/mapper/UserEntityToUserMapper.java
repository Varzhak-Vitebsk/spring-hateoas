package example.mapper;

import com.epam.example.dto.User;
import example.storage.entity.UserEntity;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserEntityToUserMapper {

  List<User> map(List<UserEntity> source);

  User map(UserEntity source);

}
