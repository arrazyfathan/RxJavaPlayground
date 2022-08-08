package com.arrazyfathan.rxjavaplayground.subject

import android.util.Log
import com.arrazyfathan.rxjavaplayground.MainActivity.Companion.TAG
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.AsyncSubject
import java.util.concurrent.TimeUnit

/**
 * Created by Ar Razy Fathan Rabbani on 04/08/22.
 */

fun asyncSubject() {
    val observable = Observable.interval(1, TimeUnit.SECONDS)
        .takeWhile {
            it <= 5
        }

    val subject = AsyncSubject.create<Long>()

    observable.subscribe(subject)

    subject.subscribe(
        {
            Log.d(TAG, "asyncSubjectOnNext: $it")
        },
        {
            Log.d(TAG, "asyncSubjectError: $it")
        },
        {
            Log.d(TAG, "asyncSubjectOnComplete")
        }
    )

    subject.subscribe(
        {
            Log.d(TAG, "asyncSubjectOnNext 2: $it")
        },
        {
            Log.d(TAG, "asyncSubjectError 2: $it")
        },
        {
            Log.d(TAG, "asyncSubjectOnComplete")
        }
    )
}
