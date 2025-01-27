package com.alimm.tanx.core.ad.bean;

import android.view.View;

/* loaded from: classes.dex */
public class ViewBean extends BaseBean {

    /* renamed from: id */
    private int f6315id;
    private String msg;
    private View view;

    public ViewBean(int i10, View view, String str) {
        this.f6315id = i10;
        this.view = view;
        this.msg = str;
    }

    public int getId() {
        return this.f6315id;
    }

    public String getMsg() {
        return this.msg;
    }

    public View getView() {
        return this.view;
    }

    public void setId(int i10) {
        this.f6315id = i10;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setView(View view) {
        this.view = view;
    }
}
