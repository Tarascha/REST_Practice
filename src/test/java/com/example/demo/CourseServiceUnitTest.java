package com.example.demo;

import com.example.demo.modal.Contact;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CourseServiceUnitTest {
    @Mock
    private CourseService courseService;

    @Mock
    private CourseRepository courseRepository;

    @Test
    public void testCourseService(){
        List<Contact> courseList = new ArrayList<>();

        given(courseRepository.findAllContacts()).willReturn(courseList);

        List<Contact> result = courseService.findAllContacts();

        assertTrue(result.isEmpty());
    }

}
