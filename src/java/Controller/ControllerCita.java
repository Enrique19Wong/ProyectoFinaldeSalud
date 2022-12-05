package Controller;

import Config.Conexion;
import Entidad.Cita;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ControllerCita {
    Conexion con = new Conexion();
    JdbcTemplate jdbctemplate = new JdbcTemplate(con.Conectar());
    ModelAndView mav = new ModelAndView();    
    @RequestMapping("/Cita/listar.htm")
    public ModelAndView Listar(){
        String sql = "Select d.IDCita, h.Nombre DNombre, e.Nombre PNombre, f.Nombre HNombre, "
                + "d.Fecha, d.Diagnostico, d.Tratamiento, d.Observaciones from tbCita d "
                + "inner join tbDoctor h on d.IDDoctor = h.IDDoctor "
                + "inner join tbPaciente e on d.IDPaciente = e.ID "
                + "inner join tbHorario f on d.IDHorario = f.IDHorario";
        List datos=jdbctemplate.queryForList(sql);
        mav.addObject("lista",datos);
        mav.setViewName("/Cita/listar");
        return mav;
    }
    @RequestMapping(value="/Cita/agregar.htm", method = RequestMethod.GET )
    public ModelAndView Agregar(){
        mav.addObject("listarDoctor",new ControllerDoctor().ListarDoctor());
        mav.addObject("listarPaciente",new ControllerPaciente().ListarPaciente());
        mav.addObject("listarHorario",new ControllerHorario().ListarHorario());
        mav.setViewName("/Cita/agregar");
        return mav;
    }
    
    @RequestMapping(value="/Cita/agregar.htm", method = RequestMethod.POST )
    public ModelAndView Agregar(Cita objEsp){
        String sql = "insert into tbcita values(?,?,?,?,?,?,?,?)";
        this.jdbctemplate.update(sql,objEsp.getIDCita(), objEsp.getIDDoctor(), 
                    objEsp.getIDPaciente(),objEsp.getIDHorario(),objEsp.getFecha(), 
                    objEsp.getDiagnostico(),objEsp.getTratamiento(),objEsp.getObservaciones());        
        return new ModelAndView("redirect:/Cita/listar.htm");
    }
    
    @RequestMapping(value="/Cita/editar.htm", method = RequestMethod.GET )
    public ModelAndView Editar(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("ID"));
        String sql = "Select * from tbcita where IDCita = ?";
        List datos=jdbctemplate.queryForList(sql,id);
        mav.addObject("lista",datos);
        mav.addObject("listaDoctor",new ControllerDoctor().ListarDoctor());
        mav.addObject("listaPaciente",new ControllerPaciente().ListarPaciente());
        mav.addObject("listaHorario",new ControllerHorario().ListarHorario());
        mav.setViewName("/Cita/editar");
        return mav;
    }
    
    @RequestMapping(value="/Cita/editar.htm", method = RequestMethod.POST )
    public ModelAndView Editar(Cita objCit){
        String sql = "update tbcita set IDDoctor=?, "
                + "IDPaciente=?, IDHorario=?, Fecha=?, Diagnostico=?, Tratamiento=?, Observaciones=? where IDCita=?";
        this.jdbctemplate.update(sql, objCit.getIDDoctor(), 
                    objCit.getIDPaciente(),objCit.getIDHorario(), objCit.getFecha(), objCit.getDiagnostico(),objCit.getTratamiento(),objCit.getObservaciones(), objCit.getIDCita());
        return new ModelAndView("redirect:/Cita/listar.htm");
    }
    
    @RequestMapping(value="/Cita/eliminar.htm", method = RequestMethod.GET )
    public ModelAndView Eliminar(HttpServletRequest request){
         int id = Integer.parseInt(request.getParameter("ID"));
        String sql = "Select * from tbcita where IDCita = ?";
        List datos=jdbctemplate.queryForList(sql,id);
        mav.addObject("lista",datos);
        mav.addObject("listaDoctor",new ControllerDoctor().ListarDoctor());
        mav.addObject("listaPaciente",new ControllerPaciente().ListarPaciente());
        mav.addObject("listaHorario",new ControllerHorario().ListarHorario());
        mav.setViewName("/Cita/eliminar");
        return mav;
    }
    
    @RequestMapping(value="/Cita/eliminar.htm", method = RequestMethod.POST )
    public ModelAndView Eliminar(Cita objEsp){
        String sql = "delete from tbcita where IDCita=?";
        this.jdbctemplate.update(sql, objEsp.getIDDoctor());        
        return new ModelAndView("redirect:/Cita/listar.htm");
    }
    
    public List ListarCita(){
        String sql = "Select * from tbcita";
        List datos=jdbctemplate.queryForList(sql);
        return datos;
    }    
}
