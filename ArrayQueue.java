/*Must implement the interface defined in the file Queue.java
 * enqueue
 * dequeue
 * empty 
 */
public class ArrayQueue implements Queue{
	private int head;
	private int tail;
	private Object[] arr;
	
	//constructor
	public ArrayQueue(){
		head = 0;
		tail = 0;
		arr = new Object[10];
	}
	
	//--------------------------------------------------------------------	
	public Object dequeue(){
		//need to check if the queue is empty
		if (empty())
			return null;
		
		//Now, we dequeue an item from the front
		Object temp = arr[head];//get the head
		head++;  //first in first out, so if head was at index 0 and we remove it, then the next "head" will be 1
		head = wrap(head, arr.length);
		return temp;
		
	}
	//--------------------------------------------------------------------	

	public void enqueue(Object item){
		//need to check if the queue is full
		if (isFull()){
			growQueue();
		}
		//if not full, then we give tail an item and increment tail
		//when tail is greater than or equal to the length of the list, then we set tail to 0
		arr[tail] = item;
		tail++;
		tail = wrap(tail, arr.length);
	}
	//--------------------------------------------------------------------	

	public boolean empty(){
		if (head == tail)
			return true;
		return false;
	}
	//--------------------------------------------------------------------	
	public int wrap(int n , int len){
		if (n >= len)
			return n%len; //returns index
		return n;
	}
	
	public boolean isFull(){
		int nextEQ = tail + 1;
		int i = wrap(nextEQ, arr.length);
		if (i == head){
			return true;
		}
		return false;
		
	}
	//--------------------------------------------------------------------	
	public void growQueue(){
		//we grow queue to twice it's size
		Object[] newArr = new Object[arr.length*2];
		//we must copy everything from the previous arr to the new array
		if (head == 0){
			
			System.arraycopy(arr, 0, newArr, 0, arr.length);
			tail =arr.length-1;
		}else{
			//copy from head to the end.then beginning to tail
						
			System.arraycopy(arr, head, newArr, 0, (arr.length-head));

			System.arraycopy(arr, 0, newArr, arr.length-head, head-1);
			
			tail = arr.length - 1;
		}
		arr = newArr;
		head = 0;

	}
	//--------------------------------------------------------------------	

}
