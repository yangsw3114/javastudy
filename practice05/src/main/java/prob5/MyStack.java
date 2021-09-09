package prob5;

import java.io.IOException;

public class MyStack {
	private int top;
	private int stacksize;
	private String[] arr;
	public MyStack(int stacksize) {
		top=-1;
		this.stacksize=stacksize;
		arr = new String[this.stacksize];
	}
	
	public boolean isEmpty() 
	{
		return (top==-1);
	}
	public boolean isFull() {

		return (top==this.stacksize-1);
	}
	public void push(String stack) {
		if(isFull()) {
			System.out.println("Stack is full.");
		}
		else {
			arr[++top]=stack;
			//System.out.println(stack);
		}
	}
	public String pop() throws MyStackException{
		if(top<0) {
			throw new MyStackException();
		}

		return arr[top--];

	}



}