package com.martian.mibook.lib.account.request;

import v8.a;

/* loaded from: classes3.dex */
public class UserCommentsParams extends TYBookHttpGetParams {

    @a
    private String cuid;

    @a
    private Integer goto_position;

    @a
    private int hideNaviBar = 1;

    public String getCuid() {
        return this.cuid;
    }

    public Integer getGoto_position() {
        return this.goto_position;
    }

    public int getHideNaviBar() {
        return this.hideNaviBar;
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "book_friend.html";
    }

    public void setCuid(String str) {
        this.cuid = str;
    }

    public void setGoto_position(Integer num) {
        this.goto_position = num;
    }

    public void setHideNaviBar(int i10) {
        this.hideNaviBar = i10;
    }
}
