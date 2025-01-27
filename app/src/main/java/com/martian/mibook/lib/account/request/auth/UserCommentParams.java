package com.martian.mibook.lib.account.request.auth;

import com.martian.mibook.lib.account.request.TYAuthoptParams;
import v8.a;

/* loaded from: classes3.dex */
public class UserCommentParams extends TYAuthoptParams {

    /* renamed from: s */
    @a
    private String f13980s;

    @a
    private Integer sec;

    @Override // com.martian.mibook.lib.account.request.TYAuthoptParams
    public String getAuthoptMethod() {
        return "get_user_comment_count";
    }

    public String getS() {
        return this.f13980s;
    }

    public Integer getSec() {
        return this.sec;
    }

    public void setS(String str) {
        this.f13980s = str;
    }

    public void setSec(Integer num) {
        this.sec = num;
    }
}
