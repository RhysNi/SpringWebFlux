package com.spring.webflux.handler;

import com.commons.entity.City;
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

    public Mono<City> save(City city) {
        return cityRepository.insert(city);
    }

    public Mono<City> findCityById(Long id) {
        return cityRepository.findById(id);
    }

    public Flux<City> findAllCity() {
        return cityRepository.findAll();

    }

    public Mono<City> modifyCity(City city) {
        return cityRepository.save(city);
    }

    public Mono<Long> deleteCity(Long id) {
        cityRepository.deleteById(id);
        return Mono.create(cityMonoSink -> cityMonoSink.success(id));
    }

    public Mono<City> getByCityName(String cityName) {
        return cityRepository.findByCityName(cityName);
    }
}
