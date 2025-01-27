package com.opos.cmn.func.dl.base.a;

import android.content.Context;
import com.opos.cmn.func.dl.base.exception.DlException;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    static final String f17216a = "a";

    /* renamed from: b */
    b f17217b;

    /* renamed from: c */
    Context f17218c;

    /* renamed from: com.opos.cmn.func.dl.base.a.a$a */
    static final class C0390a {

        /* renamed from: a */
        String f17219a;

        /* renamed from: b */
        String f17220b;

        /* renamed from: c */
        String f17221c;

        /* renamed from: d */
        long f17222d;

        /* renamed from: e */
        boolean f17223e;

        /* renamed from: f */
        boolean f17224f;

        C0390a() {
        }
    }

    public a(b bVar) {
        this.f17217b = bVar;
        this.f17218c = bVar.f17251a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00cd A[Catch: all -> 0x0195, Exception -> 0x0197, DlException -> 0x01bf, TryCatch #1 {DlException -> 0x01bf, blocks: (B:3:0x001e, B:5:0x003d, B:7:0x0052, B:8:0x0059, B:10:0x005a, B:11:0x0063, B:12:0x0064, B:14:0x0071, B:17:0x007f, B:19:0x0085, B:22:0x0092, B:23:0x0099, B:24:0x009a, B:27:0x00b7, B:29:0x00cd, B:30:0x00d7, B:65:0x00ab), top: B:2:0x001e, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ab A[Catch: all -> 0x0195, Exception -> 0x0197, DlException -> 0x01bf, TryCatch #1 {DlException -> 0x01bf, blocks: (B:3:0x001e, B:5:0x003d, B:7:0x0052, B:8:0x0059, B:10:0x005a, B:11:0x0063, B:12:0x0064, B:14:0x0071, B:17:0x007f, B:19:0x0085, B:22:0x0092, B:23:0x0099, B:24:0x009a, B:27:0x00b7, B:29:0x00cd, B:30:0x00d7, B:65:0x00ab), top: B:2:0x001e, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.opos.cmn.func.dl.base.a.a.C0390a a() {
        /*
            Method dump skipped, instructions count: 486
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.func.dl.base.a.a.a():com.opos.cmn.func.dl.base.a.a$a");
    }

    public final void a(boolean z) {
        b bVar = this.f17217b;
        boolean z2 = true;
        if (z) {
            bVar.n = true;
        }
        if (!z && !bVar.n && !bVar.q.f17199i) {
            z2 = false;
        }
        if (!z2 && com.opos.cmn.an.h.c.a.c(this.f17218c)) {
            throw new DlException(1013);
        }
    }
}
