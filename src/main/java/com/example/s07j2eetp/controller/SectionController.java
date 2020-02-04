package com.example.s07j2eetp.controller;

import com.example.s07j2eetp.repository.SectionRepository;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.s07j2eetp.entity.Section;


@Controller
@RequestMapping("/sections/")
public class SectionController {

    @Autowired
    private SectionRepository sectionRepository;

    @GetMapping("{id}")
    public String getSection(@PathVariable("id") long id, Model model) {
        Section section = sectionRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid section Id:" + id));
        model.addAttribute("section", section);
        return "section/details";
    }

    @GetMapping("list")
    public String getMethodName(Model model) {
        model.addAttribute("sections", sectionRepository.findAll());
        return "section/list";
    }

    @GetMapping("create")
    public String createSectionForm(Model model) {
        model.addAttribute("section", new Section());
        return "section/create";
    }

    @PostMapping("create")
    public String createSection(@Valid Section section) {
        sectionRepository.save(section);
        return "redirect:list";
    }

    @GetMapping("update/{id}")
    public String updateSectionForm(@PathVariable("id") long id, Model model) {
        Section section = sectionRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid section Id:" + id));
        model.addAttribute("section", section);
        return "section/update";
    }

    @PostMapping("update/{id}")
    public String updateSection(@PathVariable("id") long id, @Valid Section section) {
        sectionRepository.save(section);
        return "redirect:/sections/list";
    }

    @GetMapping("delete/{id}")
    public String deleteSection(@PathVariable("id") long id) {
        Section section = sectionRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid section Id:" + id));
        sectionRepository.delete(section);
        return "redirect:/sections/list";
    }
}
