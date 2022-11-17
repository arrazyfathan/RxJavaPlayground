package com.arrazyfathan.reactiveprogramming.operator

import com.arrazyfathan.reactiveprogramming.utils.exampleOf
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.subjects.PublishSubject

/**
 * Created by Ar Razy Fathan Rabbani on 16/11/22.
 */

/*
* Prefixing and Concatenating
*/

/*
* startWith
* create emits the initial values, followed by the values from the original observable.
*/
fun combiningUsingStartWith() {
    exampleOf("startWith") {
        val disposable = CompositeDisposable()
        val missingNumber = Observable.just(3, 4, 5)
        val completeSet = missingNumber.startWithIterable(listOf(1, 2))
        completeSet
            .subscribe { number ->
                println(number)
            }
            .addTo(disposable)
    }
}

/*
* Concat
*/
fun combiningUsingConcat() {
    exampleOf("Concat") {
        val disposable = CompositeDisposable()
        val first = Observable.just(1, 2, 3)
        val second = Observable.just(4, 5, 6)

        Observable.concat(first, second)
            .subscribe {
                println(it)
            }
            .addTo(disposable)
    }
}

/*
* concatWith
*/
fun combiningUsingConcatWith() {
    exampleOf("concatWith") {
        val disposable = CompositeDisposable()
        val germanCities = Observable.just("Berlin", "Munich", "Frankfruit")
        val spanishCities = Observable.just("Madrid", "Barcelona", "Valencia")

        germanCities
            .concatWith(spanishCities)
            .subscribeBy { cities ->
                println(cities)
            }
            .addTo(disposable)
    }
}

/*
* ConcatMap
* */
fun combiningUsingConcatMap() {
    exampleOf("concatMap") {
        val disposable = CompositeDisposable()

        val countries = Observable.just("Germany", "Spain")

        val observable = countries
            .concatMap {
                when (it) {
                    "Germany" -> {
                        Observable.just("Berlin", "Munich", "Frankfruit")
                    }
                    "Spain" -> {
                        Observable.just("Madrid", "Barcelona", "Valencia")
                    }
                    else -> Observable.empty()
                }
            }

        observable.subscribeBy { cities ->
            println(cities)
        }.addTo(disposable)
    }
}

/*
* combiningLatest
* combines values from several sequences
*/
fun combiningUsingCombineLatest() {
    exampleOf("combineLatest") {
        val disposable = CompositeDisposable()
        val left = PublishSubject.create<String>()
        val right = PublishSubject.create<String>()

        Observable.combineLatest(left, right) { leftElement, rightElement ->
            "$leftElement $rightElement"
        }
            .subscribe {
                println(it)
            }
            .addTo(disposable)

        left.onNext("1")
        right.onNext("4")
        right.onNext("5")
        left.onNext("2")
        right.onNext("6")
        left.onNext("3")
    }
}

/*
* Zip
* */
fun combiningUsingZip() {
    exampleOf("Zip") {
        val disposable = CompositeDisposable()
        val left = PublishSubject.create<String>()
        val right = PublishSubject.create<String>()

        Observable.zip(left, right) { weather, city ->
            "It's $weather in $city"
        }.subscribeBy {
            println(it)
        }.addTo(disposable)

        left.onNext("Sunny")
        right.onNext("Lisbon")
        left.onNext("Cloudy")
        right.onNext("Copenhegen")
        left.onNext("Cloudy")
        right.onNext("London")
        left.onNext("Sunny")
        right.onNext("Madrid")
        right.onNext("Vienna")
    }
}

/*
* withLatestFrom
*
* */
fun triggerUsingWithLatestFrom() {
    exampleOf("withLatestFrom") {
        val disposable = CompositeDisposable()
        val button = PublishSubject.create<Unit>()
        val editText = PublishSubject.create<String>()

        button.withLatestFrom(editText) { _, value: String ->
            value
        }.subscribe {
            println(it)
        }.addTo(disposable)

        editText.onNext("Par")
        editText.onNext("Pari")
        editText.onNext("Paris")
        button.onNext(Unit)
        button.onNext(Unit)
    }
}

fun sampleWithLatestFrom() {
    exampleOf("Sample") {
        val disposable = CompositeDisposable()

        val button = PublishSubject.create<Unit>()
        val editText = PublishSubject.create<String>()

        editText.sample(button)
            .subscribeBy {
                println(it)
            }
            .addTo(disposable)

        editText.onNext("Par")
        editText.onNext("Pari")
        editText.onNext("Paris")
        button.onNext(Unit)
        button.onNext(Unit)
    }
}

/*
* reduce
* reduce produces it summary (accumuated) value only when the source Observable Completes.
* Applying this operator sequence that never complete wont emit anything.
* Output : 30
* */
fun combiningUsingReduce() {
    exampleOf("reduce") {
        val disposable = CompositeDisposable()

        val source = Observable.just(1, 3, 5, 7, 9)
        source
            .reduce(5) { a, b -> a + b }
            .subscribeBy(
                onSuccess = { println(it) }
            )
            .addTo(disposable)
    }
}

/*
* Scan
* Output : 0 -> 1 -> 4 -> 9 -> 16 -> 25
* */
fun combiningUsingScan() {
    exampleOf("Scan") {
        val disposable = CompositeDisposable()
        val source = Observable.just(1, 3, 5, 7, 9)
        source
            .scan(0) { a, b -> a + b }
            .subscribeBy {
                println(it)
            }
            .addTo(disposable)
    }
}

fun main() {
    combiningUsingScan()
}
