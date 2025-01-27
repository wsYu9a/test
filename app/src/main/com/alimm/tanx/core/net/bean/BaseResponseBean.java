package com.alimm.tanx.core.net.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.tanx.core.ad.bean.BaseBean;

/* loaded from: classes.dex */
public class BaseResponseBean<T> extends BaseBean {

    @JSONField(name = "seat")
    private T data;

    /* renamed from: id */
    @JSONField(name = "id")
    private int f6317id;
    private int status;

    public T getData() {
        return this.data;
    }

    public int getStatus() {
        return this.status;
    }

    public void setData(T t10) {
        this.data = t10;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }
}
