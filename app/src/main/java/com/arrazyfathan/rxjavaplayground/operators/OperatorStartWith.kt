package com.arrazyfathan.rxjavaplayground.operators

import com.arrazyfathan.rxjavaplayground.sample.data.User
import com.arrazyfathan.rxjavaplayground.sample.data.mUserList
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

/**
 * Created by Ar Razy Fathan Rabbani on 02/08/22.
 */

fun startWithOperator(): Observable<User> {
    return Observable.fromIterable(mUserList).startWith(Single.just(User(0L, "0", 0)))
}
