package com.arrazyfathan.rxjavaplayground.hot

import com.arrazyfathan.rxjavaplayground.sample.data.User
import com.arrazyfathan.rxjavaplayground.sample.data.mUserList
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observables.ConnectableObservable

/**
 * Created by Ar Razy Fathan Rabbani on 04/08/22.
 */

fun hotObservable(): ConnectableObservable<User> {
    return Observable.fromIterable(mUserList).publish()
}

