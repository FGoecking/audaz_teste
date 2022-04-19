package com.audaz.audaz.service;

import com.audaz.audaz.model.Operator;
import com.audaz.audaz.model.OperatorDTO;
import com.audaz.audaz.repository.OperatorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OperatorService {

    @Autowired
    OperatorRepository operatorRepository;

    @Autowired
    private ModelMapper modelMapper;

    public OperatorDTO criar(OperatorDTO operator) {

        operatorRepository.save(modelMapper.map(operator, Operator.class));
        return modelMapper.map(operator, OperatorDTO.class);
    }

    public List<OperatorDTO> consultarTodos() {
        List<Operator> operatorList = (List<Operator>) operatorRepository.findAll();

        List<OperatorDTO> operatorDTOList = new ArrayList<>();

        operatorList.forEach(operator -> {
            OperatorDTO operatorDTO = modelMapper.map(operator, OperatorDTO.class);
            operatorDTOList.add(operatorDTO);
        });

        return operatorDTOList;
    }

    public Operator consultarPorCode(String code) {
        Operator operator = operatorRepository.findByCode(code);
        return operator;
    }

    public OperatorDTO consultarPorId(Long id) {
        Optional<Operator> operator = operatorRepository.findById(id);
        return modelMapper.map(operator, OperatorDTO.class);
    }
}
