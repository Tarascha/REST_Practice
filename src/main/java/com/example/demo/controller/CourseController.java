package com.example.demo.controller;

import com.example.demo.modal.Contact;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CourseController {
    @Autowired
    CourseService courseService;


    @GetMapping(path = "/api/contacts", produces = "application/json")
    public HttpEntity findAllContacts(){
        List<Contact> allContacts = courseService.findAllContacts();

        return new ResponseEntity<>(allContacts,HttpStatus.OK);
    }

    @GetMapping(path = "/api/contacts/{contactId}", produces = "application/json")
    public HttpEntity findContactsById(@PathVariable String contactId){
        Contact allContactsByid = courseService.findAllContactsById(contactId);

        return new ResponseEntity<>(allContactsByid, HttpStatus.OK);
    }

    @PostMapping(path = "/api/contacts", produces = "application/json")
    public HttpEntity addContact(@RequestBody Contact contact){
        Contact addedContact = courseService.addContact(contact.getId(), contact.getFirstname(), contact.getFamilyname(), contact.getPhonenumber(), contact.getEmail());

        return new ResponseEntity<>(addedContact, HttpStatus.OK);

    }

    @PutMapping(path = "/api/contacts/{contactId}", produces = "application/json")
    public  HttpEntity updateContactById(@RequestBody Contact contact, @PathVariable String contactId){

        if(contact.getId() == null || contact.getFirstname() == null || contact.getFamilyname() == null || contact.getPhonenumber() == null || contact.getEmail() == null){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        Contact upadtedContact = courseService.updateContactById(contact.getId(), contact.getFirstname(), contact.getFamilyname(), contact.getPhonenumber(), contact.getEmail(), contactId);

        if(upadtedContact != null) {
            return new ResponseEntity<>(upadtedContact, HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping(path = "/api/contacts", produces = "application/json")
    public HttpEntity deleteAll(){
        List<Contact> alldeleted = courseService.deleteall();

        return new ResponseEntity<>(alldeleted, HttpStatus.OK);
    }


    @DeleteMapping(path = "/api/contacts/{contactId}", produces = "application/json")
    public HttpEntity deleteById(@PathVariable String contactId){
        char[] sc = contactId.toCharArray();
        for(Character c : sc){
            if(!Character.isDigit(c)){
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        }
        Contact deletedId = courseService.deleteById(contactId);
        if(deletedId != null) {
            return new ResponseEntity<>(deletedId, HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
