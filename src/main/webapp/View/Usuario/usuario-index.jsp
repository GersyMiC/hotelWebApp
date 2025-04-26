<%-- 
    Document   : usuario-index
    Created on : 25 abr 2025, 1:39:44 a.m.
    Author     : DJE DAYIRO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel Paradise</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
            color: #333;
        }

        header {
            background-color: #333;
            color: white;
            padding: 1em;
            text-align: center;
        }

        nav {
            background-color: #444;
            overflow: hidden;
        }

        nav a {
            color: white;
            padding: 14px 20px;
            text-decoration: none;
            display: inline-block;
            text-align: center;
        }

        nav a:hover {
            background-color: #ddd;
            color: black;
        }

        section {
            padding: 20px;
        }

        .welcome {
            text-align: center;
            margin-top: 50px;
        }

        .welcome h1 {
            font-size: 2.5em;
        }

        .contact-form {
            max-width: 400px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .contact-form label {
            font-size: 1.1em;
            display: block;
            margin-bottom: 8px;
        }

        .contact-form input, .contact-form textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .contact-form input[type="submit"] {
            background-color: #333;
            color: white;
            cursor: pointer;
        }

        .contact-form input[type="submit"]:hover {
            background-color: #555;
        }

        footer {
            text-align: center;
            padding: 10px;
            background-color: #333;
            color: white;
            position: absolute;
            width: 100%;
            bottom: 0;
        }
    </style>
</head>
<body>

<header>
    <h1>Hotel Paradise</h1>
    <p>Tu lugar de descanso perfecto</p>
</header>

<nav>
    <a href="#welcome">Inicio</a>
    <a href="#contact">Contacto</a>
    <a href="#about">Acerca de</a>
</nav>

<section id="welcome" class="welcome">
    <h1>Bienvenido a Hotel Paradise</h1>
    <p>Disfruta de unas vacaciones únicas en el mejor hotel de la ciudad.</p>
</section>

<section id="contact">
    <h2>Contacto</h2>
    <p>Si tienes alguna pregunta, por favor completa el siguiente formulario.</p>

    <div class="contact-form">
        <form action="#">
            <label for="name">Nombre</label>
            <input type="text" id="name" name="name" placeholder="Tu nombre" required>

            <label for="email">Correo electrónico</label>
            <input type="email" id="email" name="email" placeholder="Tu correo" required>

            <label for="message">Mensaje</label>
            <textarea id="message" name="message" rows="4" placeholder="Tu mensaje" required></textarea>

            <input type="submit" value="Enviar mensaje">
        </form>
    </div>
</section>

<footer>
    <p>&copy; 2025 Hotel Paradise | Todos los derechos reservados</p>
</footer>

</body>
</html>
