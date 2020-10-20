package com.railway.dao;

import com.railway.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDAO extends JpaRepository<User, Long>
{
    public int countUserByUserNameAndPassword(String userName, String password);

    public int countUserByEmailIdOrUserName(String emailId, String userName);

    public User findUserByUserName(String userName);
}
