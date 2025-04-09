@import exercise.dto.users.UsersPage
@import exercise.model.User
@param UsersPage page

@template.layout.page(
    content = @`
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
            @for(User user : page.getUsers())
                <tr>
                    <th scope="row"><a href="users/${user.getId()}">${user.getId()}</a></th>
                    <td>${user.getFirstName()}</td>
                    <td>${user.getLastName()}</td>
                    <td>${user.getEmail()}</td>
                </tr>
            @endfor
            </tbody>
        </table>
    `
)