package com.martian.mibook.lib.account.request;

import com.martian.libcomm.http.requests.d.a;
import com.martian.libmars.comm.request.MTHttpGetParams;

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

    @Override // com.martian.libcomm.http.requests.b
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

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setWithHeader(boolean withHeader) {
        this.withHeader = withHeader;
    }
}
