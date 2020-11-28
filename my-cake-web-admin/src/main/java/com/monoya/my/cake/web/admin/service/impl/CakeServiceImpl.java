package com.monoya.my.cake.web.admin.service.impl;

import com.monoya.my.cake.commons.dtos.BaseResult;
import com.monoya.my.cake.commons.persistence.PageInfo;
import com.monoya.my.cake.commons.utils.RegexpUtils;
import com.monoya.my.cake.commons.validator.BeanValidator;
import com.monoya.my.cake.domain.Cake;
import com.monoya.my.cake.web.admin.dao.CakeDao;
import com.monoya.my.cake.web.admin.service.CakeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CakeServiceImpl implements CakeService {
    @Autowired
    private CakeDao cakeDao;

    /**
     * 更新信息
     * @param cake
     */
    @Override
    public void update(Cake cake) {
        cakeDao.update(cake);
    }

    /**
     * 根据 id 查询信息
     * @param id
     * @return
     */
    @Override
    public Cake getById(Long id) {
        return cakeDao.getById(id);
    }
    /**
     * 保存信息
     * @param cake
     */
    @Override
    public BaseResult save(Cake cake) {
        String validator = BeanValidator.validator(cake);
        //验证不通过
        if(validator!=null){
            return BaseResult.fail(validator);
        }
        //验证通过
        else {
                cake.setUpdated(new Date());
                //新增用户信息
                if(cake.getId() == null){
                    cake.setCreated(new Date());
                    cakeDao.insert(cake);
                }
                //更新用户信息
                else{
                    cakeDao.update(cake);
                }
                return BaseResult.success("保存信息成功");
        }
    }

    /**
     * 根据 id 删除信息
     */
    @Override
    public void delete(Long id) {
        cakeDao.delete(id);
    }

    /**
     * 数据总记录数
     * @return
     */
    @Override
    public int count(Cake cake) {
        return cakeDao.count(cake);
    }

    /**
     * 分页
     * @param start 开始的位置
     * @param length 要显示的记录的条数
     * @return
     */
    @Override
    public PageInfo<Cake> page(int start, int length, int draw, Cake cake) {
        PageInfo<Cake> pageInfo = new PageInfo<>();
        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("pageParams",cake);
        List<Cake> data = cakeDao.page(params);
        int count = cakeDao.count(cake);
        pageInfo.setDraw(draw);
        pageInfo.setData(data);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setRecordsTotal(count);
        return pageInfo;
    }

    @Override
    public void deleteMulti(String[] ids) {
        cakeDao.deleteMulti(ids);
    }

    @Override
    public List<Cake> search(Cake cake) {
        return cakeDao.search(cake);
    }


}
