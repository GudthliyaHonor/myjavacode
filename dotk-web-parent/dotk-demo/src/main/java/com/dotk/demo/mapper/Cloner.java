package com.dotk.demo.mapper;

import com.dotk.demo.dto.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface Cloner {
    Cloner MAPPER =Mappers.getMapper(Cloner.class);
    CustomerDto clone(CustomerDto customerDto);
}
