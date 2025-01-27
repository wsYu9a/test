package com.sigmob.sdk.base.views;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.logger.SigmobLog;

/* loaded from: classes4.dex */
public class f0 extends RelativeLayout {

    /* renamed from: a */
    public final w f18557a;

    /* renamed from: b */
    public final w f18558b;

    /* renamed from: c */
    public int f18559c;

    /* renamed from: d */
    public boolean f18560d;

    /* renamed from: e */
    public int f18561e;

    public f0(Context context) {
        super(context);
        this.f18559c = 0;
        this.f18560d = false;
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.f18557a = new w(context);
        w wVar = new w(context);
        this.f18558b = wVar;
        setLayoutParams(layoutParams);
        int i10 = this.f18559c;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i10, i10);
        layoutParams2.addRule(9);
        layoutParams2.addRule(20);
        wVar.setId(ClientMetadata.generateViewId());
        addView(wVar, layoutParams2);
    }

    public boolean a() {
        return this.f18560d;
    }

    public void b() {
        if (this.f18560d) {
            return;
        }
        this.f18560d = true;
        SigmobLog.d("show skip widget");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.f18559c);
        this.f18557a.setVisibility(0);
        this.f18558b.setVisibility(8);
        int i10 = (int) (this.f18559c / 3.0f);
        this.f18557a.setPadding(i10, 0, i10, 0);
        int i11 = this.f18561e;
        if (i11 > 0) {
            this.f18557a.setText(com.sigmob.sdk.base.g.a(Integer.valueOf(i11)));
        } else {
            this.f18557a.setText(com.sigmob.sdk.base.g.g());
        }
        addView(this.f18557a, layoutParams);
    }

    public int getTime() {
        return this.f18561e;
    }

    public void a(int i10) {
        this.f18561e = i10;
        if (!this.f18560d) {
            if (i10 > 0) {
                this.f18558b.setText(String.valueOf(i10));
            }
        } else if (i10 > 0) {
            this.f18557a.setText(com.sigmob.sdk.base.g.a(Integer.valueOf(i10)));
            if (this.f18557a.getVisibility() != 0) {
                this.f18557a.setVisibility(0);
            }
        }
    }
}
