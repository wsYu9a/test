package com.martian.mibook.account.request.book;

import com.martian.mibook.lib.account.request.auth.TYAuthParams;
import v8.a;

/* loaded from: classes3.dex */
public class MiBookReplyCommentParams extends TYAuthParams {

    @a
    private Integer cid;

    @a
    private String content;

    @a
    private Integer rid;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "reply_to_comment.do";
    }

    public Integer getCid() {
        return this.cid;
    }

    public String getContent() {
        return this.content;
    }

    public Integer getRid() {
        return this.rid;
    }

    public void setCid(Integer num) {
        this.cid = num;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setRid(Integer num) {
        this.rid = num;
    }
}
