<%@page import="java.util.ArrayList"%>
<%@page import="clases.Equipo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista equipos</title>
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
	

	<div class="container mt-3">
		<h1 style="text-align: center">Lista de Equipos</h1>

		<%
		ArrayList<Equipo> lista = (ArrayList<Equipo>) request.getAttribute("lista");
		%>

		<div class="table-container mx-auto" style="max-width: 600px">
			<a href="equipo?opcion=editar" class="btn btn-sm btn-success"><i
				class="bi bi-file-plus"></i>Agregar Equipo</a> <br>
			<table class="table table-hover" id="RolloEquipos"
				style="border: 1px solid #000000; margin: 5px 0">
				<thead>
					<tr style="background-color: #9C230B">
						<th
							style="text-align: center; color: #ffffff; background-color: #9C230B">Nombre
							Equipo</th>
						<th style="background-color: #9C230B"></th>
					</tr>
				</thead>
				<tbody class="table-group-divider">
					<%
					for (Equipo e : lista) {
					%>
					<tr>
						<td style="text-align: center"><%=e.getNombre()%></td>
						<td class="text-end" style="width: 200px">
							<div class="btn-group" style="gap: 5px">
								<a class="btn btn-sm btn-primary"
									href="equipo?opcion=editar&id=<%=e.getEquipoId()%>"><i
									class="bi bi-pencil-fill"></i> Editar</a> <a
									class="btn btn-sm btn-danger"
									href="javascript:eliminar(<%=e.getEquipoId()%>)"><i
									class="bi bi-x-circle"></i> Eliminar</a>
							</div>
						</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</div>


	<form id="formEliminar" action="equipo?opcion=eliminar" method="post">
		<input type="hidden" name="id" />
	</form>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q"
		crossorigin="anonymous"></script>

	<script type="text/javascript">
		const eliminar = (id) => {
			const respuesta = confirm('¿Desea eliminar el equipo?');
			if (respuesta) {
				document.querySelector('#formEliminar input[name=id]').value = id;
				document.getElementById('formEliminar').submit();
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
var table = new DataTable('#RolloEquipos', {
    language: {
        url: '//cdn.datatables.net/plug-ins/2.3.3/i18n/es-ES.json',
    },
}); </script>
</body>
</html>