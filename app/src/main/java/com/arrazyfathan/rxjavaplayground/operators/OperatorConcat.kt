package com.arrazyfathan.rxjavaplayground.operators

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.internal.operators.observable.ObservableRange

/**
 * Created by Ar Razy Fathan Rabbani on 02/08/22.
 */

fun getNumber1to100(): Observable<Int> {
    return Observable.range(1, 100 )
}

fun getNumber1to150(): Observable<Int> {
    return Observable.range(101, 50)
}

fun concatOperator(): Observable<Int> {
    return Observable.concat(getNumber1to100(), getNumber1to150())
}