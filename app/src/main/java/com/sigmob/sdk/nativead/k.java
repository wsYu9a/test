package com.sigmob.sdk.nativead;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.utils.ResourceUtil;

/* loaded from: classes4.dex */
public class k extends RelativeLayout {

    /* renamed from: a */
    public TextView f19966a;

    /* renamed from: b */
    public TextView f19967b;

    /* renamed from: c */
    public TextView f19968c;

    /* renamed from: d */
    public TextView f19969d;

    /* renamed from: e */
    public TextView f19970e;

    /* renamed from: f */
    public TextView f19971f;

    public k(Context context) {
        super(context);
        View.inflate(context, getLayoutId(), this);
        this.f19966a = (TextView) findViewById(ResourceUtil.getId(getContext(), "sig_app_info_name"));
        this.f19968c = (TextView) findViewById(ResourceUtil.getId(getContext(), "sig_app_info_ver"));
        this.f19969d = (TextView) findViewById(ResourceUtil.getId(getContext(), "sig_app_info_dev"));
        this.f19970e = (TextView) findViewById(ResourceUtil.getId(getContext(), "sig_app_info_privacy"));
        this.f19971f = (TextView) findViewById(ResourceUtil.getId(getContext(), "sig_app_info_permissions"));
        this.f19967b = (TextView) findViewById(ResourceUtil.getId(getContext(), "sig_app_info_product"));
        this.f19968c.getPaint().setFlags(8);
        this.f19968c.getPaint().setAntiAlias(true);
        this.f19966a.getPaint().setFlags(8);
        this.f19966a.getPaint().setAntiAlias(true);
        this.f19969d.getPaint().setFlags(8);
        this.f19969d.getPaint().setAntiAlias(true);
        this.f19970e.getPaint().setFlags(8);
        this.f19970e.getPaint().setAntiAlias(true);
        this.f19971f.getPaint().setFlags(8);
        this.f19971f.getPaint().setAntiAlias(true);
        this.f19967b.getPaint().setFlags(8);
        this.f19967b.getPaint().setAntiAlias(true);
    }

    private int getLayoutId() {
        return ResourceUtil.getLayoutId(getContext(), "sig_app_info_layout");
    }

    public void a(String str, String str2) {
    }
}
