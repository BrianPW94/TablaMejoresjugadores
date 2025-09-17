<%@page import="clases.Futbolista"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Asistidores</title>
<style>

h1{
padding-top: 20px;
text-align: center;
}


td{
text-align: center;
text-transform: capitalize;
}

#pais{
text-align: left;
}


</style>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr"
	crossorigin="anonymous">

<link
	href="https://cdn.datatables.net/v/bs5/dt-2.3.3/datatables.min.css"
	rel="stylesheet"
	integrity="sha384-CoUEazvx+MklR7+tLlL048g8FXNPCgFr7HP39p0DQojPC16bnlchqDSzQK3Td1BU"
	crossorigin="anonymous">
</head>
<body>

<%@include file="/shared/navbar.jsp"%>
<div class="container">
<h1>Tabla Goleadores</h1>
<%ArrayList<Futbolista> lista = (ArrayList<Futbolista>)request.getAttribute("lista"); %>

<table class="table table-striped table-hover table-sm" id="RolloAsistidores" style="border: 1px solid #000000; margin: 5px 0">

<thead>
<tr>
<th style=" color: white; background-color: #9c230b; border: solid 2px white; text-align: center">Nombres</th>
<th style=" color: white; background-color: #9c230b; border: solid 2px white; text-align: center">Apellidos</th>
<th style=" color: white; background-color: #9c230b; border: solid 2px white; text-align: center">Equipo</th>
<th style=" color: white; background-color: #9c230b; border: solid 2px white; text-align: center">Asistencias</th>
<th style=" color: white; background-color: #9c230b; border: solid 2px white; text-align: center;">Partidos</th>
<th style=" color: white; background-color: #9c230b; border: solid 2px white; text-align: center">Edad</th>
<th style=" color: white; background-color: #9c230b; border: solid 2px white; text-align: center">Puesto</th>
<th style=" color: white; background-color: #9c230b; border: solid 2px white; text-align: center">Pais</th>
</tr>
</thead>

<tbody>
<% for (Futbolista f: lista) { %>
<tr>
<td><%=f.getNombres() %></td>
<td><%=f.getApellidos() %></td>
<td><%=f.getNombreEquipo() %></td>
<td style="text-align: center"><%=f.getAsistencias() %></td>
<td style="text-align: center"><%=f.getPartidos() %></td>
<td style="text-align: center"><%=f.getEdad() %></td>
<td><%=f.getPuesto() %></td><td id="pais"><% if (f.getCodigoPais() != null && !f.getCodigoPais().isEmpty()) { %>
                            <img src="https://flagcdn.com/<%= f.getCodigoPais().toLowerCase() %>.svg" 
                                 alt="<%= f.getNombrePais() != null ? f.getNombrePais() : "Sin país" %>" 
                                 style="width: 20px; height: 15px; vertical-align: middle; margin-right: 5px;">
                        <% } %>
                        <%= f.getNombrePais() %>
                        </td>
</tr>

<%} %>
</tbody>
</table>
</div>

<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q"
		crossorigin="anonymous"></script>
		
		<script src="https://code.jquery.com/jquery-3.7.1.min.js"
		integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
		crossorigin="anonymous"></script>

	<script
		src="https://cdn.datatables.net/v/bs5/dt-2.3.3/datatables.min.js"
		integrity="sha384-ojz3MK3bx1Hb+Bu7oACSEUC9lgGaVZwak7rlgV4yKmSv2BAcRldS4GUz7NqRuAnn"
		crossorigin="anonymous"></script>


	<script>
var table = new DataTable('#RolloAsistidores', {
    language: {
        url: '//cdn.datatables.net/plug-ins/2.3.3/i18n/es-ES.json',
    },
    order: [[3, 'desc'], [4, 'asc']]
});
</script>
</body>
</html>