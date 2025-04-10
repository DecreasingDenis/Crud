package it.fermi.gestionehibernate.service;

import it.fermi.gestionehibernate.dao.SpoolClusterRepository;
import it.fermi.gestionehibernate.domain.SpoolCluster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "servizionuovo")
public class SpoolClusterService {

    @Autowired
    private SpoolClusterRepository spoolClusterRepository;

    //inserimento
    public SpoolCluster insertCluster(String clusterCode, String description, String state){
        SpoolCluster cluster = new SpoolCluster();
        cluster.setCluster_code(clusterCode);
        cluster.setDescription(description);
        cluster.setState(state);
        return spoolClusterRepository.save(cluster);
    }

    //recupero
    public List<SpoolCluster> recuperoCluster(){
        return spoolClusterRepository.findAll();
    }

    //update
    public SpoolCluster updateCluster(long cluster_id, String clusterCode, String description, String state){
        SpoolCluster cluster = spoolClusterRepository.getById(cluster_id);
        cluster.setCluster_code(clusterCode);
        cluster.setDescription(description);
        cluster.setState(state);
        return spoolClusterRepository.save(cluster);
    }

    //delete
    public void deleteCluster(long cluster_id){
        spoolClusterRepository.deleteById(cluster_id);
    }

}
