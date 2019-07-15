package com.wxy.configuration;

import com.wxy.mapper.NoteMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringBootConfiguration;

@MapperScan(basePackageClasses = NoteMapper.class)
@SpringBootConfiguration
public class MapperConfiguration {
}
