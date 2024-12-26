package com.example.data.mapper

import com.example.data.model.BaseData
import com.example.domain.entities.BaseModel


abstract class DataMapper<T : BaseData, R : BaseModel> {
    abstract fun map(data: T): R

    fun nullableMap(data: T?): R? {
        return data?.let { map(it) }
    }

    fun collectionMap(collection: Collection<T>): List<R> {
        return collection.map { map(it) }
    }

    fun nullableCollectionMap(collection: Collection<T>?): List<R>? {
        return collection?.map { map(it) }
    }
}
