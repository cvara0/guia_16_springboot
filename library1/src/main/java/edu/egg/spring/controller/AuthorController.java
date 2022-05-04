package edu.egg.spring.controller;

import edu.egg.spring.entity.AuthorEntity;
import edu.egg.spring.service.AuthorService;
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
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public ModelAndView getAll(HttpServletRequest request) {//tipo de java para manejar solicitudes
        ModelAndView mav = new ModelAndView("author-table");
        mav.addObject("all_author", authorService.getAll());
        return mav;
    }

    @GetMapping("/form")
    public ModelAndView getForm(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("author-form");
        mav.addObject("author_object", new AuthorEntity());
        mav.addObject("action", "create");
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        if (inputFlashMap != null) mav.addObject("success_msj", inputFlashMap.get("success_msj"));
        return mav;
    }

    @GetMapping("/form/{id}")
    public ModelAndView getForm(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("author-form");
        mav.addObject("author_object", authorService.getById(id));
        mav.addObject("action", "update");
        return mav;
    }

    //post no se ve, get si se ve, post necesita de get para ver
    @PostMapping("/create")
    public RedirectView create(AuthorEntity authorEntityDto, RedirectAttributes attributes) {
        RedirectView redirect = new RedirectView("/author/form");
        authorService.create(authorEntityDto);
        attributes.addFlashAttribute("success_msj", authorEntityDto.getName() + " added successfully");
        return redirect;
    }

    @PostMapping("/update")
    public RedirectView update(AuthorEntity authorDto, RedirectAttributes attributes) {
        RedirectView redirect = new RedirectView("/author");
        authorService.update(authorDto);
        attributes.addFlashAttribute("success_object", "Author updated successfully");
        return redirect;
    }

    @PostMapping("/deleted/{id}")
    public RedirectView destroy(@PathVariable Long id) {
        RedirectView redirect = new RedirectView("/author");
        authorService.deleteById(id);
        return redirect;
    }

    @PostMapping("/up/{id}")
    public RedirectView up(@PathVariable Long id) {

        authorService.up(id);
        RedirectView redirect = new RedirectView("/author");
        return redirect;
    }


}
