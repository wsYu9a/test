package com.martian.mibook.lib.account.request;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes3.dex */
public class UserCommentsParams extends TYBookHttpGetParams {

    @a
    private String cuid;

    @a
    private Integer goto_position;

    public String getCuid() {
        return this.cuid;
    }

    public Integer getGoto_position() {
        return this.goto_position;
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "book_friend.html";
    }

    public void setCuid(String cuid) {
        this.cuid = cuid;
    }

    public void setGoto_position(Integer goto_position) {
        this.goto_position = goto_position;
    }
}
