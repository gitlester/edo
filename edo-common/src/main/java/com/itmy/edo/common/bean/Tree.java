package com.itmy.edo.common.bean;

import java.util.List;

public class Tree {
    String id;
    String pid;

    List<Tree> list;

    public Tree(String id, String pid) {
        this.id = id;
        this.pid = pid;
    }

    public Tree() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public List<Tree> getList() {
        return list;
    }

    public void setList(List<Tree> list) {
        this.list = list;
    }
}
