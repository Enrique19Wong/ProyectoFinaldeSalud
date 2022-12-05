<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <title>MENU PRINCIPAL</title>|
           <meta name="viewport" content="width=device-width, initial-scale=1">
        
           <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>JSP Page</title>  
    </head>    
  
    <body >              
      <nav class="navbar navbar-dark bg-dark">
          <a style="color:white" class="navbar-toggler" ><span  class="navbar-toggler-icon"></span><a>
           <div  Class="dropdown">
               <a style="color:white" href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Cerrar Sesion</a>
                <div Class="dropdown-menu text-center">
                      <a><img src="img/iconpersona.png" height="140" width="140"/></a>
                      
                      <a>Paciente daniel</a>
                      <a>daniel@hotmail.com</a>
                       <div class="dropdown-divider"> </div>
                      <a href="login.jsp" class="dropdown-item" >salir</a>
                    
                </div>
                </div>
         </nav>
        <div class="container mt-4">
            <CENTER>
            <h1><strong> Bienvenido al Hospital Central Fap </strong></h1>
          </CENTER>
      
        <div class="container">
            <div class="row">
                <div class="col-md-5"></div>
                <div class="col-md-5">
                    <h3><strong>MEMU PRINCIPAL</strong></h3>
                    
                   <a class="btn btn-primary" href="./Especialidad/listar.htm">Especialidad</a><br><br>
                    <a class="btn btn-primary" href="./Turno/listar.htm">Turno</a> <br><br>
                    <a class="btn btn-primary" href="./Horario/listar.htm">Horario</a><br><br>
                    <a class="btn btn-primary" href="./Doctor/listar.htm">Doctor</a><br><br>
                    <a class="btn btn-primary" href="./Paciente/listar.htm">Paciente</a><br><br>
                    <a class="btn btn-primary" href="./Cita/listar.htm">Cita</a><br><br>
                    
                <div class="col-md-5"></div>                
            </div>
        </div>
   
        
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
