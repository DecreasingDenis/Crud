package it.fermi.controller.crud;

import it.fermi.utility.DBEntry;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;

@RestController
public class DeleteCluster {

    @DeleteMapping("/deleteCluster/{id}")
    public String deleteCluster(@PathVariable int id) {

        Connection conn = DBEntry.getConnection();
        if(conn == null) {
            return "impossibile recuperare la connesione";
        }

        try{

            String query = "DELETE FROM spool_cluster WHERE CLUSTER_ID = ?";
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setInt(1, id);
            int rowsAffected = pre.executeUpdate();
            return rowsAffected > 0 ? "delete successful" : "delete failed";

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
