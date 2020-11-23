package com.spring.webflux.handler;

import com.commons.entity.City;
import com.commons.entity.Result;
import com.commons.status.ExceptionEnum;
import com.spring.webflux.Repository.CityRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * @author: Rhys.Ni
 * @date: 2020/10/26
 * @time: 09:48
 * @email rhys.ni@softtek.com
 */

@Component
public class CityHandler {
    @Resource
    private CityRepository cityRepository;

    public Mono<Long> save(City city) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityRepository.save(city)));
    }

    public Mono<City> findCityById(Long id) {
        return Mono.justOrEmpty(cityRepository.findCityById(id));
    }

    public Flux<City> findAllCity() {
        return Flux.fromIterable(cityRepository.findAll());
    }

    public Mono<Long> modifyCity(City city) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityRepository.updateCity(city)));
    }

    public Mono<Long> deleteCity(Long id) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityRepository.deleteCity(id)));
    }
}
