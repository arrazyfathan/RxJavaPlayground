package com.arrazyfathan.rxjavaplayground.observable

import android.util.Log
import com.arrazyfathan.rxjavaplayground.MainActivity.Companion.TAG
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.lang.Exception

/**
 * Created by Ar Razy Fathan Rabbani on 02/08/22.
 */

fun createObservable(): Observable<Int> {
    return Observable.create { emitter ->
        try {
            if (!emitter.isDisposed) {
                for (i in 1..100) {
                    emitter.onNext(i)
                }

                emitter.onComplete()
            }
        } catch (e: Exception) {
            emitter.onError(e)
        }
    }
}

fun observer(): Observer<Int> {
    return object : Observer<Int> {
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG, "onSubscribe")
        }

        override fun onNext(t: Int) {
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
