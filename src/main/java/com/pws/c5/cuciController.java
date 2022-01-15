/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pws.c5;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author IlhamRobbS
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/datacuci")
public class cuciController {

    @Autowired
    repoCuci cuciah;
            
    @PostMapping("/add")
    public Nyucidong addcuci(@RequestBody Nyucidong c)
    {
        cuciah.save(c);
        return c;
    }
    
    @GetMapping("/all")
    public List<Nyucidong> allcuci()
    {
        return cuciah.findAll();
    }
    
    @GetMapping("/allbyid")
    public Nyucidong getcucibyid(@RequestParam int id)
    {
        return cuciah.findById(id).get();
    }
    
    @PutMapping("/edit")
    public Nyucidong editcuci(@RequestBody Nyucidong c)
    {
       return cuciah.save(c);
    }
    
    @DeleteMapping("/delete")
    public List<Nyucidong> deletecuci(@RequestParam int id)
    {
        cuciah.deleteById(id);
        List<Nyucidong> cucilist = cuciah.findAll();
        return cucilist;
    }
}
