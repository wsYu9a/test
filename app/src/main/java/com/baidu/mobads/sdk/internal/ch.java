package com.baidu.mobads.sdk.internal;

import android.content.SharedPreferences;
import android.os.Handler;
import com.baidu.mobads.sdk.internal.bz;

/* loaded from: classes2.dex */
class ch extends j {

    /* renamed from: b */
    final /* synthetic */ bz.c f7023b;

    /* renamed from: c */
    final /* synthetic */ Handler f7024c;

    /* renamed from: d */
    final /* synthetic */ bz f7025d;

    public ch(bz bzVar, bz.c cVar, Handler handler) {
        this.f7025d = bzVar;
        this.f7023b = cVar;
        this.f7024c = handler;
    }

    @Override // com.baidu.mobads.sdk.internal.j
    public Object i() {
        bt btVar;
        SharedPreferences m10;
        bt btVar2;
        SharedPreferences m11;
        bt btVar3;
        SharedPreferences m12;
        try {
            try {
                synchronized (bz.class) {
                    this.f7025d.b(this.f7023b, this.f7024c);
                }
                m12 = this.f7025d.m();
                SharedPreferences.Editor edit = m12.edit();
                edit.putString(bz.f6986d, this.f7025d.a());
                edit.apply();
                return null;
            } catch (Throwable th2) {
                try {
                    String str = "Load APK Failed: " + th2.toString();
                    btVar2 = this.f7025d.f7008z;
                    btVar2.a(bz.f6983a, str);
                    this.f7025d.b(false);
                    m11 = this.f7025d.m();
                    SharedPreferences.Editor edit2 = m11.edit();
                    edit2.putString(bz.f6986d, this.f7025d.a());
                    edit2.apply();
                    return null;
                } catch (Throwable th3) {
                    try {
                        m10 = this.f7025d.m();
                        SharedPreferences.Editor edit3 = m10.edit();
                        edit3.putString(bz.f6986d, this.f7025d.a());
                        edit3.apply();
                    } catch (Throwable th4) {
                        btVar = this.f7025d.f7008z;
                        btVar.a(bz.f6983a, th4);
                    }
                    throw th3;
                }
            }
        } catch (Throwable th5) {
            btVar3 = this.f7025d.f7008z;
            btVar3.a(bz.f6983a, th5);
            return null;
        }
    }
}
