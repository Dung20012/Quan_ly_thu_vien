package com.data.library.controller.admin;

import com.data.library.model.entity.Borrowing;
import com.data.library.service.IBorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/borrowings")
public class AdminBorrowingController {
    @Autowired
    private IBorrowingService borrowingService;

    // Hiển thị danh sách các yêu cầu mượn đang chờ phê duyệt
    @GetMapping
    public String listRequests(Model model) {
        List<Borrowing> pending = borrowingService.getPendingRequests();
        model.addAttribute("requests", pending);
        return "/admin/borrowRequests";
    }

    // Phê duyệt yêu cầu mượn sách
    @GetMapping("/approve/{id}")
    public String approve(@PathVariable int id) {
        borrowingService.approveRequest(id);
        return "redirect:/admin/borrowings";
    }

    // Từ chối yêu cầu mượn sách
    @GetMapping("/reject/{id}")
    public String reject(@PathVariable int id) {
        borrowingService.rejectRequest(id);
        return "redirect:/admin/borrowings";
    }

    // Xem lịch sử mượn sách
    @GetMapping("/history")
    public String viewAllBorrowHistory(Model model) {
        List<Borrowing> allBorrowings = borrowingService.getAll();
        model.addAttribute("borrowings", allBorrowings);
        return "/admin/borrow_history";
    }
}
