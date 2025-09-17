<%@page import="java.util.ArrayList"%>
<%@page import="clases.Equipo"%>
<%@page import="clases.Futbolista"%>
<%@page import="clases.Pais"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<title>Agregar o Editar Futbolista</title>
</head>
<body>
    <%@include file="/shared/navbar.jsp"%>
    <div class="container">
        <h1>Registro de Futbolistas</h1>

        <%
        Futbolista futbolista = (Futbolista) request.getAttribute("registro");
        if (futbolista == null) {
            futbolista = new Futbolista();
        }
        ArrayList<Equipo> equipos = (ArrayList<Equipo>) request.getAttribute("listaEquipos");
        if (equipos == null) equipos = new ArrayList<>();
        ArrayList<Pais> paises = (ArrayList<Pais>) request.getAttribute("listaPaises");
        if (paises == null) paises = new ArrayList<>();
        %>

        <form id="formFutbolista" action="futbolistas?opcion=registrar" method="post">
            <input type="hidden" name="futbolistaId" value="<%= futbolista.getFutbolistaId() %>" />
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Nombre(s)</label>
                <div class="col-sm-10">
                    <input type="text" name="nombres" class="form-control" value="<%= futbolista.getNombres() != null ? futbolista.getNombres() : "" %>" />
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Apellidos</label>
                <div class="col-sm-10">
                    <input type="text" name="apellidos" class="form-control" value="<%= futbolista.getApellidos() != null ? futbolista.getApellidos() : "" %>" />
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Goles</label>
                <div class="col-sm-10">
                    <input type="number" name="goles" class="form-control" value="<%= futbolista.getGoles() %>" />
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Asistencias</label>
                <div class="col-sm-10">
                    <input type="number" name="asistencias" class="form-control" value="<%= futbolista.getAsistencias() %>" />
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Partidos</label>
                <div class="col-sm-10">
                    <input type="number" name="partidos" class="form-control" value="<%= futbolista.getPartidos() %>" />
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Puesto</label>
                <div class="col-sm-10">
                    <input type="text" name="puesto" class="form-control" value="<%= futbolista.getPuesto() != null ? futbolista.getPuesto() : "" %>" />
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Edad</label>
                <div class="col-sm-10">
                    <input type="number" name="edad" class="form-control" value="<%= futbolista.getEdad() %>" />
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Equipo</label>
                <div class="col-sm-10">
                    <select name="equipoId" class="form-select">
                        <% for (Equipo e : equipos) { %>
                            <option value="<%= e.getEquipoId() %>" <%= (futbolista.getEquipoId() != 0 && futbolista.getEquipoId() == e.getEquipoId()) ? "selected" : "" %>><%= e.getNombre() %></option>
                        <% } %>
                    </select>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">País</label>
                <div class="col-sm-10">
                    <select name="paisId" class="form-select">
                        <% for (Pais p : paises) { %>
                        
                     
                      <option value="<%=p.getPaisId()%>" 
							<%=(p.getPaisId() == futbolista.getPaisId() ? "selected=\"selected\"" : "") %> >
								<%=p.getNombrePais() %>
							</option>
                      
                        <% } %>
                    </select>
                </div>
            </div>
            <div class="mb-3 row">
                <div class="col-sm-10 offset-sm-2">
                    <button type="submit" class="btn btn-primary">Enviar</button>
                </div>
            </div>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js"></script>
    <script type="text/javascript">
        $(() => {
            $('#formFutbolista').validate({
                rules: {
                    nombres: { 
                    	required: true
                    	},
                    apellidos: { 
                    	required: true 
                    	},
                    goles: { 
                    	required: true, 
                    	number: true 
                    	},
                    asistencias: {
                    	required: true, 
                    	number: true
                    	},
                    partidos: {
                    	required: true, 
                    	number: true, 
                    	min: 1 
                    	},
                    puesto: {
                    	required: true 
                    	},
                    edad: {
                    	required: true, 
                    	number: true, 
                    	min: 1 
                    	}
                },
                
                messages: {
                    nombres: { 
                    	required: 'El campo nombre es requerido' 
                    	},
                    apellidos: { 
                    	required: 'El campo apellidos es requerido' 
                    	},
                    goles: { 
                    	required: 'El campo goles es requerido'
                    	},
                    asistencias: { 
                    	required: 'El campo asistencias es requerido'
                    	},
                    partidos: { 
                    	required: 'El campo partidos es requerido',
                    	min: 'El campo debe tener mínimo 1 partido' 
                    	},
                    puesto: { 
                    	required: 'El campo puesto es requerido' 
                    	},
                    edad: { 
                    	required: 'El campo edad es requerido',
                    	min: 'El campo debe tener mínimo 1 año' 
                    	}
                }
            });
        });
    </script>
</body>
</html>