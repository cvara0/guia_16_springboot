package edu.egg.spring.controller;

import edu.egg.spring.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/publisher")
@RequiredArgsConstructor
public class PublisherController {

    private final PublisherService publisherService;

   /* @GetMapping
    public ModelAndView getPersons(HttpServletRequest request) {//tipo de java para manejar solicitudes
        ModelAndView mav = new ModelAndView("person-table");
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);

        if (inputFlashMap != null) mav.addObject("success", inputFlashMap.get("success"));

        mav.addObject("persons", personService.getAll());
        return mav;
    }

    @GetMapping("/form")
    public ModelAndView getForm(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("person-form");
        mav.addObject("person", new Person());
        mav.addObject("action", "create");

        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);

        if (inputFlashMap != null) mav.addObject("success", inputFlashMap.get("success"));

        return mav;
    }

    @GetMapping("/form/{id}")
    public ModelAndView getForm(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("person-form");
        mav.addObject("person", personService.getById(id));
        mav.addObject("action", "update");
        return mav;
    }

    @PostMapping("/create")
    public RedirectView create(Person personDto, RedirectAttributes attributes) {
        RedirectView redirect = new RedirectView("/persons/form");
        personService.create(personDto);
        attributes.addFlashAttribute("success", personDto.getName()+" "+personDto.getSurname()+" added successfully");
        return redirect;
    }

    @PostMapping("/update")
    public RedirectView update(Person personDto, RedirectAttributes attributes) {
        RedirectView redirect = new RedirectView("/persons");
        personService.update(personDto);
        attributes.addFlashAttribute("success", "The operation has been carried out successfully");
        return redirect;
    }

    @PostMapping("/delete/{id}")
    public RedirectView delete(@PathVariable Long id) {
        RedirectView redirect = new RedirectView("/persons");
        personService.deleteById(id);
        return redirect;
    }*/
}
