package ee.bcs.myApp.bank.domain.account;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AccountMapper {


    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "firstName", source = "customer.firstName")
    @Mapping(target = "lastName", source = "customer.lastName")
    @Mapping(target = "isikukood", source = "customer.isikukood")
    @Mapping(target = "accountId", source = "id")
    AccountResponse toResponse(Account entity);

    List<AccountResponse> toResponses(List<Account> entities);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(AccountDto dto, @MappingTarget Account entity);
}
