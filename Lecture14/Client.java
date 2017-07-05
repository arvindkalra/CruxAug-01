package Lecture14;

import java.util.Scanner;

import Lecture12_StacksAndQues.DynamicQues;
import Lecture12_StacksAndQues.DynamicStack;

public class Client {

	public static void main(String[] args) throws Exception {
		lexico(1000, 0);
		System.out.println(isBalanced(""));
		DynamicQues queue = new DynamicQues();
		
		queue.enque(10);
		queue.enque(20);
		queue.enque(30);
		queue.enque(40);
		queue.enque(50);
		
		queue.display();
		reverseTheQue(queue);
		queue.display();
		
		DynamicStack stack = new DynamicStack();
		DynamicStack helper = new DynamicStack();
		
		stack.push(50);
		stack.push(40);
		stack.push(30);
		stack.push(20);
		stack.push(10);
		
		stack.display();
		reverseTheStack2(stack, helper, 0);
		reverseTheStack3(stack, helper);
		Pair stackPair = new Pair(stack, helper);
		reverseTheStack4(stackPair);
		stackPair.stack.display();
	}

	public static void lexico(int max, int num) {
		if(num > max){
			return;
		}
		
		System.out.println(num);
		for(int i = 0; i <= 9; i++){
			if(num == 0 && i == 0){
				continue;
			}
			lexico(max, 10 * num + i);
		}
	}

	public static boolean isBalanced(String exp) throws Exception {
		DynamicStack stack = new DynamicStack();
		
		for(int i = 0; i < exp.length(); i++){
			char cc = exp.charAt(i);
			
			if(cc == '(' || cc == '{' || cc == '['){
				stack.push(cc);
			}
			else if(cc == ')' || cc == '}' || cc == ']'){
				if(stack.isEmpty()){
					return false;
				}
				
				char tc = (char)stack.top();
				if(cc == ')' && tc == '('){
					stack.pop();
				}
				else if(cc == '}' && tc == '{'){
					stack.pop();
				}
				else if(cc == ']' && tc == '['){
					stack.pop();
				}
				else {
					return false;
				}
			}
		}
		
		if(stack.isEmpty()){
			return true;
		}
		else {
			return false;
		}
	}

	public static void reverseTheQueue(DynamicQueue queue) throws Exception{
		if(queue.isEmpty()){
			return;
		}
		
		int el = queue.dequeue();
		reverseTheQueue(queue);
		queue.enqueue(el);
	}
	
	public static void reverseTheStack1(DynamicStack stack, DynamicStack helper, int level) throws Exception{
		if(stack.isEmpty()){
			return;
		}
		
		int el = stack.pop();
		reverseTheStack1(stack, helper, level + 1);
		helper.push(el);
		
		if(level == 0){
			while(!helper.isEmpty()){
				stack.push(helper.pop());
			}
		}
	}
	
	public static void reverseTheStack2(DynamicStack stack, DynamicStack helper, int level) throws Exception{
		if(helper.isEmpty() && level != 0){
			return;
		}
		
		if(level == 0){
			while(!stack.isEmpty()){
				helper.push(stack.pop());
			}
		}
		
		int el = helper.pop();
		reverseTheStack2(stack, helper, level + 1);
		stack.push(el);
	}

	public static void reverseTheStack3(DynamicStack stack, DynamicStack helper) throws Exception {
		if(stack.isEmpty()){
			stack = helper;
			return;
		}
		
		helper.push(stack.pop());
		reverseTheStack3(stack, helper);
	}
	
	public static void reverseTheStack4(Pair stackPair) throws Exception{
		if(stackPair.stack.isEmpty()){
			stackPair.stack = stackPair.helper;
			return;
		}
		
		stackPair.helper.push(stackPair.stack.pop());
		reverseTheStack4(stackPair);
	}
	
	public static class Pair {
		DynamicStack stack;
		DynamicStack helper;
		
		Pair(DynamicStack stack, DynamicStack helper){
			this.stack = stack;
			this.helper = helper;
		}
	}
}
