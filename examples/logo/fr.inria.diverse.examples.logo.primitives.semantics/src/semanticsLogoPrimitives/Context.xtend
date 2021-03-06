package semanticsLogoPrimitives

import java.util.ArrayList
import java.util.Hashtable

class Context {
	
		var ArrayList<Hashtable<String,Integer>> stack
		
		new() { 
			stack = new ArrayList<Hashtable<String,Integer>>()
		}
		
		def void reset () {
			stack = new ArrayList<Hashtable<String,Integer>>()
		}
		
		def Hashtable<String,Integer> peek() {
			return stack.last()
		}
		
		def Hashtable<String,Integer> pop() {
			stack.remove(stack.size - 1)
			return stack.last()
		}
		
		def void push(Hashtable<String,Integer> elem) {
			stack.add(elem)
		}
}