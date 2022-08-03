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
Maybe is used when the obeservable has to emit a value or no value. It is not recommended not use Maybe in RxJava from Android Application Development.

## Completable<>CompletableObserver
Completable is used when the Observable has to do some task without emitting a value.

## Flowable<>Observer
Flowable is similar to Observable but this comes into picture when observable is emitting a huge number of values that cant be received or consumed by the observable. In this case, the observable needs to skip some values on the basis of strategy or else it will throw an exception. Here, the flowable observable makes sense because it handles this exception with a strategy. this strategy is called BackPressureStrategy and this exception is called MissingBackPressureException. An observer for flowable is same as the observer for Observable.<br>
<br>
**Backpressure Strategy**

1. BackpressureStrategy.DROP : We can use this discard the events that cannot be consumed by the Observer.
2. backpressureStrategy.BUFFER : If we use this, the source will buffer all the events until the subscriber can consume them.
3. BackpressureStrategy.LATEST : Force to the source to keep only the latest items todo that source may need to overwrite some previous values.
4. BackressureStrategy.MISSING : We may temporary pass this values if we don't want any backpressure strategy.
5. BackpressureStrategy.ERROE : If we don't expect backpressure at all, we can pass BackpressureStrategy.ERROR 
<br>
	
