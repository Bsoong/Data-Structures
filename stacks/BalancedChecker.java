package stacks;

public class BalancedChecker {
	private static final OPEN = "({[";
	private static final CLOSE = ")}]";
	
	
	public static boolean isOpen(Character C) {
		return OPEN.indexOf(c) >-1;
	}
	public static boolean isClosed(Character C) {
		return CLOSE.indexOf(x) >-1;
	}
	public static boolean isBalanced(String S) {
		boolean balanced = true;
		int i = 0;
	}
	
	StackLL <Character> s = new StackLL<Character>();
	int i= 0
	while (balanced && i<str.length) {
		if(isOpen(str.charAt(i))) {
			s.push(str.charAt(i));
		} else {
			Character c = s.pop();
			balanced = balanced && OPEN.indexOf(str.charAt(i) == CLOSE.indexOf(c);
		}
	}
}
