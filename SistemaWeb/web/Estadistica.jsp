
<jsp:useBean id="Estadistica" class="Modelo.EstadisticasBean" scope="page"/>
<div class="BoxEstadisticas">
    <center><h1>Stadisticas</h1></center> 
    <h3>Numero total de Usuarios: <%= Estadistica.getNumero_Usuario() %></h3>
    <h3>Numero de empledos Registrados: <%= Estadistica.getNumero_Empleados() %></h3>
    <h3>Numero de prestaciones Registradas: <%= Estadistica.getNumero_Prestaciones() %></h3>
    <h3>Numero de prestaciones en proceso: <%= Estadistica.getNumero_Prestaciones_Proceso() %></h3> 
    <h3>Numero de prestaciones pagadas: <%= Estadistica.getNumero_Prestaciones_Pagadas() %></h3>
</div>