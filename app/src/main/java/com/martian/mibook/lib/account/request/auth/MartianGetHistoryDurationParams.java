package com.martian.mibook.lib.account.request.auth;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes3.dex */
public class MartianGetHistoryDurationParams extends TYAuthParams {

    @a
    private Integer page;

    @a
    private Integer pageSize = 10;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "history_durations.do";
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

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPaseSize(Integer paseSize) {
        this.pageSize = paseSize;
    }
}
