@import exercise.dto.posts.PostPage
@param PostPage postPage
@template.layout.page(
    content = @`
        <h2>${postPage.getPost().getName()}</h2>
        <p>${postPage.getPost().getBody()}</p>
    `
)