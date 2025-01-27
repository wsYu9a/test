package com.martian.mibook.lib.account.request;

import com.martian.libcomm.http.requests.d.a;

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

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "comment.html";
    }

    public boolean isOpen_keyboard() {
        return this.open_keyboard;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public void setOpen_keyboard(boolean open_keyboard) {
        this.open_keyboard = open_keyboard;
    }
}
