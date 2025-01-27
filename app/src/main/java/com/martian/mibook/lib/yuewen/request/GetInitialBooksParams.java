package com.martian.mibook.lib.yuewen.request;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.TYHttpGetParams;

/* loaded from: classes4.dex */
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

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "book_mall/initial_books";
    }

    public void setCtype(Integer ctype) {
        this.ctype = ctype;
    }

    public void setNewUser(Boolean newUser) {
        this.newUser = newUser;
    }
}
