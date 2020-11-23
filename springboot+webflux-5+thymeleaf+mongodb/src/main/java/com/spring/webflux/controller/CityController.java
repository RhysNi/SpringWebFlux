package com.spring.webflux.controller;

import com.commons.entity.City;
import com.commons.entity.Result;
import com.commons.status.ExceptionEnum;
import com.spring.webflux.handler.CityHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author: Rhys.Ni
 * @date: 2020/10/26
 * @time: 09:44
 * @email rhys.ni@softtek.com
 */

@Controller
@RequestMapping("/city")
public class CityController {

    private static final String CITY_LIST_PATH_NAME = "cityList";
    private static final String CITY_PATH_NAME = "city";

    @Resource
    private CityHandler cityHandler;

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Mono findCityById(@PathVariable("id") Long id) {
        return Result.ok(cityHandler.findCityById(id));
    }

    @GetMapping()
    @ResponseBody
    public Flux<City> findAllCity() {
        return cityHandler.findAllCity();
    }

    @PostMapping()
    @ResponseBody
    public Mono saveCity(@RequestBody City city) {
        return Result.ok(cityHandler.save(city));
    }

    @PutMapping()
    @ResponseBody
    public Mono<City> modifyCity(@RequestBody City city) {
        return cityHandler.modifyCity(city);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public Mono<Long> deleteCity(@PathVariable("id") Long id) {
        return cityHandler.deleteCity(id);
    }


    @GetMapping("/page/list")
    public String listPage(final Model model) {
        final Flux<City> cityFlux = cityHandler.findAllCity();
        model.addAttribute("cityList", cityFlux);
        return CITY_LIST_PATH_NAME;
    }

    @GetMapping("/getByName")
    public String getByCityName(final Model model, @RequestParam("cityName") String cityName) {
        final Mono<City> city = cityHandler.getByCityName(cityName);
        model.addAttribute("city", city);
        return CITY_PATH_NAME;
    }
}
