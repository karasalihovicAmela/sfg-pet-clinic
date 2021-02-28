package com.amela.sfgpetclinic.controllers;

import com.amela.sfgpetclinic.services.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;

    @RequestMapping({"/owners", "/owners/index", "/owners/index.html"})
    public String listOwners(Model model){

        model.addAttribute("owners", ownerService.findAll());

        return "owners/index";
    }
}
