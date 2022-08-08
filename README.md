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

## RxJava Schedulers

Threading in RxJava is done with help of Schedulers. Shedulers can be thought of as a thread pool managing 1 or more threads. Whenever a Schedulers needs to execute a task, it will take a thread from its pool and run the task in that thread.
<br>
**Type Of Schedulers**
<br>
1. Schedulers.io() : is backed by an unbounded thread pool. It is used for non CPU-intensive I/O type work including interaction with the file system, performing network calls, database interaction, etc. This thread pool is intended to be used for asynchronously performing blocking IO.

2. Schedulers.computation() : is backed by a bounded thread pool with size up to the number of available processors. It is used for computational or CPU-intensive work such as resizing images, processing large data sets, etc. Be careful: when you allocatte more computational threads than available cres, performance will gegrade due to context switching and thread creation overhead as threads view processors time.

3. Schedulers.newThread() : Create a new thread for each unit of work scheduled. This scheduler is expensive as new thead is spawned every time and no reuse happens.

4. Schedulers.from(Executor executor) : creates ad returns a custom scheduler backed by the specified exceutor. To limit the number of simultaneous threads in the thread pool, use scheduler.from(Executors.newFixedThreadPool(n)). This guarantees that if a task is scheduled when all threads are occupied, it will be queued. The threads in the pool will exist until it is explicitly shutdown.

5. Main thread or AndroidShedulers.mainThread() : is provided by the RxAndroid extension lib to RxJava. Main threads (also known as UI thread) is where user interaction happens. Care should be taken not overload this thread to prevent janky non-responsive UI or worse Application Not Responding ANR dialog.

6. Schedulers.single() : This schedulers is backed by a single thread executing tasks sequentially in the order requested.

## Default Threading in RxJava
If you don't specify threading in RxJava (if you don't specify subscribeOn, observeOn or both) the data will be emitted and processed by the current scheduler/thread (usually the main thread). Some operators such as inteval operator operate on a computational thread by default.
<br>
We can specify a thread to execute any operator by using subscribeOn and/or observeOn.
- subscribeOn affect upstream operators (operator above the subscribeOn)
- observeOn affects downstream operators (operators below the observeOn)
- If only subscribeOn is specified all operators will be executed on that thread
- If only observeOn is specified, all operators will be executed on the current thread and only operators below the observeOn will be switched to thread specified by the observeOn.

## Cold Observables
Cold observables are sequences that only emits item upon subscription. Each observer will have its own set of items emitted to them and depending on how the observable was created, will have different instance of emitted items.
<br>
<br>
In reality, data-driven observables are most likely cold. Multiple Observers receive the same datasets by getting separate streams of each item. For those familiar, some real-world examples of cold observables are retrofit and room queries.

## Hot Obsevables
In contrast to cold observable, hot observable emit items regardless whether there are observers. In a hot observable, there is a single source of emission and depending on when observer subscribe, they may miss some of those emission.
<br> 
<br>
Hot Observables often represent events rather finite datasets. The events can carry data with them, but there is a time-sensitive component where late observers can miss previously emitted data. UI events or server request for example can be represented as hot Observable.
<br>
<br>
There are many way to implement hot observables. One of them is Subjects.

## ConnectableObservable
ConnectableObservable takes any Observable (even if it is cold) and makes it hot, so that all emissions are played to all Obaservers at once.<br><br>
A ConnectableObservable is a single observable source for different observer. The main difference aside from being single observable source is that calling subscribe on a ConnectableObserver will not trigger emission, but connect will.<br><br>
Using ConnectableObervable allows the set up all Observer beforehand and force each emission to go to all Observer simultaneously (multicasting). This observable behavior of emitting to all obeserver simultaneously is called Multicasting.

## RxJava Subject
A Subject is a sort of bridge or proxy that is available in some implementations of ReactiveX that acts both as an oberver and as an observable. Because it is an observer, it can subscribe to one or more Observables, and because it is an Observable it can pass through the items it observer by re-emitting them and it can also emit new items.
