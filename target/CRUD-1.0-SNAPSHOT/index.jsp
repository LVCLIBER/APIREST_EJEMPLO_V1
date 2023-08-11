<%-- 
    Document   : index
    Created on : 22 abr. 2023, 12:13:48
    Author     : PROGRAM_MICHAEL
--%>

<%@page import="Modelo.Musuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<header class="header">
    <a href="#" id="cerrar-sidebar">Cerrar sidebar</a>    
</header>
<div class="container-informacion"> 
<section class="container-modal">
    <a href="#" id="cerrar-modal">Cerrar</a>
    <form action="ControladorUsuario?accion=registrar" method="POST">
        <h1>Registrar Usuario</h1>   
        <input type="number" name="ttdni" id="ttdni" placeholder="DNI">
        <input type="text" name="ttnombre" id="ttnombre" placeholder="NOMBRE">
        <input type="number" name="ttedad" id="ttedad" placeholder="EDAD">
        <input type="submit" value="Registrar" id="btnregistrar">
    </form>
</section>

<section class="container-modalEditar">
    <a href="#" id="cerrar-modal-editar">Cerrar</a>
    <!--ejemplo enviar formulario con metodo get-->
    <form action="" method="GET" >
        <h1>Editar Usuario</h1>
        <input type="number" name="ttdniE" id="ttdniE">
        <input type="text" name="ttnombreE" id="ttnombreE">
        <input type="number" name="ttedadE" id="ttedadE" >
        <input type="submit" name="accion" value="guardar" id="btnguardar" >
    </form>
</section>


    <section class="seccion-table">

    <div class="container-nuevoregistro">
        <h3>Registrar Nuevo usuario</h3>
        <a id="btn-abrir-modal" href="#">Nuevo Usuario</a>
    </div>
    <div class="content-table">
        <table >
        <thead>
            <tr>
                <th>DNI</th>
                <th>NOMBRE</th>
                <th>EDAD</th>
                <th>ACCIONES</th>
            </tr>
        </thead>
        <tbody>
            <% ArrayList<Musuario> lista = (ArrayList<Musuario>) request.getAttribute("listauser");%>
            <tr>
                <% for (Musuario elem : lista) {%>
                <td><%=elem.getDni()%></td>
                <td><%=elem.getNombre()%>s</td>
                <td><%=elem.getEdad()%></td>
                <%   int dni = elem.getDni();
                    String nombre = elem.getNombre();
                    int edad = elem.getEdad();%>
                <td> <a id="btnModalEditar"  onclick="modaleditar('<%=dni%>', '<%=nombre%>', '<%=edad%>')"  href="#" >Editar</a>
                    <a   id="btnModaleliminar" href="ControladorUsuario?accion=eliminar&dni=<%=elem.getDni()%>"> Eliminar</a></td>
            </tr>
            <%  }%>
        </tbody>
    </table>
    </div>
    
</section>

</div>

</div>
</div>
<script src="script/script.js"></script>
</body>
</html>
