package example.mapper;

import com.epam.example.dto.Subscription;
import example.storage.entity.SubscriptionEntity;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface SubscriptionEntityToSubscriptionMapper {

  List<Subscription> map(List<SubscriptionEntity> source);

  Subscription map(SubscriptionEntity source);

}
