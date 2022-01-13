/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pws.c5;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author IlhamRobbS
 */
@CrossOrigin
@RestController
@RequestMapping("/datacuci")
public class cuciController {
    @Autowired
     private repoCuci cuciatuh;
     
     @GetMapping("/cuciah")
    public List<Nyucidong> getAllNyucidong(){
        return cuciatuh.findAll();
    }
    
    @GetMapping ("/cuciah/{idproduct}")
    public Nyucidong getNyucidongById(@PathVariable String idproduct){
        return cuciatuh.findById(idproduct).get();
    }
    
    @PostMapping ("/cuciah")
    public Nyucidong saveNyucidongDetails(@RequestBody Nyucidong c){
        return cuciatuh.save(c);
    }
    
    @PutMapping("/cuciah")
    public Nyucidong updateNyucidong(@RequestBody Nyucidong c){
        return cuciatuh.save(c);
    }
    
    @DeleteMapping("/cuciah/{idproduct}")
    public ResponseEntity<HttpStatus> deleteNyucidongById(@PathVariable String idproduct){
        cuciatuh.deleteById(idproduct);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
