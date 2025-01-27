package com.baidu.mobads.sdk.internal;

import android.content.SharedPreferences;
import android.os.Handler;
import com.baidu.mobads.sdk.internal.bw;

/* loaded from: classes.dex */
class ce extends h {

    /* renamed from: b */
    final /* synthetic */ bw.c f5692b;

    /* renamed from: c */
    final /* synthetic */ Handler f5693c;

    /* renamed from: d */
    final /* synthetic */ bw f5694d;

    ce(bw bwVar, bw.c cVar, Handler handler) {
        this.f5694d = bwVar;
        this.f5692b = cVar;
        this.f5693c = handler;
    }

    @Override // com.baidu.mobads.sdk.internal.h
    protected Object i() {
        bq bqVar;
        SharedPreferences m;
        bq bqVar2;
        SharedPreferences m2;
        bq bqVar3;
        SharedPreferences m3;
        try {
            try {
                synchronized (bw.class) {
                    this.f5694d.b(this.f5692b, this.f5693c);
                }
                m3 = this.f5694d.m();
                SharedPreferences.Editor edit = m3.edit();
                edit.putString(bw.f5671d, this.f5694d.a());
                edit.apply();
                return null;
            } catch (Throwable th) {
                try {
                    String str = "Load APK Failed: " + th.toString();
                    bqVar2 = this.f5694d.z;
                    bqVar2.a(bw.f5668a, str);
                    this.f5694d.b(false);
                    m2 = this.f5694d.m();
                    SharedPreferences.Editor edit2 = m2.edit();
                    edit2.putString(bw.f5671d, this.f5694d.a());
                    edit2.apply();
                    return null;
                } catch (Throwable th2) {
                    try {
                        m = this.f5694d.m();
                        SharedPreferences.Editor edit3 = m.edit();
                        edit3.putString(bw.f5671d, this.f5694d.a());
                        edit3.apply();
                    } catch (Throwable th3) {
                        bqVar = this.f5694d.z;
                        bqVar.a(bw.f5668a, th3);
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            bqVar3 = this.f5694d.z;
            bqVar3.a(bw.f5668a, th4);
            return null;
        }
    }
}
