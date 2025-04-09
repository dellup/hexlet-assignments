@import gg.jte.Content
@param Content content


<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
    <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
        <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">Перейти на главную</a>
        <ul class="nav-pills nav">
            <li class="nav-item">
                <a class="nav-link" href="/users">Все пользователи</a>
            </li>
        </ul>
    </header>
    <main>
        ${content}
    </main>
    <footer>
        <div class="py-3 my-4">
            <a class="nav-link" href="https://github.com/dellup">Ссылка на гит</a>
        </div>
    </footer>
</body>
</html>