package com.arrazyfathan.rxjavaplayground.operators

import com.arrazyfathan.rxjavaplayground.sample.data.User
import com.arrazyfathan.rxjavaplayground.sample.data.mUserList
import io.reactivex.rxjava3.core.Observable

/**
 * Created by Ar Razy Fathan Rabbani on 29/07/22.
 */

fun distinctOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}