package com.example.demo.service;


import com.example.demo.modal.Contact;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Contact> findAllContacts(){

        return courseRepository.findAllContacts();
    }

    public Contact findAllContactsById(String Id){
        return courseRepository.findAllContactsById(Id);
    }

    public Contact addContact(String id, String firstname, String familyname, String phonenumber, String email){
        return courseRepository.addContact(id, firstname, familyname, phonenumber, email);
    }

    public Contact updateContactById(String id, String firstname, String familyname, String phonenumber, String email, String indexId){
        return courseRepository.updateContactById(id, firstname, familyname, phonenumber, email, indexId);
    }

    public List<Contact> deleteall(){
        return courseRepository.deleteall();
    }

    public Contact deleteById(String id){
        return courseRepository.deleteById(id);
    }

}
