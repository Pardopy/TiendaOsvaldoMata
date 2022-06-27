
package com.tienda.controller;

import com.tienda.dao.ClienteDao;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class IndexController {
    
    @Autowired
    private ClienteDao ClienteDao;
    
    
    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ahora se usa arquitectura MVC");
        
        /*String mensaje = "Estamos en la semana 4";
        model.addAttribute ("texto", mensaje) ;
        Cliente cliente = new Cliente ("Osvaldo", "Mata", "omata60764@ufide.ac.cr", "83411340");
        model.addAttribute("cliente", cliente);
        
        
        Cliente cliente2 = new Cliente ("Jesus", "Mata", "hoallalanjn@gmail.com", "83411340");
        Cliente cliente3 = new Cliente ("Jimena", "Mata", "hoallalanjn@gmail.com", "83411340");
        var clientes = Arrays.asList( cliente,cliente2,cliente3);*/
       
        var clientes = ClienteDao.findAll();
        
        
        model.addAttribute("clientes", clientes);
        
                
        
        return "index";
        
    }
}
