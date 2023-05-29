    package com.microservice.UserRegistrationService.resources;

import com.microservice.UserRegistrationService.Service.UserService;
import com.microservice.UserRegistrationService.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserRegService
{
    @Autowired
    private UserService userService;

    @RequestMapping(method= RequestMethod.POST , value="/newUser")
    public void createNewUser(@RequestBody User user)
    {
      userService.addUser(user);
    }

    @RequestMapping("/allUser")
    public List<User> getAllUser()
    {
       return userService.getUsers();
    }

    @RequestMapping("/{firstName}")
    public User getUser(@PathVariable("firstName") String firstname)
    {
        return userService.getUser(firstname);
    }


   /* @RequestMapping("/{firstName}")
    public String getEmail(@PathVariable("firstName") String firstname)
    {
        return userService.getEmail(firstname);
    }*/

}
