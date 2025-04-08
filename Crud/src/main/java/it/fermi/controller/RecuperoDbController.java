package it.fermi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class RecuperoDbController {

    String host = "jdbc:mysql://10.0.9.240:3306/popa";
    String username = "popa";
    String password = "pop10101l";

    @GetMapping("/findSpoolCluster")
    public List findSpoolCluster() {

    }

}
