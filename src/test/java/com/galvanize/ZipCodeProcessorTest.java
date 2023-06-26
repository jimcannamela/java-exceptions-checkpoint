package com.galvanize;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZipCodeProcessorTest {

    Verifier verifier;
    ZipCodeProcessor processor;
    @BeforeEach
    void setUp() {
        verifier = new Verifier();
        processor = new ZipCodeProcessor(verifier);
    }

    // write your tests here
    @Test
    public void validZipCodeNoError() {
        assertEquals("Thank you!  Your package will arrive soon.", processor.process("80302") );
    }

    @Test
    public void zipCodeTooShort_WrongLengthError() {
        assertEquals("The zip code you entered was the wrong length.", processor.process("321"));
    }

    @Test
    public void zipCodeTooLong_WrongLengthError()  {

        assertEquals("The zip code you entered was the wrong length.", processor.process("2345678"));
    }

    @Test
    public void zipCodeStartsWithOne_OutOfServiceError() {
        assertEquals("We're sorry, but the zip code you entered is out of our range.", processor.process("12234") );
    }
}