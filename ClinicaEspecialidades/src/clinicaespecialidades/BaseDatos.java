/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicaespecialidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
/**
 *
 * @author Adriana
 */
public class BaseDatos {
   Connection con = null;
   Statement  st = null;
   ResultSet  rs = null;
   
   String pUrl = "jdbc:mysql://localhost/clinicaespecialidades";
   String user = "root";
   String driver = "com.mysql.jdbc.Driver";
   String pass = "";
   
   LinkedList<String> ll= new LinkedList<String>();

   public BaseDatos() {
       try{
       Class.forName(driver);
       con = DriverManager.getConnection(pUrl, user, pass);
       }catch(ClassNotFoundException | SQLException e){
           
       }
   }
   public Connection generaConexion () {
      
      return con;
   }
    public boolean validarUsuario(String idUsu, String pass) {
        
        try {
       
            st = con.createStatement();
            String sql =  "SELECT idUsuario,password FROM Usuario WHERE idUsuario='"+idUsu+"' AND password='"+pass+"'";
            rs = st.executeQuery(sql);  
            if(rs.next()){
                rs.getString("idUsuario");
                rs.getString("password");
            }
                        
            if( pass.equals(rs.getString("password")) && idUsu.charAt(0)== 'M') {
                Medico medico = new Medico();
                medico.setVisible(true);
                return true;
            }
            else{
                if( pass.equals(rs.getString("password")) && idUsu.charAt(0)== 'A') {
                    Administrador adm = new Administrador();
                    adm.setVisible(true);
                    return true;
                }
                else{
                    if( pass.equals(rs.getString("password")) && idUsu.charAt(0)== 'R') {
                        Recepcionista rep = new Recepcionista();
                        rep.setVisible(true);
                        return true;
                    }
                    else{
                        if( pass.equals(rs.getString("password")) && idUsu.charAt(0)== 'L') {
                            Laboratorista lab = new Laboratorista();
                            lab.setVisible(true);
                            return true;
                        }
                    }
                }
            }
        }catch (Exception e) {
         //System.out.println(e);
         JOptionPane.showMessageDialog(null, "incorrecto");
         return false;
      }
       return false;
    }
    
