package com.nohjunh.sample.model

data class CurOrderBookCoin(
    val order_currency : String,
    val bids : List<CurOrderBookPrice>,
    val asks : List<CurOrderBookPrice>
)

