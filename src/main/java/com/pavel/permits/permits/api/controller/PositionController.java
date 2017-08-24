package com.pavel.permits.permits.api.controller;

import com.pavel.permits.permits.api.dto.PositionDto;
import com.pavel.permits.permits.core.service.PositionService;
import com.pavel.permits.permits.model.Position;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import io.swagger.annotations.Api;

/**
 * Created by Pavel on 24.08.2017.
 */

@RestController
@RequestMapping("/api/pos")
@Api(value = "/api/pos", description = "Positions")
public class PositionController {
    @Autowired
    private PositionService service;

    @Autowired
    private ModelMapper mapper;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public PositionDto createPosition(@RequestBody PositionDto positionDto) {
        Position position = convertToEntity(positionDto);
        Position createdPosition = service.save(position);

        return convertToDto(createdPosition);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<PositionDto> getAllPositions() {
        List<Position> positions = service.findAll();

        return positions.stream()
                .map(p -> convertToDto(p))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public PositionDto getPosition(@PathVariable("id") Integer id) {

        return convertToDto(service.findOne(id));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public PositionDto updatePosition(
            @PathVariable("id") Integer id, @RequestBody PositionDto positionDto) {
        Position position = convertToEntity(positionDto);
        position.setId(id);

        return convertToDto(service.save(position));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deletePosition(@PathVariable("id") Integer id) {

        service.delete(id);
    }

    private PositionDto convertToDto(Position position) {
        PositionDto positionDto = mapper.map(position, PositionDto.class);
        return positionDto;
    }

    private Position convertToEntity(PositionDto positionDto) {
        Position position = mapper.map(positionDto, Position.class);
        return position;
    }
}