    public void agregarUsuarios(String apaterno, String amaterno, String nacimiento, String nom, String alta, String genero,
        String tipous, String pass, String usu){
       
        try {
            st = con.createStatement();
            String sql = "INSERT INTO Usuario(idUsuario,Nombre,ApellidoPat,ApellidoMat,TipoUsuario,FechaNacim,FechaActual,Sexo,password) VALUES ('"+usu+"','"+nom+"','"+apaterno+"','"+amaterno+"','"+tipous+"','"+nacimiento+"','"+alta+"','"+genero+"','"+pass+"')";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Usuario agregado"); 
        }catch (Exception e) {
          
          JOptionPane.showMessageDialog(null, "Usuario no agregado");
      }
    }
    public String buscarUsuario(String idusu){
        
        String resultado = "";
        
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT idUsuario,ApellidoPat,ApellidoMat,Nombre FROM Usuario WHERE idUsuario='"+idusu+"'");
            while (rs.next()) {
            resultado = rs.getString("idUsuario")+ " " + rs.getString("ApellidoPat")+" " + rs.getString("ApellidoMat")+" "+ rs.getString("Nombre");          
            }
        }catch (Exception e) {
            resultado = null;
            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
      }return resultado;
    }
    public void eliminarUsuario(String idusu){
        
        try {
            st = con.createStatement();
            st.executeUpdate("DELETE FROM Usuario WHERE idUsuario='"+idusu+"'");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuario eliminado");
      }
    }
    public ArrayList buscarPacienteDiagnostico(String idpaci){
        ArrayList array = new ArrayList();
        String resultado = "";
        
        try {
            st = con.createStatement();
            String sql = "SELECT P.idPaciente,P.ApellidoPat,P.ApellidoMat,P.Nombre,H.Diagnostico,H.ResultadosLab,H.Observaciones FROM Paciente P,Historial H WHERE P.idPaciente='"+idpaci+"'";
            System.out.println(sql);
            rs = st.executeQuery(sql);
            
            while (rs.next()) {
            array.add(resultado = rs.getString("ApellidoPat")+"  "+ rs.getString("ApellidoMat")+"  "+rs.getString("Nombre")+"  "+rs.getString("Diagnostico")+"  "+rs.getString("ResultadosLab")+"  "+rs.getString("Observaciones"));
            }
        }catch (Exception e) {
            resultado = null;
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Paciente no encontrado");
      }return array;
    }
    public String buscarPaciente(String idpaci){
        
        String resultado = "";
        
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT idPaciente,ApellidoPat,ApellidoMat,Nombre FROM Paciente WHERE idPaciente='"+idpaci+"'");
            while (rs.next()) {
            resultado = rs.getString("ApellidoPat")+" " + rs.getString("ApellidoMat")+" "+ rs.getString("Nombre");          
            }
        }catch (Exception e) {
            resultado = null;
            JOptionPane.showMessageDialog(null, "Paciente no encontrado");
      }return resultado;
    }
    public void guardarResultados(String idpaci,String result, String fecha){
        
         try {
            st = con.createStatement();
            String sql = "INSERT INTO Historial VALUES ('"+idpaci+"','NULL','"+result+"','"+fecha+"','NULL')";
            st.executeUpdate(sql);
        }catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Resultado no agregado");
      }
    }
    public ArrayList buscarFechaAgenda(String buscar){
        ArrayList array = new ArrayList();
        String busqueda="";
        
        try{
            st = con.createStatement();
            
            String sql = "SELECT P.idPaciente,P.ApellidoPat,P.ApellidoMat,P.Nombre,C.FechaCita,C.Hora FROM Paciente P,Cita C WHERE C.FechaCita='"+buscar+"' AND P.idPaciente=C.idPaciente";
            System.out.println(sql);
            rs = st.executeQuery(sql);           
            while (rs.next()) {
                array.add(busqueda = rs.getString("ApellidoPat")+" " +rs.getString("ApellidoMat")+" "+rs.getString("Nombre")+" "+rs.getString("FechaCita")+" "+rs.getString("Hora"));
            }            
        }catch (Exception e) {
            busqueda = null;
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Agenda vacia");
      }
        return array;
    }
    public void guardarDiagnostico(String idpaci, String diag, String obs, String fecha){
        
         try {
            st = con.createStatement();
            String sql = "INSERT INTO Historial VALUES ('"+idpaci+"','"+diag+"','NULL','"+fecha+"','"+obs+"')";
            st.executeUpdate(sql);  
        }catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Datos no agregados");
      }
    }
    public String idMedico(String idusu){
       
        String med = "";
        
         try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT idUsuario,ApellidoPat,ApellidoMat,Nombre FROM Usuario WHERE idUsuario='"+idusu+"'");
            while (rs.next()) {
            med = rs.getString("ApellidoPat")+" " + rs.getString("ApellidoMat")+" "+ rs.getString("Nombre");          
            }
        }catch (Exception e) {
          med = null;
      }return med;
    }
    public void agendarCita( String paci, String horacita, String fechaactual, String fechacita, String idusu){
        
         try {
            st = con.createStatement();
            String sql = "INSERT INTO cita VALUES ('"+paci+"','"+idusu+"','"+fechaactual+"','"+fechacita+"','"+horacita+"')";
            System.out.println(sql);
            st.executeUpdate(sql);
         }catch (Exception e) {
            System.out.println(e);
          JOptionPane.showMessageDialog(null, "Cita no agendada");
      }
    }
    public void agregarPaciente(String apaterno, String amaterno, String nacimiento, String nom, String alta, String genero,
        String dir, String tel, String paci){
        
        try {
            st = con.createStatement();
            String sql="INSERT INTO Paciente VALUES ('"+paci+"','"+apaterno+"','"+amaterno+"','"+nom+"','"+nacimiento+"','"+alta+"','"+dir+"','"+tel+"','"+genero+"')";
            st.executeUpdate(sql);
            
        }catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Paciente no agregado");
      }
    }
    public String consultarCita(String idPaciente){
        
        String res="";
        
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT cita.FechaCita, cita.Hora FROM cita WHERE idPaciente='"+idPaciente+"'");
            while (rs.next()) {
                System.out.println(rs.getString("FechaCita")+" " + rs.getString("Hora"));
                res= rs.getString("FechaCita")+" " + rs.getString("Hora");
                
            }
        }catch (Exception e) {
            res = null;
            JOptionPane.showMessageDialog(null, "Sin cita");
      }
      return res;
    }
    public void eliminarCitas(String idPaciente){
        try {
            st = con.createStatement();
            st.executeUpdate("DELETE FROM cita WHERE idPaciente='"+idPaciente+"'");
            JOptionPane.showMessageDialog(null, "Citas eliminadas");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Citas NO eliminadas");
      }
    }
    public void eliminarCita(String idPaciente){
        try{
            StringTokenizer consulta= new StringTokenizer(consultarCita(idPaciente), " ");
            while(consulta.hasMoreTokens()) {
                String token = consulta.nextToken();
                System.out.println(token);
                ll.add(token);
            }
            st = con.createStatement();
            st.executeUpdate("DELETE FROM cita WHERE idPaciente='"+idPaciente+"' and FechaCita='"+ll.get(0)+"' and Hora='"+ll.get(1)+"'");
            
            JOptionPane.showMessageDialog(null, "Cita eliminada");
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Cita NO eliminada");
    }
        ll.clear();
    }
    
    public void modificarCita(String idPaciente, String fecha, String hora){
        
        try {
            StringTokenizer consulta= new StringTokenizer(consultarCita(idPaciente), " ");
            while(consulta.hasMoreTokens()) {
                String token = consulta.nextToken();
                System.out.println(token);
                ll.add(token);
            }
            st = con.createStatement();
            st.executeUpdate("Update cita Set FechaCita='"+fecha+"', Hora='"+hora+"' Where idPaciente='"+idPaciente+"' and FechaCita='"+ll.get(0)+"' and Hora='"+ll.get(1)+"'");
            JOptionPane.showMessageDialog(null, "Cita modificada");
            
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cita NO modificada");
      }
      ll.clear();
    }
    public void modificarUsuario(String apaterno, String amaterno, String nacimiento, String nom, String alta, String genero,
        String tipous, String pass, String usu){
       
        try {
            st = con.createStatement();
            String sql = "UPDATE usuario SET Nombre='"+nom+"',ApellidoPat='"+apaterno+"',ApellidoMat='"+amaterno+"',TipoUsuario='"+tipous+"',FechaNacim='"+nacimiento+"',FechaActual='"+alta+"',Sexo='"+genero+"',password='"+pass+"' "
                    + "  WHERE idUsuario = '"+usu+"';";
            
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Usuario modificado"); 
        }catch (Exception e) {
          
          JOptionPane.showMessageDialog(null, "Usuario no modificado");
      }
    }
    public String [] busacarDatosUsuario(String idusu){
        
        String [] datosUsuario = new String[8];
        try {           
            st = con.createStatement();           
            rs = st.executeQuery("SELECT Nombre,ApellidoPat,ApellidoMat,TipoUsuario,FechaNacim,FechaActual,Sexo,Password FROM usuario WHERE idUsuario='"+idusu+"'");
                        
            if (rs.next()){
                datosUsuario[0] = rs.getString("Nombre");
                datosUsuario[1] = rs.getString("ApellidoPat");
                datosUsuario[2] = rs.getString("ApellidoMat");
                datosUsuario[3] = rs.getString("TipoUsuario");
                datosUsuario[4] = rs.getString("FechaNacim");
                datosUsuario[5] = rs.getString("FechaActual");
                datosUsuario[6] = rs.getString("Sexo");
                datosUsuario[7] = rs.getString("password");
            }      
           
        }catch (Exception e) {          
          JOptionPane.showMessageDialog(null, "Usuario no Encontrado");        
      } 
        return datosUsuario;
    }
    public void peticionPrueba(String idPaciente, String fechaSolicitud, String pruebasSolicitadas){
        try {
            st = con.createStatement();
            String sql = "INSERT INTO clinicaespecialidades.analisisclinicos (idPaciente, fechaSolicitud, pruebasSolicitadas) VALUES ('"+idPaciente+"', '"+fechaSolicitud+"', '"+pruebasSolicitadas+"')";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Petición generada"); 
        }catch (Exception e) {
          JOptionPane.showMessageDialog(null, "La petición no se realizó correctamente");
      }
    }
    
} 

