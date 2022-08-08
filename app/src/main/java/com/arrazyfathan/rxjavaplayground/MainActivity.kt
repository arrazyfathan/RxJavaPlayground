package com.arrazyfathan.rxjavaplayground

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.arrazyfathan.rxjavaplayground.databinding.ActivityMainBinding
import com.arrazyfathan.rxjavaplayground.operators.*
import com.arrazyfathan.rxjavaplayground.subject.*
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        const val TAG = "MainActivity"
    }

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        demoRxJava()
    }

    private fun demoRxJava() {
        // justOperator()

        // fromOperator()

        // fromIterableOperator()

        /*rangeOperator().subscribe(
            {
                Log.d(TAG, "onNext: $it")
            },
            {
                Log.d(TAG, "onError: $it ")
            },
            {
                Log.d(TAG, "onComplete")
            }
        )*/

        /*repeatOperator().subscribe(
            {
                Log.d(TAG, "onNext: $it")
            },
            {
                Log.d(TAG, "onError: $it ")
            },
            {
                Log.d(TAG, "onComplete")
            }
        )*/

        /*intervalOperator().subscribe(
            {
                getLocation()
            },
            {
                Log.d(TAG, "onError: $it ")
            },
            {
                Log.d(TAG, "onComplete")
            }
        )*/

        /*timerOperator().subscribe(
            {
                Log.d(TAG, "onNext: $it ")
            },
            {
                Log.d(TAG, "onError: $it ")
            },
            {
                Log.d(TAG, "onComplete")
            }
        )*/

        /*operatorCreate().subscribe(
            {
                Log.d(TAG, "onNext: $it ")
            },
            {
                Log.d(TAG, "onError: $it ")
            },
            {
                Log.d(TAG, "onComplete")
            }
        )*/

        /*filterOperator()
            .filter { user ->
                user.age >= 43
            }
            .subscribe(
                {
                    Log.d(TAG, "onNext: $it ")
                },
                {
                    Log.d(TAG, "onError: $it ")
                },
                {
                    Log.d(TAG, "onComplete")
                }
            )*/

        /*lastOperator()
            // .last(User(1, "demo1", 18)) using last() must provide default value when empty data
            // .lastOrError()
            .lastElement() // lastElement() don't need provide default value
            .subscribe(
                {
                    Log.d(TAG, "onNext: $it ")
                },
                {
                    Log.d(TAG, "onError: $it ")
                }
            )*/

        /*lastOperator()
            .distinct {
                it.age
            }
            .subscribe(
                {
                    Log.d(TAG, "onNext: $it ")
                },
                {
                    Log.d(TAG, "onError: $it ")
                },
                {
                    Log.d(TAG, "onComplete")
                }
            )*/

        /*skipOperator()
            // .skipLast(2)
            // .skip(2)
            .skip(1, TimeUnit.MICROSECONDS)
            .subscribe(
                {
                    Log.d(TAG, "onNext: $it ")
                },
                {
                    Log.d(TAG, "onError: $it ")
                },
                {
                    Log.d(TAG, "onComplete")
                }
            )*/

        /*bufferOperator()
            .buffer(3)
            .subscribe(
                {
                    Log.d(TAG, "onNext: $it ")
                },
                {
                    Log.d(TAG, "onError: $it ")
                },
                {
                    Log.d(TAG, "onComplete")
                }
            )*/

        /*mapOperator()
            .map { user ->
                UserProfile(
                    id = user.id,
                    name = "Mr. ${user.name} S.pd",
                    age = user.age,
                    image = "cdn.myiamges.com/${user.id}.png"
                )
            }
            .subscribe(
                {
                    Log.d(TAG, "onNext: $it ")
                },
                {
                    Log.d(TAG, "onError: $it ")
                },
                {
                    Log.d(TAG, "onComplete")
                }
            )*/

        /*flatMapOperator()
            .flatMap {
                getUserProfile(it.id)
            }
            .subscribe(
                {
                    Log.d(TAG, "onNext: $it ")
                },
                {
                    Log.d(TAG, "onError: $it ")
                },
                {
                    Log.d(TAG, "onComplete")
                }
            )*/

        /*flatMapOperatorTwo()
            .flatMap {
                Observable.fromIterable(it)
            }
            .flatMap {
                getUserProfile(it.id)
            }
            .subscribe(
                {
                    Log.d(TAG, "onNext: $it ")
                },
                {
                    Log.d(TAG, "onError: $it ")
                },
                {
                    Log.d(TAG, "onComplete")
                }
            )*/

        /*groupByOperator()
            .groupBy { user ->
                user.age
            }
            .filter {
                it.key == 65
            }
            .subscribe(
                { group ->
                    group.subscribe(
                        {
                            Log.d(TAG, "Key : ${group.key} values : $it ")
                        },
                        {
                            Log.d(TAG, "onError: $it ")
                        }
                    )
                    // Log.d(TAG, "onNext: $it ")
                },
                {
                    Log.d(TAG, "onError: $it ")
                },
                {
                    Log.d(TAG, "onComplete")
                }
            )*/

        /*mergeOperator()
            .subscribe(
                {
                    Log.d(TAG, "onNext: $it ")
                },
                {
                    Log.d(TAG, "onError: $it ")
                },
                {
                    Log.d(TAG, "onComplete")
                }
            )*/

        /*concatOperator()
            .subscribe(
                {
                    Log.d(TAG, "onNext: $it ")
                },
                {
                    Log.d(TAG, "onError: $it ")
                },
                {
                    Log.d(TAG, "onComplete")
                }
            )*/

        /*startWithOperator()
            .subscribe(
                {
                    Log.d(TAG, "onNext: $it ")
                },
                {
                    Log.d(TAG, "onNext: $it ")
                }
            )*/

        /*zipOperator()
            .subscribe(
                {
                    Log.d(TAG, "onNext: $it ")
                },
                {
                    Log.d(TAG, "onNext: $it ")
                },
                {
                    Log.d(TAG, "onComplete")
                }

            )*/

        /*zipGetUserAndGetBlogs()
            .subscribe(
                {
                    it.forEach { blogDetail ->
                        Log.d(TAG, "onNext: $blogDetail ")
                    }
                },
                {
                    Log.d(TAG, "onNext: $it ")
                },
                {
                    Log.d(TAG, "onComplete")
                }

            )*/

        // createObservable().subscribe(observer())

        // createSingleObservable().subscribe(observeSingle())

        // createMaybe().subscribe(observeMaybe())

        // createCompletableObservable().subscribe(observerCompletable())

        /*createFlowable()
            .onBackpressureLatest()
            .observeOn(Schedulers.io(), false, 10)
            .subscribe(
                {
                    Log.d(TAG, "onNext: $it")
                },
                {
                    Log.d(TAG, "onError: $it")
                },
                {
                    Log.d(TAG, "onComplete")
                }
            )*/

        /*createFlowableTwo()
            .toFlowable(BackpressureStrategy.LATEST)
            .observeOn(Schedulers.io(), false, 9)
            .subscribe(
                {
                    Log.d(TAG, "onNext: $it")
                },
                {
                    Log.d(TAG, "onError: $it")
                },
                {
                    Log.d(TAG, "onComplete")
                }
            )*/

        /*compositeDisposable.add(
            createObservableDisposable()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        Log.d(TAG, "onNext: $it")
                    },
                    {
                        Log.d(TAG, "onError: $it")
                    },
                    {
                        Log.d(TAG, "onComplete")
                    }
                )
        )*/

        // createObservableDisposable().subscribe(observerDisposable())

        /*compositeDisposable.add(
            Observable.just(mUserList)
                .flatMap {
                    Log.d(TAG, "Upstream Thread: ${Thread.currentThread().name}")
                    Observable.fromIterable(it)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        binding.number.text = it.toString()
                        Log.d(TAG, "onNext: $it Downstream Thread: ${Thread.currentThread().name}")
                    },
                    {
                        Log.d(TAG, "onError: $it")
                    },
                    {
                        Log.d(TAG, "onComplete")
                    }
                )
        )*/

        // Cold Observable
        /*coldObservable()
            .subscribe(coldObserver())*/

        // Hot Observable
        /*val hotObservable = hotObservable()
        hotObservable.subscribe(
            {
                Log.d(TAG, "onNext: $it")
            },
            {
                Log.d(TAG, "onError: $it")
            },
            {
                Log.d(TAG, "onComplete")
            }
        )
        hotObservable.connect()*/

        /*val hotObservableTwo = hotObservableTwo()
        hotObservableTwo.connect()

        hotObservableTwo.subscribe(
            {
                Log.d(TAG, "onNext: $it")
            },
            {
                Log.d(TAG, "onError: $it")
            },
            {
                Log.d(TAG, "onComplete")
            }
        )*/

        // asyncSubject()
        // behaviorSubject()
        // behaviorSubjectTwo()
        // publishSubject()
        // publishSubjectTwo()
        // replaySubject()
        replaySubjectTwo()
    }

    private fun getLocation() {
        Log.d(
            TAG,
            "Latitude: ${120}.${(100..900).random()}, Longitude: ${177}.${(100..900).random()}"
        )
    }

    override fun onDestroy() {
        // disposable.dispose()
        compositeDisposable.clear()
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }

    override fun onStop() {
        // disposable.dispose()
        compositeDisposable.clear()
        Log.d(TAG, "onDestroy")
        super.onStop()
    }
}
