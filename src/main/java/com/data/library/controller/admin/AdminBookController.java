package com.data.library.controller.admin;

import com.data.library.model.entity.Book;
import com.data.library.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/books")
public class AdminBookController {

    @Autowired
    private IBookService bookService;

    // Hiển thị danh sách sách, tìm kiếm, phân trang
    @GetMapping
    public String showAll(@RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "size", defaultValue = "5")int size,
                          @RequestParam(value = "keyword", required = false)String keyword,
                          Model model){
        if (keyword != null && !keyword.trim().isEmpty()){
            model.addAttribute("books", bookService.searchBookByTitle(keyword));
        }else {
            int totalBook = bookService.getBookCount();
            int totalPage = (int) Math.ceil((double)totalBook/(double)size);
            model.addAttribute("books", bookService.getBookByPage(page,size));
            model.addAttribute("currentPage", page);
            model.addAttribute("totalPage", totalPage);
        }
        return "/admin/bookList";
    }

    // Hiển thị form thêm mới
    @GetMapping("/create")
    public String createBook(Model model){
        model.addAttribute("books", new Book());
        return "/admin/addBook";
    }

    // Xử lý thêm mới
    @PostMapping("/create")
    public String doCreateBook(@ModelAttribute("book") Book book){
        bookService.addBook(book);
        return "redirect:/admin/books";
    }

    // Hiển thị form update
    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable int id,Model model){
        model.addAttribute("books", bookService.getById(id));
        return "/admin/editBook";
    }

    // Xử lý update
    @PostMapping("/edit")
    public String doEditBook(@ModelAttribute("book") Book book){
        bookService.updateBook(book);
        return "redirect:/admin/books";
    }

    // Xử lý xóa
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
        return "redirect:/admin/books";
    }
}
