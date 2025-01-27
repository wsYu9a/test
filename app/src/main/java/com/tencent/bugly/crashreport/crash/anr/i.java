package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.proguard.X;
import java.util.HashMap;

/* loaded from: classes4.dex */
class i implements TraceFileHelper.b {

    /* renamed from: a */
    final /* synthetic */ TraceFileHelper.a f24827a;

    /* renamed from: b */
    final /* synthetic */ String f24828b;

    /* renamed from: c */
    final /* synthetic */ boolean f24829c;

    i(TraceFileHelper.a aVar, String str, boolean z) {
        this.f24827a = aVar;
        this.f24828b = str;
        this.f24829c = z;
    }

    @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
    public boolean a(String str, int i2, String str2, String str3, boolean z) {
        X.a("new thread %s", str);
        TraceFileHelper.a aVar = this.f24827a;
        if (aVar.f24799a > 0 && aVar.f24801c > 0 && aVar.f24800b != null) {
            if (aVar.f24802d == null) {
                aVar.f24802d = new HashMap();
            }
            this.f24827a.f24802d.put(str, new String[]{str2, str3, "" + i2});
        }
        return true;
    }

    @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
    public boolean a(String str, long j2, long j3) {
        return true;
    }

    @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
    public boolean a(long j2, long j3, String str) {
        X.a("new process %s", str);
        if (!str.equals(this.f24828b)) {
            return true;
        }
        TraceFileHelper.a aVar = this.f24827a;
        aVar.f24799a = j2;
        aVar.f24800b = str;
        aVar.f24801c = j3;
        return this.f24829c;
    }

    @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
    public boolean a(long j2) {
        X.a("process end %d", Long.valueOf(j2));
        TraceFileHelper.a aVar = this.f24827a;
        return aVar.f24799a <= 0 || aVar.f24801c <= 0 || aVar.f24800b == null;
    }
}
