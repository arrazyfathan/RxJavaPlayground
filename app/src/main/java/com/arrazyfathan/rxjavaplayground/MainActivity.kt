package com.arrazyfathan.rxjavaplayground

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.arrazyfathan.rxjavaplayground.databinding.ActivityMainBinding
import com.arrazyfathan.rxjavaplayground.maybe.createMaybe
import com.arrazyfathan.rxjavaplayground.maybe.observeMaybe
import com.arrazyfathan.rxjavaplayground.operators.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        const val TAG = "MainActivity"
    }

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

        createMaybe().subscribe(observeMaybe())
    }

    private fun getLocation() {
        Log.d(
            TAG,
            "Latitude: ${120}.${(100..900).random()}, Longitude: ${177}.${(100..900).random()}"
        )
    }
}
