package com.wbl.ad.yzz.adapter.b.f;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.adapter.b.d.f;
import com.wbl.ad.yzz.adapter.base.BaseQuickAdapter;
import com.wbl.ad.yzz.adapter.base.loadmore.LoadMoreStatus;
import com.wbl.ad.yzz.adapter.base.viewholder.BaseViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: a */
    public f f31156a;

    /* renamed from: b */
    public boolean f31157b;

    /* renamed from: c */
    @f.b.a.d
    public LoadMoreStatus f31158c;

    /* renamed from: d */
    public boolean f31159d;

    /* renamed from: e */
    @f.b.a.d
    public com.wbl.ad.yzz.adapter.b.e.b f31160e;

    /* renamed from: f */
    public boolean f31161f;

    /* renamed from: g */
    public boolean f31162g;

    /* renamed from: h */
    public boolean f31163h;

    /* renamed from: i */
    public int f31164i;

    /* renamed from: j */
    public boolean f31165j;
    public final BaseQuickAdapter<?, ?> k;

    public static final class a implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ RecyclerView.LayoutManager f31167b;

        public a(RecyclerView.LayoutManager layoutManager) {
            this.f31167b = layoutManager;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15907, this, null);
        }
    }

    /* renamed from: com.wbl.ad.yzz.adapter.b.f.b$b */
    public static final class RunnableC0678b implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ RecyclerView.LayoutManager f31169b;

        public RunnableC0678b(RecyclerView.LayoutManager layoutManager) {
            this.f31169b = layoutManager;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15934, this, null);
        }
    }

    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15933, this, null);
        }
    }

    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15936, this, view);
        }
    }

    public b(@f.b.a.d BaseQuickAdapter<?, ?> baseQuickAdapter) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "baseQuickAdapter");
        this.k = baseQuickAdapter;
        this.f31157b = true;
        this.f31158c = LoadMoreStatus.Complete;
        this.f31160e = e.a();
        this.f31162g = true;
        this.f31163h = true;
        this.f31164i = 1;
    }

    public static final /* synthetic */ BaseQuickAdapter a(b bVar) {
        return (BaseQuickAdapter) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15930, null, bVar);
    }

    public static final /* synthetic */ f b(b bVar) {
        return (f) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15926, null, bVar);
    }

    public final int a(int[] iArr) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-15925, this, iArr);
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15928, this, null);
    }

    public final void a(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15927, this, Integer.valueOf(i2));
    }

    public void a(f fVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15922, this, fVar);
    }

    public final void a(BaseViewHolder baseViewHolder) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15921, this, baseViewHolder);
    }

    public final void a(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15924, this, Boolean.valueOf(z));
    }

    public final boolean a(LinearLayoutManager linearLayoutManager) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15923, this, linearLayoutManager);
    }

    public final void b(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15886, this, Boolean.valueOf(z));
    }

    public final boolean b() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15885, this, null);
    }

    public final LoadMoreStatus c() {
        return (LoadMoreStatus) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15888, this, null);
    }

    public final void c(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15887, this, Boolean.valueOf(z));
    }

    public final com.wbl.ad.yzz.adapter.b.e.b d() {
        return (com.wbl.ad.yzz.adapter.b.e.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15882, this, null);
    }

    public final int e() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-15881, this, null);
    }

    public final boolean f() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15884, this, null);
    }

    public final void g() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15883, this, null);
    }

    public final boolean h() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15878, this, null);
    }

    public final boolean i() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15877, this, null);
    }

    public final boolean j() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15880, this, null);
    }

    public final void k() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15879, this, null);
    }

    public final void l() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15874, this, null);
    }

    public final void m() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15873, this, null);
    }

    public final void n() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15876, this, null);
    }
}
