package it.fermi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RecuperoDbController {

    @GetMapping("/findSpoolCluster")
    public List findSpoolCluster() {

        String url = "jdbc:mysql://10.0.9.240:3306/popa";
        String username = "popa";
        String password = "pop10101l";

        List<String> listCodCluster = new ArrayList<>();

        try{

            Connection con = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM spool_cluster";

            PreparedStatement pre = con.prepareStatement(query);
            ResultSet rs = pre.executeQuery();

            while(rs.next()){
                String clusterCode = rs.getString("CLUSTER_CODE");
                listCodCluster.add(clusterCode);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return listCodCluster;

    }

}
