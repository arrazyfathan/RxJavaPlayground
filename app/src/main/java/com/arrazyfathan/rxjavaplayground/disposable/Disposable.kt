package com.arrazyfathan.rxjavaplayground.disposable

import android.util.Log
import com.arrazyfathan.rxjavaplayground.MainActivity
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.lang.Exception

/**
 * Created by Ar Razy Fathan Rabbani on 03/08/22.
 */

lateinit var disposable: Disposable

fun createObservableDisposable(): Observable<Int> {
    return Observable.create { emitter ->
        try {
            if (!emitter.isDisposed) {
                for (i in 1..100000) {
                    emitter.onNext(i)
                }

                emitter.onComplete()
            }
        } catch (e: Exception) {
            emitter.onError(e)
        }
    }
}

fun observerDisposable(): Observer<Int> {
    return object : Observer<Int> {
        override fun onSubscribe(d: Disposable) {
            d.let {
                disposable = d
            }
            Log.d(MainActivity.TAG, "onSubscribe")
        }

        override fun onNext(t: Int) {
            Log.d(MainActivity.TAG, "onNext: $t")
        }

        override fun onError(e: Throwable) {
            Log.d(MainActivity.TAG, "onError: $e")
        }

        override fun onComplete() {
            Log.d(MainActivity.TAG, "onComplete")
        }
    }
}