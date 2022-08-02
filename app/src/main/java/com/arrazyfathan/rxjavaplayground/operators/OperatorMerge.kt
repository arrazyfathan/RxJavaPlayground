package com.arrazyfathan.rxjavaplayground.operators

import com.arrazyfathan.rxjavaplayground.sample.data.User
import com.arrazyfathan.rxjavaplayground.sample.data.UserProfile
import com.arrazyfathan.rxjavaplayground.sample.data.mUserList
import com.arrazyfathan.rxjavaplayground.sample.data.mUserProfileList
import io.reactivex.rxjava3.core.Observable

/**
 * Created by Ar Razy Fathan Rabbani on 02/08/22.
 */

fun getUser(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun getProfile(): Observable<UserProfile> {
    return Observable.fromIterable(mUserProfileList)
}

fun mergeOperator(): Observable<Any> {
    return Observable.merge(getProfile(), getUser())
}