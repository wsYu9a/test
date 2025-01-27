package com.wbl.ad.yzz.innerconfig.d;

import android.content.Context;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.bean.AdPageNeedData;
import com.wbl.ad.yzz.config.OnInfoEventListener;
import com.wbl.ad.yzz.config.PageOptions;
import com.wbl.ad.yzz.network.b.b.c0;
import com.wbl.ad.yzz.network.b.b.u;
import com.wbl.ad.yzz.network.b.b.v;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class i implements d {

    /* renamed from: a */
    public final e f32833a;

    /* renamed from: b */
    public String f32834b;

    /* renamed from: c */
    public String f32835c;

    /* renamed from: d */
    public String f32836d;

    /* renamed from: e */
    public boolean f32837e;

    /* renamed from: f */
    public boolean f32838f;

    /* renamed from: g */
    @f.b.a.e
    public AdPageNeedData f32839g;

    /* renamed from: h */
    @f.b.a.e
    public String f32840h;

    /* renamed from: i */
    @f.b.a.e
    public List<com.wbl.ad.yzz.adapter.d.b> f32841i;

    /* renamed from: j */
    @f.b.a.e
    public v f32842j;

    @f.b.a.e
    public com.wbl.ad.yzz.network.b.b.k k;
    public final o l;
    public int m;
    public int n;
    public com.wbl.ad.yzz.gudie.c o;
    public com.wbl.ad.yzz.gudie.a p;
    public final com.wbl.ad.yzz.network.c.a q;
    public n r;
    public int s;
    public PageOptions t;
    public final Map<String, Integer> u;

    public i(@f.b.a.d e scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.f32834b = "";
        this.f32835c = "";
        this.f32836d = "";
        this.m = -1;
        this.n = -1;
        this.q = new com.wbl.ad.yzz.network.c.a();
        this.f32833a = scene;
        this.l = new o(scene.getKey());
        this.u = new HashMap();
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public int a(Context context) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-13158, this, context);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public e a() {
        return (e) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13157, this, null);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public void a(AdPageNeedData adPageNeedData) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13160, this, adPageNeedData);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public void a(OnInfoEventListener onInfoEventListener) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13159, this, onInfoEventListener);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public void a(PageOptions pageOptions) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13154, this, pageOptions);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public void a(com.wbl.ad.yzz.network.b.b.k kVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13153, this, kVar);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public void a(v vVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13156, this, vVar);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public void a(Integer num) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13155, this, num);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public void a(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13182, this, str);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public void a(String str, int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13181, this, str, Integer.valueOf(i2));
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public void a(List<com.wbl.ad.yzz.adapter.d.b> list) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13184, this, list);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public void a(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13183, this, Boolean.valueOf(z));
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public int b(String str) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-13178, this, str);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public c0 b() {
        return (c0) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13177, this, null);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public void b(Context context) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13180, this, context);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public void b(PageOptions pageOptions) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13179, this, pageOptions);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public void b(String str, int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13174, this, str, Integer.valueOf(i2));
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public void b(List<com.wbl.ad.yzz.adapter.d.b> list) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13173, this, list);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public void b(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13176, this, Boolean.valueOf(z));
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public int c(Context context) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-13175, this, context);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public com.wbl.ad.yzz.network.b.b.k c() {
        return (com.wbl.ad.yzz.network.b.b.k) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13170, this, null);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public int d(Context context) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-13169, this, context);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public void d() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13172, this, null);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public int e(Context context) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-13171, this, context);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13134, this, null);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public v f() {
        return (v) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13133, this, null);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public void f(Context context) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13136, this, context);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public int g() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-13135, this, null);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public void g(Context context) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13130, this, context);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public void h(Context context) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13129, this, context);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public boolean h() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13132, this, null);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public PageOptions i() {
        return (PageOptions) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13131, this, null);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public boolean j() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13126, this, null);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public List<com.wbl.ad.yzz.adapter.d.b> k() {
        return (List) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13125, this, null);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public n l() {
        return (n) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13128, this, null);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public String m() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13127, this, null);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public com.wbl.ad.yzz.gudie.c n() {
        return (com.wbl.ad.yzz.gudie.c) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13122, this, null);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public String o() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13121, this, null);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public int p() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-13124, this, null);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public String q() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13123, this, null);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public com.wbl.ad.yzz.network.c.a r() {
        return (com.wbl.ad.yzz.network.c.a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13150, this, null);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public AdPageNeedData s() {
        return (AdPageNeedData) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13149, this, null);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public String t() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13152, this, null);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public com.wbl.ad.yzz.gudie.a u() {
        return (com.wbl.ad.yzz.gudie.a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13151, this, null);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public String v() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13146, this, null);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public String w() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13145, this, null);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public boolean x() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13148, this, null);
    }

    @Override // com.wbl.ad.yzz.innerconfig.d.d
    public u y() {
        return (u) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13147, this, null);
    }
}
