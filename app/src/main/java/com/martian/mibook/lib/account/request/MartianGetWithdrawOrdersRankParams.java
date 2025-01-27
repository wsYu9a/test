package com.martian.mibook.lib.account.request;

import com.martian.libmars.comm.request.MTHttpGetParams;
import v8.a;

/* loaded from: classes3.dex */
public class MartianGetWithdrawOrdersRankParams extends MTHttpGetParams {

    @a
    private Integer page;

    @a
    private Integer pageSize;

    @a
    private Integer type;

    @a
    private boolean withHeader;

    public MartianGetWithdrawOrdersRankParams() {
        super(new TYUrlProvider());
        this.page = 0;
        this.pageSize = 10;
        this.withHeader = false;
    }

    public int getPage() {
        Integer num = this.page;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getPageSize() {
        Integer num = this.pageSize;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "withdraw_rank";
    }

    public int getType() {
        Integer num = this.type;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public boolean getWithHeader() {
        return this.withHeader;
    }

    public void setPage(Integer num) {
        this.page = num;
    }

    public void setPageSize(Integer num) {
        this.pageSize = num;
    }

    public void setType(Integer num) {
        this.type = num;
    }

    public void setWithHeader(boolean z10) {
        this.withHeader = z10;
    }
}
