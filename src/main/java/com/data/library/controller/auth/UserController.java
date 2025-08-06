package com.data.library.controller.auth;

import com.data.library.model.dto.UserDTO;
import com.data.library.model.entity.User;
import com.data.library.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private IUserService userService;

    // Hiển thị form login
    @GetMapping("/login")
    public String showLoginForm(Model model){
        model.addAttribute("user", new UserDTO());
        return "/auth/login";
    }

    // Xử lý login
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model){
        User user = userService.login(username, password);
        if (user != null){
            session.setAttribute("loginUser", user);
            if (user.getRole().equals("ADMIN")){
                return "redirect:/admin/home";
            }else {
                return "redirect:/user/home";
            }
        }else {
            model.addAttribute("error", "Sai tên đăng nhập hoặc mật khẩu");
            return "/auth/login";
        }
    }

    // Hiển thị form register
    @GetMapping("register")
    public String showRegisterForm(Model model){
        model.addAttribute("user", new User());
        return "/auth/register";
    }

    // Xử lý form register
    @PostMapping("/register")
    public String register(@ModelAttribute("user") @Valid UserDTO userDTO,
                           BindingResult bindingResult,
                           @RequestParam String confirmPassword,
                           Model model) {
        // Nếu có lỗi validate từ DTO
        if (bindingResult.hasErrors()) {
            return "/auth/register";
        }

        // Kiểm tra trùng username
        if (userService.findByUserName(userDTO.getUsername()) != null) {
            model.addAttribute("error", "Tên đăng nhập đã tồn tại");
            return "/auth/register";
        }

        // Kiểm tra trùng email
        if (userService.findUserByEmail(userDTO.getEmail()) != null) {
            model.addAttribute("error", "Email đã tồn tại");
            return "/auth/register";
        }

        // Kiểm tra confirm password
        if (!userDTO.getPassword().equals(confirmPassword)) {
            model.addAttribute("error", "Mật khẩu không trùng khớp");
            return "/auth/register";
        }

        // Chuyển từ DTO -> Entity
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setRole("USER");  // mặc định
        user.setStatus(true);  // mặc định

        userService.register(user);
        model.addAttribute("message", "Đăng ký thành công !");
        return "/auth/login";
    }

    // logout
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "/auth/login";
    }
}
