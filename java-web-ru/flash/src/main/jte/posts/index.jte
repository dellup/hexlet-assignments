@import exercise.dto.posts.PostsPage
@import exercise.model.Post
@import exercise.util.NamedRoutes

@param PostsPage page

@template.layout.page(
    page = page,
    content = @`
@if (page.getPosts().isEmpty())
<p>Пользователей пока нет.</p>
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
    @for (Post post : page.getPosts())
    <tr>
        <th scope="row"><a href="${NamedRoutes.postPath(post.getId())}">${post.getId()}</a></th>
        <td>${post.getName()}</td>
        <td>${post.getBody()}</td>
    </tr>
    @endfor
    </tbody>
</table>

@endif
`
)