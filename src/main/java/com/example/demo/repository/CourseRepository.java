package com.example.demo.repository;

import com.example.demo.modal.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    //List<Course> courses = new ArrayList<>();

//    public CourseRepository() {
//        Course javaOne = Course.builder()
//                .className("Java I")
//                .instructor(new Instructor("Steve", "Jobs", "Phd", "TownHall201"))
//                .startDate(new Date("8/1/2018"))
//                .endDate(new Date("12/24/2018"))
//                .timeFrame("8am-10am")
//                .build();
//
//        courses.add(javaOne);
//    }
//
//
//    public List<Course> findAllClasses(){
//        return  courses;
//    }
//
//    public List<CourseDto> findAllClassesDto(){
//        List<CourseDto> courseDtos = new ArrayList<>();
//
//        for(Course item : courses){
//            CourseDto cdto = CourseDto.builder()
//                    .courseName(item.getClassName())
//                    .courseLocation("TBA")
//                    .courseContent("TBA")
//                    .teacherName(item.getInstructor().getFirstName() + " " + item.getInstructor().getLastName())
//                    .build();
//
//            courseDtos.add(cdto);
//        }
//
//        return courseDtos;
//    }

    List<Contact> contacts = new ArrayList<>();
    int idcount = 0;
    public CourseRepository(){
        Contact contact1 = Contact.builder()
                .id("1")
                .firstname("Stephon")
                .familyname("Curry")
                .phonenumber("12345")
                .email("12345@nba.com")
                .build();

        Contact contact2 = Contact.builder()
                .id("2")
                .firstname("Cevin")
                .familyname("Durrant")
                .phonenumber("12346")
                .email("12346@nba.com")
                .build();
        contacts.add(contact1);
        contacts.add(contact2);

        idcount = 3;
    }

    public List<Contact> findAllContacts(){
        return contacts;
    }

    public Contact findAllContactsById(String Id){

        for(Contact c : contacts){
            if(c.getId().equals(Id)){
                return c;
            }
        }
        return null;
    }

    public Contact addContact(String id, String firstname, String familyname, String phonenumber, String email){
        Contact newcontact = Contact.builder()
                .id(idcount + "")
                .firstname(firstname)
                .familyname(familyname)
                .phonenumber(phonenumber)
                .email(email)
                .build();
        idcount++;

        contacts.add(newcontact);

        return newcontact;
    }

    public Contact updateContactById(String id, String firstname, String familyname, String phonenumber, String email, String indexId){


        for(Contact c : contacts){
            if(c.getId().equals(indexId)){
                c.setId(id);
                c.setFirstname(firstname);
                c.setFamilyname(familyname);
                c.setPhonenumber(phonenumber);
                c.setEmail(email);
                return c;
            }
        }
        return null;
    }

    public List<Contact> deleteall(){
        List<Contact> res = new ArrayList<>(contacts);
        contacts = new ArrayList<>();
        return res;
    }

    public Contact deleteById(String id){
        for(Contact c : contacts){
            if(c.getId().equals(id)){
                contacts.remove(c);
                return c;
            }
        }
        return null;
    }
}


