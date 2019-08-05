package re.res;

import re.res.User;
import re.res.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by songqiuming on 2018/1/7.
 */
@RestController
public class UserController {

    @Autowired
    private UserJPARepository userJPARepository;

    /**
     * 查询用户列表
     * @return
     */
    @GetMapping(value = "/user")
    public List<User> findUserList(){
        return userJPARepository.findAll();
    }

    /**
     * 根据Id查询一个用户
     * @param id
     * @return
     */
    @GetMapping(value = "/user/query/{id}")
    public User findUserOne(@PathVariable("id") Integer id){
        return userJPARepository.findOne(id);
    }

    /**
     * 添加用户
     * @param name
     * @param age
     * @param country
     * @return
     */

    @PostMapping(value = "/user")
    public User addUser(@RequestParam("name") String name, @RequestParam("age") int age,
                        @RequestParam("country") String country){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setCountry(country);
        return userJPARepository.save(user);
    }

    /**
     * 删除用户
     * @param id  用户编号
     * @return
     */
    @DeleteMapping(value = "/user/{id}")
    public  List<User> deleteUser(@PathVariable("id") Integer id){
        userJPARepository.delete(id);
        return userJPARepository.findAll();
    }

    /**
     * 更新用户
     * @param id
     * @param name
     * @param age
     * @param country
     * @return
     */
    @PutMapping(value = "/user/{id}")
    public User updateUser(@PathVariable("id") Integer id, @RequestParam("name") String name,
                           @RequestParam("age") int age, @RequestParam("country") String country){
        User user = userJPARepository.findById(id);
        user.setName(name);
        user.setAge(age);
        user.setCountry(country);
        return userJPARepository.save(user);
    }

    /**
     * 根据国家查询用户
     * @param country
     * @return
     */
    @GetMapping(value = "/user/{country}")
    public List<User> findByCountry(@PathVariable("country") String country){
        return userJPARepository.findByCountry(country);
    }

}


