package com.github.DominasPL.Giveaway.web.controllers.admin;

import com.github.DominasPL.Giveaway.dtos.InstitutionDTO;
import com.github.DominasPL.Giveaway.services.InstitutionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/panel/institutions")
public class ManageInstitutionsController {

    private InstitutionService institutionService;

    public ManageInstitutionsController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping
    public String displayInstitutions(Model model) {

        List<InstitutionDTO> institutions = institutionService.loadAllInstitutions();

        model.addAttribute("institutions", institutions);

        return "display-institutions";

    }

    @GetMapping("/add")
    public String addInstitutionPrepareForm(Model model) {

        model.addAttribute("form", new InstitutionDTO());

        return "add-institution";

    }

    @PostMapping("/add")
    public String addInstitution(@Valid @ModelAttribute("form") InstitutionDTO form, BindingResult result) {

        if (result.hasErrors()) {
            return "add-institution";
        }

        institutionService.addInstitution(form);

        return "redirect:/admin/panel/institutions";

    }

    @GetMapping("/delete/{id}")
    public String deleteInstitution(@PathVariable("id") Long id) {

        institutionService.deleteInstitution(id);

        return "redirect:/admin/panel/institutions";
    }

    @GetMapping("/edit/{id}")
    public String editInstitutionPrepareForm(@PathVariable("id") Long id, Model model) {

        InstitutionDTO institutionDTO = institutionService.findInstitutionById(id);

        model.addAttribute("form", institutionDTO);

        return "edit-institution";
    }

    @PostMapping("/edit/{id}")
    public String editInstitution(@PathVariable("id") Long id, @Valid @ModelAttribute("form") InstitutionDTO form, BindingResult result) {

        if (result.hasErrors()) {
            return "edit-institution";
        }

        institutionService.editInstitution(form);

        //TODO WYSWIETLIC KOMUNIKAT PO POPRAWNEJ EDYCJI DANYCH


        return "redirect:/admin/panel/institutions/edit/"+ id;

    }

}

