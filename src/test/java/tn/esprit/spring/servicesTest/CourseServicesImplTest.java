package tn.esprit.spring.servicesTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.TypeCourse;
import tn.esprit.spring.entities.Support;
import tn.esprit.spring.repositories.ICourseRepository;
import tn.esprit.spring.services.CourseServicesImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class CourseServicesImplTest {

    @Mock
    private ICourseRepository courseRepository;

    @InjectMocks
    private CourseServicesImpl courseServices;

    private Course course;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        course = new Course(1L, 3, TypeCourse.COLLECTIVE_CHILDREN, Support.SKI, 99.99f, 10, null);
    }

    @Test
    void testRetrieveAllCourses() {
        when(courseRepository.findAll()).thenReturn(Arrays.asList(course));
        List<Course> courses = courseServices.retrieveAllCourses();
        assertNotNull(courses);
        assertEquals(1, courses.size());
        verify(courseRepository, times(1)).findAll();
    }

    @Test
    void testAddCourse() {
        when(courseRepository.save(course)).thenReturn(course);
        Course savedCourse = courseServices.addCourse(course);
        assertNotNull(savedCourse);
        verify(courseRepository, times(1)).save(course);
    }

    @Test
    void testUpdateCourse() {
        when(courseRepository.save(course)).thenReturn(course);
        Course updatedCourse = courseServices.updateCourse(course);
        assertNotNull(updatedCourse);
        verify(courseRepository, times(1)).save(course);
    }

    @Test
    void testRetrieveCourse() {
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        Course retrievedCourse = courseServices.retrieveCourse(1L);
        assertNotNull(retrievedCourse);
        assertEquals(3, retrievedCourse.getLevel());
        verify(courseRepository, times(1)).findById(1L);
    }

    @Test
    void testRetrieveCourseNotFound() {
        when(courseRepository.findById(2L)).thenReturn(Optional.empty());
        Course retrievedCourse = courseServices.retrieveCourse(2L);
        assertNull(retrievedCourse);
        verify(courseRepository, times(1)).findById(2L);

    }
}
