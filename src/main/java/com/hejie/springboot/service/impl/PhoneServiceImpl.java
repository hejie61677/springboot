package com.hejie.springboot.service.impl;

import com.hejie.springboot.config.Page4Navigator;
import com.hejie.springboot.dao.UniversalDAO;
import com.hejie.springboot.pojo.PhoneEntity;
import com.hejie.springboot.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @program: springboot
 * @description: phone服务接口实现类
 * @author: hejie
 * @create: 2019-05-08 10:40
 */
@Service
@CacheConfig(cacheNames = "phone")
public class PhoneServiceImpl implements PhoneService {

    @Autowired UniversalDAO phoneDAO;

    @Override
    @Cacheable(key ="'phone ' + #p0.offset + '-' + #p0.pageSize")
    public Page4Navigator<PhoneEntity> list(Pageable pageable) {

        Page<PhoneEntity> pageFromJPA =  phoneDAO.findAll(pageable);
        Page4Navigator<PhoneEntity> page = new Page4Navigator<>(pageFromJPA,5);
        return page;
    }

    @Override
    @Cacheable(key ="'phone '+ #p0")
    public PhoneEntity get(int id) {

        PhoneEntity phoneEntity = phoneDAO.getOne(id);
        return phoneEntity;
    }

    @Override
    @CacheEvict(allEntries=true)
//  @CachePut(key = "'phone ' + #p0")
    public void save(PhoneEntity phoneEntity) {

        phoneDAO.save(phoneEntity);
    }

    @Override
    @CacheEvict(allEntries=true)
//  @CacheEvict(key = "'phone ' + #p0")
    public void delete(int id) {

        phoneDAO.deleteById(id);
    }

}
