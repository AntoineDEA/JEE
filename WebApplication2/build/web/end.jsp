<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Bonus Calculation - TP1</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    <center>
        <b>User by name</b><br><br>
        <table>
    </center>
    <style type="text/css">
    .tg  {border-collapse:collapse;border-spacing:0;}
    .tg td{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;
      overflow:hidden;padding:10px 5px;word-break:normal;}
    .tg th{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;
      font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;}
    .tg .tg-0pky{border-color:inherit;text-align:left;vertical-align:top}
    </style>
    <table class="tg">
        <thead>
          <tr>
            <th>ID</th>
            <th>Fisrt Name</th>
            <th>Last Name</th>
            <th>Login</th>
          </tr>
        </thead>
    <c:forEach items="${Users}" var="data">
        <tr>
            <tbody>
              <tr>
                <td>${data.getId()}</td>
                <td>${data.getName()}</td>
                <td>${data.getSurname()}</td>
                <td>${data.getLogin()}</td>
              </tr>
            </tbody>
        </tr>
    </c:forEach>
    </table>
    </table>
    </body>
</html>

