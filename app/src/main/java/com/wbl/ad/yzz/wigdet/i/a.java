package com.wbl.ad.yzz.wigdet.i;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.R;
import com.wbl.ad.yzz.counttimer.b;
import f.b.a.e;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a */
    public final Context f34522a;

    /* renamed from: b */
    public final View f34523b;

    /* renamed from: c */
    public final TextView f34524c;

    /* renamed from: d */
    public final TextView f34525d;

    /* renamed from: e */
    public final ImageView f34526e;

    /* renamed from: f */
    public com.wbl.ad.yzz.counttimer.a f34527f;

    /* renamed from: g */
    public InterfaceC0801a f34528g;

    /* renamed from: com.wbl.ad.yzz.wigdet.i.a$a */
    public interface InterfaceC0801a {
        void a();
    }

    public static final class b {

        /* renamed from: a */
        public static final int f34529a = 1;

        /* renamed from: b */
        public static final int f34530b = 2;

        /* renamed from: c */
        @f.b.a.d
        public static final b f34531c = new b();

        public final int a() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-8704, this, null);
        }

        public final int b() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-8703, this, null);
        }
    }

    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8698, this, view);
        }
    }

    public static final class d implements b.a {

        /* renamed from: b */
        public final /* synthetic */ long f34534b;

        /* renamed from: c */
        public final /* synthetic */ b.a f34535c;

        public d(long j2, b.a aVar) {
            this.f34534b = j2;
            this.f34535c = aVar;
        }

        @Override // com.wbl.ad.yzz.counttimer.b.a
        public void a(long j2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8697, this, Long.valueOf(j2));
        }

        @Override // com.wbl.ad.yzz.counttimer.b.a
        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8700, this, null);
        }

        @Override // com.wbl.ad.yzz.counttimer.b.a
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8699, this, null);
        }
    }

    public a(@e Context context, int i2, @e View view) {
        this.f34522a = context == null ? view != null ? view.getContext() : null : context;
        this.f34523b = view != null ? view.findViewById(R.id.cl_download_tips_container) : null;
        this.f34524c = view != null ? (TextView) view.findViewById(R.id.tv_download_tips_click_content) : null;
        if (view != null) {
        }
        this.f34525d = view != null ? (TextView) view.findViewById(R.id.tv_download_tips_count_down) : null;
        this.f34526e = view != null ? (ImageView) view.findViewById(R.id.iv_download_tips_icon) : null;
        a();
        c();
        d();
    }

    public static final /* synthetic */ InterfaceC0801a a(a aVar) {
        return (InterfaceC0801a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8694, null, aVar);
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8695, this, null);
    }

    public final void a(long j2, b.a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8690, this, Long.valueOf(j2), aVar);
    }

    public final void a(InterfaceC0801a interfaceC0801a) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8689, this, interfaceC0801a);
    }

    public final void a(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8692, this, str);
    }

    public final void a(String str, int i2, int i3) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8691, this, str, Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8654, this, null);
    }

    public final void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8653, this, null);
    }

    public final void d() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8656, this, null);
    }

    public final void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8655, this, null);
    }
}
