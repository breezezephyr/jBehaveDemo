package com.qunar.jbehave.basic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA. Author: xiappeng.cai Date: 14-11-23 Time: 下午4:31
 */
public class StudentStepsZh {
    private ClassRoom classRoom;
    private Student student;
    private Logger logger = LoggerFactory.getLogger(StudentStepsZh.class);

    @Given("我们新来了一位同学")
    public void initStudent() {
        student = new Student();
        classRoom = new ClassRoom();
    }

    @Given("他的名字叫'$name'")
    public void setName(@Named("name") String name) {
        student.setName(name);
        logger.info("他的名字{}", name);
    }

    @Given("他的年纪'$age'")
    public void setAge(@Named("age") Integer age) {
        student.setAge(age);
        logger.info("他的年纪{}", age);
    }

    @When("我们把'$studentName'添加到我们的班级")
    public void addStudent(@Named("studentName") String studentName) {
        classRoom.addStudent(studentName, student);
        logger.info("我们把{}添加到我们的班级", studentName);
    }

    @Then("我们可以在班里面找到'$studentName'")
    public void getStudent(@Named("studentName") String studentName) {
        assertThat(student, is(classRoom.getStudent(studentName)));
        logger.info("我们可以在班里面找到{}", classRoom.getStudent(studentName).toString());
    }
}
