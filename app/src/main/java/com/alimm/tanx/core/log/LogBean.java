package com.alimm.tanx.core.log;

import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.bean.BaseBean;
import com.alimm.tanx.core.ut.bean.BaseUtBean;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class LogBean extends BaseBean {
    public BaseUtBean device;
    public List<LogItemBean> events;
    public String reqId = uuid();

    public LogBean() {
    }

    private String uuid() {
        return UUID.randomUUID().toString().replace("-", "") + "-" + (System.currentTimeMillis() / 1000);
    }

    public String toString() {
        return "UtBean{device=" + this.device + ", events=" + this.events + "} " + super.toString();
    }

    public LogBean(LogItemBean logItemBean) {
        TanxCoreSdk.logCheckSdkInit();
        ArrayList arrayList = new ArrayList();
        arrayList.add(logItemBean);
        this.events = arrayList;
    }

    public LogBean(List<LogItemBean> list) {
        TanxCoreSdk.logCheckSdkInit();
        this.events = list;
    }

    public LogBean(BaseUtBean baseUtBean, List<LogItemBean> list) {
        this.device = baseUtBean;
        this.events = list;
    }
}
