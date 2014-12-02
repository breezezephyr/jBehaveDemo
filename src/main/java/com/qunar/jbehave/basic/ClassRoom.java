package com.qunar.jbehave.basic;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created with IntelliJ IDEA. Author: xiappeng.cai Date: 14-11-23 Time: 下午4:32
 */
public class ClassRoom {
    private Map<String, Student> classRoom = Maps.newHashMap();

    public void addStudent(String name, Student student) {
        classRoom.put(name, student);
    }

    public Student getStudent(String studentName) {
        return classRoom.get(studentName);
    }
}
