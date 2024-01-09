package com.jxc.service.impl;

import com.jxc.dao.UsersDao;
import com.jxc.entity.Users;
import com.jxc.service.UsersService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Users)表服务实现类
 *
 * @author makejava
 * @since 2023-12-18 17:51:50
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersDao usersDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Users queryById(Integer id) {
        return this.usersDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param users 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Users> queryByPage(Users users, PageRequest pageRequest) {
        long total = this.usersDao.count(users);
        return new PageImpl<>(this.usersDao.queryAllByLimit(users, pageRequest), pageRequest, total);
    }

    @Override
    public Users queryByName(String username) {
        return this.usersDao.queryByName(username);
    }
    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
    public Users insert(Users users) {
        this.usersDao.insert(users);
        return users;
    }

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
    public Users update(Users users) {
        this.usersDao.update(users);
        return this.queryById(users.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.usersDao.deleteById(id) > 0;
    }

    @Override
    public Users authenticate(String username, String password) {
        Users user = usersDao.getUserByUserName(username);

        // 模拟验证逻辑，实际项目中应该从数据库中获取用户信息进行验证
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }
}
