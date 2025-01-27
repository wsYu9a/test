package com.wbl.ad.yzz.sensor;

import android.content.SharedPreferences;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.sensor.g;
import java.util.concurrent.Future;

/* loaded from: classes5.dex */
public class e extends g<String> {

    public class a implements g.a<String> {
        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.lang.String] */
        @Override // com.wbl.ad.yzz.sensor.g.a
        public /* bridge */ /* synthetic */ String a() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10743, this, null);
        }

        /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, java.lang.String] */
        @Override // com.wbl.ad.yzz.sensor.g.a
        public /* bridge */ /* synthetic */ String a(String str) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10738, this, str);
        }

        @Override // com.wbl.ad.yzz.sensor.g.a
        public /* bridge */ /* synthetic */ String a(String str) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10737, this, str);
        }

        public String b() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10740, this, null);
        }

        public String b(String str) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10739, this, str);
        }

        public String c(String str) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10702, this, str);
        }
    }

    public e(Future<SharedPreferences> future) {
        super(future, "first_day", new a());
    }
}
