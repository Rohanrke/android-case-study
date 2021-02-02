package com.target.targetcasestudy.utils

import junit.framework.TestCase
import org.junit.Test

class ValidatorsKtTest : TestCase() {


    @Test
    fun test_validateCreditCard_correct_number() {
        val card1 = "4556505243715388"
        assertTrue(validateCreditCard(card1))

        val card2 = "4556505243715388"
        assertTrue(validateCreditCard(card2))

        val card3 = "4024007163296763720"
        assertTrue(validateCreditCard(card3))

        val card4 = "5232236235317541"
        assertTrue(validateCreditCard(card4))

        val card5 = "5272437885037998"
        assertTrue(validateCreditCard(card5))

        val card6 = "5176441329564242"
        assertTrue(validateCreditCard(card6))

        val card7 = "345748708989551"
        assertTrue(validateCreditCard(card7))

        val card8 = "373138108180495"
        assertTrue(validateCreditCard(card8))

        val card9 = "378722941950936"
        assertTrue(validateCreditCard(card9))

        val card10 = "6011993784246985"
        assertTrue(validateCreditCard(card10))

        val card11 = "21212"
        assertTrue(validateCreditCard(card11))

    }

    @Test
    fun test_validateCreditCard_wrong_number() {
        val card1 = "402400716329676372"
        assertFalse(validateCreditCard(card1))
    }

}