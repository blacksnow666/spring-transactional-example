package com.twistlet.example.springtransactional;

import static org.hamcrest.core.IsEqual.*;
import static org.junit.Assert.*;
import static org.springframework.transaction.TransactionDefinition.*;

import org.junit.Test;

/**
 * 
 * @author Titi Wangsa
 *
 */
public class MajorGroupITCase extends AbstractSpringTransactionalITCase {

	// TransactionDefinition
	// PROPAGATION_REQUIRED
	// PROPAGATION_SUPPORTS
	// PROPAGATION_MANDATORY
	// PROPAGATION_REQUIRES_NEW
	// PROPAGATION_NOT_SUPPORTED
	// PROPAGATION_NEVER
	// PROPAGATION_NESTED
	@Test
	public void testRequiredGoodData() {
		insertMultiple(PROPAGATION_REQUIRED, SINGLE_VALUE_GOOD_DATA);
		assertThat(simpleService.table1Count(), equalTo(5L));
	}

	@Test
	public void testRequiredFailOnLast() {
		insertMultiple(PROPAGATION_REQUIRED, SINGLE_VALUE_FAIL_ON_LAST);
		assertThat(simpleService.table1Count(), equalTo(0L));
	}

	@Test
	public void testRequiredFailOnMiddle() {
		insertMultipleWithCatch(PROPAGATION_REQUIRED,
				SINGLE_VALUE_FAIL_ON_MIDDLE);
		assertThat(simpleService.table1Count(), equalTo(4L));
	}

	@Test
	public void testSupportsGoodData() {
		insertMultiple(PROPAGATION_SUPPORTS, SINGLE_VALUE_GOOD_DATA);
		assertThat(simpleService.table1Count(), equalTo(5L));
	}

	@Test
	public void testSupportsFailOnLast() {
		insertMultiple(PROPAGATION_SUPPORTS, SINGLE_VALUE_FAIL_ON_LAST);
		assertThat(simpleService.table1Count(), equalTo(4L));
	}

	@Test
	public void testSupportsFailOnMiddle() {
		insertMultipleWithCatch(PROPAGATION_SUPPORTS,
				SINGLE_VALUE_FAIL_ON_MIDDLE);
		assertThat(simpleService.table1Count(), equalTo(4L));
	}

	@Test
	public void testMandatoryGoodData() {
		insertMultiple(PROPAGATION_MANDATORY, SINGLE_VALUE_GOOD_DATA);
		assertThat(simpleService.table1Count(), equalTo(0L));
	}

	@Test
	public void testMandatoryFailOnLast() {
		insertMultiple(PROPAGATION_MANDATORY, SINGLE_VALUE_FAIL_ON_LAST);
		assertThat(simpleService.table1Count(), equalTo(0L));
	}

	@Test
	public void testMandatoryFailOnMiddle() {
		insertMultipleWithCatch(PROPAGATION_MANDATORY,
				SINGLE_VALUE_FAIL_ON_MIDDLE);
		assertThat(simpleService.table1Count(), equalTo(0L));
	}

	@Test
	public void testRequiresNewGoodData() {
		insertMultiple(PROPAGATION_REQUIRES_NEW, SINGLE_VALUE_GOOD_DATA);
		assertThat(simpleService.table1Count(), equalTo(5L));
	}

	@Test
	public void testRequiresNewFailOnLast() {
		insertMultiple(PROPAGATION_REQUIRES_NEW, SINGLE_VALUE_FAIL_ON_LAST);
		assertThat(simpleService.table1Count(), equalTo(0L));
	}

	@Test
	public void testRequiresNewFailOnMiddle() {
		insertMultipleWithCatch(PROPAGATION_REQUIRES_NEW,
				SINGLE_VALUE_FAIL_ON_MIDDLE);
		assertThat(simpleService.table1Count(), equalTo(4L));
	}

	@Test
	public void testNotSupportedGoodData() {
		insertMultiple(PROPAGATION_NOT_SUPPORTED, SINGLE_VALUE_GOOD_DATA);
		assertThat(simpleService.table1Count(), equalTo(5L));
	}

	@Test
	public void testNotSupportedFailOnLast() {
		insertMultiple(PROPAGATION_NOT_SUPPORTED, SINGLE_VALUE_FAIL_ON_LAST);
		assertThat(simpleService.table1Count(), equalTo(4L));
	}

	@Test
	public void testNotSupportedFailOnMiddle() {
		insertMultipleWithCatch(PROPAGATION_NOT_SUPPORTED,
				SINGLE_VALUE_FAIL_ON_MIDDLE);
		assertThat(simpleService.table1Count(), equalTo(4L));
	}

	@Test
	public void testNeverGoodData() {
		insertMultiple(PROPAGATION_NEVER, SINGLE_VALUE_GOOD_DATA);
		assertThat(simpleService.table1Count(), equalTo(5L));
	}

	@Test
	public void testNeverFailOnLast() {
		insertMultiple(PROPAGATION_NEVER, SINGLE_VALUE_FAIL_ON_LAST);
		assertThat(simpleService.table1Count(), equalTo(4L));
	}

	@Test
	public void testNeverFailOnMiddle() {
		insertMultipleWithCatch(PROPAGATION_NEVER, SINGLE_VALUE_FAIL_ON_MIDDLE);
		assertThat(simpleService.table1Count(), equalTo(4L));
	}

	@Test
	public void testNestedGoodData() {
		insertMultiple(PROPAGATION_NESTED, SINGLE_VALUE_GOOD_DATA);
		assertThat(simpleService.table1Count(), equalTo(5L));
	}

	@Test
	public void testNestedFailOnLast() {
		insertMultiple(PROPAGATION_NESTED, SINGLE_VALUE_FAIL_ON_LAST);
		assertThat(simpleService.table1Count(), equalTo(0L));
	}

	@Test
	public void testNestedFailOnMiddle() {
		insertMultipleWithCatch(PROPAGATION_NEVER, SINGLE_VALUE_FAIL_ON_MIDDLE);
		assertThat(simpleService.table1Count(), equalTo(4L));
	}

	private void insertMultiple(final int propagation, final String[] values) {
		try {
			simpleService.insertMultipleOneLayer(propagation, values);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	private void insertMultipleWithCatch(final int propagation,
			final String[] values) {
		try {
			simpleService.insertMultipleWithCatchOneLayer(propagation, values);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
