package com.arrazyfathan.rxjavaplayground.operators

import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by Ar Razy Fathan Rabbani on 29/07/22.
 */

fun intervalOperator(): Observable<Long> {
    return Observable.interval(10,1, TimeUnit.SECONDS).takeWhile { value ->
        value < 5
    }
}