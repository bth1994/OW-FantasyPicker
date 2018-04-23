package com.ourowproject.owproject.repositories;

import com.ourowproject.owproject.entities.Choice;

import org.springframework.data.repository.CrudRepository;

public interface ChoiceRepository extends CrudRepository<Choice, Long>{
//    Iterable<Choice> getAllChoicesByMatch_id(Long match_id);
//    Iterable<Choice> getAllChoicesByUser_id(Long user_id);
    Choice findChoiceById(Long choiceId);

}
