import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class AlaTestChallengeTest {

	@Test
	void testMain() {
		
		OperatorList list = new OperatorList();
		
		//inserting data
		list.insert("1", 0.9, "A");
		list.insert("268", 5.1, "A");
		list.insert("46", 0.17, "A");
		list.insert("4620", 0.0, "A");
		list.insert("468", 0.15, "A");
		list.insert("4631", 0.15, "A");
		list.insert("4673", 0.9, "A");
		list.insert("46732", 1.1, "A");
		
		list.insert("1", 0.92, "B");
		list.insert("44", 0.5, "B");
		list.insert("46", 0.2, "B");
		list.insert("467", 1.0, "B");
		list.insert("48", 1.2, "B");
		
		//searching
		TrieNode result = list.searchPayment("4673212345");
		Assert.assertEquals(result.getOperator(), "B");
		
//		if(result == null)
//			System.out.print("cannot find any operator");
//		else
//			System.out.print("the cheapest operator is " + result.getOperator() + ", the payment is "+ result.getPayment() + "/min");
	}

}
