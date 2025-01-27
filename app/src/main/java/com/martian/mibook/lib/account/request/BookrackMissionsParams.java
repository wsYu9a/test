package com.martian.mibook.lib.account.request;

import v8.a;

/* loaded from: classes3.dex */
public class BookrackMissionsParams extends TYAuthoptParams {
    public static int BOOKRACK_MISSION_LEFT = 0;
    public static int BOOKRACK_MISSION_RIGHT = 1;

    @a
    private Integer ctype;

    @a
    private Integer type;

    @Override // com.martian.mibook.lib.account.request.TYAuthoptParams
    public String getAuthoptMethod() {
        return "bookrack_missions";
    }

    public Integer getCtype() {
        return this.ctype;
    }

    public Integer getType() {
        return this.type;
    }

    public void setCtype(Integer num) {
        this.ctype = num;
    }

    public void setType(Integer num) {
        this.type = num;
    }
}
