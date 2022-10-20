package com.example.IPv4.service.controller;


























import com.example.IPv4.entity.IPInterval;
import com.example.IPv4.repository.IPIntervalRepository;
import com.example.IPv4.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1")
public class HomeController {

    @Autowired
    private IPIntervalRepository ipIntervalRepository;
    @Autowired
    private RequestService requestService;

    @GetMapping("/home")
    public String index(HttpServletRequest request, Model model) {
        String clientIPAddress = requestService.getClientIPAddress(request);
        model.addAttribute("clientIPAddress", clientIPAddress);

        IPInterval ipInterval = new IPInterval();
        ipInterval.setStartIP(100l);
        ipInterval.setEndIP(200l);
        ipIntervalRepository.save(ipInterval);
        return "index";
    }



}
