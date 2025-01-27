package com.bytedance.pangle.g;

import android.system.Os;
import android.system.OsConstants;
import java.io.FileDescriptor;

/* loaded from: classes.dex */
final class l implements k {

    /* renamed from: a */
    private static final long f6142a = Os.sysconf(OsConstants._SC_PAGESIZE);

    /* renamed from: b */
    private final FileDescriptor f6143b;

    /* renamed from: c */
    private final long f6144c;

    /* renamed from: d */
    private final long f6145d;

    l(FileDescriptor fileDescriptor, long j2, long j3) {
        this.f6143b = fileDescriptor;
        this.f6144c = j2;
        this.f6145d = j3;
    }

    @Override // com.bytedance.pangle.g.k
    public final long a() {
        return this.f6145d;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0113 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0142 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.bytedance.pangle.g.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.bytedance.pangle.g.j r20, long r21, int r23) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.g.l.a(com.bytedance.pangle.g.j, long, int):void");
    }
}
