package com.dotk;

import com.dotk.demo.dto.CarDto;
import com.dotk.demo.mapper.CarMapper;
import com.dotk.demo.vo.Car;


public class Main {
    public static void main(String[] args) {
        Car car = new Car( "测试", "add",10 );
        //转换对象
        CarDto carDto = CarMapper.INSTANCE.carToCarDto(car);
        //测试
        System.out.println( carDto );
        System.out.println( carDto.getMake() );
        System.out.println( carDto.getSeatCount() );
    }
}