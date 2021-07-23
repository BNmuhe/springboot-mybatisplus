package com.example.mybatisplus.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.example.mybatisplus.model.domain.Admin;
import com.example.mybatisplus.mapper.AdminMapper;
import com.example.mybatisplus.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxp
 * @since 2021-04-19
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(Admin admin) {
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("loginName",admin.getLoginName())
                .eq("password",admin.getPassword());

        Admin one = adminMapper.selectOne(wrapper);



        return one;
    }

    @Override
    public Admin register(Admin admin) {
        QueryWrapper<Admin> wrapper=new QueryWrapper<>();
        wrapper.eq("loginName",admin.getLoginName());
        Admin one = adminMapper.selectOne(wrapper);
        if(one==null){
            adminMapper.insert(admin);
            return admin;
        }else {
            return null;
        }

    }
}
