<%-- 
    Document   : index
    Created on : 8 oct 2024, 12:28:28 a. m.
    Author     : 1PC
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
        <title>JSP Page</title>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>

        <div class="container mt-4 col-lg-4 d-grid gap-4">
            <div class="card col-sm-10">
                <div class="card-body">
                    <form class="form-sign" action="Validar" method="POST">
                        <div class="form-group text-center">
                            <h3>Login</h3>
                            <img src="img/linkin-park-band-logo.png" alt="70" width="170"/>
                            <div class="d-grid gap-8 mx-auto">
                                <label>Bienvenido al Sistema</label
                            </div>
                        </div>
                        <div class="form-group">
                            <label>Usuario:</label>
                            <input class="form-control" type="text" name="txtUser">                            
                        </div>
                        <div class="form-group">
                            <label>Contraseña:</label>
                            <input class="form-control" type="password" name="txtPassword">
                        </div>
                        <br>
                        <div class="mx-auto d-grid gap-2 col-4">
                            <button class="btn btn-primary btn-block" type="submit" name="accion" value="Ingresar">
                                Ingresar
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </body>
</html>