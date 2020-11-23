package com.spring.webflux.webfluxcontroller;

import com.commons.entity.City;
import com.spring.webflux.handler.CityHandler;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * @author: Rhys.Ni
 * @date: 2020/6/3
 * @time: 18:18
 * @email rhys.ni@softtek.com
 */
@RestController
@RequestMapping(value = "/city")
public class CityWebFluxController {
    @Resource
    private CityHandler cityHandler;

    @PostMapping()
    public Mono<Long> saveCity(@RequestBody City city) {
        return cityHandler.save(city);
    }

    @DeleteMapping(value = "/{cityId}")
    public Mono<Long> deleteCity(@PathVariable("cityId") Long cityId) {
        return cityHandler.delete(cityId);
    }

    @PutMapping()
    public Mono<Long> update(@RequestBody City city) {
        return cityHandler.update(city);
    }

    @GetMapping()
    public Flux<City> queryAllCity() {
        return cityHandler.queryAllCity();
    }

    @GetMapping(value = "/{cityId}")
    public Mono<City> queryCityById(@PathVariable("cityId") Long cityId) {
        return cityHandler.queryCityById(cityId);
    }
}
