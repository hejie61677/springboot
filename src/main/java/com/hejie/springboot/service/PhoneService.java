package com.hejie.springboot.service;

import com.hejie.springboot.config.Page4Navigator;
import com.hejie.springboot.pojo.PhoneEntity;
import org.springframework.data.domain.Pageable;

/**
  * @program: srpingboot
  * @description: phone服务接口
  * @author: hejie
  * @create: 2019/5/8
  */
public interface PhoneService {

    public Page4Navigator<PhoneEntity> list (Pageable pageable);

    public void save (PhoneEntity phoneEntity);

    public void delete (int id);

    public PhoneEntity get (int id);

}
