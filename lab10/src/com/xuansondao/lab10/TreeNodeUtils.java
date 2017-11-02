package com.xuansondao.lab10;

import java.util.List;

public class TreeNodeUtils {
    public static <T> boolean contains(TreeNode<T> node, T avalue){
        if(node.getValue().equals(avalue)) return true;
        TreeNode<T> temp = node.getFirstChild();
        while (temp != null){
            if(contains(temp,avalue)) return true;
            temp = temp.getNextSibling();
        }

        return false;
    }

    public static <T> void visit(TreeNode<T> Node, TreeNodeFilter<T> filter, List<T> list){
        if(filter.filter(Node.getValue())) list.add(Node.getValue());
        TreeNode<T> temp = Node.getFirstChild();
        while (temp != null){
            visit(temp, filter, list);
            temp = temp.getNextSibling();
        }
    }
}
