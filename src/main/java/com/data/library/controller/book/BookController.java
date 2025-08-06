package com.data.library.controller.book;

import com.data.library.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    // Hiển thị danh sách sách, tìm kiếm, phân trang
    @GetMapping
    public String showAll(@RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "size", defaultValue = "5") int size,
                          @RequestParam(value = "keyword", required = false) String keyword,
                          Model model) {
        if (keyword != null && !keyword.trim().isEmpty()) {
            model.addAttribute("books", bookService.searchBookByTitle(keyword));
        }else {
            int totalBook =bookService.getBookCount();
            int totalPage = (int) Math.ceil((double)totalBook/(double)size);

            model.addAttribute("books", bookService.getAllBooks());
            model.addAttribute("books", bookService.getBookByPage(page, size));
            model.addAttribute("currentPage", page);
            model.addAttribute("totalPage", totalPage);
        }
        return "bookList";
    }
}
