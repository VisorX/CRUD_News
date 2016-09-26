/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.News;

/**
 *
 * @author Houssem
 */
public class DataAccess {
    public void addNew(News n){
        try {
            PreparedStatement ps=DBUtils.getPreparedStatement("insert into News values (?,?,?,?,?,?)");
            ps.setString(1, n.getTitle());
            ps.setString(2, n.getDate());
            ps.setString(3, n.getDescription());
            ps.setString(4, n.getDetail());
            ps.setString(5, n.getCategory());
            ps.setString(6, n.getImage());
            ps.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static List<News> getAll(){
       List<News> ls=new LinkedList<>();
        try {
            ResultSet rs=DBUtils.getPreparedStatement("select * from News").executeQuery();
            while(rs.next())
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
