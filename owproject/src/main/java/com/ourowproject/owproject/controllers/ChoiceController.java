package com.ourowproject.owproject.controllers;

import com.ourowproject.owproject.entities.Choice;
import com.ourowproject.owproject.services.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChoiceController {

    private ChoiceService choiceService;

    @Autowired
    public ChoiceController(ChoiceService choiceService){
        this.choiceService = choiceService;
    }

    @RequestMapping(value = "/choices", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Choice>> getAllChoices(){
        return choiceService.getAllChoices();
    }

    @RequestMapping(value = "/choices/{choiceId}", method = RequestMethod.GET)
    public ResponseEntity<Choice> getChoiceById(@PathVariable Long choiceId){
        return choiceService.getChoiceById(choiceId);
    }

    @RequestMapping(value = "/choices", method = RequestMethod.POST)
    public ResponseEntity<Choice> createChoice(Choice choice){
        return choiceService.createChoice(choice);
    }

    @RequestMapping(value = "/choices", method = RequestMethod.PUT)
    public ResponseEntity<Choice> updateChoice(Choice choice){
        return choiceService.updateChoice(choice);
    }

}
