package it.fermi.controller.crud;

import it.fermi.utility.DBEntry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;

@RestController
public class UpdateCluster {

    @GetMapping("/updateCluster/{campo}")
    public String updateCluster(@PathVariable("campo") String campo, @RequestParam int cluster_id) {

        Connection conn = DBEntry.getConnection();
        if(conn == null) {
            return "impossibile recuperare la connesione";
        }

        /*try {
            String query = null;
            switch (campo) {
                case "cluster_code":

                    query = "UPDATE spool_cluster SET cluster_code = ? WHERE cluster_id=?";
                    PreparedStatement pre = conn.prepareStatement(query);
                    //pre.setString(1, );
                    int rowsAffected = pre.executeUpdate();
                    return rowsAffected > 0 ? "Insert successful" : "Insert failed";

                    break;
                case "descriprion":
                    query = "UPDATE spool_cluster SET description = ? WHERE cluster_id=?";
                    break;
                case "state":
                    query = "UPDATE spool_cluster SET state = ? WHERE cluster_id=?";
                    break;


            }
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }*/
        return null;
    }
}
