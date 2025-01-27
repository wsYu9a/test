package com.wbl.ad.yzz.network.bean.request;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class LeaveAdPageReq extends SceneReq implements Serializable {
    private int is_active;
    private int total_rp;
    private int user_id;

    public LeaveAdPageReq() {
    }

    public int getIs_active() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11236, this, null);
    }

    public int getTotal_rp() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11235, this, null);
    }

    public int getUser_id() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11262, this, null);
    }

    public void setIs_active(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11261, this, Integer.valueOf(i2));
    }

    public void setTotal_rp(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11264, this, Integer.valueOf(i2));
    }

    public void setUser_id(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11263, this, Integer.valueOf(i2));
    }

    public LeaveAdPageReq(int i2, int i3, int i4, String str) {
        this.user_id = i2;
        this.is_active = i3;
        this.total_rp = i4;
        setScene(str);
    }
}
