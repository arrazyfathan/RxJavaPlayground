package com.arrazyfathan.rxjavaplayground.operators

import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by Ar Razy Fathan Rabbani on 29/07/22.
 */

fun timerOperator(): Observable<Long> {
    return Observable.timer(30, TimeUnit.SECONDS)
}