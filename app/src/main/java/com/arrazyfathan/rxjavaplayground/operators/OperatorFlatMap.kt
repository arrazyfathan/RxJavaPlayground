package com.arrazyfathan.rxjavaplayground.operators

import com.arrazyfathan.rxjavaplayground.sample.data.User
import com.arrazyfathan.rxjavaplayground.sample.data.UserProfile
import com.arrazyfathan.rxjavaplayground.sample.data.mUserList
import com.arrazyfathan.rxjavaplayground.sample.data.mUserProfileList
import io.reactivex.rxjava3.core.Observable

/**
 * Created by Ar Razy Fathan Rabbani on 29/07/22.
 */

fun flatMapOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun getUserProfile(id: Long): Observable<UserProfile> {
    return Observable.fromIterable(mUserProfileList).filter {
        it.id == id
    }
}
