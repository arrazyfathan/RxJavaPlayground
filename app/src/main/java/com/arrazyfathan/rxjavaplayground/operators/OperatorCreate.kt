package com.arrazyfathan.rxjavaplayground.operators

import com.arrazyfathan.rxjavaplayground.sample.listNumber
import io.reactivex.rxjava3.core.Observable

/**
 * Created by Ar Razy Fathan Rabbani on 29/07/22.
 */

fun operatorCreate(): Observable<Int> {
    return Observable.create {
        try {
            for (i in listNumber) {
                it.onNext(i * 5)
            }

            it.onComplete()
        } catch (e: Exception) {
            it.onError(e)
        }
    }
}
