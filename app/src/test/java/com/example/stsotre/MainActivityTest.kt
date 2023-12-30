package com.example.stsotre

import com.example.stsotre.MainActivity.Companion.reverseString
import org.junit.Assert.*
import org.junit.Test

class MainActivityTest{

    @Test
    fun `reverseString should return reversed string` (){

        //Arrange
        val testCase = "mohammad"

        //Act
        val result = reverseString(testCase)


        //Assert
        assertEquals("dammahom", result)
    }
}