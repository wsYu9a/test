package com.martian.mibook.lib.account.request.auth;

import v8.a;

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

    public void setPage(Integer num) {
        this.page = num;
    }

    public void setPaseSize(Integer num) {
        this.paseSize = num;
    }

    public void setType(Integer num) {
        this.type = num;
    }
}
