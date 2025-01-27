package com.wbl.ad.yzz.network.bean.request;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.config.PageOptions;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class GetConfReq extends BaseReq implements Serializable {
    private int is_active;
    private String user_id;

    public GetConfReq(String str, boolean z, String str2, PageOptions pageOptions) {
        super(pageOptions);
        this.user_id = str;
        this.is_active = z ? 1 : 0;
        setScene(str2);
    }

    public int getIs_active() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11183, this, null);
    }

    public String getUser_id() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11178, this, null);
    }

    public void setIs_active(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11177, this, Integer.valueOf(i2));
    }

    public void setUser_id(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11180, this, str);
    }
}
