package com.xuansondao.lab10;

public class TestNode {
    private static void test(Node<?> node){
        while (node != null){
            System.out.println("Value is" + node.getValue());
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Node<String> root = new Node<String>("Step 1");
        Node<String> node1 = new Node<String>("Step 2");
        root.next = node1;

        Node<Integer> root2 = new Node<Integer>(99, new Node<Integer>(23, new Node<Integer>(11)));


        test(root2);
    }
}
