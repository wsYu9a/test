package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.proguard.X;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class j implements TraceFileHelper.b {

    /* renamed from: a */
    final /* synthetic */ TraceFileHelper.a f22437a;

    /* renamed from: b */
    final /* synthetic */ boolean f22438b;

    public j(TraceFileHelper.a aVar, boolean z10) {
        this.f22437a = aVar;
        this.f22438b = z10;
    }

    @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
    public boolean a(String str, long j10, long j11) {
        return true;
    }

    @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
    public boolean a(String str, int i10, String str2, String str3, boolean z10) {
        X.a("new thread %s", str);
        TraceFileHelper.a aVar = this.f22437a;
        if (aVar.f22405d == null) {
            aVar.f22405d = new HashMap();
        }
        this.f22437a.f22405d.put(str, new String[]{str2, str3, "" + i10});
        return true;
    }

    @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
    public boolean a(long j10, long j11, String str) {
        X.a("new process %s", str);
        TraceFileHelper.a aVar = this.f22437a;
        aVar.f22402a = j10;
        aVar.f22403b = str;
        aVar.f22404c = j11;
        return this.f22438b;
    }

    @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
    public boolean a(long j10) {
        X.a("process end %d", Long.valueOf(j10));
        return false;
    }
}
