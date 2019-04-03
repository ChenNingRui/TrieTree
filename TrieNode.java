import java.util.LinkedList;

public class TrieNode {
	private char content;//the character in the node
	private int index;//the index of the character sharing this string
	private boolean isEnd;//the ending of the string
	
	LinkedList<TrieNode> childList;//the child list;
	
	private double payment;
	private String operator;
	
	public TrieNode(char content) {
		childList = new LinkedList<TrieNode>();
		this.content = content;
		index = 0;
		setEnd(false);
	}
	
	public TrieNode subNode(char character) {
		if(childList != null) {
			for(TrieNode child : childList) {
				if(child.content == character)
					return child;
			}
		}
		
		return null;
	}

	public char getContent() {
		return content;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
}
