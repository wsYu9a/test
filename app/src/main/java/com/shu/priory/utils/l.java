package com.shu.priory.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bm;
import com.shu.priory.utils.a.a;

/* loaded from: classes3.dex */
public class l {

    /* renamed from: a */
    private static volatile l f17315a;

    /* renamed from: b */
    private volatile String f17316b;

    /* renamed from: c */
    private volatile boolean f17317c;

    /* renamed from: com.shu.priory.utils.l$1 */
    public class AnonymousClass1 implements a.InterfaceC0558a {

        /* renamed from: a */
        final /* synthetic */ Context f17318a;

        public AnonymousClass1(Context context) {
            context = context;
        }

        @Override // com.shu.priory.utils.a.a.InterfaceC0558a
        public void a(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            l.this.f17316b = str;
            SharedPreferences.Editor edit = e.a(context).edit();
            edit.putString("ifly_oaid", l.this.f17316b);
            edit.putLong("ifly_oaid_update_ts", System.currentTimeMillis());
            edit.apply();
        }
    }

    private l() {
    }

    public static l a() {
        if (f17315a == null) {
            synchronized (l.class) {
                try {
                    if (f17315a == null) {
                        f17315a = new l();
                    }
                } finally {
                }
            }
        }
        return f17315a;
    }

    public String a(Context context) {
        if (!TextUtils.isEmpty(this.f17316b)) {
            return this.f17316b;
        }
        try {
            String string = e.a(context).getString("ifly_oaid", "");
            if (!TextUtils.isEmpty(string)) {
                this.f17316b = string;
            }
            long j10 = e.a(context).getLong("ifly_oaid_update_ts", 0L);
            if (!this.f17317c && System.currentTimeMillis() - j10 > bm.f6899d) {
                this.f17317c = true;
                com.shu.priory.utils.a.a.a(context, new a.InterfaceC0558a() { // from class: com.shu.priory.utils.l.1

                    /* renamed from: a */
                    final /* synthetic */ Context f17318a;

                    public AnonymousClass1(Context context2) {
                        context = context2;
                    }

                    @Override // com.shu.priory.utils.a.a.InterfaceC0558a
                    public void a(String str) {
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        l.this.f17316b = str;
                        SharedPreferences.Editor edit = e.a(context).edit();
                        edit.putString("ifly_oaid", l.this.f17316b);
                        edit.putLong("ifly_oaid_update_ts", System.currentTimeMillis());
                        edit.apply();
                    }
                });
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return this.f17316b;
    }
}
