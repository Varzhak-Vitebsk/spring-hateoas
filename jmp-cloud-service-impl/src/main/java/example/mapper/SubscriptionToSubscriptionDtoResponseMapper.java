package example.mapper;

import com.epam.example.dto.Subscription;
import com.epam.example.dto.SubscriptionResponseDto;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface SubscriptionToSubscriptionDtoResponseMapper {

  List<SubscriptionResponseDto> map(List<Subscription> source);

  SubscriptionResponseDto map(Subscription source);

}
