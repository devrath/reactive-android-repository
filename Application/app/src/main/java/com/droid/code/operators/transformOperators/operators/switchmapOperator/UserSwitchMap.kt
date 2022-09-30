package com.droid.code.operators.transformOperators.operators.switchmapOperator

import io.reactivex.rxjava3.subjects.BehaviorSubject

data class UserSwitchMap(
    // Age is a observable
    val age: BehaviorSubject<Int>
)
