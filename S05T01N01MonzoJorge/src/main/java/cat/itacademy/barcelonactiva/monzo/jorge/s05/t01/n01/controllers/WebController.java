package cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n01.controllers;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n01.model.domain.Branch;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n01.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n01.model.services.BranchServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class WebController {

    @Autowired
    private BranchServices branchServices;
    @GetMapping({"","/","/branch/index"})
    public String index(Model model) {

        return "redirect:/branch/getAll";
    }
}