package com.martian.mibook.lib.account.request.auth;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.TYAuthoptParams;

/* loaded from: classes.dex */
public class UserCommentParams extends TYAuthoptParams {

    @a
    private String s;

    @a
    private Integer sec;

    @Override // com.martian.mibook.lib.account.request.TYAuthoptParams
    public String getAuthoptMethod() {
        return "get_user_comment_count";
    }

    public String getS() {
        return this.s;
    }

    public Integer getSec() {
        return this.sec;
    }

    public void setS(String s) {
        this.s = s;
    }

    public void setSec(Integer sec) {
        this.sec = sec;
    }
}
