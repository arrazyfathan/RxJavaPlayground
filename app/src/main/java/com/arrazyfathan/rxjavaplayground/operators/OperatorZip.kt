package com.arrazyfathan.rxjavaplayground.operators

import com.arrazyfathan.rxjavaplayground.sample.data.*
import io.reactivex.rxjava3.core.Observable

/**
 * Created by Ar Razy Fathan Rabbani on 02/08/22.
 */

fun zipOperator(): Observable<Any> {
    val number = Observable.just(1, 2, 3, 4, 5)
    val character = Observable.just('a', 'b', 'c', 'd')
    return Observable.zip(number, character) { num, char ->
        "$num$char"
    }
}

fun getBlogs(): Observable<List<Blog>> {
    return Observable.just(mBlogList)
}

fun getUsers(): Observable<List<User>> {
    return Observable.just(mUserList)
}

fun zipGetUserAndGetBlogs(): Observable<List<BlogDetail>> {
    return Observable.zip(getUsers(), getBlogs()) { users, blogs ->
        blogDetail(users, blogs)
    }
}

fun blogDetail(users: List<User>, blogs: List<Blog>): List<BlogDetail> {
    val listBlogDetail = mutableListOf<BlogDetail>()
    users.forEach { user ->
        blogs.forEach { blog ->
            if (user.id == blog.userId) {
                listBlogDetail.add(
                    BlogDetail(
                        id = blog.id,
                        title = blog.title,
                        content = blog.content,
                        user = user,
                        userId = blog.userId
                    )
                )
            }
        }
    }
    return listBlogDetail
}
