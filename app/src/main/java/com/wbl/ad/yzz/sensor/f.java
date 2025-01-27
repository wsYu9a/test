package com.wbl.ad.yzz.sensor;

import android.content.SharedPreferences;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.sensor.g;
import java.util.concurrent.Future;

/* loaded from: classes5.dex */
public class f extends g<Boolean> {

    public class a implements g.a<Boolean> {
        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Boolean, java.lang.Object] */
        @Override // com.wbl.ad.yzz.sensor.g.a
        public /* bridge */ /* synthetic */ Boolean a() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10704, this, null);
        }

        /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Boolean, java.lang.Object] */
        @Override // com.wbl.ad.yzz.sensor.g.a
        public /* bridge */ /* synthetic */ Boolean a(String str) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10703, this, str);
        }

        /* renamed from: a */
        public String a2(Boolean bool) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10698, this, bool);
        }

        @Override // com.wbl.ad.yzz.sensor.g.a
        public /* bridge */ /* synthetic */ String a(Boolean bool) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10697, this, bool);
        }

        public Boolean b() {
            return (Boolean) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10700, this, null);
        }

        public Boolean b(String str) {
            return (Boolean) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10699, this, str);
        }
    }

    public f(Future<SharedPreferences> future) {
        super(future, "first_start", new a());
    }
}
