package sayan.infix2postfix;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ExpressionTest {

	@Test
	public void test() {
		Assert.assertEquals(returnResultAsString("a+b"), "ab+");
		Assert.assertEquals(returnResultAsString("a - b"), "ab-");
		Assert.assertEquals(returnResultAsString("f(a,b)+c"), "|abf()c+");
		Assert.assertEquals(returnResultAsString("a* f(b)+c"), "a|bf()*c+");
	}

	private String returnResultAsString(String exp) {
		List<String> tokens = Expression.eval(exp);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tokens.size(); i++) {
			sb.append(tokens.get(i));
		}
		return sb.toString();
	}

}
