package com.martian.mibook.account.request.book;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.auth.TYAuthParams;

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

    public void setCancel(Boolean cancel) {
        this.cancel = cancel;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}
