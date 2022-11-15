package com.arrazyfathan.reactiveprogramming

import com.arrazyfathan.reactiveprogramming.utils.exampleOf
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import java.io.File
import java.io.FileNotFoundException
import kotlin.math.roundToInt

/**
 * Created by Ar Razy Fathan Rabbani on 15/11/22.
 */

fun main() {
    exampleOf("just") {
        val observable = Observable.just(listOf(1, 2, 3))
    }

    exampleOf("fromIterable") {
        val observable: Observable<Int> = Observable.fromIterable(listOf(1, 2, 3, 4))

        observable.subscribe {
            println(it)
        }
    }

    exampleOf("empty") {
        val observable = Observable.empty<Unit>()

        observable.subscribeBy(
            onNext = {
                println(it)
            },
            onComplete = {
                println("Completed")
            }
        )
    }

    exampleOf("never") {
        val observable = Observable.never<Any>()

        observable.subscribeBy(
            onNext = { println(it) },
            onComplete = { println("onCompleted") }
        )
    }

    exampleOf("range") {
        val observable: Observable<Int> = Observable.range(1, 10)
        observable.subscribe {
            val n = it.toDouble()
            val fibonacci = ((Math.pow(1.61803, n) - Math.pow(0.61803, n)) / 2.23606).roundToInt()
            println(fibonacci)
        }
    }

    exampleOf("dispose") {
        val mostPopular: Observable<String> = Observable.just("A", "B", "C")
        val subs = mostPopular.subscribe {
            println(it)
        }

        subs.dispose()
    }

    exampleOf("CompositeDisposable") {
        val subs = CompositeDisposable()
        val disposable = Observable.just("A", "B", "C")
            .subscribe {
                println(it)
            }

        subs.add(disposable)
        subs.dispose()
    }

    exampleOf("create") {
        val disposable = CompositeDisposable()
        val observable = Observable.create<String> { emitter ->
            emitter.onNext("1")
            emitter.onComplete()
            emitter.onNext("?")
            emitter.onError(RuntimeException("Error"))
        }
            .subscribeBy(
                onNext = { println(it) },
                onError = { println("Error") },
                onComplete = { println("Completed") }
            )
        disposable.add(observable)
        disposable.dispose()
    }

    exampleOf("defer") {
        val disposable = CompositeDisposable()
        var flip = false

        val factory: Observable<Int> = Observable.defer {
            flip = !flip
            if (flip) {
                Observable.just(1, 2, 3)
            } else {
                Observable.just(4, 5, 6)
            }
        }

        for (i in 0..3) {
            disposable.add(
                factory.subscribe {
                    println(it)
                }
            )
        }

        disposable.dispose()
    }

    exampleOf("Single") {
        val subs = CompositeDisposable()
        fun loadText(fileName: String): Single<String> {
            return Single.create create@{ emitter ->
                val file = File(fileName)
                if (!file.exists()) {
                    emitter.onError(FileNotFoundException("can't find $fileName"))
                    return@create
                }

                val contents = file.readText(Charsets.UTF_8)
                emitter.onSuccess(contents)
            }
        }

        val observer = loadText("File.txt")
            .subscribeBy(
                onSuccess = { println(it) },
                onError = { println("Error, $it") }
            )
        subs.add(observer)
    }
}
