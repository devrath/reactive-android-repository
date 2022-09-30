package com.droid.code.operators.transformOperators.operators.materializeOperator

import io.reactivex.rxjava3.subjects.BehaviorSubject

data class UserMaterialize(
    // Age is a observable
    val age: BehaviorSubject<Int>
)
