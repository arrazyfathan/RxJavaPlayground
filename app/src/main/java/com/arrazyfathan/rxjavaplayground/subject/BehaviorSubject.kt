package com.arrazyfathan.rxjavaplayground.subject

import android.util.Log
import com.arrazyfathan.rxjavaplayground.MainActivity
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import java.util.concurrent.TimeUnit

/**
 * Created by Ar Razy Fathan Rabbani on 08/08/22.
 */

fun behaviorSubject() {
    val observable = Observable.interval(1, TimeUnit.SECONDS).takeWhile {
        it <= 5
    }
    val behaviorSubject = BehaviorSubject.create<Long>()
    observable.subscribe(behaviorSubject)

    behaviorSubject.subscribe(
        {
            Log.d(MainActivity.TAG, "behaviorSubjectOnNext: $it")
        },
        {
            Log.d(MainActivity.TAG, "behaviorSubjectError: $it")
        },
        {
            Log.d(MainActivity.TAG, "behaviorSubjectComplete")
        }
    )

    behaviorSubject.subscribe(
        {
            Log.d(MainActivity.TAG, "behaviorSubjectOnNext Two: $it")
        },
        {
            Log.d(MainActivity.TAG, "behaviorSubjectError Two: $it")
        },
        {
            Log.d(MainActivity.TAG, "behaviorSubjectComplete Two")
        }
    )
}

fun behaviorSubjectTwo() {
    val subject = BehaviorSubject.create<Int>()
    subject.onNext(0)

    subject.subscribe(
        {
            Log.d(MainActivity.TAG, "behaviorSubjectOnNext: $it")
        },
        {
            Log.d(MainActivity.TAG, "behaviorSubjectError: $it")
        },
        {
            Log.d(MainActivity.TAG, "behaviorSubjectComplete")
        }
    )

    subject.onNext(1)
    subject.onNext(2)

    subject.subscribe(
        {
            Log.d(MainActivity.TAG, "behaviorSubjectOnNext Two: $it")
        },
        {
            Log.d(MainActivity.TAG, "behaviorSubjectError Two: $it")
        },
        {
            Log.d(MainActivity.TAG, "behaviorSubjectComplete Two")
        }
    )
}
