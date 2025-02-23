@import exercise.dto.users.UsersPage
@import exercise.model.User
@param UsersPage page


<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>${page.getHeader()}</title>
</head>
<body>
    <ul>
        @if (page.getList().isEmpty())
            <p>Пользователей пока нет.</p>
        @else
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">FirstName</th>
                    <th scope="col">LastName</th>
                    <th scope="col">Email</th>
                </tr>
                </thead>
                <tbody>
                @for (User user : page.getList())
                    <tr>
                        <th scope="row"><a href="/users/${user.getId()}">${user.getId()}</a></th>
                        <td>${user.getFirstName()}</td>
                        <td>${user.getLastName()}</td>
                        <td>${user.getEmail()}</td>
                    </tr>
                @endfor
                </tbody>
            </table>

        @endif
    </ul>
</body>
</html>