package com.arrazyfathan.rxjavaplayground.single

import android.util.Log
import com.arrazyfathan.rxjavaplayground.MainActivity.Companion.TAG
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable

/**
 * Created by Ar Razy Fathan Rabbani on 02/08/22.
 */

fun createSingleObservable(): Single<Int> {
    return Single.create { emitter ->
        try {
            if (!emitter.isDisposed) {
                for (i in 1..100) {
                    emitter.onSuccess(i)
                }
            }
        } catch (e: Exception) {
            emitter.onError(e)
        }
    }
}

fun observeSingle(): SingleObserver<Int> {
    return object : SingleObserver<Int> {
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG, "onSubscribe")
        }

        override fun onSuccess(t: Int) {
            Log.d(TAG, "onSuccess: $t")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "onError: $e")
        }
    }
}
