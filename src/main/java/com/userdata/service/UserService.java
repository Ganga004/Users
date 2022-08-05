package com.userdata.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userdata.entity.User;
import com.userdata.repository.UserRepository;
import com.userdata.valueobject.Department;
import com.userdata.valueobject.ResponseTemplateVO;

@Service
public class UserService {

	@Autowired
	private UserRepository userrepository;
	
	
	@Autowired
	private RestTemplate restTemplate;
	 

	public User saveUserData(User user) {
		return userrepository.save(user);
	}

	
	  public ResponseTemplateVO getDatafromBothEntity(Long userId) {
	  ResponseTemplateVO vo=new ResponseTemplateVO();
	  User user=userrepository.findById(userId).orElseThrow();
	  Department dept=restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/getrecord/"+user.getDepartmentId(), Department.class);
	  vo.setUser(user);
	  vo.setDepartment(dept);
	  return vo; 
	  
	  }


	public List<User> getAllData(User user) {
		return userrepository.findAll();
	}
	  
	 	
}
