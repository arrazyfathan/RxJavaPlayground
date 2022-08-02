# RxJavaPlayground
Source : RxJava For Beginner Full Course | https://youtu.be/AppSgPnM7-U



## What is RxJava?
RxJava is a Java VM implementation of Reactive Extension. Reactive Extension is a library for composing asynchronous and event-based program by using observable sequences. ([Reactivex](https://reactivex.io/))

## Three O of RxJava
1. Observable : It does some work and emits some values
2. Operator : It translate or modifies data from one to another form
3. Observer : Get those values that are coming from the observable


## Observable<>Observer
The observer that emits more than one value.<br>
Use case:<br>
If the user want to donwload a file from the internet, he should be provide with the progress of the download. In this case, the Observable has to emit values at regular intervals. In ths case we can use this Observable.

## Single<>SingleObserver
Single is used when the Observable has to emit only one value like a response from network call. This is common Observable we will be using in Android as most of out application invlolve Network calls.

## Maybe<>MaybeObserver
Maybe is used when the obeservable has to emit a value or no value. It is not recommended not use Maybe in RxJave from Android Application Development.

## Completable<>CompletableObserver
Completable is used when the Observable has to do some task wothout emitting a value