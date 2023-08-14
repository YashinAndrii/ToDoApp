package com.in28min.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class ToDoService {
    private static int todosCount = 0;

    private static List<ToDo> toDoList = new ArrayList<>();

    public void addToDo(String userName, String description, LocalDate targetDate) {
        toDoList.add(new ToDo(++todosCount,userName,description,targetDate,false));
        System.out.println(toDoList);
    }

    public void deleteToDo(int id) {
        Predicate<? super ToDo> predicate = toDo -> toDo.getId() == id;
        toDoList.removeIf(predicate);
    }

    public List<ToDo> listAll(){
        return toDoList;
    }

    public List<ToDo> findByUsername(String userName) {
        Predicate<? super ToDo> predicate = toDo -> toDo.getUserName().equals(userName);
        return toDoList.stream().filter(predicate).toList();
    }

}
