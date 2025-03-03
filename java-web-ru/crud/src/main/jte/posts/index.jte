@import exercise.dto.posts.PostsPage
@import exercise.model.Post
@import exercise.util.NamedRoutes
@param PostsPage postsPage
@param Long pageNum

@template.layout.page(
content = @`
<ul>
    @if (postsPage.getPosts() == null)
    <p>Такого курса нет или курсы еще не добавлены</p>
    @else
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Body</th>
        </tr>
        </thead>
        <tbody>
        @for (Post post : postsPage.getPosts())
        <tr>
            <th scope="row">${post.getId()}</th>
            <td><a href="${NamedRoutes.showPostPath(post.getId())}">${post.getName()}</a></td>
            <td>${post.getBody()}</td>
        </tr>
        @endfor
        </tbody>
    </table>
    <a href="${NamedRoutes.postsPath()}?page=${pageNum + 1}">Следующая</a>
    <a href="${NamedRoutes.postsPath()}?page=${pageNum - 1}">Предыдущая</a>

    @endif
</ul>
`
)