package com.data.library.controller.borrowing;

import com.data.library.model.entity.Book;
import com.data.library.model.entity.Borrowing;
import com.data.library.model.entity.User;
import com.data.library.service.IBorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/borrowings")
public class BorrowingController {
    @Autowired
    private IBorrowingService borrowingService;

    // Xử lý yêu cầu mượn sách từ ng dùng
    @PostMapping("/request/{bookId}")
    public String requestBorrow(@PathVariable int bookId, HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        if (user == null) {
            return "redirect:/auth/login";
        }

        // Tạo đối tượng mượn sách mới
        Borrowing borrowing = new Borrowing();
        borrowing.setUser(user);
        borrowing.setBook(new Book(bookId));
        borrowing.setBorrowDate(LocalDate.now());
        borrowing.setReturned(false); // chưa trả
        borrowing.setApproved(false); // chưa được admin duyệt

        borrowingService.createBorrowing(borrowing);
        return "redirect:/books";
    }

    // Hiển thị lịch sử mượn sách với người dùng hiện tại
    @GetMapping("/my-borrows")
    public String viewMyBorrows(Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("loginUser");
       if (currentUser == null) {
           return "redirect:/auth/login"; // chưa login chuyeern đến login
       }
       // Lấy danh sách mượn user hiện tại
       List<Borrowing> borrowings = borrowingService.getBorrowingByUser(currentUser.getId());
       model.addAttribute("borrowings", borrowings);
       return "/borrow_list";
    }

    // Xử lý người dùng trả sách
    @PostMapping("/return/{id}")
    public String returnBook(@PathVariable("id") int borrowId) {
        borrowingService.returnBook(borrowId);
        return "redirect:/borrowings/my-borrows";
    }
}
