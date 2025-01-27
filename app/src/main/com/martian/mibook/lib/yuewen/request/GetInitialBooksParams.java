package com.martian.mibook.lib.yuewen.request;

import com.martian.mibook.lib.account.request.TYHttpGetParams;
import v8.a;

/* loaded from: classes3.dex */
public class GetInitialBooksParams extends TYHttpGetParams {

    @a
    private Integer ctype;

    @a
    private Boolean newUser;

    public int getCtype() {
        Integer num = this.ctype;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Boolean getNewUser() {
        return this.newUser;
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "book_mall/initial_books";
    }

    public void setCtype(Integer num) {
        this.ctype = num;
    }

    public void setNewUser(Boolean bool) {
        this.newUser = bool;
    }
}
