package com.ourowproject.owproject.repositories;

import com.ourowproject.owproject.entities.Choice;

import org.springframework.data.repository.CrudRepository;

public interface ChoiceRepository extends CrudRepository<Choice, Long>{
    Iterable<Choice> getAllChoicesBymatchID(Long match_id);
    Iterable<Choice> getAllChoicesByuserID(Long user);
    Choice findChoiceById(Long choiceId);

}
