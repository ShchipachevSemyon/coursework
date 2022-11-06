package com.example.coursework.controller;

import com.example.coursework.entity.Lesson;
import com.example.coursework.repository.LessonRepository;
import com.example.coursework.service.UAService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Slf4j
@Controller
public class LessonController {

    @Autowired
    private LessonRepository lessonRepository;
    private UAService UAService;

    private LessonController (LessonRepository lessonRepository, UAService UAService){
        this.lessonRepository = lessonRepository;
        this.UAService = UAService;
    }


    @GetMapping("/list")
    public ModelAndView getAllLesson() {
        log.info("/list -> connection");
        ModelAndView mav = new ModelAndView("list-lesson");
        mav.addObject("lessons", lessonRepository.findAll());
        return mav;
    }

    @GetMapping("/addLessonForm")
    public ModelAndView addLessonForm() {
        ModelAndView mav = new ModelAndView("add-lesson-form");
        Lesson lesson = new Lesson();
        mav.addObject("lesson", lesson);
        UAService.saveUserAction(currentUserName() + " add lesson" + lesson.getTitle());
        return mav;
    }

    @PostMapping("/saveLesson")
    public String saveLesson(@ModelAttribute Lesson lesson) {
        lessonRepository.save(lesson);
        UAService.saveUserAction(currentUserName() + " save lesson" + lesson.getTitle());
        return "redirect:/list";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long lessonId) {
        ModelAndView mav = new ModelAndView("add-lesson-form");
        Optional<Lesson> optionalLesson = lessonRepository.findById(lessonId);
        Lesson lesson = new Lesson();
        if (optionalLesson.isPresent()) {
            lesson = optionalLesson.get();
        }
        UAService.saveUserAction(currentUserName() + " update lesson" + lesson.getTitle());
        mav.addObject("lesson", lesson);
        return mav;
    }

    @GetMapping("/deleteLesson")
    public String deleteLesson(@RequestParam Long lessonId) {
        Optional<Lesson> lesson = lessonRepository.findById(lessonId);
        lessonRepository.deleteById(lessonId);
        UAService.saveUserAction(currentUserName() + " delete lesson" + lesson.get().getTitle());
        return "redirect:/list";
    }

    private String currentUserName() {
        Authentication loggingInUser = SecurityContextHolder.getContext().getAuthentication();
        String userName = loggingInUser.getName();
        return userName;
    }
}


