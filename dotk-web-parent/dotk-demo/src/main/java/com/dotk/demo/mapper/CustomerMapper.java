package com.dotk.demo.mapper;


import com.dotk.demo.dto.Customer;
import com.dotk.demo.dto.CustomerDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {OrderItemMapper.class})
public interface CustomerMapper {
    CustomerMapper MAPPER = Mappers.getMapper( CustomerMapper.class );

    @InheritInverseConfiguration
    CustomerDto fromCustomer(Customer customer);

    @Mapping(source = "orders", target = "orderItems")
    @Mapping(source = "customerName", target = "name")
    Customer toCustomer(CustomerDto customerDto);

}
