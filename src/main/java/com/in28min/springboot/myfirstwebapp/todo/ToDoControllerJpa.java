package com.in28min.springboot.myfirstwebapp.todo;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@SessionAttributes("name")
public class ToDoControllerJpa {

    private ToDoRepository toDoRepository;

    public ToDoControllerJpa(ToDoService toDoService, ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @GetMapping("todos")
    public String findByUsername(ModelMap model) {
        model.put("todos", toDoRepository.findByUserName(getLoggedUserName()));
        return "listAlltodos";
    }

    @GetMapping("welcome")
    public String welcomePage() {
        return "welcome";
    }

    @GetMapping("add-todo")
    public String showNewTodo(ModelMap model){
        ToDo todo = new ToDo(0,getLoggedUserName(),"", LocalDate.now(),false);
        model.put("todo",todo);
        return "todoPage";
    }

    @PostMapping("add-todo")
    public String addNewTodo(ModelMap model, ToDo todo){
        todo.setUserName(getLoggedUserName());
        toDoRepository.save(todo);
        return "redirect:/todos";
    }

    @GetMapping( "delete-todo")
    public String deleteNewTodo(@RequestParam int id){
        toDoRepository.deleteById(id);
        return "redirect:/todos";
    }

    @GetMapping("done-todo")
    public String doneTodo(@RequestParam int id){
        Optional<ToDo> toDo = toDoRepository.findById(id);
        toDo.get().setDone(true);
        toDoRepository.save(toDo.get());
        return "redirect:/todos";
    }

    private String getLoggedUserName(){
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
