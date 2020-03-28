import java.util.Stack;
import java.util.Arrays;

public class BalancedParenthesis {
    public Node root;

    private class Node<E>{
        String terminal;
        Node<E>[] children;

        public Node(String terminal, Node<E>[] children){
            this.terminal = terminal;
            this.children = children;
        }

    }

    public BalancedParenthesis(){
        root = new Node("N", null);
    }

    public void parse(String paren_str){
        Stack s1 = new Stack();
        Stack s2 = new Stack();
        Stack s3 = new Stack();
        Stack s4 = new Stack();
        int count = 0;

        //push all char values to stack
        for (int i = 0; i < paren_str.length();i++){
            s1.push(paren_str.charAt(i));
        }

        while(s1.empty()== false){

            if (s1.peek().equals(')')){
                s2.push(s1.pop());


            }

            if (s1.peek().equals('(')){
                s1.pop();
                s2.pop();
                Node temp3 = new Node("(", null);
                Node temp2 = new Node("N", null);
                Node temp1 = new Node(")", null);

                Node[] tempArray = new Node[]{temp3, temp2, temp1};


                if (s2.empty()==true){
                    Node subRoot = new Node("N", tempArray);
                    count++;
                    s3.push(subRoot);
                }

                if (s4.empty()==false){
                    Node[] newArray = new Node[]{(Node) s4.pop(), (Node) s4.pop(), (Node) s4.pop()};
                    temp2.children = newArray;

                }

                if (s2.empty()==false){
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


    //change return statement
    public void print(Node root) {
        if (root.terminal != null && root.terminal != "N") {
            System.out.print(root.terminal + "");

        }

        if (root.children != null) {


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



