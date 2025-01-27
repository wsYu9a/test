package com.wbl.ad.yzz.wigdet.k.e;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class d {

    /* renamed from: f */
    public static final Pattern f34557f = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");

    /* renamed from: g */
    public static final Pattern f34558g = Pattern.compile("GET /(.*) HTTP");

    /* renamed from: a */
    public final String f34559a;

    /* renamed from: b */
    public final long f34560b;

    /* renamed from: c */
    public final boolean f34561c;

    /* renamed from: d */
    public boolean f34562d;

    /* renamed from: e */
    public int f34563e;

    public d(String str) {
        m.a(str);
        long a2 = a(str);
        this.f34560b = Math.max(0L, a2);
        this.f34561c = a2 >= 0;
        this.f34559a = b(str);
    }

    public static d a(InputStream inputStream) throws IOException {
        return (d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8672, null, inputStream);
    }

    public final long a(String str) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.j(-8671, this, str);
    }

    public final String b(String str) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8666, this, str);
    }

    public String toString() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8665, this, null);
    }
}
