package it.fermi.controller.crud;

import it.fermi.utility.DBEntry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FindCluster {

    @GetMapping("/findCluster")
    public List findSpoolCluster(@RequestParam(required = false) String clusterCode) {

        List<String> listaCodCluster = new ArrayList<>();
        Connection conn = DBEntry.getConnection();

        if(conn == null) {
            listaCodCluster.add("impossibile recuperare la connesione");
            return listaCodCluster;
        }

        try{
            clusterCode = (clusterCode != null) ? "%" + clusterCode + "%" : "%%";
                //cluster_code = abc -> "%abc%"
                //else cluster_code = null -> "%%"

            String query = "select * from spool_cluster where cluster_Code like ?"; //here can happen SQL injection, separare i parametri dai comandi
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, clusterCode);
            ResultSet rs = pre.executeQuery();

            while(rs.next()){
                String cluster = rs.getString("CLUSTER_CODE");
                listaCodCluster.add(cluster);
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{

            if(conn != null){
                try{
                    conn.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

        }

        return listaCodCluster;

    }

}
