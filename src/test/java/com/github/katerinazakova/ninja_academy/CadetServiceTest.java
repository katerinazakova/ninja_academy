package com.github.katerinazakova.ninja_academy;

import com.github.katerinazakova.ninja_academy.entity.Cadet;
import com.github.katerinazakova.ninja_academy.entity.CourseEnum;
import com.github.katerinazakova.ninja_academy.entity.Dates;
import com.github.katerinazakova.ninja_academy.entity.DayEnum;
import com.github.katerinazakova.ninja_academy.service.CadetService;
import com.github.katerinazakova.ninja_academy.service.DatesService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class CadetServiceTest {
    private final CadetService cadetService;
    Cadet cadetTest;
    @Autowired
    private DatesService datesService;

    @Autowired
    public CadetServiceTest(CadetService cadetService) {
        this.cadetService = cadetService;
    }

    @BeforeEach
    void setUp() {
        cadetTest = new Cadet();
    }

    @Test
    void testFindCadetById_ReturnExistingCadetById() {
        //Arrange
        cadetTest.setFirstName("Jana");
        cadetTest.setSecondName("Jahodová");
        cadetTest.setBirthDay(LocalDate.of(2021,2,3));
        cadetTest.setNameCourse(CourseEnum.TAEKWONDO);
        cadetTest.setDayCourse(DayEnum.PO);
        cadetTest.setStartTimeCourse(LocalTime.of(15,0));
        cadetTest.setNameParent("Petra Jahodová");
        cadetTest.setEmail("jahoda@gmail.com");
        cadetTest.setPhoneNumber("450450450");
        cadetTest.setDate(datesService.findDateById(1));
        cadetService.saveNewCadet(cadetTest);
        //Act
        Cadet actualResult = cadetService.findCadetById(cadetTest.getId());
        //Assert
        assertNotNull(actualResult);
        Assertions.assertEquals(cadetTest,actualResult);
    }


    @Test
    void testCalculateAge_ReturnAgeOfCadet() {
        //Arrange
        cadetTest.setBirthDay(LocalDate.of(2020, 4, 26));
        int expectedResult = Period.between(cadetTest.getBirthDay(), LocalDate.now()).getYears();
        //Act
        int actualResult = cadetService.calculateAge(cadetTest);
        //Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void tesIsParentEscortRequired_ReturnTrue() {
        //Arrange
        cadetTest.setBirthDay(LocalDate.of(2020, 2, 2));
        //Act
        boolean actualResult = cadetService.isParentEscortRequired(cadetTest);
        //Assert
        assertTrue(actualResult);
    }

    @Test
    void testIsParentEscortRequired_ReturnFalse() {
        //Arrange
        cadetTest.setBirthDay(LocalDate.of(2014, 2, 2));
        //Act
        boolean actualResult = cadetService.isParentEscortRequired(cadetTest);
        //Assert
        assertFalse(actualResult);
    }

    @Test
    void testIsCadetOutOfAgeCategory_ReturnTrue() {
        //Arrange
        Dates dateOfCadet = new Dates();
        dateOfCadet.setAgeFrom(5);
        dateOfCadet.setAgeTo(6);
        cadetTest.setBirthDay(LocalDate.of(2016, 5, 15));
        //Act
        boolean actualResult = cadetService.isCadetOutOfAgeCategory(cadetTest, dateOfCadet);
        //Assert
        assertTrue(actualResult);
    }

    @Test
    void testIsCadetOutOfAgeCategory_ReturnFalse() {
        //Arrange
        Dates dateOfCadet = new Dates();
        dateOfCadet.setAgeFrom(5);
        dateOfCadet.setAgeTo(6);
        cadetTest.setBirthDay(LocalDate.of(2018, 5, 15));
        //Act
        boolean actualResult = cadetService.isCadetOutOfAgeCategory(cadetTest, dateOfCadet);
        //Assert
        assertFalse(actualResult);
    }

}
