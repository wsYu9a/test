package com.wbl.ad.yzz.bean;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class p {

    /* renamed from: a */
    @f.b.a.d
    public static final a f31591a = new a(null);

    public static final class a {
        public a() {
        }

        public final String a(String str) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14969, this, str);
        }

        public final boolean b(String str) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14972, this, str);
        }

        public final boolean c(String str) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14971, this, str);
        }

        public final boolean d(String str) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14966, this, str);
        }

        public final p e(String str) {
            return (p) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14965, this, str);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b {

        /* renamed from: a */
        public final String f31592a;

        /* renamed from: b */
        public final String f31593b;

        /* renamed from: c */
        public String f31594c;

        /* renamed from: d */
        public String f31595d;

        public b(@f.b.a.e String str, @f.b.a.e String str2) {
            this.f31592a = str;
            this.f31593b = str2;
            a aVar = p.f31591a;
            this.f31594c = aVar.a(str);
            this.f31595d = aVar.a(str2);
        }

        public final String a() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14968, this, null);
        }

        public final String b() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14967, this, null);
        }

        public final String c() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14962, this, null);
        }

        public String toString() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14961, this, null);
        }
    }

    public static final class c extends p {

        /* renamed from: b */
        public final String f31596b;

        /* renamed from: c */
        public final String f31597c;

        /* renamed from: d */
        public volatile int f31598d;

        /* renamed from: e */
        public volatile int f31599e;

        /* renamed from: f */
        public volatile int f31600f;

        /* renamed from: g */
        public volatile String f31601g;

        /* renamed from: h */
        public volatile boolean f31602h;

        public c(@f.b.a.d String uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.f31596b = "StringLink";
            this.f31598d = -2;
            this.f31599e = -2;
            this.f31600f = -2;
            this.f31601g = "WBL_NOT_CALCULATED_-2";
            this.f31597c = uri;
        }

        @Override // com.wbl.ad.yzz.bean.p
        public String a() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14964, this, null);
        }

        public final String a(String str) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14963, this, str);
        }

        public final String a(String str, int i2) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14926, this, str, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.bean.p
        public Map<String, b> b() {
            return (Map) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14925, this, null);
        }

        @Override // com.wbl.ad.yzz.bean.p
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14928, this, null);
        }

        public final int d() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-14927, this, null);
        }

        public final String e() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14922, this, null);
        }

        public final int f() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-14921, this, null);
        }

        public final int g() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-14924, this, null);
        }

        public boolean h() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14923, this, null);
        }

        public final String i() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14918, this, null);
        }

        public final String j() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14917, this, null);
        }
    }

    @f.b.a.e
    public abstract String a();

    @f.b.a.e
    public abstract Map<String, b> b();

    public abstract void c();
}
