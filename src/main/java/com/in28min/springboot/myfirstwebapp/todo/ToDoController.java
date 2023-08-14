package com.in28min.springboot.myfirstwebapp.todo;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

//@Controller
@SessionAttributes("name")
public class ToDoController {

    private ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @RequestMapping(value = "todos", method = RequestMethod.GET)
    public String findByUsername(ModelMap model) {
        model.put("todos", toDoService.findByUsername(getLoggedUserName()));
        return "listAlltodos";
    }

    @RequestMapping(value = "welcome", method = RequestMethod.GET)
    public String welcomePage() {
        return "welcome";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodo(ModelMap model){
        ToDo todo = new ToDo(0,getLoggedUserName(),"", LocalDate.now(),false);
        model.put("todo",todo);
        return "todoPage";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, ToDo todo){
        toDoService.addToDo(getLoggedUserName(), todo.getDescription(),todo.getTargetDate());
        return "redirect:/todos";
    }

    @RequestMapping(value = "delete-todo", method = RequestMethod.GET)
    public String deleteNewTodo(@RequestParam int id){
        toDoService.deleteToDo(id);
        return "redirect:/todos";
    }

    private String getLoggedUserName(){
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
