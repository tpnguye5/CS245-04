/*
 * Must implement the Stack class with its functions
 */
		
public class ArrayStack implements Stack{
	private int top;      //need to keep track of what is currently on top of the stack
	private Object[] arr; //array that we will be using to keep track of everything
	
	public ArrayStack(){
		top = -1;
		arr = new Object[10];
	}
	//++top increments top first and then performs push function
	public void push(Object item){
		if (top+1==arr.length)
			grow_stack();
		arr[++top] = item;
	}
	//takes out item and sets it to null
	public Object pop(){
		if(empty()){
			return null;
		}
		Object val = arr[top];
		arr[top] = null;
		top--;
		return val;
	}
	
	//literally peeks at stuff
	public Object peek(){
		if (empty())
			return null;
		return arr[top];
	}
	//if top is at -1, then the array is empty
	public boolean empty(){
		if (top == -1)
			return true;
		return false;
	}
	//copys the old array into the new array
	private void grow_stack(){
		Object[] newArr = new Object[arr.length * 2];
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		arr = newArr;
	}
	
}
