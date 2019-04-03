
public class TrieTree {
	private TrieNode root;
	private String operator;
	
	public TrieTree() {
		root = new TrieNode(' ');
		root.setPayment(-1);
	}
	
	public void insert(String content, double payment, String operator) {
		TrieNode current = root;
		for(int i = 0, length = content.length(); i < length; i++) {
			TrieNode child = current.subNode(content.charAt(i));
			if(child != null) {
				current = child;
			}
			else {
				current.childList.add(new TrieNode(content.charAt(i)));
				current = current.subNode(content.charAt(i));
			}
			
			current.setIndex(current.getIndex() + 1);
		}
		
		current.setPayment(payment);
		current.setOperator(operator);
		current.setEnd(true);
	}
	
	public TrieNode search(String content) {
		TrieNode current = root;
		
		for(int i = 0, length = content.length(); i < length; i++) {
			if(current.subNode(content.charAt(i)) == null) {
				if(current.getOperator() == null)//the longest one should be used
					return null;
				else
					return current;
			}
			else
				current = current.subNode(content.charAt(i));
		}
		
		if(current.getOperator() == null)//the content equals to the node
			return null;
		else
			return current;
	}
	
	public void delete(String content) {
		TrieNode current = root;
		for(char character : content.toCharArray()) {
			TrieNode child = current.subNode(character);
			if(child.getIndex() == 1) {
				current.childList.remove(child);
				return;
			}
			else {
				child.setIndex(child.getIndex() - 1);
				current = child;
			}
		}
		
		current.setEnd(false);
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
}
