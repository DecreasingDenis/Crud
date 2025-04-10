package it.fermi.gestionehibernate.controller;

import it.fermi.gestionehibernate.domain.SpoolCluster;
import it.fermi.gestionehibernate.service.SpoolClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpoolClusterController {

    @Autowired
    @Qualifier("servizionuovo")     //importa il service (con il nome del @Service)
    private SpoolClusterService spoolClusterService;

    @PostMapping("/insertClusterHibernate/{clusterCode}")
    public SpoolCluster insertClusterHibernate(@PathVariable String clusterCode, @RequestParam(required = false) String description, @RequestParam(required = false) String state) {
        return spoolClusterService.insertCluster(clusterCode, description, state);
    }

    @GetMapping("/recuperoClusterHibernate")
    public List<SpoolCluster> recuperoClusterHibernate() {
        return spoolClusterService.recuperoCluster();
    }

    @DeleteMapping("/deleteClusterHibernate/{clusterId}")
    public void deleteClusterHibernate(@PathVariable long clusterId) {
        spoolClusterService.deleteCluster(clusterId);
    }

    @PostMapping("/updateClusterHibernate/{clusterId}")
    public SpoolCluster updateClusterHibernate(@PathVariable long clusterId, @RequestParam(required = true) String clusterCode, @RequestParam(required = false) String description, @RequestParam(required = false) String state) {
        return spoolClusterService.updateCluster(clusterId,clusterCode,description,state);
    }
}
