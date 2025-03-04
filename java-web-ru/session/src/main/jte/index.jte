@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(
    content = @`
        @if(page.getName() == null)
            <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
        @else
            <p>${(String) page.getName()}</p>
            <form action="${NamedRoutes.logoutPath()}" method="post">
                <p>Выйти</p>
                <input type="submit" />
            </form>
        @endif
    `
)