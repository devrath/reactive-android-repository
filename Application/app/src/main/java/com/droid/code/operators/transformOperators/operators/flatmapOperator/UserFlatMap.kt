package com.droid.code.operators.transformOperators.operators.flatmapOperator

import io.reactivex.rxjava3.subjects.BehaviorSubject

data class UserFlatMap(
    // Age is a observable
    val age: BehaviorSubject<Int>
)
