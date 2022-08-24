package fun.miaomi.Kittyadmin.controller;

import fun.miaomi.Kittyadmin.mapper.UserMapper;
import fun.miaomi.Kittyadmin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/queryUserList")
    public List<User> queryUserList() {
        List<User> userList = userMapper.queryUserList();
        return userList;
    }

    @GetMapping("/queryUserById")
    public User queryUserById(Long id) {
        User user = userMapper.queryUserById(id);
        return user;
    }

    @PostMapping("/addUser")
    public String addUser(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "password") String  password,
            @RequestParam(value = "email") String email) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        userMapper.addUser(user);
        return "添加成功";
    }

    @PostMapping("/updateUser")
    public String updateUser(
            @RequestParam(value = "id") Long id,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "email") String email
    ) {
        User user = new User(id, name, password, email);
        userMapper.updateUser(user);
        return "修改成功";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam(value = "id") Long id) {
        userMapper.deleteUser(id);
        return "删除成功";
    }
}
