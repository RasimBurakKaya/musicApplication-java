
public class Node {
	private Song song;
	private Node leftChild;
	private Node rightChild;
	
	public Node(Song song) {
		this.song = song;
		this.leftChild = null;
		this.rightChild = null;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	
	
	
	

}
