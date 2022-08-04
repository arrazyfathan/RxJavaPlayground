package com.arrazyfathan.rxjavaplayground.cold

import android.util.Log
import com.arrazyfathan.rxjavaplayground.MainActivity.Companion.TAG
import com.arrazyfathan.rxjavaplayground.sample.data.User
import com.arrazyfathan.rxjavaplayground.sample.data.mUserList
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

/**
 * Created by Ar Razy Fathan Rabbani on 04/08/22.
 */

fun coldObservable(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun coldObserver(): Observer<User> {
    return object : Observer<User> {
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG, "onSubscribe")
        }

        override fun onNext(t: User) {
            Log.d(TAG, "onNext: $t")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "onError: $e")
        }

        override fun onComplete() {
            Log.d(TAG, "onComplete")
        }
    }
}
