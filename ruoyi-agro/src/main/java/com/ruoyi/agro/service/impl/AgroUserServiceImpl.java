package com.ruoyi.agro.service.impl;

import java.util.List;
import java.util.UUID;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.agro.mapper.AgroUserMapper;
import com.ruoyi.agro.domain.AgroUser;
import com.ruoyi.agro.service.IAgroUserService;

/**
 * 养殖户管理Service业务层处理
 * 
 * @author 罗晨熙
 * @date 2024-03-13
 */
@Service
public class AgroUserServiceImpl implements IAgroUserService
{
    @Autowired
    private AgroUserMapper agroUserMapper;

    /**
     * 查询养殖户管理
     * 
     * @param id 养殖户管理主键
     * @return 养殖户管理
     */
    @Override
    public AgroUser selectAgroUserById(String id)
    {
        return agroUserMapper.selectAgroUserById(id);
    }

    /**
     * 查询养殖户管理列表
     * 
     * @param agroUser 养殖户管理
     * @return 养殖户管理
     */
    @Override
    @DataScope(deptAlias = "t" ,userAlias = "t")
    public List<AgroUser> selectAgroUserList(AgroUser agroUser)
    {
        return agroUserMapper.selectAgroUserList(agroUser);
    }

    /**
     * 新增养殖户管理
     * 
     * @param agroUser 养殖户管理
     * @return 结果
     */
    @Override
    public int insertAgroUser(AgroUser agroUser)
    {
        agroUser.setCreateTime(DateUtils.getNowDate());
        agroUser.setId(IdUtils.randomUUID());
        return agroUserMapper.insertAgroUser(agroUser);
    }

    /**
     * 修改养殖户管理
     * 
     * @param agroUser 养殖户管理
     * @return 结果
     */
    @Override
    public int updateAgroUser(AgroUser agroUser)
    {
        agroUser.setUpdateTime(DateUtils.getNowDate());
        return agroUserMapper.updateAgroUser(agroUser);
    }

    /**
     * 批量删除养殖户管理
     * 
     * @param ids 需要删除的养殖户管理主键
     * @return 结果
     */
    @Override
    public int deleteAgroUserByIds(String[] ids)
    {
        return agroUserMapper.deleteAgroUserByIds(ids);
    }

    /**
     * 删除养殖户管理信息
     * 
     * @param id 养殖户管理主键
     * @return 结果
     */
    @Override
    public int deleteAgroUserById(String id)
    {
        return agroUserMapper.deleteAgroUserById(id);
    }
}
