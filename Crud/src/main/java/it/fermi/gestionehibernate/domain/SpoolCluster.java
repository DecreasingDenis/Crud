package it.fermi.gestionehibernate.domain;

import javax.persistence.*;

@Entity
@Table(name="spool_cluster")
public class SpoolCluster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cluster_id;

    @Column(name= "clusterCode", nullable = false, length = 128)
    private String cluster_code;

    @Column(name = "description", nullable = true, length = 128)
    private String description;

    @Column(name = "state", nullable = true, length = 512)
    private String state;

    public String getCluster_code() {
        return cluster_code;
    }

    public long getCluster_id() {
        return cluster_id;
    }

    public String getDescription() {
        return description;
    }

    public String getState() {
        return state;
    }

    public void setCluster_code(String cluster_code) {
        this.cluster_code = cluster_code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCluster_id(long cluster_id) {
        this.cluster_id = cluster_id;
    }
}
