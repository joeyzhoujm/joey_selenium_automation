/**
 * Copyright (C), 2009-2020, JoeyZhou个人所有
 * FileName: TitleLinkTree
 * Author:   Joey
 * Date:     1/20/2020 9:33 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * Joey       1/20/2020 9:33 AM        1.0
 */
package com.joey.auto.test.utility.fileutil.word;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author Joey
 * @create 1/20/2020
 * @since 1.0.0
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static java.util.stream.Collectors.toList;

public final class TitleLinkTree {
    TitleLinkNode root = null;
    boolean over = false;
    private String nowOutlineLvl = "0";
    private TitleLinkNode nowParent;
    private TitleLinkNode indexNode;
    private TitleLinkNode prevNode;
    private TitleLinkNode nextNode;
    private Stack<TitleLinkNode> stack = new Stack<>();
    private int preMaxTreeOrder;

    private TitleLinkTree() {
        root = new TitleLinkNode();
        root.setName("root");
        root.setOutlineLvl("-1");
        root.setParent(null);
        root.setTreeOrder(0);
        nowParent = root;
        preMaxTreeOrder = 0;

    }

    public static TitleLinkTree newTitleLinkTree() {
        return new TitleLinkTree();
    }

    public TitleLinkTree addNewTitleNode(TitleLinkNode node) {
        if (needInit()) {
            TitleLinkTree.newTitleLinkTree();
        }

        node.setTreeOrder(++preMaxTreeOrder);

        if (!node.getOutlineLvl().equals(nowOutlineLvl)) {

            if (Integer.parseInt(node.getOutlineLvl()) > Integer.parseInt(nowOutlineLvl)) {

                stack.push(node);
                nowParent = indexNode;
                node.setParent(nowParent);
                nowParent.setHead(node);

            } else {
                // 求前节点
                for (; ; ) {
                    stack.pop();
                    prevNode = stack.peek();
                    if (prevNode.getOutlineLvl().equals(node.getOutlineLvl())) {
                        break;
                    }
                }
                // 求父节点
                int parentIndex = Integer.parseInt(node.getOutlineLvl()) - 1;

                if (parentIndex == -1) {
                    nowParent = root;
                } else {
                    nowParent = stack.get(parentIndex);
                }

                node.setParent(nowParent);
                node.setPrevious(prevNode);
                prevNode.setNext(node);
                stack.pop();
                stack.push(node);
            }
            nowOutlineLvl = node.getOutlineLvl();
        } else {
            if (!stack.isEmpty()) {
                prevNode = stack.pop();
                prevNode.setNext(node);
            }
            node.setPrevious(prevNode);
            stack.push(node);
            if (node.isHead()) {
                int parentIndex = Integer.parseInt(node.getOutlineLvl()) - 1;
                if (parentIndex == -1) {
                    root.setHead(node);
                } else {
                    nowParent = stack.get(parentIndex);
                    nowParent.setHead(node);
                }
            }
            node.setParent(nowParent);
        }
        indexNode = node;

        return this;
    }

    public boolean needInit() {
        return root == null;
    }

    public TitleLinkNode getRoot() {
        return root;
    }

    public void setRoot(TitleLinkNode root) {
        this.root = root;
    }

    public void printAllTitle() {
        List<TitleLinkNode> titleNodes = getAllOrderNodes(this.root, new ArrayList<TitleLinkNode>(), new Stack<>());
        titleNodes.stream().map(TitleLinkNode::getTitleNo).distinct().collect(toList()).forEach(System.out::println);
        titleNodes.stream().map(TitleLinkNode::getWholeTitle).distinct().collect(toList()).forEach(System.out::println);

    }

    public List<TitleLinkNode> getAllOrderNodes(TitleLinkNode root, List<TitleLinkNode> all, Stack<TitleLinkNode> nodeVos) {
        if (root != null) {
            if (root.getParent() == null && all == null) {
                all = new ArrayList<>();
            }
            if (root.getParent() != null) {
                all.add(root);

            }
            if (!nodeVos.isEmpty()) {
                TitleLinkNode top = nodeVos.peek();
                if (top.getOutlineLvl().equals(root.getOutlineLvl())) {
                    nodeVos.pop();
                }
            }
            nodeVos.push(root);

            if (root != this.root && root.getNext() == null && root.getOutlineLvl() != "0") {

                TitleLinkNode last = nodeVos.pop();
                over = last.getNext() == null && last.getHead() == null;
                for (TitleLinkNode tln : nodeVos) {
                    over = over && tln.getNext() == null;
                }
                //if(nodeVos.peek().getNext()==null) over  = true;
                getAllOrderNodes(nodeVos.peek().getNext(), all, nodeVos);

            }


            for (; ; ) {
                TitleLinkNode head = root.getHead();
                TitleLinkNode next = root.getNext();
                if (over) {
                    break;
                }
                if (head == null && next == null) {
                    break;
                }
                if (head != null) {
                    root.setReadHead(true);
                    getAllOrderNodes(head, all, nodeVos);
                } else {
                    root.setReadHead(true);
                }
                if (next != null) {
                    root.setReadNext(true);
                    getAllOrderNodes(next, all, nodeVos);
                } else {
                    root.setReadNext(true);
                }

            }
        }
        return all;
    }


}