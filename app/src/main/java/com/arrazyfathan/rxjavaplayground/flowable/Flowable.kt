package com.arrazyfathan.rxjavaplayground.flowable

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable

/**
 * Created by Ar Razy Fathan Rabbani on 03/08/22.
 */

fun createFlowable(): Flowable<Int> {
    return Flowable.range(1, 100)
}

fun createFlowableTwo(): Observable<Int> {
    return Observable.range(1, 100)
}