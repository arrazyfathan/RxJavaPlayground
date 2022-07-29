package com.arrazyfathan.rxjavaplayground.operators

import android.util.Log
import com.arrazyfathan.rxjavaplayground.MainActivity
import com.arrazyfathan.rxjavaplayground.sample.listNumber
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

fun fromIterableOperator() {
    val observable = Observable.fromIterable(listNumber)

    val observer = object : Observer<Int> {
        override fun onSubscribe(d: Disposable) {
            Log.d(MainActivity.TAG, "onSubscribe")
        }

        override fun onNext(t: Int) {
            Log.d(MainActivity.TAG, "onNext : $t")
        }

        override fun onError(e: Throwable) {
            Log.d(MainActivity.TAG, "onError: $e")
        }

        override fun onComplete() {
            Log.d(MainActivity.TAG, "onComplete")
        }
    }

    observable.subscribe(observer)
}
