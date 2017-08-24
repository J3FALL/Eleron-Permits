package com.pavel.permits.permits;

import com.pavel.permits.permits.api.dto.CodeDto;
import com.pavel.permits.permits.api.dto.PermitDto;
import com.pavel.permits.permits.model.Code;
import com.pavel.permits.permits.model.Permit;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.spi.Mapping;
import org.modelmapper.spi.MappingContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableAutoConfiguration(exclude = HibernateJpaAutoConfiguration.class)
public class PermitsApplication {

    @Bean
    public ModelMapper modelMapper() {

        //Add mapping for List<Code> to List<code_ids>
        ModelMapper mapper = new ModelMapper();

        mapper.addMappings(new PropertyMap<Permit, PermitDto>() {
            @Override
            protected void configure() {
                Converter<List<Code>, List<Integer>> codeConverter = mappingContext -> {
                    List<Integer> result = new ArrayList<>();
                    mappingContext.getSource().forEach(code -> result.add(code.getId()));
                    return result;
                };

                using(codeConverter).map(source.getCodes()).setCodeIds(null);
            }
        });
        return mapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(PermitsApplication.class, args);
    }
}
