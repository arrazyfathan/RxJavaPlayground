package com.arrazyfathan.rxjavaplayground.operators

import com.arrazyfathan.rxjavaplayground.sample.data.User
import com.arrazyfathan.rxjavaplayground.sample.data.mUserList
import com.arrazyfathan.rxjavaplayground.sample.listNumber
import io.reactivex.rxjava3.core.Observable

/**
 * Created by Ar Razy Fathan Rabbani on 29/07/22.
 */

fun filterOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun lastOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}