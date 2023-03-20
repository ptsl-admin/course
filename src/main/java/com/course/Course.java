package com.course;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Locale;
import java.util.regex.Pattern;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String courseName;

    @Column
    private String courseSlug;

    public Course(){
        // empty constructor
    }

    // constructor with both course name and course slug 
    public Course(String courseName, String courseSlug){
        this.courseName = courseName;
        this.courseSlug = courseSlug;
    }

    // constructor with only courseName parameter.. here courseSlug will be auto-generated
    public Course(String couserNmae){
        this.courseName = couserNmae;
        this.courseSlug = Course.getCourseSlug(courseName);
        System.out.println(this.courseSlug);
    }

    public static String getCourseSlug(String courseName){
        final Pattern nonLatin = Pattern.compile("[^\\w-]");
        final Pattern whiteSpace = Pattern.compile("[\\s]");

        String nowhitespace = whiteSpace.matcher(courseName).replaceAll("-");
        String normalized = Normalizer.normalize(nowhitespace, Form.NFD);
        String slug = nonLatin.matcher(normalized).replaceAll("");

        System.out.println(slug.toLowerCase(Locale.ENGLISH));
        return slug.toLowerCase(Locale.ENGLISH);

    }


}
