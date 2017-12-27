package com.jsen.blog.study.controller;

import com.jsen.blog.study.test.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @（#）:Ch72Controlelr.java
 * @description:
 * @author: jiaosen 2017/12/25
 * @version: Version 1.0
 */
@Controller
public class Ch72Controller {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(Model model){
        Person single = new Person("aa","11");

        List<Person> people = new ArrayList<>();
        Person person1 = new Person("person1","11");
        Person person2 = new Person("person2","22");
        Person person3 = new Person("person3","33");
        people.add(person1);
        people.add(person2);
        people.add(person3);
        model.addAttribute("singlePerson",single);
        model.addAttribute("people",people);
        return "index";
    }
}
