package com.itmy.edo.web.biz;

import cn.hutool.json.JSONUtil;
import com.itmy.edo.common.bean.Tree;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TreeTest {
    @Test
    void tree() {
        List<Tree> trees = initList();
        Tree root = new Tree("0", "root");
        List<Tree> tree = getTrees("0",trees);
        root.setList(tree);

        System.out.println(JSONUtil.toJsonStr(root));
    }



    @Test
    public void treelist() {
        List<Tree> trees = initList();
        Tree root = new Tree("0", "root");

        List<Tree> list = getList("0",trees);
        list.add(root);
        System.out.println(JSONUtil.toJsonStr(list));
    }

    // 递归为树
    private List<Tree> getTrees(String id, List<Tree> trees) {
        List<Tree> list = new ArrayList<>();

        for (Tree tree : trees) {
            if (tree.getPid().equals(id)) {
                list.add(tree);
                tree.setList(getTrees(tree.getId(),trees));
            }
        }
        return list;
    }

    // 递归为列表
    private List<Tree> getList(String id, List<Tree> trees) {
        List<Tree> list = new ArrayList<>();
        for (Tree tree : trees) {
            if (tree.getPid().equals(id)) {
                list.add(tree);
                list.addAll(getList(tree.getId(),trees));
            }
        }
        return list;
    }



    private List<Tree> initList() {
        List<Tree> trees = new ArrayList<>();
        trees.add(new Tree("0", "root"));
        trees.add(new Tree("1", "0"));
        trees.add(new Tree("2", "0"));
        trees.add(new Tree("6", "2"));
        trees.add(new Tree("7", "6"));
        trees.add(new Tree("3", "1"));
        trees.add(new Tree("4", "1"));
        trees.add(new Tree("5", "4"));
        return trees;
    }
}
