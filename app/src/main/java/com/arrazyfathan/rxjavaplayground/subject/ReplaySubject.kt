package com.arrazyfathan.rxjavaplayground.subject

import android.util.Log
import com.arrazyfathan.rxjavaplayground.MainActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.ReplaySubject
import java.util.concurrent.TimeUnit

/**
 * Created by Ar Razy Fathan Rabbani on 08/08/22.
 */

fun replaySubject() {
    val observable = Observable.interval(1, TimeUnit.SECONDS).takeWhile { it <= 5 }
        .observeOn(Schedulers.io())
        .subscribeOn(AndroidSchedulers.mainThread())

    val subject = ReplaySubject.create<Long>()
    observable.subscribe(subject)

    observable.subscribe(
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

    observable.subscribe(
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

    observable.subscribe(
        {
            Log.d(MainActivity.TAG, "onNext 3: $it")
        },
        {
            Log.d(MainActivity.TAG, "onError 3: $it")
        },
        {
            Log.d(MainActivity.TAG, "onComplete 3")
        }
    )
}

fun replaySubjectTwo() {
    val subject = ReplaySubject.create<Int>()
    subject.onNext(0)
    subject.onNext(1)

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

    subject.onNext(2)
    subject.onNext(3)

    subject.subscribe(
        {
            Log.d(MainActivity.TAG, "onNext 2 : $it")
        },
        {
            Log.d(MainActivity.TAG, "onError 2: $it")
        },
        {
            Log.d(MainActivity.TAG, "onComplete 2")
        }
    )
}
