<%-- 
    Document   : RegistrarVenta
    Created on : 10 oct 2024, 12:18:44 a. m.
    Author     : 1PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
        <title>JSP Page Registro de Venta</title>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

        <%--Apartado para imprimir estilo factura--%>
        <style>
            @media print{

                .parte01, .btn, .accion{

                    display: none;
                }
            }
        </style>

    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-5 me-2 parte01">
                <div class="card">
                    <form action="Controlador?menu=NuevaVenta" method="POST">
                        <div class="card-body">
                            <!--Datos de los Clientes -->
                            <div class="form-group">
                                <label>Datos del Cliente</label>
                            </div>
                            <div class="form-group row d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="CodigoCliente" value="${cli.getCedula()}" class="form-control" placeholder="Codigo">
                                    <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info">
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nombreCliente" value="${cli.getNombre()}" class="form-control" placeholder="Datos Cliente">
                                </div>
                            </div>
                            <br>
                            <!--Datos de los Productos -->
                            <div class="form-group">
                                <label>Datos Productos</label>
                            </div>
                            <div class="form-group  row d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="CodigoProducto" value="${prod.getIdProducto()}" class="form-control" placeholder="Codigo">
                                    <!--<input type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info" placeholder="Buscar">-->
                                    <button type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info">Buscar</button>
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="NombreProducto" value="${prod.getNombreProducto()}"  class="form-control" placeholder="Datos Producto">
                                </div>
                            </div>
                            <br>
                            <div class="form-group row d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="precio" value="${prod.getPrecio()}" class="form-control" placeholder="$/0.00">
                                </div>
                                <div class="col-sm-3 d-flex">
                                    <input type="number" value="1" name="cantidad" class="form-control" placeholder="">
                                </div>
                                <div class="col-sm-3 d-flex">
                                    <input type="text" name="stock" value="${prod.getStock()}" class="form-control" placeholder="stock">
                                </div>
                            </div>
                            <br>
                            <!--Boton Agregar Producto al Registrar -->
                            <div class="form-group">
                                <button type="submit" name="accion" value="Agregar" class="btn btn-info">Agregar Producto</button>
                                <%--<button type="submit" name="accion" value="UpdateCant" class="btn btn-success">Actualizar</button>--%>
                                <button type="submit" name="accion" value="Actualizar" class="btn btn-success">Actualizar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex ml-auto col-sm-6">
                            <label class="text-right mt-2 col-sm-6">Numero de Serie</label>
                            <input readonly="" type="text" name="NumeroSerie" class="form-control text-center"  value="${NumeroSerie}" style="font-weight: bold"style="font-weight: bold;font-size: 18px">        
                        </div> 
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <tr class="text-center">
                                    <th>Nro</th>
                                    <th>Codigo</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>SubTotal</th>
                                    <th class="accion">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                    <tr class="text-center">
                                        <td>${list.getItem()}</td>
                                        <td>${list.getIdProducto()}</td>
                                        <td>${list.getDescripcionProducto()}</td>
                                        <td>${list.getPrecio()}</td>
                                        <%--<td>
                                            <input type="hidden" id="item1" value="${list.getIdProducto()}">
                                            <input type="number" min="1" max="10" id="Cant" class="form-control text-center" value="${list.getCantidad()}">
                                        </td>--%>
                                        <td>${list.getCantidad()}</td>
                                        <td>${list.getSubTotal()}</td>
                                        <%--<td class="d-flex text-center">--%>
                                        <td>
                                            <a href="Controlador?menu=NuevaVenta&accion=Editar&id=${prod.getIdProducto()}" class="btn btn-warning">Editar</a>
                                            <a href="#" class="btn btn-danger" style="margin-left: 5px">Delete</a>
                                            <%--<input type="hidden" id="item2" value="${list.getIdProducto()}">
                                            <a id="deleteItem" class="btn btn-outline-danger btn-sm"><i class="bi bi-trash"></i></a>--%>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>

                    <div class="card-footer d-flex">
                        <div class="row">
                            <div class="col-sm-6">
                                <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta" onclick="print()" class="btn btn-success">Generar Venta</a>
                                <%--<input type="submit" name="accion" value="Generar Venta" class="btn btn-success">--%>
                                <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                            </div>
                            <div class="col-sm-6 ml-auto d-flex">                                
                                <label class=" col-sm-6 text-right mt-2">Total a Pagar</label>
                                <input type="text" name="txtTotal" value="$/. ${TotalPagar}0" class="form-control text-center font-weight-bold" style="font-size: 18px;">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </body>
</html>
