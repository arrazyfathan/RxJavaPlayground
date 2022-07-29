package com.arrazyfathan.rxjavaplayground.operators

import com.arrazyfathan.rxjavaplayground.sample.listNumber
import io.reactivex.rxjava3.core.Observable

/**
 * Created by Ar Razy Fathan Rabbani on 29/07/22.
 */

fun skipOperator(): Observable<Int> {
    return Observable.fromIterable(listNumber)
}