package edu.egg.spring.controller;

import edu.egg.spring.entity.BookEntity;
import edu.egg.spring.service.AuthorService;
import edu.egg.spring.service.BookService;
import edu.egg.spring.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

import java.util.Map;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;
    //private final PublisherService publisherService;

    @GetMapping
    public ModelAndView getAll() {//tipo de java para manejar solicitudes
        ModelAndView mav = new ModelAndView("book-table");
        mav.addObject("all_book", bookService.getAll());
        return mav;
    }

    @GetMapping("/form")
    public ModelAndView getForm(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("book-form");
        mav.addObject("book_object", new BookEntity());
        mav.addObject("all_author",authorService.getAll());
        //mav.addObject("all_publisher",publisherService.getAll());
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        if (inputFlashMap != null) mav.addObject("success_msj", inputFlashMap.get("success_msj"));
        return mav;
    }

    @GetMapping("/form/{id}")
    public ModelAndView getForm(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("book-form");
        mav.addObject("book_object", new BookEntity());
        mav.addObject("all_author", authorService.getAll());
        //mav.addObject("all_publisher", publisherService.getAll());
        return mav;
    }
//post no se ve, get si se ve, post necesita de get para ver
    @PostMapping("/create")
    public RedirectView create(BookEntity bookDto, RedirectAttributes attributes) {
        RedirectView redirect = new RedirectView("/book/form");
        bookService.create(bookDto);
        attributes.addFlashAttribute("success_msj", bookDto.getTitle()+" added successfully");
        return redirect;
    }

    @PostMapping("/update")
    public RedirectView update(BookEntity bookDto, RedirectAttributes attributes) {
        RedirectView redirect = new RedirectView("/book");
        bookService.update(bookDto);
       attributes.addFlashAttribute("success_msj", bookDto.getTitle()+" updated successfully");
        return redirect;
    }

    @PostMapping("/delete/{id}")
    public RedirectView delete(@PathVariable Long id) {
        RedirectView redirect = new RedirectView("/book");
        bookService.deleteById(id);
        return redirect;
    }
}
