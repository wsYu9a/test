package fh;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes4.dex */
public final class c implements ThreadFactory {

    /* renamed from: b */
    public String f26042b;

    /* renamed from: c */
    public int f26043c = 0;

    public c(String str) {
        this.f26042b = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f26042b);
        sb2.append(hf.e.f26694a);
        int i10 = this.f26043c;
        this.f26043c = i10 + 1;
        sb2.append(i10);
        return new Thread(runnable, sb2.toString());
    }
}
