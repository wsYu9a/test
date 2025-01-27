package com.martian.mibook.account.request.book;

import com.martian.mibook.lib.account.request.auth.TYAuthParams;
import v8.a;

/* loaded from: classes3.dex */
public class MiBookVoteCommentParams extends TYAuthParams {

    @a
    private Boolean cancel;

    @a
    private Integer cid;

    @a
    private Integer rid;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "up_comment.do";
    }

    public Boolean getCancel() {
        return this.cancel;
    }

    public Integer getCid() {
        return this.cid;
    }

    public Integer getRid() {
        return this.rid;
    }

    public void setCancel(Boolean bool) {
        this.cancel = bool;
    }

    public void setCid(Integer num) {
        this.cid = num;
    }

    public void setRid(Integer num) {
        this.rid = num;
    }
}
