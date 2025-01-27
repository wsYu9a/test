package com.martian.mibook.lib.account.request;

import v8.a;

/* loaded from: classes3.dex */
public class CommentDetailParams extends TYBookHttpGetParams {

    @a
    private String chapterName;

    @a
    private Integer cid;

    @a
    private boolean open_keyboard = false;

    public String getChapterName() {
        return this.chapterName;
    }

    public Integer getCid() {
        return this.cid;
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "comment.html";
    }

    public boolean isOpen_keyboard() {
        return this.open_keyboard;
    }

    public void setChapterName(String str) {
        this.chapterName = str;
    }

    public void setCid(Integer num) {
        this.cid = num;
    }

    public void setOpen_keyboard(boolean z10) {
        this.open_keyboard = z10;
    }
}
