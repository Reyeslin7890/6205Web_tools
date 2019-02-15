/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.pojo.Course;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Reyes
 */
public class CourseController extends AbstractController {

    List<Course> courseList = null;

    public CourseController() {

    }

    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        if (courseList == null) {
            setCourseList();
        }
                String action = request.getParameter("action");
        HttpSession session = request.getSession(false);
        Set<Course> myCourses;
        if (session.getAttribute("myCourseSet") != null) {
            myCourses = (Set<Course>) session.getAttribute("myCourseSet");
        } else {
            myCourses = new HashSet<Course>();
        }

        if (action.equals("add")) {
            String[] crn = request.getParameterValues("crn");
            if (crn != null) {
                for (String courseCrn : crn) {
                    for (Course course : courseList) {
                        if (course.getCrn().equals(courseCrn)) {
                            myCourses.add(course);
                        }
                    }
                }
            }
            session.setAttribute("myCourseSet", myCourses);
            mav.setViewName("mycourses");

        } else if (action.equals("search")) {
            String searchType = request.getParameter("searchType");
            String searchQuery = request.getParameter("query");
            ArrayList<Course> searchResults = new ArrayList<>();
            if (searchType.equals("crn")) {
                for (Course course : courseList) {
                    if (course.getCrn().equals(searchQuery)) {
                        searchResults.add(course);
                    }
                }
            } else if (searchType.equals("title")) {
                for (Course course : courseList) {
                    if (course.getCourseDescription().contains(searchQuery) || course.getInstructor().contains(searchQuery) || course.getName().contains(searchQuery)) {
                        searchResults.add(course);
                    }
                }
            }
            mav = new ModelAndView("courseview", "searchResults", searchResults);
        } else if (action.equals("remove")) {
            //To be completed by students as part of Lab HW
            String courseCrn = request.getParameter("crn");
            for (Course course : myCourses) {
                if (course.getCrn().equals(courseCrn)) {
                    myCourses.remove(course);
                    break;
                }
            }
            mav.setViewName("mycourses");
        } else if (action.equals("mycourses")){
            mav.setViewName("mycourses");
        } else if (action.equals("searchCourse"))
            mav.setViewName("searchCourse");
        return mav;
    }

    private void setCourseList() {
        courseList = new ArrayList<>();
        Course c1 = new Course();
        c1.setCourseDescription("java programming");
        c1.setCrn("36099");
        c1.setInstructor("Khaled M. Bugrara");
        c1.setName("AED");

        Course c2 = new Course();
        c2.setCourseDescription("Course fro learning web technologies used in frint end");
        c2.setCrn("37913");
        c2.setInstructor("YusufOzbek");
        c2.setName("Web Dsign and user exp");

        Course c3 = new Course();
        c3.setCourseDescription("course for learning algorithms");
        c3.setCrn("34267");
        c3.setInstructor("Khaled M. Bugrara");
        c3.setName("Program Structure and Algorithms");

        Course c4 = new Course();
        c4.setCourseDescription("course for learning java EE");
        c4.setCrn("31606");
        c4.setInstructor("YusufOzbek");
        c4.setName("Web Tools");

        courseList.add(c1);
        courseList.add(c2);
        courseList.add(c3);
        courseList.add(c4);
    }

}
