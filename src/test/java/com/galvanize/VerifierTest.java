package com.galvanize;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class VerifierTest {
	Verifier verifier;
	@BeforeEach
	void setUp() {
		verifier = new Verifier();
	}
	@Test
	public void verifierTooShort_ThrowIFE() {
		assertThrows(InvalidFormatException.class, () -> verifier.verify("321");
	};
	@Test
	public void verifierTooLong_ThrowIFE() {
		assertThrows(InvalidFormatException.class, () -> verifier.verify("2345678");
	};
	@Test
	public void verifierNoService_ThrowNSE() {
		assertThrows(NoServiceException.class, () -> verifier.verify("11234");
	};

}
