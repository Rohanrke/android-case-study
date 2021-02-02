package com.target.targetcasestudy.data.mapper

interface RemoteToEntityMapper<R,E> {

    fun map(remote: R): E
}