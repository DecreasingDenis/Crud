package it.fermi.controller.crud;

import it.fermi.utility.DBEntry;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

@RestController
public class UpdateCluster {

    @PutMapping("/updateCluster/{id}")
    public String updateCluster(@PathVariable int cluster_id, @RequestParam(required = false) String description, @RequestParam(required = false) String state) {

        Connection conn = DBEntry.getConnection();
        if(conn == null) {
            return "impossibile recuperare la connesione";
        }

        if(description == null && state == null) {
            return "nessuna modifica da effettuare";
        }

            try{
            if(state == null) {

                String query = "UPDATE spool_cluster SET description = ? WHERE CLUSTER_ID = ?";
                PreparedStatement pre = conn.prepareStatement(query);
                pre.setString(1, description);
                pre.setInt(2, cluster_id);
                return "modifica della description effettuata";

            } else if (description == null) {

                String query = "UPDATE spool_cluster SET state = ? WHERE CLUSTER_ID = ?";
                PreparedStatement pre = conn.prepareStatement(query);
                pre.setString(1, state);
                pre.setInt(2, cluster_id);
                return "modifica dello state effettuata";

            } else {

                String query = "UPDATE spool_cluster SET description = ?, state = ? WHERE CLUSTER_ID = ?";
                PreparedStatement pre = conn.prepareStatement(query);
                pre.setString(1, description);
                pre.setString(2, state);
                pre.setInt(3, cluster_id);
                return "modifica della description e lo state effettuata";

            }

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
