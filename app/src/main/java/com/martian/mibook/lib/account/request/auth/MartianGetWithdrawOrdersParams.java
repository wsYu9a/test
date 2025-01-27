package com.martian.mibook.lib.account.request.auth;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes3.dex */
public class MartianGetWithdrawOrdersParams extends TYAuthParams {

    @a
    private Integer page;

    @a
    private Integer paseSize = 10;

    @a
    private Integer type;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "withdraw_orders.do";
    }

    public int getPage() {
        Integer num = this.page;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getPageSize() {
        Integer num = this.paseSize;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getType() {
        Integer num = this.type;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPaseSize(Integer paseSize) {
        this.paseSize = paseSize;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
