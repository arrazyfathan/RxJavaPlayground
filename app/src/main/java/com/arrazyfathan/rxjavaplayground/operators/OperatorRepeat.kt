package com.arrazyfathan.rxjavaplayground.operators

import io.reactivex.rxjava3.core.Observable

/**
 * Created by Ar Razy Fathan Rabbani on 29/07/22.
 */

fun repeatOperator(): Observable<Int> {
    return Observable.range(1,5).repeat(2)
}