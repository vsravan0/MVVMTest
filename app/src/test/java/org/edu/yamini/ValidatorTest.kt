package org.edu.yamini


import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ValidatorTest {

    @Test
    fun whenInputIsValid() {

        val amount = 100
        val desc ="Random Description"
        val sra = Validator.validateInput(amount, desc)
        assertThat(sra).isEqualTo(true)

    }

    @Test
    fun whenInputIsInValid() {

        val amount = 0
        val desc =""
        val sra = Validator.validateInput(amount, desc)
        assertThat(sra).isEqualTo(false)

    }
}