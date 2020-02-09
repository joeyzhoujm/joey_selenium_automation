/**
 * Copyright (C), 2009-2020, JoeyZhou个人所有
 * FileName: a
 * Author:   Joey
 * Date:     1/20/2020 9:46 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * Joey       1/20/2020 9:46 AM        1.0
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

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public final class XWPFUtil2 {

    /**
     * Logger
     */
    private static Logger log = LoggerFactory.getLogger(XWPFUtil2.class);

    public static void main(String[] args) throws Exception {//D:\\words\\daik.docx
        XWPFDocument docx = new XWPFDocument(); //
        List<XWPFParagraph> graphs = docx.getParagraphs();

        long start = System.currentTimeMillis();
        TitleLinkTree tree = TitleLinkTree.newTitleLinkTree();
        for (XWPFParagraph graph : graphs) {

            if (graph.getStyleID() != null && graph.getStyleID().matches("\\d") && graph.getText() != null && !graph.getText().trim().equals("")) {
                // stack
                TitleLinkNode node = new TitleLinkNode(graph.getText(), "2");
                tree.addNewTitleNode(node);
            }
        }
        long endBuid = System.currentTimeMillis();

        System.out.println("构建树耗时：" + (endBuid - start));
        List<TitleLinkNode> nodes = tree.getAllOrderNodes(tree.getRoot(), new ArrayList<>(), new Stack<TitleLinkNode>());

        System.out.println("node.size()==" + nodes.size());

        nodes = nodes.stream().distinct().collect(Collectors.toList());
        nodes.forEach(System.out::println);
        long endPrintEach = System.currentTimeMillis();

        System.out.println("构建树、打印每个数元素耗时：" + (endPrintEach - start));
        for (TitleLinkNode n : nodes) {
            System.out.println(n.getWholeTitle());
        }
        //tree.printAllTitle();
        long endPrintTitle = System.currentTimeMillis();
        System.out.println("构建树、打印每个数元素、打印标题耗时：" + (endPrintTitle - start));

    }

}