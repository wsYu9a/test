package com.wbl.ad.yzz.network.bean.request;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.config.PageOptions;
import com.wbl.ad.yzz.network.f.f;
import java.io.Serializable;
import java.util.Map;

/* loaded from: classes5.dex */
public class BaseReq extends SceneReq implements Serializable {
    private int exchange_rate;
    private int fee_mode;
    private int leave_limit;
    private String third_user_id;
    private String tpl_title;

    public BaseReq(PageOptions pageOptions) {
        if (pageOptions != null) {
            try {
                this.fee_mode = pageOptions.getmFeeMode();
                this.tpl_title = pageOptions.getmTopBarTitle();
                this.exchange_rate = pageOptions.getmExchangeRate();
                this.leave_limit = pageOptions.getmLeaveLimit();
                Map<String, String> extras = pageOptions.getExtras();
                if (extras != null) {
                    this.third_user_id = extras.get("third_user_id");
                }
            } catch (Throwable th) {
                f.a(th);
            }
        }
    }

    public void addToMap(Map<String, Object> map) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11132, this, map);
    }

    public void addToStringMap(Map<String, String> map) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11131, this, map);
    }

    public void clearBaseInfo() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11126, this, null);
    }

    public int getExchange_rate() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11125, this, null);
    }

    public int getFee_mode() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11128, this, null);
    }

    public int getLeave_limit() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11127, this, null);
    }

    public String getTpl_title() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11122, this, null);
    }

    public void setExchange_rate(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11121, this, Integer.valueOf(i2));
    }

    public void setFee_mode(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11124, this, Integer.valueOf(i2));
    }

    public void setLeave_limit(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11123, this, Integer.valueOf(i2));
    }

    public void setTpl_title(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11086, this, str);
    }
}
