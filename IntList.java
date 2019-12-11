public class IntList {
    public int first;
    public IntList rest;
 
    /** Return the size of the list using ... recursion! */
    public int size {

        if (this.rest == null) {
            return 1;
        }
        else {
            return 1 + this.rest.size();
        }
    } 

       /** Return the size of the list using no recuresion! */
    public int iterativeSzie() {
        IntList p = this;
        int to
    }  
}