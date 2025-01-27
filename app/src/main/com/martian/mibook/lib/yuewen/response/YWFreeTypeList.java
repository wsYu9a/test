package com.martian.mibook.lib.yuewen.response;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class YWFreeTypeList {
    private List<YWFreeType> freeTypeList;
    private List<TYTagAlias> tyTagList;

    public List<YWFreeType> getFreeTypeList() {
        return this.freeTypeList;
    }

    public List<TYTagAlias> getTyTagList() {
        if (this.tyTagList == null) {
            this.tyTagList = new ArrayList();
        }
        return this.tyTagList;
    }

    public void setFreeTypeList(List<YWFreeType> list) {
        this.freeTypeList = list;
    }

    public void setTyTagList(List<TYTagAlias> list) {
        this.tyTagList = list;
    }
}
