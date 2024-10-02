package com.deavensoft.training.streams.assignment;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import com.deavensoft.training.streams.assignment.a1.LambdaExpressionsTest;
import com.deavensoft.training.streams.assignment.a2.BehaviorParametrizationTest;
import com.deavensoft.training.streams.assignment.a3.StreamsTest;
import com.deavensoft.training.streams.assignment.a4.ByeByeForLoopTest;
import com.deavensoft.training.streams.assignment.a5.PagingResultsTest;
import com.deavensoft.training.streams.assignment.a6.OptionalTest;
import com.deavensoft.training.streams.assignment.a7.TimeApiTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   LambdaExpressionsTest.class,
   BehaviorParametrizationTest.class,
   StreamsTest.class,
   ByeByeForLoopTest.class,
   PagingResultsTest.class,
   OptionalTest.class,
   TimeApiTest.class
})
public class AllTestsSuite {

}

