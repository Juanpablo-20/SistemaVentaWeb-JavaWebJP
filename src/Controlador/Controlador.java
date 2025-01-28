package Controlador;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Ventas;
import Modelo.VentasDAO;
import config.GenerarSerie;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    Empleado em = new Empleado();

    EmpleadoDAO edao = new EmpleadoDAO();

    int ide;

    Producto prod = new Producto();

    ProductoDAO proDao = new ProductoDAO();

    Cliente cli = new Cliente();

    ClienteDAO cliDao = new ClienteDAO();

    Ventas ventas = new Ventas();

    List<Ventas> lista = new ArrayList<>();

    int Item;

    int CodigoProducto;

    String Descripcion;

    double Precio;

    int Cantidad;

    double SubTotal;

    double TotalPagar;

    String NumeroSerie = " ";

    VentasDAO venDao = new VentasDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        String menu = request.getParameter("menu");

        String accion = request.getParameter("accion");

        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }

        if (menu.equals("Producto")) {
//            System.out.println("En producto");
            switch (accion) {
                case "Listar":
                    List lista = proDao.listar();
                    //*************************************
                    //*************************************
//                    prod.setNombreProducto("Este");
//                    prod.setPrecio(Double.parseDouble("20.0"));
//                    prod.setStock(Integer.parseInt("1"));
//                    prod.setEstado("Fino");
                    request.setAttribute("Producto", lista);
                    //*************************************
                    //*************************************
//                    request.setAttribute("producto", prod);
                    break;

                case "Agregar":
                    String nombreProducto = request.getParameter("txtNombreProducto");
                    String precio = request.getParameter("txtPrecio");
                    String stock = request.getParameter("txtStock");
                    String estado = request.getParameter("txtEstado");

                    prod.setNombreProducto(nombreProducto);
                    prod.setPrecio(Double.parseDouble(precio));
                    prod.setStock(Integer.parseInt(stock));
                    prod.setEstado(estado);

                    proDao.agregar(prod);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;

                case "Editar":

                    ide = Integer.parseInt(request.getParameter("id"));

                    Producto p = proDao.listarId(ide);

                    request.setAttribute("producto", p);

                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":

                    String nombreProducto1 = request.getParameter("txtNombreProducto");
                    String precio1 = request.getParameter("txtPrecio");
                    String stock1 = request.getParameter("txtStock");
                    String estado1 = request.getParameter("txtEstado");

                    prod.setNombreProducto(nombreProducto1);
                    prod.setPrecio(Double.parseDouble(precio1));
                    prod.setStock(Integer.parseInt(stock1));
                    prod.setEstado(estado1);

                    prod.setIdProducto(ide);

                    proDao.actualizar(prod);

                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;

                case "Delete":

                    ide = Integer.parseInt(request.getParameter("id"));

                    proDao.delete(ide);

                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);

                    break;

                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }

        if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar":
                    List lista = edao.listar();
                    //*************************************
                    //*************************************
//                     em.setNombre("Si funciona");
//                    request.setAttribute("emple", em);
                    //**************************************
                    //**************************************
                    request.setAttribute("empleado", lista);
                    break;

                case "Agregar":
