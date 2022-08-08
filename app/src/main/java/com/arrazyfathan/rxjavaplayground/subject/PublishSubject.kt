package com.arrazyfathan.rxjavaplayground.subject

import android.util.Log
import com.arrazyfathan.rxjavaplayground.MainActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit

/**
 * Created by Ar Razy Fathan Rabbani on 08/08/22.
 */

fun publishSubject() {
    val observable = Observable.interval(1, TimeUnit.SECONDS).takeWhile {
        it <= 5
    }
        .subscribeOn(Schedulers.io())
        .subscribeOn(AndroidSchedulers.mainThread())

    val subject = PublishSubject.create<Long>()

    observable.subscribe(subject)

    subject.subscribe(
        {
            Log.d(MainActivity.TAG, "onNext: $it")
        },
        {
            Log.d(MainActivity.TAG, "onError: $it")
        },
        {
            Log.d(MainActivity.TAG, "onComplete")
        }
    )

    subject.subscribe(
        {
            Log.d(MainActivity.TAG, "onNext 2: $it")
        },
        {
            Log.d(MainActivity.TAG, "onError 2: $it")
        },
        {
            Log.d(MainActivity.TAG, "onComplete 2")
        }
    )
}

fun publishSubjectTwo() {
    val subject = PublishSubject.create<Int>()

    subject.subscribe(
        {
            Log.d(MainActivity.TAG, "onNext: $it")
        },
        {
            Log.d(MainActivity.TAG, "onError: $it")
        },
        {
            Log.d(MainActivity.TAG, "onComplete")
        }
    )

    subject.onNext(0)
    subject.onNext(1)
}
