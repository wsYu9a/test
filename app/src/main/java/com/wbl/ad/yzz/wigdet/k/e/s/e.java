package com.wbl.ad.yzz.wigdet.k.e.s;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes5.dex */
public abstract class e implements com.wbl.ad.yzz.wigdet.k.e.s.a {

    /* renamed from: a */
    public final ExecutorService f34636a = Executors.newSingleThreadExecutor();

    public class a implements Callable<Void> {

        /* renamed from: a */
        public final File f34637a;

        public a(File file) {
            this.f34637a = file;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.lang.Void] */
        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Void call() throws Exception {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7776, this, null);
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: call */
        public Void call2() throws Exception {
            return (Void) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7775, this, null);
        }
    }

    public final long a(List<File> list) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.j(-7769, this, list);
    }

    @Override // com.wbl.ad.yzz.wigdet.k.e.s.a
    public void a(File file) throws IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7772, this, file);
    }

    public abstract boolean a(File file, long j2, int i2);

    public final void b(File file) throws IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7771, this, file);
    }

    public final void b(List<File> list) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7766, this, list);
    }
}
