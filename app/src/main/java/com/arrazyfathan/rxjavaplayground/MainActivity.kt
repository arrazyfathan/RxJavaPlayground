package com.arrazyfathan.rxjavaplayground

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.arrazyfathan.rxjavaplayground.databinding.ActivityMainBinding
import com.arrazyfathan.rxjavaplayground.operators.lastOperator

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

        lastOperator()
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
            )
    }

    private fun getLocation() {
        Log.d(
            TAG,
            "Latitude: ${120}.${(100..900).random()}, Longitude: ${177}.${(100..900).random()}"
        )
    }
}
