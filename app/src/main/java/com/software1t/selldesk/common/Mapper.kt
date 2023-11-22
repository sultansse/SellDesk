package com.software1t.selldesk.common


interface Mapper<I, O> {


    /*
    * Можно было бы сделать типы nullable -> i: I?  это было бы лучшим решением
    * но мне лень
    * */
    fun from(i: I): O

    fun to(o: O): I

    fun fromList(list: List<I>?): List<O> {
        return list?.mapNotNull { from(it) } ?: listOf()
    }

    fun toList(list: List<O>?): List<I> {
        return list?.mapNotNull { to(it) } ?: listOf()
    }

}