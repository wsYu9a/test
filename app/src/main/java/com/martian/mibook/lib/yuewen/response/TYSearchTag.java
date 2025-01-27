package com.martian.mibook.lib.yuewen.response;

import com.martian.libmars.common.ConfigSingleton;

/* loaded from: classes3.dex */
public class TYSearchTag {
    private Integer ctype;
    private String dplink;
    private String name;
    private String url;

    public int getCtype() {
        Integer num = this.ctype;
        return num == null ? ConfigSingleton.D().p() : num.intValue();
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

    public void setCtype(Integer num) {
        this.ctype = num;
    }

    public void setDplink(String str) {
        this.dplink = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
