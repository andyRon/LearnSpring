package com.andyron.spring6.iocxml.dimap;

/**
 * @author andyron
 **/
public class Lesson {
    private String lessonName;

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonName='" + lessonName + '\'' +
                '}';
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }
}
