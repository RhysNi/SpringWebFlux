package com.spring.webflux.handler;

import com.commons.entity.City;
import com.spring.webflux.repository.CityRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author: Rhys.Ni
 * @date: 2020/6/3
 * @time: 17:27
 * @email rhys.ni@softtek.com
 */
@Component
public class CityHandler {
    final CityRepository cityRepository;

    public CityHandler(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Mono<Long> save(City city) {
        return Mono.create(
                cityMonoSink -> cityMonoSink.success(
                        cityRepository.save(city))
        );
    }

    public Mono<Long> delete(Long id) {
        return Mono.create(
                cityMonoSink -> cityMonoSink.success(
                        cityRepository.delete(id))
        );
    }

    public Mono<Long> update(City city) {
        return Mono.create(
                cityMonoSink -> cityMonoSink.success(
                        cityRepository.update(city))
        );
    }

    public Mono<City> queryCityById(Long id) {
        return Mono.create(
                cityMonoSink -> cityMonoSink.success(
                        cityRepository.queryCityById(id))
        );
    }

    public Flux<City> queryAllCity() {
        return Flux.fromIterable(
                cityRepository.queryAllCity()
        );
    }
}
