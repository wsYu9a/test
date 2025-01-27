package com.martian.mibook.lib.yuewen.response;

import com.martian.libmars.d.h;

/* loaded from: classes4.dex */
public class TYSearchTag {
    private Integer ctype;
    private String dplink;
    private String name;
    private String url;

    public int getCtype() {
        Integer num = this.ctype;
        return num == null ? h.F().k() : num.intValue();
    }

    public String getDplink() {
        return this.dplink;
    }

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setCtype(Integer ctype) {
        this.ctype = ctype;
    }

    public void setDplink(String dplink) {
        this.dplink = dplink;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
