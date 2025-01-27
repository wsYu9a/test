package com.alimm.tanx.core.ut.bean;

import com.alimm.tanx.core.ad.bean.BaseBean;
import com.alimm.tanx.core.net.bean.RequestBean;

/* loaded from: classes.dex */
public class UtErrorBean extends BaseBean {
    public int errorCode;
    public String msg;
    public RequestBean requestBean;

    public UtErrorBean() {
    }

    public String toString() {
        return "UtErrorBean{requestBean=" + this.requestBean + ", errorCode='" + this.errorCode + "', msg='" + this.msg + "'} ";
    }

    public UtErrorBean(RequestBean requestBean, int i10, String str) {
        this.requestBean = requestBean;
        this.errorCode = i10;
        this.msg = str;
    }
}
