package com.wbl.ad.yzz.download.j;

import android.content.Context;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.download.f;
import f.b.a.d;
import f.b.a.e;
import java.io.File;
import java.io.FileFilter;
import java.net.HttpURLConnection;
import java.net.URL;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class b extends com.wbl.ad.yzz.download.j.a {

    /* renamed from: f */
    public final String f32108f;

    /* renamed from: g */
    public final String f32109g;

    /* renamed from: h */
    public final Object f32110h;

    /* renamed from: i */
    public final Object f32111i;

    public static final class a {

        /* renamed from: a */
        public int f32112a;

        /* renamed from: b */
        public int f32113b;

        /* renamed from: c */
        @d
        public final File f32114c;

        /* renamed from: d */
        @d
        public final File f32115d;

        public a(@d File targetFile, @d File tempFile, int i2) {
            Intrinsics.checkNotNullParameter(targetFile, "targetFile");
            Intrinsics.checkNotNullParameter(tempFile, "tempFile");
            this.f32114c = targetFile;
            this.f32112a = i2;
            this.f32115d = tempFile;
            this.f32113b = 5;
        }

        public final a a(int i2) {
            return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13989, this, Integer.valueOf(i2));
        }

        public final boolean a() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13992, this, null);
        }

        public final void b(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13991, this, Integer.valueOf(i2));
        }

        public final boolean b() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13986, this, null);
        }

        public final void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13985, this, null);
        }

        public final int d() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-13988, this, null);
        }

        public final int e() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-13987, this, null);
        }

        public final int f() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-14014, this, null);
        }

        public final int g() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-14013, this, null);
        }

        public final File h() {
            return (File) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14016, this, null);
        }

        public final File i() {
            return (File) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14015, this, null);
        }

        public final void j() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14010, this, null);
        }
    }

    /* renamed from: com.wbl.ad.yzz.download.j.b$b */
    public static final class C0719b implements FileFilter {

        /* renamed from: a */
        public final /* synthetic */ long f32116a;

        public C0719b(long j2) {
            this.f32116a = j2;
        }

        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14009, this, file);
        }
    }

    public b(@e Context context, @e String str, @e String str2) {
        super(context, str);
        this.f32108f = "HttpRangeDownload";
        this.f32110h = new Object();
        this.f32111i = new Object();
        if (str2 != null) {
            this.f32109g = str2;
        } else {
            this.f32109g = "";
        }
    }

    @Override // com.wbl.ad.yzz.download.j.c
    public Long a() {
        return (Long) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14012, this, null);
    }

    public final URL a(URL url, HttpURLConnection httpURLConnection) {
        return (URL) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14011, this, url, httpURLConnection);
    }

    public final void a(a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14006, this, aVar);
    }

    public final void a(URL url, a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14005, this, url, aVar);
    }

    public final boolean a(File file) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14008, this, file);
    }

    @Override // com.wbl.ad.yzz.download.j.c
    public int b() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-14007, this, null);
    }

    public final URL b(String str) {
        return (URL) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14002, this, str);
    }

    @Override // com.wbl.ad.yzz.download.j.c
    public void b(f fVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14001, this, fVar);
    }

    public final boolean b(File file) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14004, this, file);
    }

    @Override // com.wbl.ad.yzz.download.j.a
    public void c(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14003, this, Integer.valueOf(i2));
    }

    public final void c(File file) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13966, this, file);
    }

    public final File d(File file) {
        return (File) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13965, this, file);
    }

    public final boolean d(int i2) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13968, this, Integer.valueOf(i2));
    }

    public final File e(File file) {
        return (File) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13967, this, file);
    }

    @Override // com.wbl.ad.yzz.download.j.a
    public int f() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-13962, this, null);
    }

    public final boolean f(File file) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13961, this, file);
    }

    public final void g() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13964, this, null);
    }

    public final boolean h() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13963, this, null);
    }

    public final boolean i() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13958, this, null);
    }

    @Override // java.lang.Runnable
    public void run() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13957, this, null);
    }
}
