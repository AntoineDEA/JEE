<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>User Creation</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="graphicPart.js"></script>
    </head>
    <body>
    <center>
        <h1>User Creation</h1>
        <form METHOD="GET" ACTION="MaServlet2">
        <style type="text/css">
            .tg  {border-collapse:collapse;border-spacing:0;}
            .tg td{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;
              overflow:hidden;padding:10px 5px;word-break:normal;}
            .tg th{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;
              font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;}
            .tg .tg-0lax{text-align:left;vertical-align:top}
            .myButton {
            box-shadow:inset 0px 1px 0px 0px #f29c93;
            background:linear-gradient(to bottom, #fe1a00 5%, #ce0100 100%);
            background-color:#fe1a00;
            border-radius:6px;
            border:1px solid #d83526;
            display:inline-block;
            cursor:pointer;
            color:#ffffff;
            font-family:Arial;
            font-size:25px;
            font-weight:bold;
            padding:2px 2px;
            text-decoration:none;
            text-shadow:0px 1px 0px #b23e35;
            }
            .myButton:hover {
                    background:linear-gradient(to bottom, #ce0100 5%, #fe1a00 100%);
                    background-color:#ce0100;
            }
            .myButton:active {
                    position:relative;
                    top:1px;
            }
        </style>

        <table class="tg">
            <thead>
              <tr>
                <th class="tg-0lax"><span style="font-weight:bold">First Name</span></th>
                <th class="tg-0lax"><span style="font-weight:bold">Last Name</span></th>
                <th class="tg-0lax"><span style="font-weight:bold">Login</span></th>
                <th class="tg-0lax"><span style="font-weight:bold">Delete This Line</span></th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td class="tg-0lax"><input TYPE="TEXT" NAME="name1"/></td>
                <td class="tg-0lax"><input TYPE="TEXT" NAME="surname1"/></td>
                <td class="tg-0lax"><input TYPE="TEXT" NAME="login1"/></td>
                <td><center><a href="#" class="myButton"><input type="button" value="X"></center></a></td>
              </tr>
              <tr class="test">
                <td class="tg-0lax"><input TYPE="TEXT" NAME="name2"/></td>
                <td class="tg-0lax"><input TYPE="TEXT" NAME="surname2"/></td>
                <td class="tg-0lax"><input TYPE="TEXT" NAME="login2"/></td>
                <td><center><a href="#" class="myButton"><input type="button" value="X"></center></a></td>
              </tr>
              <tr class="2">
                <td class="tg-0lax"><input TYPE="TEXT" NAME="name3"/></td>
                <td class="tg-0lax"><input TYPE="TEXT" NAME="surname3"/></td>
                <td class="tg-0lax"><input TYPE="TEXT" NAME="login3"/></td>
                <td><center><a href="#" class="myButton"><input type="button" value="X"></center></a></td>
              </tr>
              <tr class="3">
                <td class="tg-0lax"><input TYPE="TEXT" NAME="name4"/></td>
                <td class="tg-0lax"><input TYPE="TEXT" NAME="surname4"/></td>
                <td class="tg-0lax"><input TYPE="TEXT" NAME="login4"/></td>
                <td><center><a href="#" class="myButton"><input type="button" value="X"></center></a></td>
              </tr>
            </tbody>
        </table>
        <br><button type="submit">Submit</button>
        </form>

        <script>
          $('input[type="button"]').click(function(e){
           $(this).closest('tr').remove()
         })  
        </script>
    </center>
    </body>
</html>
