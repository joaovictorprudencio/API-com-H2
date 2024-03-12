package com.devjoao.userdept.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devjoao.userdept.entitis.User;
import com.devjoao.userdept.userrepository.UserRepository;

@RestController
@RequestMapping(value = "/user")
public class UserControler {
    
   @Autowired    
   private UserRepository repository;
       
       @GetMapping
        public List<User> Listar(){
           List<User> result = repository.findAll();
          return result;


        }

        @GetMapping(value = "/{id}")
        public User Buscar(@PathVariable Long id){
           User result = repository.findById(id).get();
            return result;
        }

        @PostMapping
        public User insert(@RequestBody User user){
            User result = repository.save(user);
            return result;
        }


        @DeleteMapping(value = "/{id}")
        public void Deletar(@PathVariable Long id){
           repository.deleteById(id);
              
        }


}
