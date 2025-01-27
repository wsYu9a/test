package com.opos.mobad.cmn.service;

import com.opos.mobad.cmn.a.d;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static a f20317a;

    /* renamed from: b */
    private volatile d f20318b;

    /* renamed from: c */
    private volatile com.opos.mobad.activity.webview.a f20319c;

    public static final a a() {
        a aVar = f20317a;
        if (aVar == null) {
            synchronized (a.class) {
                aVar = f20317a;
                if (aVar == null) {
                    aVar = new a();
                    f20317a = aVar;
                }
            }
        }
        return aVar;
    }

    public void a(d dVar, com.opos.mobad.activity.webview.a aVar) {
        this.f20318b = dVar;
        this.f20319c = aVar;
    }

    public d b() {
        return this.f20318b;
    }

    public com.opos.mobad.activity.webview.a c() {
        return this.f20319c;
    }
}
