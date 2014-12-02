package com.qunar.jbehave.basic;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created with IntelliJ IDEA. Author: xiappeng.cai Date: 14-11-23 Time: 下午4:31
 */
public class StudentSteps {
    private ClassRoom classRoom;
    private Student student;
    private Logger logger = LoggerFactory.getLogger(StudentSteps.class);

    @Given("There is a student")
    public void initStudent() {
        student = new Student();
        classRoom = new ClassRoom();
    }

    @Given("his name is '$name'")
    public void setName(@Named("name") String name) {
        student.setName(name);
        logger.info("his name is {}", name);
    }

    @Given("his age is '$age'")
    public void setAge(@Named("age") Integer age) {
        student.setAge(age);
        logger.info("his age is {}", age);
    }

    @Given("his hobby is '$hobby'")
    public void setHobby(@Named("hobbu") String hobby) {
        student.setHobby(hobby);
        logger.info("his hobby is {}", hobby);
    }

    @Given("his father's name is '$fatherName'")
    public void setFatherName(@Named("fatherName") String fatherName) {
        student.setFatherName(fatherName);
        logger.info("his father name is {}", fatherName);
    }

    @Given("his mother's name is '$motherName'")
    public void setMotherName(@Named("motherName") String motherName) {
        student.setMotherName(motherName);
        logger.info("his mother name is {}", motherName);
    }

    @Given("his brother's name is '$brotherName'")
    public void setBrotherName(@Named("brotherName") String brotherName) {
        student.setBrotherName(brotherName);
        logger.info("his brother name is {}", brotherName);
    }

    @When("system add the student '$studentName' into classRoom")
    public void addStudent(@Named("studentName") String studentName) {
        classRoom.addStudent(studentName, student);
        logger.info("we allocate {} in our class", studentName);
    }

    @Then("we can get student '$studentName' from classRoom")
    public void getStudent(@Named("studentName") String studentName) {
        assertThat(student, is(classRoom.getStudent(studentName)));
        logger.info(classRoom.getStudent(studentName).toString());
    }
}
