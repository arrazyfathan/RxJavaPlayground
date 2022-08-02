package com.arrazyfathan.rxjavaplayground.maybe

import android.util.Log
import com.arrazyfathan.rxjavaplayground.MainActivity.Companion.TAG
import com.arrazyfathan.rxjavaplayground.sample.data.User
import com.arrazyfathan.rxjavaplayground.sample.data.mUserList
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.MaybeObserver
import io.reactivex.rxjava3.disposables.Disposable

/**
 * Created by Ar Razy Fathan Rabbani on 02/08/22.
 */

fun createMaybe(): Maybe<List<User>> {
    return Maybe.just(mUserList)
}

fun observeMaybe(): MaybeObserver<List<User>> {
    return object : MaybeObserver<List<User>> {
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG, "onSubscribe")
        }

        override fun onSuccess(t: List<User>) {
            t.forEach { user ->
                Log.d(TAG, "onSuccess: $user")
            }
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "onError: $e")
        }

        override fun onComplete() {
            Log.d(TAG, "onComplete")
        }
    }
}
