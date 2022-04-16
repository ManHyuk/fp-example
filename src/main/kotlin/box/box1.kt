package box

import box.model.Post

class Box<T>(val value: T) {

    companion object {
        fun<T> of(_value: T): Box<T> {
            return Box(_value)
        }

    }

    override fun toString(): String {
        return "Box($value)"
    }

    fun <T, R> map(fn: (T) -> R): Box<R> {
        return Box(fn(this.value as T))
    }
}


open class Maybe<T>(val value: T) {

    companion object {
        fun<T> of(_value: T): Maybe<T> {
            return Maybe(_value)
        }
    }

    override fun toString(): String {
        return "Maybe($value)"
    }

    fun isNothing(): Boolean {
        return this.value == null
    }

    fun <T, R> map(fn: (T) -> R): Maybe<R> {
        if (isNothing()) {
            return Maybe("Nothing" as R)
        }
        return Maybe(fn(this.value as T))
    }
}


data class Post(
    val id: Int,
    val title: String,
    val author: String = ""
)

fun main() {
    val posts = listOf(
        Post(id = 1, title = "kotlin is cool"),
        Post(id = 2, title = "java is not cool")
    )

    val startCase = { str: String -> str.get(0).toUpperCase() + str.substring(1) }
    val getTitle = { post: Post -> post.title }
    val findPostById = { id: Int, posts: List<Post> -> posts.find { post -> post.id == id } }


    fun getUpperPostTitleById(id: Int, posts: List<Post>): String? {
        val box = Box.of(posts)
        val post = findPostById(id, box.value)
        val title = post?.let { getTitle(it) }
        return title?.let { startCase(it) }
    }

    println(getUpperPostTitleById(1, posts))
    println(getUpperPostTitleById(2, posts))
//    println(getUpperPostTitleById("book3", posts))

//    val addFive = { num: Int -> num + 5 }
//    println(Box.of(1)
//        .map<Int, Int> { addFive(it) })

    fun getUpperPostTitleById2(id: Int, posts: List<Post>): Box<String> {
        return Box.of(posts)
            .map<List<Post>, Post?> { findPostById(id, it) }
            .map<Post?, String> { getTitle(it!!)}
            .map<String, String> { startCase(it)}
    }

    println("getUpperPostTitleById2() = ${getUpperPostTitleById2(2, posts)}")
    println("getUpperPostTitleById2() = ${getUpperPostTitleById2(2, posts)}")

    fun getUpperPostTitleById3(id: Int, posts: List<Post>): Maybe<String> {
        return Maybe.of(posts)
            .map<List<Post>, Post?> { findPostById(id, it) }
            .map<Post?, String> { getTitle(it!!)}
            .map<String, String> { startCase(it)}
    }
    println("getUpperPostTitleById3() = ${getUpperPostTitleById3(3, posts)}")


}




