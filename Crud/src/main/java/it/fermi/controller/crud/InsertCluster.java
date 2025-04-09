package it.fermi.controller.crud;

import it.fermi.utility.DBEntry;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@RestController
public class InsertCluster {

    @PostMapping("/insertCluster/{cluster_Code}")
    public String insertCluster(@PathVariable("cluster_Code") String cluster_Code, @RequestParam (required = false) String description, @RequestParam (required = false) String state) {

        Connection conn = DBEntry.getConnection();
        if(conn == null) {
            //messaggio di errore
        }

        try {

            String query = "insert into spool_cluster (cluster_code,description,state) values (?,?,?)";
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, cluster_Code);
            pre.setString(2, description);
            pre.setString(3, state);
            int rowsAffected = pre.executeUpdate();
            return rowsAffected > 0 ? "Insert successful" : "Insert failed";

        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}