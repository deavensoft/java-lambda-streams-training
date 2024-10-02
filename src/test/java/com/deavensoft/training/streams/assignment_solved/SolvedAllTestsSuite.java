package com.deavensoft.training.streams.assignment_solved;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import com.deavensoft.training.streams.assignment_solved.a1.LambdaExpressionsTest;
import com.deavensoft.training.streams.assignment_solved.a2.BehaviorParametrizationTest;
import com.deavensoft.training.streams.assignment_solved.a3.StreamsTest;
import com.deavensoft.training.streams.assignment_solved.a4.ByeByeForLoopTest;
import com.deavensoft.training.streams.assignment_solved.a5.PagingResultsTest;
import com.deavensoft.training.streams.assignment_solved.a6.OptionalTest;
import com.deavensoft.training.streams.assignment_solved.a7.TimeApiTest;

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
public class SolvedAllTestsSuite {

}

