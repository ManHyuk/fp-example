package box

class CEither<A, B>() {
    companion object {
        fun<A> left(_value: A): Left<A> {
            return Left(_value)
        }
        fun<B> right(_value: B): Right<B> {
            return Right(_value)
        }
    }


    class Left<A>(val value: A) {

        fun isRight(): Boolean {
            return false
        }
        fun isLeft(): Boolean {
            return true
        }


        fun<T, R> map(fn: (T) -> R): Left<T> {
            return Left(this as T)
        }
    }

    class Right<B>(val value: B) {
        fun isRight(): Boolean {
            return true
        }
        fun isLeft(): Boolean {
            return false
        }

        fun<T, R> map(fn: (T) -> R): Right<R> {
            return Right(fn(this.value as T))
        }
    }
}


