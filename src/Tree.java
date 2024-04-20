

public class Tree {
	private Node root;

	public Tree(Node root) {
		this.root = null;
	}

	public Node getRoot() {
		return root;
	}

	private Node createNewNode(Song song) {
		return new Node(song);
	}
	
	public boolean insert(Song song) {
		if(root==null)
			root=createNewNode(song);
		else {
			Node parent = null;
			Node current = root;
			while(current!=null) {
				if(song.getTitle().compareTo(current.getSong().getTitle()) < 0) {
					parent = current;
					current = current.getLeftChild();
			}
				else if(song.getTitle().compareTo(current.getSong().getTitle()) > 0) {
					parent = current;
					current = current.getRightChild();
				}
				else
					return false;
					
				}
			if(song.getTitle().compareTo(parent.getSong().getTitle()) < 0)
				parent.setLeftChild(createNewNode(song));
			else
				parent.setRightChild(createNewNode(song));
				}
		return true;
	}
	
	public void inorder(Node root) {
		if(root==null)
			return;
		inorder(root.getLeftChild());
		System.out.println(root.getSong().toString());
		inorder(root.getRightChild());
		
}

	
	
	
	

}
