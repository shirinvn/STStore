package com.example.stsotre.util

import java.text.DecimalFormat

object DigitHelper {



    fun digitByLocate(englishStr: String): String{
        var result = ""
        var fa = '۰'
        for (ch in englishStr){
            when (ch){
                '۰'-> fa = '0'
                '۱'-> fa = '1'
                '۲'-> fa = '2'
                '۳'-> fa = '3'
                '۴'-> fa = '4'
                '۵'-> fa = '5'
                '۶'-> fa = '6'
                '۷'-> fa = '7'
                '۸'-> fa = '8'
                '۹'-> fa = '9'

            }

            result = "${result}$fa"
        }
        return result
    }


    //جداسازی سه تایی ارقام از هم

    fun digitBySeparator(price : String) : String{
        val priceFormat = DecimalFormat("###,###")
        return priceFormat.format(Integer.valueOf(price))
    }

    fun digitByLocateAndSeparator(price: String): String{
        val pricewithoutCommas = price.replace(",","")
        val presianDigit= digitByLocate(pricewithoutCommas)
        return digitBySeparator(presianDigit)
    }

    fun applyDiscount(price: Long, discountPercent :Int): Long{

        return if (discountPercent>0 ){
            val discountAmount= (price * discountPercent) / 100
            price- discountAmount

        }else{
            price
        }
    }
}

