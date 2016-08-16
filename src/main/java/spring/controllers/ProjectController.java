package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import spring.beans.BeanA;
import spring.beans.Project;

/**
 * Created by Balaji on 14/07/16.
 */

@Controller
@SessionAttributes("project")

public class ProjectController
{


    @Autowired
    BeanA beanA;

    @RequestMapping("/")
    public String home(HttpServletRequest request)
    {
        request.removeAttribute("project");
        return "home" ;
    }

    @RequestMapping("add")
    public String add(Model model)
    {
        model.addAttribute(new Project());
        return "project_add";
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String added(@ModelAttribute("project") Project project, HttpServletRequest request )
    {
        HttpSession session = request.getSession();
        if(session.getAttribute("projects") != null)
        {
            ArrayList<Project> projects = (ArrayList<Project>) session.getAttribute("projects");
            projects.add(project);
            session.setAttribute("projects", projects);
        }
        else
        {
            ArrayList<Project> projects = new ArrayList<Project>();
            projects.add(project);
            session.setAttribute("projects", projects);
        }
        return "project_added" ;
    }

    @RequestMapping("edit")
    public String edit(Model m)
    {
        return "project_edit";
    }

    @RequestMapping("save")
    public String save(HttpServletRequest request)
    {

        return "project_save";
    }

    @RequestMapping(value = "data", produces = "application/xml")
    public String data(HttpServletRequest request)
    {

        return "data";
    }



}
