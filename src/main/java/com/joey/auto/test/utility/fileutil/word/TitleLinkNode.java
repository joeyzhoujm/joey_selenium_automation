/**
 * Copyright (C), 2009-2020, JoeyZhou个人所有
 * FileName: TitleLinkNode
 * Author:   Joey
 * Date:     1/20/2020 9:29 AM
 * Description: 一种数据结构用来实现Word提炼标题和编号
 * History:
 * <author>          <time>          <version>          <desc>
 * Joey       1/20/2020 9:29 AM        1.0          一种数据结构用来实现Word提炼标题和编号
 */
package com.joey.auto.test.utility.fileutil.word;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 〈功能简述〉<br>
 * 〈一种数据结构用来实现Word提炼标题和编号〉
 *
 * @author Joey
 * @create 1/20/2020
 * @since 1.0.0
 */

public final class TitleLinkNode {

    private String name;            // 标题名称
    private String outlineLvl;    // 大纲级别
    private String titleNo;        // 编号
    private int treeOrder;        // 树编号
    private TitleLinkNode parent;        // 父标题节点
    private TitleLinkNode previous;   // 前标题节点  previous == null
    private TitleLinkNode next;        // 后标题节点
    private TitleLinkNode head;     // 头节点

    private boolean readHead = false;
    private boolean readNext = false;

    public TitleLinkNode() {
    }

    public TitleLinkNode(String name, String outlineLvl) {
        this(name, outlineLvl, null, -1, null, null, null);
    }

    public TitleLinkNode(String name, String outlineLvl, String titleNo, int treeOrder, TitleLinkNode parent, TitleLinkNode previous, TitleLinkNode next) {
        this.name = name;
        this.outlineLvl = outlineLvl;
        this.titleNo = titleNo;
        this.treeOrder = treeOrder;
        this.parent = parent;
        this.previous = previous;
        this.next = next;
    }

    public boolean isReadHead() {
        return readHead;
    }

    public void setReadHead(boolean readHead) {
        this.readHead = readHead;
    }

    public boolean isReadNext() {
        return readNext;
    }

    public void setReadNext(boolean readNext) {
        this.readNext = readNext;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOutlineLvl() {
        return outlineLvl;
    }

    public void setOutlineLvl(String outlineLvl) {
        this.outlineLvl = outlineLvl;
    }

    public int getOrder(TitleLinkNode node) {
        int order = 1;
        while ((node = node.getPrevious()) != null) {
            order++;
        }
        return order;
    }


    public String getWholeTitle() {
        return this.getTitleNo() + "." + this.getName();
    }

    public String getTitleNo() {
        List<Integer> orders = new ArrayList<>();
        TitleLinkNode curr = this;
        for (; ; ) {
            orders.add(getOrder(curr));
            if (curr.getParent().getOutlineLvl().equals("-1")) {
                break;
            }
            curr = curr.getParent();
        }
        orders.sort(Comparator.reverseOrder());
        titleNo = orders.stream().map(e -> {
            return String.valueOf(e);
        }).collect(Collectors.joining("."));

        return titleNo;
    }

    public void setTitleNo(String titleNo) {
        this.titleNo = titleNo;
    }

    public int getTreeOrder() {
        return treeOrder;
    }

    public void setTreeOrder(int treeOrder) {
        this.treeOrder = treeOrder;
    }

    public TitleLinkNode getParent() {
        return parent;
    }

    public void setParent(TitleLinkNode parent) {
        this.parent = parent;
    }

    public TitleLinkNode getPrevious() {
        return previous;
    }

    public void setPrevious(TitleLinkNode previous) {
        this.previous = previous;
    }

    public TitleLinkNode getNext() {
        return next;
    }

    public void setNext(TitleLinkNode next) {
        this.next = next;
    }

    public boolean isHead() {
        return this.previous == null;
    }

    public boolean isTail() {
        return this.next == null;
    }


    public boolean hasParent() {
        return this.parent != null;
    }

    public TitleLinkNode getHead() {
        return head;
    }

    public void setHead(TitleLinkNode head) {
        this.head = head;
    }

    @Override
    public String toString() {
        return "TitleLinkNode{" +
                "name='" + name + '\'' +
                ", outlineLvl='" + outlineLvl + '\'' +
                ", treeOrder=" + treeOrder +
                '}';
    }
}