package box

import arrow.core.Either
import arrow.core.curried

//data class Post(
//    val id: Int,
//    val title: String,
//    val author: String
//)

val posts: List<Post> = listOf(
    Post(id = 1, title = "kotlin is coooool", author = "manhyuk"),
    Post(id = 2, title = "java is dead", author = "sujin")
)



val findPostById = {id: Int, posts: List<Post> -> posts.find { it.id == id }}

fun validatePostAuthor(post: Post?): Maybe<Post?> {
    if (post == null) {
        return Maybe.of(null)
    }
    val isContained = post.author.contains("manhyuk")
    if (isContained) {
        return Maybe.of(post)
    }
    return Maybe.of(null)
}

fun logBookAuthor(id: Int, posts: List<Post>): Maybe<Post?> {
    val findPost = findPostById(id, posts)
    return validatePostAuthor(findPost)
}


fun logBookAuthorWithHandling(id: Int, posts: List<Post>) {
    val findPost = findPostById(id, posts)
    val validatedPost = validatePostAuthor(findPost)
    logByMaybeStatus(validatedPost)
}

fun logByMaybeStatus(maybePost: Maybe<Post?>) {
    if (maybePost.isNothing()) {
        println("error")
    } else {
        println("success = $maybePost")
    }
}

fun validatePostAuthorWithEiter(post: Post?): Either<Post?, Post> {
    if (post == null) {
        return Either.Left(post)
    }
    val isContained = post.author.contains("manhyuk")
    if (isContained) {
        return Either.Right(post)
    }
    return Either.Left(post)
}

fun logByEitherStatus(eitherPost: Either<Post?, Post>) {
    if (eitherPost.isLeft()) {
        println("error = $eitherPost")
    } else {
        println("success = $eitherPost")
    }
}

fun logPostAuthor(id: Int, posts: List<Post>) {
    val findPost = findPostById(id, posts)
    val validated = validatePostAuthorWithEiter(findPost)
    logByEitherStatus(validated)
}


val concat = {str1: String, str2: String -> "$str1$str2"}
fun main() {
//    println("logBookAuthor(posts = posts) = ${logBookAuthor(id = 1, posts = posts)}")
//    println("logBookAuthor(posts = posts) = ${logBookAuthor(id = 3, posts = posts)}")
//    logBookAuthorWithHandling(id = 1, posts = posts)
//    logBookAuthorWithHandling(id = 3, posts = posts)
//    println(Either.Right("kotlin").map { concat(it, " is cool")})
//    println(Either.Left("java").map { concat(it, " is dead") })

    logPostAuthor(id = 1, posts = posts)
    logPostAuthor(id = 2, posts = posts)

}
