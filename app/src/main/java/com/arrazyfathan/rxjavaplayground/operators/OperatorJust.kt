package com.arrazyfathan.rxjavaplayground.operators

import android.util.Log
import com.arrazyfathan.rxjavaplayground.MainActivity
import com.arrazyfathan.rxjavaplayground.sample.listNumber
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

fun justOperator() {
    val observable = Observable.just(listNumber)
        .delay(5, TimeUnit.SECONDS)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    val observer = object : Observer<List<Int>> {
        override fun onSubscribe(d: Disposable) {
            Log.d(MainActivity.TAG, "onSubscribe")
        }

        override fun onNext(t: List<Int>) {
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
