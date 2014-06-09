/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoTPV;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edu
 */
public class JDBC {

    public static java.sql.Connection conectarBD() {
        java.sql.Connection con = null;
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        
            java.util.Properties props = new java.util.Properties();
            props.put("charSet", "iso-8859-1");
            String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=.//src//proyectoTPV//proyecto.accdb";
            con = (java.sql.Connection) java.sql.DriverManager.getConnection(url, props);
            return con;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    public static java.sql.Statement crearSentencia(java.sql.Connection conexion) {
        try {
            java.sql.Statement sentencia = conexion.createStatement();
            return sentencia;
        } catch (java.sql.SQLException e) {
            return null;
        }
    }
    public static java.sql.Statement crearSentenciaF(java.sql.Connection conexion, boolean forwardOnly) {
        try {
            java.sql.Statement sentencia = conexion.createStatement();
            if(forwardOnly){
                sentencia = conexion.createStatement();
            }else{
                sentencia = conexion.createStatement( java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
            java.sql.ResultSet.CONCUR_UPDATABLE);
            }
            return sentencia;
        } catch (java.sql.SQLException e) {
            return null;
        }
    }

    public static java.sql.ResultSet crearResultado(java.sql.Statement sentencia, String sql) {
        try {
            java.sql.ResultSet resultado = sentencia.executeQuery(sql);
            return resultado;
        } catch (java.sql.SQLException e) {
            return null;
        }
    }
}
