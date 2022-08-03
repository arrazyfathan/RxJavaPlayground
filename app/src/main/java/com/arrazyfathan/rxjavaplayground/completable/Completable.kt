package com.arrazyfathan.rxjavaplayground.completable

import android.util.Log
import com.arrazyfathan.rxjavaplayground.MainActivity
import com.arrazyfathan.rxjavaplayground.MainActivity.Companion.TAG
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.CompletableObserver
import io.reactivex.rxjava3.disposables.Disposable

/**
 * Created by Ar Razy Fathan Rabbani on 03/08/22.
 */

fun createCompletableObservable(): Completable {
    return Completable.create { emitter ->
        try {
            if (!emitter.isDisposed) {
                getLocation()
                emitter.onComplete()
            }
        } catch (e: Exception) {
            emitter.onError(e)
        }
    }
}

fun observerCompletable(): CompletableObserver {
    return object : CompletableObserver {
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG, "onSubscribe")
        }

        override fun onComplete() {
            Log.d(TAG, "onComplete")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "onError : $e")
        }
    }
}

private fun getLocation() {
    Thread.sleep(2000)
    // throw Exception("Error getting a location")
    Log.d(
        MainActivity.TAG,
        "Latitude: ${120}.${(100..900).random()}, Longitude: ${177}.${(100..900).random()}"
    )
}
