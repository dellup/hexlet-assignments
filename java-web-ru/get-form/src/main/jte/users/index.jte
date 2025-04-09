@import exercise.dto.users.UsersPage
@import exercise.model.User
@param UsersPage usersPage

@template.layout.page (
    content = @`
        <form action="/users" method="get">
            <input type="search" required name="term" value="${usersPage.getTerm()}">
            <input type="submit" value="Искать">
        </form>
        @if(!(usersPage.getUsers().isEmpty()))
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">First name</th>
                    <th scope="col">Last name</th>
                    <th scope="col">Email</th>
                </tr>
                </thead>
                <tbody>
                @for (User user : usersPage.getUsers())
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

    `
)