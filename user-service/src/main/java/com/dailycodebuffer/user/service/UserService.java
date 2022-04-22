package com.dailycodebuffer.user.service;

import com.dailycodebuffer.user.VO.Department;
import com.dailycodebuffer.user.VO.ResponseTemplateVo;
import com.dailycodebuffer.user.model.User;
import com.dailycodebuffer.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    Logger logger = LoggerFactory.getLogger(UserService.class);
    public User saveUser(User user){
        logger.info("Saving user");
        System.out.println( user.getDepartmentId());
        return userRepository.save(user);
    }

    public ResponseTemplateVo getUserWithDepartments(Long userId) {
        logger.info("Getting user with departments");
        ResponseTemplateVo vo=new ResponseTemplateVo();
        User user = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User getOneUser(Long userId) {
        return userRepository.findByUserId(userId);
    }
}
