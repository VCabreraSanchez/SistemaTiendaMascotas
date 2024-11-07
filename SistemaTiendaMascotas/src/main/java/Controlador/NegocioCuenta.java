
package Controlador;
import Modelo.*;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import util.MySQLConexion;

public class NegocioCuenta{
    
    public void adi_Emp (Empleado e){
        Connection cn = MySQLConexion.getConexion();
        String sql = "{call adiemp(?,?,?)}";
        try {
            PreparedStatement st = cn.prepareCall(sql);
            st.setString(1, e.getNombE());
            st.setInt(2, e.getDni());
            st.setString(3, e.getContr());
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void adicionCliente(Cliente c){
        Connection cn = MySQLConexion.getConexion();
        String sql = "{call adicli(?,?,?)}";
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, c.getNomb());
            st.setInt(2, c.getDni());
            st.setString(3, c.getContra());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Cliente buscaC(int dnii, String contra){
        Cliente ci = new Cliente();
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select Cli_Code, Cli_nombre, Cli_dni, Cli_contraseña from cliente";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                if(rs.getInt(3) == dnii && rs.getString(4).equals(contra)){
                    ci.setCode(rs.getString(1));
                    ci.setNomb(rs.getString(2));
                    ci.setDni(dnii);
                    ci.setContra(contra);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ci;
    }
    
    public List<Cliente> lisCli(){
        List<Cliente> lista = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select Cli_Code, Cli_nombre, Cli_dni, Cli_contraseña from cliente";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                Cliente ci = new Cliente();
                ci.setCode(rs.getString(1));
                ci.setNomb(rs.getString(2));
                ci.setDni(rs.getInt(3));
                ci.setContra(rs.getString(4));
                lista.add(ci);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public List<Empleado> lisEmp(){
        List<Empleado> listaE = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select Emp_code, Emp_nombre, Emp_dni, Emp_contraseña from empleado";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                Empleado em = new Empleado();
                em.setCode(rs.getString(1));
                em.setNombE(rs.getString(2));
                em.setDni(rs.getInt(3));
                em.setContr(rs.getString(4));
                listaE.add(em);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaE;
    }
    
    public List<Cabecera> lisFac(){
        List<Cabecera> lista = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select Fac_num, Fac_fec, Cli_code from fac_cabe";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                Cabecera c = new Cabecera();
                c.setFnum(rs.getString(1));
                c.setFecha(rs.getString(2));
                c.setCode(rs.getString(3));
                lista.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public List<Detalle> lisDet(){
        List<Detalle> lista = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select Fac_num, cantidad, Pro_code  from fac_deta";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                Detalle d = new Detalle();
                d.setFacnum(rs.getString(1));
                d.setCantidad(rs.getInt(2));
                d.setCode(rs.getString(3));
                lista.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public Empleado buscaE(int dnii, String contra){
        Empleado em = new Empleado();
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select Emp_code, Emp_nombre, Emp_dni, Emp_contraseña from empleado";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                if(rs.getInt(3) == dnii && rs.getString(4).equals(contra)){
                    em.setCode(rs.getString(1));
                    em.setNombE(rs.getString(2));
                    em.setDni(dnii);
                    em.setContr(contra);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return em;
    }
    
    public void adiPro(Producto p, int tipo, String nomb){
        String cod = "";
        Connection cn = MySQLConexion.getConexion();
        String sql = "{call adipro(?,?,?,?,?)}";
        try {
            CallableStatement st = cn.prepareCall(sql);
            st.setString(1, p.getNombP());
            st.setDouble(2, p.getPrecioU());
            st.setInt(3, p.getStock());
            st.setString(4, p.getMarca());
            st.setString(5, p.getAnimal());
            ResultSet rs = st.executeQuery();
            rs.next();
            cod = rs.getString(1);
            switch(tipo){
                case 1: sql = "{call adiali(?,?)}"; break;
                case 2: sql = "{call adihig(?,?)}"; break;
                case 3: sql = "{call adiotr(?,?)}"; break;
            }
            if(tipo != 0){
                CallableStatement st2 = cn.prepareCall(sql);
                st2.setString(1, nomb);
                st2.setString(2, cod);
                st2.executeUpdate();
            } else{
                System.out.println("F");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Producto> lisPro(){
        List<Producto> lista = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select Pro_code, Pro_nombre, Pro_precio, Pro_Stock, Pro_marca, Pro_animal from producto";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                Producto p = new Producto();
                p.setCode(rs.getString(1));
                p.setNombP(rs.getString(2));
                p.setPrecioU(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setMarca(rs.getString(5));
                p.setAnimal(rs.getString(6));
                lista.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    
    public List<TipoAlimento> lisAlimento(){
        List<TipoAlimento> lista = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select producto.Pro_code, Pro_nombre, Pro_precio, Pro_Stock, Ali_nom from producto join tipoalimento ON producto.Pro_code = tipoalimento.Pro_code";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                TipoAlimento p = new TipoAlimento();
                p.setCode(rs.getString(1));
                p.setNombP(rs.getString(2));
                p.setPrecioU(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setAnombre(rs.getString(5));
                lista.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public List<Producto> lisAnimal(String animal){
        List<Producto> lista = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select Pro_code, Pro_nombre, Pro_precio, Pro_Stock, Pro_marca, Pro_animal from producto";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                Producto p = new Producto();
                p.setCode(rs.getString(1));
                p.setNombP(rs.getString(2));
                p.setPrecioU(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setMarca(rs.getString(5));
                p.setAnimal(rs.getString(6));
                lista.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public List<TipoHigiene> lisHigiene(){
        List<TipoHigiene> lista = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select producto.Pro_code, Pro_nombre, Pro_precio, Pro_Stock, Hig_nom  from producto join tipohigiene ON producto.Pro_code = tipohigiene.Pro_code";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                TipoHigiene p = new TipoHigiene();
                p.setCode(rs.getString(1));
                p.setNombP(rs.getString(2));
                p.setPrecioU(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setHnombre(rs.getString(5));
                lista.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public List<TipoOtros> lisOtros(){
        List<TipoOtros> lista = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select producto.Pro_code, Pro_nombre, Pro_precio, Pro_Stock, Otro_nom  from producto join tipootros ON producto.Pro_code = tipootros.Pro_code";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                TipoOtros p = new TipoOtros();
                p.setNombP(rs.getString(1));
                p.setPrecioU(rs.getDouble(2));
                p.setStock(rs.getInt(3));
                p.setOnombre(rs.getString(4));
                lista.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    
    public String adi_Factura(String cod, List<Detalle> lista){
        String nfac="";
        Connection cn = MySQLConexion.getConexion();
        String sql = "{call adifac(?)}";
        try {
            CallableStatement st = cn.prepareCall(sql);
            st.setString(1, cod);
            ResultSet rs = st.executeQuery();
            rs.next();
            nfac=rs.getString(1);
            System.out.println(nfac);
            //grabar detalle
            sql = "{call adideta(?,?,?)}";
            CallableStatement st2 = cn.prepareCall(sql);
            for(Detalle x: lista){
                st2.setString(1, nfac);
                System.out.println(x.getCode());
                System.out.println(x.getCantidad());
                st2.setString(2, x.getCode());
                st2.setInt(3, x.getCantidad());
                st2.executeUpdate();
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return nfac;
    }
    
    public List<Cabecera> lisCabe(String code){
        List<Cabecera> lista = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "{call regfac(?)}";
            CallableStatement st = cn.prepareCall(sql);
            st.setString(1, code);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Cabecera c = new Cabecera();
                c.setFnum(rs.getString(1));
                c.setFecha(rs.getString(2));
                c.setTotalP(rs.getDouble(3));
                lista.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public void CambiarProd(Producto p){
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "{call CambiarPro(?,?,?,?,?)}";
            CallableStatement st = cn.prepareCall(sql);
            st.setString(1, p.getCode());
            st.setString(2, p.getNombP());
            st.setDouble(3, p.getPrecioU());
            st.setInt(4, p.getStock());
            st.setString(5, p.getAnimal());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void adiCamb(Cambios c){
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "{call adiCamb(?,?)}";
            CallableStatement st = cn.prepareCall(sql);
            st.setString(1, c.getCpro());
            st.setString(2, c.getCemp());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void CambiarEmp(Empleado e){
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "{call CambiarEmp(?,?,?,?)}";
            CallableStatement st = cn.prepareCall(sql);
            st.setString(1, e.getCode());
            st.setString(2, e.getNombE());
            st.setInt(3, e.getDni());
            st.setString(4, e.getContr());
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public List<Cambios> LisCambios(){
        List<Cambios> lista = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select Emp_code, Pro_code, Camb_fec from cambios";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                Cambios c = new Cambios();
                c.setCemp(rs.getString(1));
                c.setCpro(rs.getString(2));
                c.setFecha(rs.getString(3));
                lista.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
}
