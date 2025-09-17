<%@page import="clases.Futbolista"%>
<%@page import="clases.Equipo" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jugadores</title>
<style>
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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">

<link
	href="https://cdn.datatables.net/v/bs5/dt-2.3.3/datatables.min.css"
	rel="stylesheet"
	integrity="sha384-CoUEazvx+MklR7+tLlL048g8FXNPCgFr7HP39p0DQojPC16bnlchqDSzQK3Td1BU"
	crossorigin="anonymous">
</head>
<body>

	<%@include file="/shared/navbar.jsp"%>
	<div class="container">
		<h1>Lista de jugadores</h1>
		<%
		ArrayList<Futbolista> lista = (ArrayList<Futbolista>) request.getAttribute("lista");
		
		%>


		<div class="row">
			<div class="col">
			<a href="futbolistas?opcion=editar" class="btn btn-sm btn-success"><i class="bi bi-person-plus"></i> Agregar</a>
			</div>

		</div>
		
		<table class="table table-striped table-hover table-sm" id="RolloFutbolistas" style="border: 1px solid #000000; margin: 5px 0">
		<thead>
		<tr>
		<th style="text-align: center; color: white; background-color: #9c230b; border: solid 2px white">Nombre</th>
<th style="text-align: center; color: white; background-color: #9c230b;  border: solid 2px white">Apellido</th>
<th style="text-align: center; color: white; background-color: #9c230b; border: solid 2px white">Goles</th>
<th style="text-align: center; color: white; background-color: #9c230b;  border: solid 2px white">Asistencias</th>
<th style="text-align: center; color: white; background-color: #9c230b; border: solid 2px white ">Partidos</th>
<th style="text-align: center; color: white; background-color: #9c230b;  border: solid 2px white ">Puesto</th>
<th style="text-align: center; color: white; background-color: #9c230b;  border: solid 2px white">Edad</th>
<th style="text-align: center; color: white; background-color: #9c230b;  border: solid 2px white">Equipo</th>
<th style="text-align: center; color: white; background-color: #9c230b ; border: solid 2px white">Pais</th>
<th style="text-align: center; color: white; background-color: #9c230b ; border: solid 2px white"></th>
		</tr>
		</thead>
		
		<tbody>
		<% for(Futbolista f : lista) {%>
	<tr>
	<td><%= f.getNombres() %></td>
	<td><%= f.getApellidos() %></td>
	<td><%= f.getGoles() %></td>
	<td><%= f.getAsistencias() %></td>
	<td><%= f.getPartidos() %></td>
	<td><%= f.getPuesto()%></td>
	<td><%= f.getEdad() %></td>
	<td><%= f.getNombreEquipo() %></td>
	
	<td id="pais"><% if (f.getCodigoPais() != null && !f.getCodigoPais().isEmpty()) { %>
                            <img src="https://flagcdn.com/<%= f.getCodigoPais().toLowerCase() %>.svg" 
                                 alt="<%= f.getNombrePais() != null ? f.getNombrePais() : "Sin país" %>" 
                                 style="width: 20px; height: 15px; vertical-align: middle; margin-right: 5px;">
                        <% } %>
                        <%= f.getNombrePais() %>
                        </td>
                        
                        <td class="text-end" style="width: 200px">
							<div class="btn-group" style="gap: 5px">
								<a class="btn btn-sm btn-primary"
									href="futbolistas?opcion=editar&id=<%=f.getFutbolistaId()%>"><i
									class="bi bi-pencil-fill"></i> Editar</a>
									 <a	class="btn btn-sm btn-danger" href="javascript:eliminar(<%=f.getFutbolistaId()%>)"> <i
class="bi bi-x-circle"></i> Eliminar</a>
							</div>
						</td>
	</tr>
	<%} %>
		</tbody>
		</table>
	</div>
	
	<form id="formBorrar"  action="futbolistas?opcion=eliminar"method="post">
	<input type="hidden" name="id"/>
	</form>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q"
		crossorigin="anonymous"></script>
		
		<script type="text/javascript">
		const eliminar = (id) => {
			const respuesta = confirm('¿Desea eliminar el equipo?');
			if (respuesta) {
				document.querySelector('#formBorrar input[name=id]').value = id;
				document.getElementById('formBorrar').submit();
			}
		};
	</script>
	
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"
		integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
		crossorigin="anonymous"></script>

	<script
		src="https://cdn.datatables.net/v/bs5/dt-2.3.3/datatables.min.js"
		integrity="sha384-ojz3MK3bx1Hb+Bu7oACSEUC9lgGaVZwak7rlgV4yKmSv2BAcRldS4GUz7NqRuAnn"
		crossorigin="anonymous"></script>


	<script>
var table = new DataTable('#RolloFutbolistas', {
    language: {
        url: '//cdn.datatables.net/plug-ins/2.3.3/i18n/es-ES.json',
    },
}); </script>
</body>
</html>