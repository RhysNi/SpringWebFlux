package com.spring.webflux.repository;

import com.commons.entity.City;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author: Rhys.Ni
 * @date: 2020/6/3
 * @time: 18:05
 * @email rhys.ni@softtek.com
 */
@Repository
public class CityRepository {
    //利用Map并发集合模拟增删改查
    private ConcurrentMap<Long, City> repository = new ConcurrentHashMap<>();
    //新建一个初始值为0的AtomicLong
    private static final AtomicLong idGenerator = new AtomicLong(0);

    public Long save(City city) {
        //incrementAndGet：为AtomicLong先加1再获取当前值
        Long cityId = idGenerator.incrementAndGet();
        city.setId(cityId);
        repository.put(cityId, city);
        return cityId;
    }

    public Long delete(Long id) {
        repository.remove(id);
        return id;
    }

    public Long update(City city) {
        repository.put(city.getId(), city);
        return city.getId();
    }

    public City queryCityById(Long id) {
        return repository.get(id);
    }

    public Collection<City> queryAllCity() {
        return repository.values();
    }
}
