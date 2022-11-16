package com.arrazyfathan.reactiveprogramming.operator

import com.arrazyfathan.reactiveprogramming.utils.exampleOf
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.subjects.PublishSubject

/**
 * Created by Ar Razy Fathan Rabbani on 16/11/22.
 */

/*
* Ignored Element
* Ignore next event element
* Ignore element is useful when you only want to be notified when an observable has terminated
* via onComplete or onError
* */
fun operatorIgnoredElement() {
    exampleOf("Ignored Element") {
        val subscriptions = CompositeDisposable()

        val strikes = PublishSubject.create<String>()

        subscriptions.add(
            strikes.ignoreElements()
                .subscribeBy {
                    println("You are out")
                }
        )

        strikes.onNext("X")
        strikes.onNext("X")
        strikes.onNext("X")
        strikes.onComplete()
    }
}

/*
* Operator elementAt
* Operator elementAt takes the index of the element you want to receive and it ignores everything else
*  */
fun operatorElementAt() {
    exampleOf("Operator elementAt") {
        val subscriptions = CompositeDisposable()
        val strikes = PublishSubject.create<String>()
        subscriptions.add(
            strikes.elementAt(2)
                .subscribeBy(
                    onSuccess = { println("You are out!, $it") }
                )
        )

        strikes.onNext("1")
        strikes.onNext("2")
        strikes.onNext("3")
        strikes.onNext("4")
    }
}

/*
* Filter Element
* Filter takes a predicate lambda, which applies to each element. allowing through only those element for which the predicate resolve true
* */
fun operatorFilter() {
    exampleOf("Filter") {
        val subscription = CompositeDisposable()
        subscription.add(
            Observable.fromIterable(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
                .filter { number ->
                    number % 2 == 0
                }
                .subscribeBy {
                    println(it)
                }
        )
    }
}

/*
* Skipping Operator
* Skip operator allows you to ignore from the first to the number you pass as its parameters
* */
fun operatorSkip() {
    exampleOf("Skip") {
        val compositeDisposable = CompositeDisposable()
        compositeDisposable.add(
            Observable.just("A", "B", "C", "D", "E", "F", "G")
                .skip(3)
                .subscribeBy {
                    println(it)
                }
        )
    }
}

/*
* SkipWhile Operator
* Like filter skipWhile lets you include a predicate to determine what should be skipped.
* */
fun operatorSkipWhile() {
    exampleOf("Skip While") {
        val subscription = CompositeDisposable()
        subscription.add(
            Observable.just(2, 3, 2, 3, 4)
                .skipWhile { number ->
                    number % 2 == 0
                }
                .subscribeBy { result ->
                    println(result)
                }
        )
    }
}

/*
* Skip Until Operator
* Will keep skipping elements from the source observable ( the one you are subscibing to ) until some other trigger observable emits.
* */
fun operatorSkipUntil() {
    exampleOf("Skip Until") {
        val subscription = CompositeDisposable()
        val subject = PublishSubject.create<String>()
        val trigger = PublishSubject.create<String>()

        subscription.add(
            subject.skipUntil(trigger)
                .subscribeBy {
                    println(it)
                }
        )

        subject.onNext("A")
        subject.onNext("B")
        trigger.onNext("X")
        subject.onNext("C")
    }
}

/*
* Taking Operator
* Taking is the opposite of skipping. When you want to only take certain element, RxJava has you covered.
* */
fun operatorTake() {
    exampleOf("Take Operator") {
        val subscription = CompositeDisposable()
        subscription.add(
            Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .take(3)
                .subscribeBy {
                    println(it)
                }
        )
    }
}

/*
* TakeWhile
* takeWhile works simililary to skipWhile except youre taking instead of skipping.
* */
fun operatorTakingWhile() {
    exampleOf("takeWhile") {
        val subscription = CompositeDisposable()
        subscription.add(
            Observable.fromIterable(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1))
                .takeWhile { number ->
                    number < 5
                }
                .subscribeBy {
                    println(it)
                }
        )
    }
}

/*
* takeUntil operator
* */
fun operatorTakeUntil() {
    exampleOf("Take Until") {
        val subscription = CompositeDisposable()
        val subject = PublishSubject.create<String>()
        val trigger = PublishSubject.create<String>()

        subscription.add(
            subject.takeUntil(trigger)
                .subscribeBy {
                    println(it)
                }
        )

        subject.onNext("1")
        subject.onNext("2")
        subject.onNext("3")
        subject.onNext("3")
        trigger.onNext("X")
        subject.onNext("3")
        subject.onNext("3")
    }
}

/*
* Distinct Until Change Operator
* prevent duplicate items one after another form getting through. Distinct until change only prevents duplicate that right next to each other.
* disticntUntilChange only prevent contiguous duplicates.
* */
fun operatorDistinctUntilChange() {
    exampleOf("distinctUntilChange") {
        val subscriptions = CompositeDisposable()
        subscriptions.add(
            Observable.just("Dog", "Cat", "Cat", "Dog")
                .distinctUntilChanged()
                .subscribeBy {
                    println(it)
                }
        )
    }
}

/*
* DistictUntilChange Predicate
* */
fun operatorDistinctUntilChangePredicate() {
    exampleOf("DistinctUntilChangePredicate") {
        val subs = CompositeDisposable()
        subs.add(
            Observable.just("ABC", "BCD", "CDE", "FGH", "IJK", "JKL", "LMN")
                .distinctUntilChanged { first, second ->
                    second.any { it in first }
                }
                .subscribeBy {
                    println(it)
                }
        )
    }
}

/*                  Key Points
*
* Ignoring : operator like ignoreElement , elementAt, and filter let you remove certain element from an observable stream
* Skipping : operators let you skip certain elements and then begin emitting
* Conversely : taking operators let you take certain elements and then stop emitting
* Distinct : operators let you prevent duplicates from being emitted back-to-back in observable stream.
* */
fun main() {
    operatorDistinctUntilChangePredicate()
}
