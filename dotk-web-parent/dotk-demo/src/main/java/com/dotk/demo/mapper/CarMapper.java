package com.dotk.demo.mapper;

import com.dotk.demo.dto.CarDto;
import com.dotk.demo.vo.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper( CarMapper.class );

    @Mapping(source = "number", target = "seatCount")
    @Mapping(source = "specialty",target = "specialization")
    CarDto carToCarDto(Car car);
}
