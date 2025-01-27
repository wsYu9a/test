package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.proguard.X;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class i implements TraceFileHelper.b {

    /* renamed from: a */
    final /* synthetic */ TraceFileHelper.a f22434a;

    /* renamed from: b */
    final /* synthetic */ String f22435b;

    /* renamed from: c */
    final /* synthetic */ boolean f22436c;

    public i(TraceFileHelper.a aVar, String str, boolean z10) {
        this.f22434a = aVar;
        this.f22435b = str;
        this.f22436c = z10;
    }

    @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
    public boolean a(String str, long j10, long j11) {
        return true;
    }

    @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
    public boolean a(String str, int i10, String str2, String str3, boolean z10) {
        X.a("new thread %s", str);
        TraceFileHelper.a aVar = this.f22434a;
        if (aVar.f22402a > 0 && aVar.f22404c > 0 && aVar.f22403b != null) {
            if (aVar.f22405d == null) {
                aVar.f22405d = new HashMap();
            }
            this.f22434a.f22405d.put(str, new String[]{str2, str3, "" + i10});
        }
        return true;
    }

    @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
    public boolean a(long j10, long j11, String str) {
        X.a("new process %s", str);
        if (!str.equals(this.f22435b)) {
            return true;
        }
        TraceFileHelper.a aVar = this.f22434a;
        aVar.f22402a = j10;
        aVar.f22403b = str;
        aVar.f22404c = j11;
        return this.f22436c;
    }

    @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
    public boolean a(long j10) {
        X.a("process end %d", Long.valueOf(j10));
        TraceFileHelper.a aVar = this.f22434a;
        return aVar.f22402a <= 0 || aVar.f22404c <= 0 || aVar.f22403b == null;
    }
}
