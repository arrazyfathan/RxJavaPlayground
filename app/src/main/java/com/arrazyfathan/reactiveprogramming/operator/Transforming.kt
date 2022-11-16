package com.arrazyfathan.reactiveprogramming.operator

import com.arrazyfathan.reactiveprogramming.Student
import com.arrazyfathan.reactiveprogramming.utils.exampleOf
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject

/**
 * Created by Ar Razy Fathan Rabbani on 16/11/22.
 */

/*
* Transforming Element
*/
fun transformingToList() {
    exampleOf("toList") {
        val subs = CompositeDisposable()

        val items = Observable.just("A", "B", "C")
        subs.add(
            items
                .toList()
                .subscribeBy {
                    println(it)
                }
        )
    }
}

/*
* Map
* */
fun transformingUsingMap() {
    exampleOf("Map") {
        val subs = CompositeDisposable()
        val items = Observable.just("A", "B", "C")
        subs.add(
            items
                .map {
                    "Mr. $it"
                }
                .subscribeBy {
                    println(it)
                }
        )
    }
}

/*
* FlatMap
* flatMap transform and projects all the values from all the observables that it receive. It then flattens them
* all down to a target Observable.
*
* FlatMap keeps projecting changes from each Observable. There will be times when you want this behavior and there will be
* times where you only want to keep up with the latest element in the source obsevable.
* */
fun transformingUsingFlatMap() {
    exampleOf("Flat Map") {
        val subs = CompositeDisposable()
        val ryan = Student(BehaviorSubject.createDefault(80))
        val charlotte = Student(BehaviorSubject.createDefault(90))

        val student = PublishSubject.create<Student>()

        student
            .flatMap { it.score }
            .subscribe { println(it) }
            .addTo(subs)

        student.onNext(ryan)
        ryan.score.onNext(85)
        student.onNext(charlotte)
        ryan.score.onNext(95)
        charlotte.score.onNext(100)
    }
}

/*
* SwitchMap
* switch map takes a function which returns some type of reactive source ( a Completable, Observable, Single and so on)
* and applies that function to each items emitted by some source observable.
*
* the result of using switchMap is that the target observable only receives elements from the latest source observable
* that has emitted.
* */
fun transformingUsingSwitchMap() {
    exampleOf("Flat Map") {
        val subs = CompositeDisposable()
        val ryan = Student(BehaviorSubject.createDefault(80))
        val charlotte = Student(BehaviorSubject.createDefault(90))

        val student = PublishSubject.create<Student>()

        student
            .switchMap { it.score }
            .subscribe { println(it) }
            .addTo(subs)

        student.onNext(ryan)
        ryan.score.onNext(85)
        student.onNext(charlotte)
        ryan.score.onNext(95)
        charlotte.score.onNext(100)
    }
}

fun main() {
    transformingUsingSwitchMap()
}
