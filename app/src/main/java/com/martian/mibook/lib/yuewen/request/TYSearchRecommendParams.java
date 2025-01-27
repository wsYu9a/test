package com.martian.mibook.lib.yuewen.request;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.TYAuthoptParams;

/* loaded from: classes4.dex */
public class TYSearchRecommendParams extends TYAuthoptParams {

    @a
    private Integer ctype;

    @Override // com.martian.mibook.lib.account.request.TYAuthoptParams
    public String getAuthoptMethod() {
        return "search_recommend";
    }

    public int getCtype() {
        Integer num = this.ctype;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void setCtype(Integer ctype) {
        this.ctype = ctype;
    }
}
