package com.wbl.ad.yzz.download;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.download.k.b;
import java.util.List;

/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a */
    public static com.wbl.ad.yzz.download.k.a f32000a;

    /* renamed from: c */
    @f.b.a.d
    public static final e f32002c = new e();

    /* renamed from: b */
    public static Handler f32001b = new Handler(Looper.getMainLooper());

    public static final class a implements b.InterfaceC0720b {

        /* renamed from: a */
        public final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d f32003a;

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f32004b;

        public a(com.wbl.ad.yzz.innerconfig.d.d dVar, com.wbl.ad.yzz.bean.b bVar) {
            this.f32003a = dVar;
            this.f32004b = bVar;
        }

        @Override // com.wbl.ad.yzz.download.k.b.InterfaceC0720b
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14770, this, null);
        }

        @Override // com.wbl.ad.yzz.download.k.b.InterfaceC0720b
        public void a(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14769, this, view);
        }
    }

    public static final class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Activity f32005a;

        /* renamed from: b */
        public final /* synthetic */ RecyclerView f32006b;

        /* renamed from: c */
        public final /* synthetic */ List f32007c;

        /* renamed from: d */
        public final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d f32008d;

        public b(Activity activity, RecyclerView recyclerView, List list, com.wbl.ad.yzz.innerconfig.d.d dVar) {
            this.f32005a = activity;
            this.f32006b = recyclerView;
            this.f32007c = list;
            this.f32008d = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14772, this, null);
        }
    }

    public static final class c implements b.InterfaceC0720b {

        /* renamed from: a */
        public final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d f32009a;

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f32010b;

        public c(com.wbl.ad.yzz.innerconfig.d.d dVar, com.wbl.ad.yzz.bean.b bVar) {
            this.f32009a = dVar;
            this.f32010b = bVar;
        }

        @Override // com.wbl.ad.yzz.download.k.b.InterfaceC0720b
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14771, this, null);
        }

        @Override // com.wbl.ad.yzz.download.k.b.InterfaceC0720b
        public void a(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14734, this, view);
        }
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14733, this, null);
    }

    public final void a(Activity activity, long j2, RecyclerView recyclerView, List<com.wbl.ad.yzz.adapter.d.b> list, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14736, this, activity, Long.valueOf(j2), recyclerView, list, dVar);
    }

    public final void a(Activity activity, RecyclerView recyclerView, List<com.wbl.ad.yzz.adapter.d.b> list) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14735, this, activity, recyclerView, list);
    }

    public final void a(Activity activity, RecyclerView recyclerView, List<com.wbl.ad.yzz.adapter.d.b> list, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14730, this, activity, recyclerView, list, dVar);
    }

    public final void a(com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14729, this, dVar);
    }

    public final void a(com.wbl.ad.yzz.innerconfig.d.d dVar, String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14732, this, dVar, str);
    }

    public final boolean a(Activity activity, int i2, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14731, this, activity, Integer.valueOf(i2), dVar);
    }

    public final boolean a(Activity activity, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14726, this, activity, dVar);
    }

    public final void b(Activity activity, RecyclerView recyclerView, List<com.wbl.ad.yzz.adapter.d.b> list, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14725, this, activity, recyclerView, list, dVar);
    }

    public final boolean b() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14728, this, null);
    }

    public final boolean b(Activity activity, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14727, this, activity, dVar);
    }

    public final void c(Activity activity, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14722, this, activity, dVar);
    }

    public final boolean d(Activity activity, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14721, this, activity, dVar);
    }
}
