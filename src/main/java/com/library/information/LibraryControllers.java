package com.library.information;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/Library")
public class LibraryControllers {

    HashMap <Integer, BookInfo> db;

    LibraryControllers(){
        db=new HashMap<>();
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public @ResponseBody String meth1(){
        return "Hello World";
    }

    @RequestMapping(value = "/addBook",method = RequestMethod.POST)
    public @ResponseBody String create(@RequestBody BookInfo b){
        if(!db.containsKey(b.getBookID())) {
            db.put(b.getBookID(), b);
            return "Book inserted with id: " + b.getBookID();
        }
        else return "Book already exists with id: "+b.getBookID();
    }
    @RequestMapping(value = "/showBooks",method = RequestMethod.POST)
    public @ResponseBody ArrayList<BookInfo> readAll(){
        return new ArrayList<>(db.values());

    }

    @RequestMapping(value = "/showBooks/{id}",method = RequestMethod.GET)
    public @ResponseBody BookInfo readOne(@PathVariable(value = "id") Integer b){
        return db.get(b);
    }






}
