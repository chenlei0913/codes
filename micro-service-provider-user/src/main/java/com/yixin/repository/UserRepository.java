package com.yixin.repository;

import com.yixin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Package : com.yixin.repository
 *
 * @author YixinCapital -- chenlei01
 *         2017/5/4 11:03
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
