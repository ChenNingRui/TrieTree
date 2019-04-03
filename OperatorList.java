import java.util.ArrayList;

public class OperatorList {
	private ArrayList<TrieTree> operatorList;
	
	public OperatorList() {
		operatorList = new ArrayList<TrieTree>();
	}
	
	//insert new element, each operator is controlled by a Trie tree
	public void insert(String content, double payment, String operator) {
		TrieTree tree = searchOperator(operator);
		
		if(tree == null) {
			tree = new TrieTree();
			tree.setOperator(operator);
			operatorList.add(tree);
		}
		
		tree.insert(content, payment, operator);
	}
	
	public TrieNode searchPayment(String content) {
		return optimumScheme(content); 
	}
	
	public TrieTree searchOperator(String operator) {
		
		for(int i = 0, length = operatorList.size(); i < length; i++) {
			TrieTree tree = operatorList.get(i);
			if(tree.getOperator() == operator)
				return tree;
		}
		
		return null;
	}
	
	//calculated the optimum payment
	private TrieNode optimumScheme(String content) {
		TrieNode optimum = null;
		for(int i = 0; i < operatorList.size(); i++) {
			TrieTree tree = operatorList.get(i);
			TrieNode node = tree.search(content);
			
			if(optimum != null && node != null && optimum.getPayment() > node.getPayment())
				optimum = node;
			else if(optimum == null)
				optimum = node;
		}
		
		if(optimum != null) {
			return optimum;
		}
		
		return null;
	}

}
