package com.bhanu.webservice.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bhanu.webservice.dao.UserDetailsRepository;
import com.bhanu.webservice.entity.KidsInfo;
import com.bhanu.webservice.entity.SchoolAddress;
import com.bhanu.webservice.entity.UserDetails;

@RestController
@RequestMapping("/bhanuservice/userapi")
public class UserControllerAPI {

    @Autowired
    private UserDetailsRepository userRepository;


    @RequestMapping(value ="/create_user" ,method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserDetails create(@RequestBody UserDetails userDetails)
    
    
    {
    	KidsInfo kidsInfo = userDetails.getKidsInfo();
    	SchoolAddress schoolAddress = userDetails.getKidsInfo().getSchoolAddress();
    	
    	
    	kidsInfo.setUserdetails(userDetails);
    	userDetails.setKidsInfo(kidsInfo);
    	
    	
    	schoolAddress.setKidsinfo(kidsInfo);
    	kidsInfo.setSchoolAddress(schoolAddress);

        return userRepository.save(userDetails);
    }


    @RequestMapping(value ="/getAllusers" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<UserDetails> findAll()
    {
        return userRepository.findAll();
    }


    @PutMapping("/update_user/{user_id}")
    public UserDetails update(@PathVariable("user_id") Long userId, @RequestBody UserDetails userObject)
    {
    	UserDetails user = userRepository.findOne(userId);
        user.setName(userObject.getName());
        user.setCountry(userObject.getCountry());
        return userRepository.save(user);
    }



    @DeleteMapping("/delete_user/{user_id}")
    public List<UserDetails> delete(@PathVariable("user_id") Long userId)
    {
        userRepository.delete(userId);
        return userRepository.findAll();
    }



    @GetMapping("/get_user/{user_id}")
    public UserDetails findByUserId(@PathVariable("user_id") Long userId)
    {
        return userRepository.findOne(userId);
    }
}
