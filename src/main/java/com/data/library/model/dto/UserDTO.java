package com.data.library.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserDTO {
    private int id;

    @NotBlank(message = "Tên đăng nhập không được để trống")
    @Size(min = 5, max = 20, message = "Tên đăng nhập phải từ 5 đến 20 ký tự")
    private String username;

    @NotBlank(message = "Mật khẩu không được để trống")
    @Pattern(
            regexp = "^[A-Z][a-zA-Z0-9!@#$%^&*()_+=\\-\\[\\]{};':\"\\\\|,.<>\\/?]*[0-9]+.*[!@#$%^&*()_+=\\-\\[\\]{};':\"\\\\|,.<>\\/?]+.*$",
            message = "Mật khẩu phải bắt đầu bằng chữ hoa, chứa ít nhất một số và một ký tự đặc biệt"
    )
    private String password;

    @NotBlank(message = "Email không được để trống")
    @Pattern(
            regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$",
            message = "Email phải đúng định dạng và kết thúc bằng @gmail.com"
    )
    private String email;
}
