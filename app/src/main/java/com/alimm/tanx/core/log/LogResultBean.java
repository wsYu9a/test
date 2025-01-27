package com.alimm.tanx.core.log;

import com.alimm.tanx.core.ad.bean.BaseBean;

/* loaded from: classes.dex */
public class LogResultBean extends BaseBean {
    public String content;
    public String errorCode;
    public String errorMsg;
    public String reqId;

    public LogResultBean() {
    }

    public String toString() {
        return "LogResultBean{errorCode='" + this.errorCode + "', errorMsg='" + this.errorMsg + "', reqId='" + this.reqId + "', content='" + this.content + "'} " + super.toString();
    }

    public LogResultBean(String str, String str2, String str3, String str4) {
        this.errorCode = str;
        this.errorMsg = str2;
        this.reqId = str3;
        this.content = str4;
    }
}
