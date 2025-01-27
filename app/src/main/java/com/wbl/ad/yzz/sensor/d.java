package com.wbl.ad.yzz.sensor;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.sensor.g;
import java.util.concurrent.Future;

/* loaded from: classes5.dex */
public class d extends g<String> {

    public class a implements g.a<String> {

        /* renamed from: a */
        public final /* synthetic */ boolean f33812a;

        /* renamed from: b */
        public final /* synthetic */ Context f33813b;

        public a(boolean z, Context context) {
            this.f33812a = z;
            this.f33813b = context;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.lang.String] */
        @Override // com.wbl.ad.yzz.sensor.g.a
        public /* bridge */ /* synthetic */ String a() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10745, this, null);
        }

        /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, java.lang.String] */
        @Override // com.wbl.ad.yzz.sensor.g.a
        public /* bridge */ /* synthetic */ String a(String str) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10748, this, str);
        }

        @Override // com.wbl.ad.yzz.sensor.g.a
        public /* bridge */ /* synthetic */ String a(String str) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10747, this, str);
        }

        public String b() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10742, this, null);
        }

        public String b(String str) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10741, this, str);
        }

        public String c(String str) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10744, this, str);
        }
    }

    public d(Future<SharedPreferences> future, Context context, boolean z) {
        super(future, "events_distinct_id", new a(z, context));
    }
}