//                    System.out.println("Agregando empleado");
                    String cedula = request.getParameter("txtCedula");
                    String nombre = request.getParameter("txtNombre");
                    String telefono = request.getParameter("txtTelefono");
                    String estado = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUsuario");

                    em.setCedula(cedula);
                    em.setNombre(nombre);
                    em.setTelefono(telefono);
                    em.setEstado(estado);
                    em.setUser(user);

                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;

                case "Editar":

                    ide = Integer.parseInt(request.getParameter("id"));

                    Empleado e = edao.listarId(ide);

                    request.setAttribute("empleado", e);

                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":

                    String cedula1 = request.getParameter("txtCedula");
                    String nombre1 = request.getParameter("txtNombre");
                    String telefono1 = request.getParameter("txtTelefono");
                    String estado1 = request.getParameter("txtEstado");
                    String user1 = request.getParameter("txtUsuario");

                    em.setCedula(cedula1);
                    em.setNombre(nombre1);
                    em.setTelefono(telefono1);
                    em.setEstado(estado1);
                    em.setUser(user1);

                    em.setId(ide);

                    edao.actualizar(em);

                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;

                case "Delete":

                    ide = Integer.parseInt(request.getParameter("id"));

                    edao.delete(ide);

                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);

                    break;

                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }

        if (menu.equals("Cliente")) {

            switch (accion) {
                case "Listar":
                    List lista = cliDao.listar();

                    request.setAttribute("Cliente", lista);
                    break;

                case "Agregar":
                    String cedula = request.getParameter("txtCedula");
                    String nombre = request.getParameter("txtNombre");
                    String direccion = request.getParameter("txtDireccion");
                    String estado = request.getParameter("txtEstado");

                    cli.setCedula(cedula);
                    cli.setNombre(nombre);
                    cli.setDireccion(direccion);
                    cli.setEstado(estado);

                    cliDao.agregar(cli);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;

                case "Editar":

                    ide = Integer.parseInt(request.getParameter("id"));

                    Cliente e = cliDao.listarId(ide);

                    request.setAttribute("cliente", e);

                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":

                    String cedula1 = request.getParameter("txtCedula");
                    String nombre1 = request.getParameter("txtNombre");
                    String direccion1 = request.getParameter("txtDireccion");
                    String estado1 = request.getParameter("txtEstado");

                    cli.setCedula(cedula1);
                    cli.setNombre(nombre1);
                    cli.setDireccion(direccion1);
                    cli.setEstado(estado1);

                    cli.setIdCliente(ide);

                    cliDao.actualizar(cli);

                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;

                case "Delete":

                    ide = Integer.parseInt(request.getParameter("id"));

                    cliDao.delete(ide);

                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);

                    break;

                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("Cliente.jsp").forward(request, response);
        }

        if (menu.equals("NuevaVenta")) {

            switch (accion) {

                case "Listar":
                    List listaVentas = venDao.listarNuevaVentas();

                    request.setAttribute("Ventas", listaVentas);
                    break;

                case "BuscarCliente":

                    String cedula = request.getParameter("CodigoCliente");

                    cli.setCedula(cedula);

                    cli = cliDao.buscar(cedula);

                    request.setAttribute("cli", cli);

                    request.setAttribute("NumeroSerie", NumeroSerie);

//                    request.setAttribute("usuario", usuario);
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                    break;

                case "BuscarProducto":

                    int id = Integer.parseInt(request.getParameter("CodigoProducto"));

//                    prod.setIdProducto(id);
                    prod = proDao.listarId2(id);

                    request.setAttribute("cli", cli);

                    request.setAttribute("prod", prod);

                    request.setAttribute("lista", lista);

                    request.setAttribute("TotalPagar", TotalPagar);

                    request.setAttribute("NumeroSerie", NumeroSerie);

//                    request.setAttribute("usuario", usuario);
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                    break;

                case "Agregar":

                    request.setAttribute("NumeroSerie", NumeroSerie);

                    request.setAttribute("cli", cli);

                    TotalPagar = 0.0;

                    Item = Item + 1;

                    CodigoProducto = prod.getIdProducto();

                    Descripcion = request.getParameter("NombreProducto");

                    Precio = Double.parseDouble(request.getParameter("precio"));

                    Cantidad = Integer.parseInt(request.getParameter("cantidad"));

                    SubTotal = Precio * Cantidad;

                    ventas = new Ventas();

                    ventas.setItem(Item);

                    ventas.setIdProducto(CodigoProducto);

                    ventas.setDescripcionProducto(Descripcion);

                    ventas.setPrecio(Precio);

                    ventas.setCantidad(Cantidad);

                    ventas.setSubTotal(SubTotal);

//                    lista.add(ventas);
//                    for (int i = 0; i < lista.size(); i++) {
//
//                        TotalPagar = TotalPagar + lista.get(i).getSubTotal();
//                    }
                    boolean exist = false;
                    int count = 0;
                    int position = 0;
                    for (Ventas ventas : lista) {
                        if (ventas.getIdProducto() == CodigoProducto) {
                            exist = true;
                            position = count;
                        }
                        count++;
                    }
                    if (exist) {
                        lista.get(position).setCantidad(lista.get(position).getCantidad());
                    } else {
                        lista.add(ventas);
                    }
                    for (int i = 0; i < lista.size(); i++) {
                        TotalPagar = TotalPagar + lista.get(i).getSubTotal();
                    }

                    request.setAttribute("TotalPagar", TotalPagar);

                    request.setAttribute("lista", lista);

//                    session.setAttribute("usuario", usuario);
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);

                    break;

                case "Editar":

                    ide = Integer.parseInt(request.getParameter("id"));

                    Cliente idCli = cliDao.listarId(ide);

                    request.setAttribute("cli", idCli);

                    Producto idProd = proDao.listarId(ide);

                    request.setAttribute("prod", idProd);

                    request.getRequestDispatcher("Controlador?menu=NuevaVenta&accion=Listar").forward(request, response);

                    break;

                case "Actualizar":

                    String cedulaCliente = request.getParameter("CodigoCliente");

                    String nombreCliente = request.getParameter("nombreCliente");

                    int codigoProducto = Integer.parseInt(request.getParameter("CodigoProducto"));

                    String nombreProducto = request.getParameter("NombreProducto");

                    int precioProducto = Integer.parseInt(request.getParameter("precio"));

                    int stockProducto = Integer.parseInt(request.getParameter("stock"));

                    cli.setCedula(cedulaCliente);

                    cli.setNombre(nombreCliente);

                    prod.setIdProducto(codigoProducto);

                    prod.setNombreProducto(nombreProducto);

                    prod.setPrecio(precioProducto);

                    prod.setStock(stockProducto);

                    cliDao.actualizar(cli);

                    proDao.actualizar(prod);

                    request.getRequestDispatcher("Controlador?menu=NuevaVenta&accion=Listar").forward(request, response);

                    break;

                case "Delete":

                    ide = Integer.parseInt(request.getParameter("id"));

                    cliDao.delete(ide);

                    proDao.delete(ide);

                    request.getRequestDispatcher("Controlador?menu=NuevaVenta&accion=Listar").forward(request, response);

                    break;

                case "GenerarVenta":

//                    Actualizacion del Stock
                    for (int i = 0; i < lista.size(); i++) {

                        Producto prod = new Producto();

                        int Cantidad = lista.get(i).getCantidad();

                        int IdProducto = lista.get(i).getIdProducto();

                        ProductoDAO proDao = new ProductoDAO();

                        prod = proDao.buscar(IdProducto);

                        int StockActual = prod.getStock() - Cantidad;

                        proDao.ActualizarStock(IdProducto, StockActual);
                    }

//                    Apartado para GUARDAR las Ventas
                    ventas.setIdCliente(cli.getIdCliente());

                    ventas.setIdEmpleado(2);

                    ventas.setNumeroSerie(NumeroSerie);
                    
                    ventas.setFecha("2024-11-25");

                    ventas.setMonto(TotalPagar);

                    ventas.setEstado("1");

                    int r = venDao.GuardarVentas(ventas);

//                    Apatado para GUARDAR Detalle de Ventas
                    int IdVen = Integer.parseInt(venDao.IdVentas());

                    for (int i = 0; i < lista.size(); i++) {

                        ventas = new Ventas();

                        ventas.setIdVentas(IdVen);

                        ventas.setIdProducto(lista.get(i).getIdProducto());

                        ventas.setCantidad(lista.get(i).getCantidad());

                        ventas.setPrecio(lista.get(i).getPrecio());

                        r = venDao.GuardarDetalleVentas(ventas);
                    }

//                    Imprimir.imprimirDocumento(lista, numeroserie, c, em);
//                    try {
//                        Desktop.getDesktop().open(new File(numeroserie + ".txt"));
//                    } catch (IOException ex) {
//                        Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    lista = new ArrayList<>();
//                    request.getRequestDispatcher("Controlador?menu=NuevaVenta&accion=ventanueva").forward(request, response);
//                    System.out.println("Venta Realizada con Éxito..!!!:" + r);
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);

                    break;

                default:

                    ventas = new Ventas();

                    lista = new ArrayList<>();

                    Item = 0;

                    TotalPagar = 0.0;

                    NumeroSerie = venDao.GenerarSerie();

                    if (NumeroSerie == null) {

                        NumeroSerie = "00000001";

                        request.setAttribute("NumeroSerie", NumeroSerie);

                    } else {

                        int incrementar = Integer.parseInt(NumeroSerie);

                        GenerarSerie GenSerie = new GenerarSerie();

                        NumeroSerie = GenSerie.NumeroSerie(incrementar);

                        request.setAttribute("NumeroSerie", NumeroSerie);
                    }

//                    session.setAttribute("Usuario", usuario);
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }

            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
