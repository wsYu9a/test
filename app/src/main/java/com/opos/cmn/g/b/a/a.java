package com.opos.cmn.g.b.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.opos.cmn.an.transactivity.api.b;

/* loaded from: classes4.dex */
public class a extends b {

    /* renamed from: a */
    private String f17413a;

    public a(String str) {
        this.f17413a = "";
        this.f17413a = str;
    }

    @Override // com.opos.cmn.an.transactivity.api.b, com.opos.cmn.an.transactivity.a.a
    public void a(Activity activity, Bundle bundle) {
        try {
            if (activity != null) {
                try {
                    com.opos.cmn.an.f.a.b("MkdlTransLifeCallback", "marketUrl:" + this.f17413a);
                    com.opos.cmn.g.b.b.a.a((Context) activity, this.f17413a);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("MkdlTransLifeCallback", "onCreate", e2);
                }
            }
        } finally {
            activity.finish();
        }
    }
}
