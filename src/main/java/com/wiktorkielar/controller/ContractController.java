package com.wiktorkielar.controller;

import com.wiktorkielar.model.Contract;
import com.wiktorkielar.model.System;
import com.wiktorkielar.service.ContractService;
import com.wiktorkielar.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @Autowired
    private SystemService systemService;

    @GetMapping("/list")
    public String showContractList(Model model) {

        List<Contract> contracts = contractService.getContracts();

        model.addAttribute("contracts", contracts);

        return "contract-list-def";
    }

    @GetMapping("/list/active")
    public String showActiveContractList(Model model) {

        List<Contract> activeContracts = contractService.getActiveContracts();

        model.addAttribute("contracts", activeContracts);

        return "contract-list-def";
    }

    @GetMapping("/add")
    public String showContractAdd(Model model) {

        Contract contract = new Contract();
        List<System> systems = systemService.getSystems();

        model.addAttribute("contract", contract);
        model.addAttribute("systems", systems);

        return "contract-add-def";
    }

    @PostMapping("/save-new")
    public String saveContract(@Valid @ModelAttribute Contract contract, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            return "contract-add-def";
        } else {

            contractService.saveContract(contract);

            return "redirect:/contract/list";
        }
    }

    @GetMapping("/update")
    public String showContractUpdate(Model model, @RequestParam int contractId) {

        Contract contract = contractService.getContractById(contractId);
        List<System> systems = systemService.getSystems();

        model.addAttribute("contract", contract);
        model.addAttribute("systems", systems);

        return "contract-update-def";
    }

    @PostMapping("/save-existing")
    public String saveExistingContract(@Valid @ModelAttribute Contract contract, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            return "contract-update-def";
        } else {

            contractService.saveExistingContract(contract);

            return "redirect:/contract/list";
        }
    }

    @GetMapping("/delete")
    public String contractDelete(@RequestParam int contractId) {

        contractService.deleteContractById(contractId);

        return "redirect:/contract/list";
    }
}
