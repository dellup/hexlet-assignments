<!-- BEGIN -->
@import exercise.dto.BasePage
@import gg.jte.Content
@param BasePage page = null
@param Content content

<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
    <main>
        @if(page != null)
            @if(page.getFlash() != null)
            <div class="alert alert-success" role="alert">
                ${page.getFlash().toString()}
            </div>
            @endif
        @endif

        <div class="container">
            ${content}
        </div>
    </main>
</body>
</html>
<!-- END -->
