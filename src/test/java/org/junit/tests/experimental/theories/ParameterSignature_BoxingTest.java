package org.junit.tests.experimental.theories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.experimental.results.PrintableResult.testResult;
import static org.junit.experimental.results.ResultMatchers.isSuccessful;
import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

public class ParameterSignature_BoxingTest {

	@Test
	public void testUnboxedUnboxed() throws Exception {
		assertThat(
				testResult(UnboxedDataPoints_UnboxedParameters.class), 
				isSuccessful());
	}
	
	@RunWith(Theories.class)
	public static class UnboxedDataPoints_UnboxedParameters {
		@DataPoint public static boolean a = false;
		@DataPoint public static byte b = 1;
		@DataPoint public static short c = 1;
		@DataPoint public static char d = 'a';
		@DataPoint public static int e = 1;
		@DataPoint public static long f = 1L;
		@DataPoint public static double g = 1.0;
		@DataPoint public static float h = 1.0F;
		
		@SuppressWarnings("static-access")
		@Theory
		public void m(boolean a, byte b, short c, char d, int e, long f, double g, float h) {
			assertEquals(this.a, a);
			assertEquals(this.b, b);
			assertEquals(this.c, c);
			assertEquals(this.d, d);
			assertEquals(this.e, e);
			assertEquals(this.f, f);
			assertEquals(this.g, g, 0.1);
			assertEquals(this.h, h, 0.1);
		}
	}

	@Test
	public void testBoxedUnboxed() throws Exception {
		assertThat(
				testResult(BoxedDataPoints_UnboxedParameters.class), 
				isSuccessful());
	}
	
	@RunWith(Theories.class)
	public static class BoxedDataPoints_UnboxedParameters {
		@DataPoint public static Boolean a = false;
		@DataPoint public static Byte b = 1;
		@DataPoint public static Short c = 1;
		@DataPoint public static Character d = 'a';
		@DataPoint public static Integer e = 1;
		@DataPoint public static Long f = 1L;
		@DataPoint public static Double g = 1.0;
		@DataPoint public static Float h = 1.0F;
		
		@SuppressWarnings("static-access")
		@Theory
		public void m(boolean a, byte b, short c, char d, int e, long f, double g, float h) {
			assertEquals(this.a, a);
			assertEquals(this.b, new Byte(b));
			assertEquals(this.c, new Short(c));
			assertEquals(this.d, new Character(d));
			assertEquals(this.e, new Integer(e));
			assertEquals(this.f, new Long(f));
			assertEquals(this.g, g, 0.1);
			assertEquals(this.h, h, 0.1);
		}
	}

	@Test
	public void testUnboxedBoxed() throws Exception {
		assertThat(
				testResult(UnboxedDataPoints_BoxedParameters.class), 
				isSuccessful());
	}

	@RunWith(Theories.class)
	public static class UnboxedDataPoints_BoxedParameters {
		@DataPoint public static boolean a = false;
		@DataPoint public static byte b = 1;
		@DataPoint public static short c = 1;
		@DataPoint public static char d = 'a';
		@DataPoint public static int e = 1;
		@DataPoint public static long f = 1L;
		@DataPoint public static double g = 1.0;
		@DataPoint public static float h = 1.0F;
		
		@SuppressWarnings("static-access")
		@Theory
		public void m(Boolean a, Byte b, Short c, Character d, Integer e, Long f, Double g, Float h) {
			assertEquals(this.a, a);
			assertEquals(new Byte(this.b), b);
			assertEquals(new Short(this.c), c);
			assertEquals(new Character(this.d), d);
			assertEquals(new Integer(this.e), e);
			assertEquals(new Long(this.f), f);
			assertEquals(this.g, g, 0.1);
			assertEquals(this.h, h, 0.1);
		}
	}
	
	@Test
	public void testBoxedBoxed() throws Exception {
		assertThat(
				testResult(BoxedDataPoints_BoxedParameters.class), 
				isSuccessful());
	}

	@RunWith(Theories.class)
	public static class BoxedDataPoints_BoxedParameters {
		@DataPoint public static Boolean a = false;
		@DataPoint public static Byte b = 1;
		@DataPoint public static Short c = 1;
		@DataPoint public static Character d = 'a';
		@DataPoint public static Integer e = 1;
		@DataPoint public static Long f = 1L;
		@DataPoint public static Double g = 1.0;
		@DataPoint public static Float h = 1.0F;
		
		@SuppressWarnings("static-access")
		@Theory
		public void m(Boolean a, Byte b, Short c, Character d, Integer e, Long f, Double g, Float h) {
			assertEquals(this.a, a);
			assertEquals(this.b, b);
			assertEquals(this.c, c);
			assertEquals(this.d, d);
			assertEquals(this.e, e);
			assertEquals(this.f, f);
			assertEquals(this.g, g, 0.1);
			assertEquals(this.h, h, 0.1);
		}
	}
	
	@Test
	public void testArray_UnboxedUnboxed() {
		assertThat(
				testResult(UnboxedArray_UnboxedParameter.class), 
				isSuccessful());
	}

	@RunWith(Theories.class) 
	public static class UnboxedArray_UnboxedParameter {
		
		@DataPoints public static int[] dp = {1};
		
		@Theory
		public void m(int i) {
			assertEquals(1, i);
		}
	}

	@Test
	public void testArray_BoxedUnboxed() {
		assertThat(
				testResult(BoxedArray_UnboxedParameter.class), 
				isSuccessful());
	}

	@RunWith(Theories.class) 
	public static class BoxedArray_UnboxedParameter {
		
		@DataPoints public static Integer[] dp = {1};
		
		@Theory
		public void m(int i) {
			assertEquals(1, i);
		}
	}

	@Test
	public void testArray_UnboxedBoxed() {
		assertThat(
				testResult(UnboxedArray_BoxedParameter.class), 
				isSuccessful());
	}

	@RunWith(Theories.class) 
	public static class UnboxedArray_BoxedParameter {
		
		@DataPoints public static int[] dp = {1};
		
		@Theory
		public void m(Integer i) {
			assertEquals(new Integer(1), i);
		}
	}

	@Test
	public void testArray_BoxedBoxed() {
		assertThat(
				testResult(BoxedArray_BoxedParameter.class), 
				isSuccessful());
	}

	@RunWith(Theories.class) 
	public static class BoxedArray_BoxedParameter {
		
		@DataPoints public static Integer[] dp = {1};
		
		@Theory
		public void m(Integer i) {
			assertEquals(new Integer(1), i);
		}
	}

}
