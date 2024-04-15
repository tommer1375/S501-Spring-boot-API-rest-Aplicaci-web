package cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n01.model.domain.Branch;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n01.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n01.model.services.BranchServices;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

    @RestController
    @RequestMapping("/branch")
    public class BranchController {
        @Autowired
        private BranchServices branchServices;


        @GetMapping("/add")
        public ModelAndView newOffice (Model model){
            model.addAttribute("branch", new Branch());
            return new ModelAndView("branch/add",model.asMap());
        }

        @PostMapping("/add")
        public ModelAndView addOffice (@Valid @ModelAttribute Branch branch, BindingResult result, Model model){
            if(result.hasErrors()){
                model.addAttribute("branch", new Branch());
                model.addAttribute("error", "All fields are required. Please complete all fields.");
                return new ModelAndView("branchl/add",model.asMap());

            }  else {
                BranchDTO officeDTO = branchServices.addBranch(branch);
                return new ModelAndView("redirect:/branch/index",model.asMap());
            }
        }

        @GetMapping("/update/{id}")
        public ModelAndView showUpdateOffice (@PathVariable("id") Integer branchId, Model model){
            model.addAttribute("branch", branchServices.getOneBranch(branchId));
            String updateUrl = "/branch/update/" + branchId;
            model.addAttribute("updateUrl", updateUrl);
            return new ModelAndView("branch/update",model.asMap());
        }

        @PostMapping("/update/{id}")
        public ModelAndView updateOffice (@Valid @ModelAttribute Branch branch, BindingResult result, @PathVariable("id") Integer branchId, Model model){
            if(result.hasErrors()){
                model.addAttribute("error", "All fields are required. Please complete all fields.");
                return new ModelAndView("branch/update",model.asMap());
            } else{
                branchServices.updateBranch(branch);
                return new ModelAndView("redirect:/branch/index",model.asMap());
            }
        }

        @GetMapping("/delete/{id}")
        public ModelAndView deleteOffice (@PathVariable("id") Integer branchId, Model model){
            boolean doIt = branchServices.deleteBranch(branchId);
            return new ModelAndView("redirect:/branch/index",model.asMap());
        }

        @GetMapping("/getOne")
        public ModelAndView getOneOffice(@RequestParam(value = "id", required = true) String branchId, Model model) {
            try {
                int id = Integer.parseInt(branchId);
                BranchDTO branchDTO = branchServices.getOneBranchDTO(id);
                if (branchDTO != null) {
                    model.addAttribute("branchs", Arrays.asList(branchDTO));
                } else {
                    model.addAttribute("message", "Branch with ID " + id + " not found.");
                }
            } catch (NumberFormatException e) {
                model.addAttribute("message", "Insert a valid ID");
            } catch (Exception e) {
                model.addAttribute("message", "Branch with id "+ branchId + " not found");
            }
            return new ModelAndView("branch/index", model.asMap());
        }

        @GetMapping("/getAll")
        public ModelAndView getAllOffice (Model model){
            List<BranchDTO> officeList = branchServices.getAllBranch();
            model.addAttribute("Title","Branch List");
            model.addAttribute("branchs", officeList);
            return new ModelAndView("branch/index",model.asMap());
        }
    }

