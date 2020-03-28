import java.util.Stack;
import java.util.Arrays;

public class BalancedParenthesis {
    //Root Node
    public Node root;



    //Private Class for Node
    private class Node<E>{
        String terminal;
        Node<E>[] children;

        public Node(String terminal, Node<E>[] children){
            this.terminal = terminal;
            this.children = children;
        }

    }


    //Constructor
    public BalancedParenthesis(){
        root = new Node("N", null);
    }





    //Parse method - Goes through string, and creates tree using stacks
    public void parse(String paren_str){

        //Initliaze four stacks
        Stack s1 = new Stack();
        Stack s2 = new Stack();
        Stack s3 = new Stack();
        Stack s4 = new Stack();

        //Initlialize count for later
        int count = 0;

        //Push each individual character from string to the first stack
        for (int i = 0; i < paren_str.length();i++){
            s1.push(paren_str.charAt(i));
        }
        //Iterate until first stack is empty {For every "(" or ")"}
        while(s1.empty()== false){

            //This is where it becomes big confusion time and I wrote this like a week ago so like
            //My explanation may be of the susan quality

            //if the top of stack 1 is "(" then push it to stack 2
            if (s1.peek().equals(')')){
                s2.push(s1.pop());
            }

            //if the top of the stack 1 is "(", then pop it from that stack and also pop from the top
            //of stack 2
            if (s1.peek().equals('(')){
                s1.pop();
                s2.pop();

                //Create three new nodes (these are the nodes that you see in the tree picture on the asssignment
                Node temp3 = new Node("(", null);
                Node temp2 = new Node("N", null);
                Node temp1 = new Node(")", null);

                //Make a temporary array with the three nodes in it
                Node[] tempArray = new Node[]{temp3, temp2, temp1};

                //if stack 2 is empty then create another node (this is the node that is above the three nodes in the
                //picture, it basically connects the three nodes to the root if that makes sense (it makes dollars actually)
                if (s2.empty()==true){
                    Node subRoot = new Node("N", tempArray);
                    count++;

                    //then push that new root to stack 3
                    s3.push(subRoot);
                }


                //These last two if statements are weird and idk why it works but it does so fuck
                //if stack 4 is not empty
                if (s4.empty()==false){

                    //make a new node with whatever is in stack 4
                    Node[] newArray = new Node[]{(Node) s4.pop(), (Node) s4.pop(), (Node) s4.pop()};

                    //make the children of the middle node from a couple if statements above be equal to this array
                    temp2.children = newArray;

                }

                //if Stack 2 is not empty
                if (s2.empty()==false){
                    //then push the three nodes to it
                    s4.push(temp1);
                    s4.push(temp2);
                    s4.push(temp3);


                }

            }

        }


        //Make the root.children array have as many nodes as it needs
        Node[] finalChildrenArray = new Node[count];
        for (int i = 0; i <= finalChildrenArray.length-1; i++){
            finalChildrenArray[i] = (Node) s3.pop();
        }
        root.children = finalChildrenArray;

    }



    public void print(Node root) {
        //Base case- if the root.terminal is not null and is not equal to "N"
        if (root.terminal != null && root.terminal != "N") {

            //print it out
            System.out.print(root.terminal + "");

        }

        //if root.children is not null
        if (root.children != null) {

            //recursively go through each branch of the tree
            for (int i = 0; i < root.children.length; i++) {
                if (root.children[i] != null) {
                    print(root.children[i]);
                }


            }
        }
    }

    public void print(){
        print(root);
    }



}



