package org.jinha.board.commons.configs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.jinha.board.entities.Configs;
import org.jinha.board.repositories.ConfigsRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConfigSaveService {
    private final ConfigsRepository repository;
    public <T> void save(String code, T t){

        Configs configs = repository.findById(code).orElseGet(Configs::new);


        ObjectMapper om = new ObjectMapper(); //restTemplate 가 더 편하다고 함 요청, 변환 다해줌
        String value = null;
        try {
            value = om.writeValueAsString(t);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        configs.setCode(code);
        configs.setValue(value);

        repository.saveAndFlush(configs);
    }
}
