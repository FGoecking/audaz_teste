package com.audaz.audaz.service;

import com.audaz.audaz.model.Fare;
import com.audaz.audaz.model.FareDTO;
import com.audaz.audaz.model.Operator;
import com.audaz.audaz.model.OperatorDTO;
import com.audaz.audaz.repository.FareRepository;
import com.audaz.audaz.repository.OperatorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class FareService {

    @Autowired
    private FareRepository fareRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OperatorService operatorService;

    public FareDTO criar(FareDTO fareDTO) throws Exception {

        Fare fare = modelMapper.map(fareDTO, Fare.class);

        fare.setCreatedAt(LocalDate.now());
        fare.setStatus(Boolean.TRUE);
        fare.setOperator(operatorService.consultarPorCode(fareDTO.getOperatorCode()));


        if(validarFare(fare)){

            throw new Exception();
        }
        fareRepository.save(fare);
        return modelMapper.map(fare, FareDTO.class);
    }


public List<FareDTO> consultarTodos() {
    List<Fare> fareList = (List<Fare>) fareRepository.findAll();

    List<FareDTO> fareDTOList = new ArrayList<>();

    fareList.forEach(fare -> {
        FareDTO fareDTO = modelMapper.map(fare, FareDTO.class);
        fareDTOList.add(fareDTO);
    });

    return fareDTOList;
}

    private Boolean validarFare(Fare fare){

        final Boolean[] validation = {Boolean.FALSE};

        Operator operator = fare.getOperator();

        operator.getFareList().forEach(i -> {
            if(i.getValue().doubleValue() == fare.getValue().doubleValue()){

                YearMonth fareCreatedat = YearMonth.from(i.getCreatedAt());
                YearMonth newFareDate = YearMonth.from(fare.getCreatedAt());

                Long timeDiference = fareCreatedat.until(newFareDate, ChronoUnit.MONTHS) + 1;

                if(timeDiference <= 6 || (i.getStatus() == Boolean.FALSE)){
                    validation[0] = Boolean.TRUE;
                }
            }
        });

        return validation[0];
    }
}
