"""
Ref
1. https://cs61bl.org/su18/labs/lab05/#discussion-addfirst
2. https://joshhug.gitbooks.io/hug61b/content/chap2/chap22.html



Consider the case below, and how you might make it so that the IntList L in main can see the changes. It’s not as straightforward as you might think!

public class IntList {
    public int first;
    public IntList rest;

    public void addFirst(int x) {
        // Describe in your own words what you might put here.
    }

    public static void main(String[] args) {
        IntList L = IntList.of(2, 3, 4, 5);
        L.addFirst(1);
        System.out.println(L.first);
    }
}
Printing out L.first should display the number 1 even without reassigning L in the main method.

Hint: If we know that the reference, L, cannot be changed, what are our options for making the changes in addFirst visible to main? We know that, 
due to Golden Rule of Equals, there’s no way to change what L points to from the addFirst method. Given these constraints, 
try drawing a box-and-pointer diagram that shows what it should look like before and after calling addFirst

Demonstrate process:

1. L----------> 15->10 
                    ^
                   /
2. new ------->  15          # Create a new node that its first = L.first, rest = L.rest. The new node replace the orignial L
                 ^
                / 

3. L --------->5            # Then change the L.first = new_value, L.rest = new_node
"""

class IntList:
    def __init__(self, first, rest):
        self.first = first
        self.rest = rest
    
    def addFirst(self, x):
        new_node = IntList(self.first, self.rest)
        self.first = x
        self.rest = new_node
 
	
L= IntNode(15, None)
L.addFirst(10)
L.addFirst(5)
