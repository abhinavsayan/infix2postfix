# infix2postfix
Java librar to convert infix expressions to postfix expressions.

Simple library that takes in an infix expression and returns a postfix expression. The librar has support for functions with variable number of inpurt.

The functions are converted to their prefix form using the wall notation.


### Wall notation: (using "|" as the wall operator)

Some examples are:

```
f(1,2) + 3 ⟶ | 1 2 f() 3 +
1 * f(2) + 3⟶ 1 | 2 f() * 3 +
```

### Usage
```
List<String> postFix = xpression.eval("A + 2B * 3 / 15");
List<String> postFix = xpression.eval("Sin(A) + Cos(B)");
List<String> postFix = xpression.eval("Max(A,B,C)");
List<String> postFix = xpression.eval("(3 * B) + 33 / 18 + log(8876) + f(99, 88)");
```


### To Do
- Update test cases to verify all scenarios
- Document the handling of the rnary operator.
