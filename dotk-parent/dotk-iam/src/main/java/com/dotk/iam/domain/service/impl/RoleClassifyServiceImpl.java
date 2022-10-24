package com.dotk.iam.domain.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dotk.core.exception.ServiceException;
import com.dotk.core.utils.StringUtils;
import com.dotk.iam.common.constant.RoleConstant;
import com.dotk.iam.common.enums.ErrorCodeConstants;
import com.dotk.iam.domain.bo.QueryRoleClassifyBO;
import com.dotk.iam.domain.entity.RoleClassifyEntity;
import com.dotk.iam.domain.service.RoleClassifyService;
import com.dotk.iam.domain.transfer.RoleClassifyTransfer;
import com.dotk.iam.domain.vo.RoleClassifyListVO;
import com.dotk.iam.infra.mapper.RoleClassifyMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hailanzhou
 * @create 2022-10-18 14:24
 * @desc
 **/
@Service
@Slf4j
public class RoleClassifyServiceImpl implements RoleClassifyService {

    @Resource
    private RoleClassifyMapper roleClassifyMapper;

    @Resource
    private RoleClassifyTransfer roleClassifyTransfer;


    @Override
    public Long createRoleClassify(String name) {
        checkRoleClassifyUnique(null,name);
        RoleClassifyEntity roleClassifyEntity=new RoleClassifyEntity();
        roleClassifyEntity.setName(name);
        roleClassifyEntity.setCount(0);
        roleClassifyMapper.insert(roleClassifyEntity);
        return roleClassifyEntity.getId();
    }

    @Override
    public Long initializeRoleClassify() {
        // 校验正确性
        checkRoleClassifyUnique(null, RoleConstant.DEFALUT_ROLE_CLASSIFY);
        //添加角色分类
        RoleClassifyEntity roleClassifyEntity=new RoleClassifyEntity();
        roleClassifyEntity.setName(RoleConstant.DEFALUT_ROLE_CLASSIFY);
        roleClassifyEntity.setCount(0);
        roleClassifyMapper.insert(roleClassifyEntity);
        return roleClassifyEntity.getId();

    }

    @Override
    public void updateRoleClassify(Long id, String name) {
        //检查是否可以更新
        checkRoleClassifyUnique(id,name);

        //更新数据
        RoleClassifyEntity roleClassifyEntity=new RoleClassifyEntity();
        roleClassifyEntity.setName(name);
        roleClassifyEntity.setId(id);
        roleClassifyMapper.updateById(roleClassifyEntity);
    }

    @Override
    public void deleteRoleClassify(Long id) {
        //删除业务校验
        checkDeleteRoleClassify(id);
        //删除角色分类
        roleClassifyMapper.deleteById(id);
    }

    @Override
    public void incrRoleClassifyCount(Long id) {
        checkRoleClassifyExists(id);
        roleClassifyMapper.incrRoleClassifyCount(id);
    }

    @Override
    public void descRoleClassifyCount(Long id) {
        checkRoleClassifyExists(id);
        roleClassifyMapper.descRoleClassifyCount(id);
    }

    @Override
    public RoleClassifyListVO list(QueryRoleClassifyBO queryRoleClassifyBO) {
        Page<RoleClassifyEntity> page = new Page<>(queryRoleClassifyBO.getPage(), queryRoleClassifyBO.getSize());
        Page<RoleClassifyEntity> result = roleClassifyMapper.selectPage(page, null);

        RoleClassifyListVO roleClassifyListVO=new RoleClassifyListVO();
        roleClassifyListVO.setTotal(result.getTotal());
        roleClassifyListVO.setPage(result.getCurrent());
        roleClassifyListVO.setLimit(result.getSize());
        roleClassifyListVO.setList(roleClassifyTransfer.toRoleClassifyList(result.getRecords()));
        return roleClassifyListVO;
    }

    private RoleClassifyEntity checkRoleClassifyExists(Long id){
        RoleClassifyEntity roleClassifyEntity=roleClassifyMapper.selectById(id);
        if (StringUtils.isNull(roleClassifyEntity)){
            throw  new ServiceException(ErrorCodeConstants.ROLE_CLASSIFY_NO_EXISTS);
        }
        return roleClassifyEntity;
    }

    private void checkDeleteRoleClassify(Long id){
        RoleClassifyEntity roleClassifyEntity=roleClassifyMapper.selectById(id);
        if (StringUtils.isNull(roleClassifyEntity)){
            throw  new ServiceException(ErrorCodeConstants.ROLE_CLASSIFY_NO_EXISTS);
        }
        if (roleClassifyEntity.getCount()>0){
            throw  new ServiceException(ErrorCodeConstants.ROLE_CLASSIFY_EXISTS_ROLE);
        }
        Long count=roleClassifyMapper.count();
        if(count==1){
            throw  new ServiceException(ErrorCodeConstants.ROLE_CLASSIFY_LIMIT);
        }
    }


    /**
    * @Description: 验证分类是否已存在
    * @Author hailanzhou
    * @Date: 2022/10/18 15:00
    * @return void 
    */
    private void checkRoleClassifyUnique(Long id, String name){
        RoleClassifyEntity roleClassifyEntity=roleClassifyMapper.selectByName(name);
        if (roleClassifyEntity==null){
            return;
        }
        if (id==null){
            throw  new ServiceException(ErrorCodeConstants.ROLE_CLASSIFY_EXISTS);
        }
        if(!roleClassifyEntity.getId().equals(id)){
            throw  new ServiceException(ErrorCodeConstants.ROLE_CLASSIFY_EXISTS);
        }

    }
}
