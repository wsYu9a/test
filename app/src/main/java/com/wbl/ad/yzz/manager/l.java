package com.wbl.ad.yzz.manager;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.network.b.b.d0;
import com.wbl.ad.yzz.network.c.d;
import java.util.List;

/* loaded from: classes5.dex */
public final class l {

    /* renamed from: a */
    public static List<com.wbl.ad.yzz.network.b.b.d> f32965a;

    /* renamed from: b */
    @f.b.a.d
    public static final l f32966b = new l();

    public interface a {
        void a(@f.b.a.d TextView textView);

        @f.b.a.e
        TextView c();
    }

    public static final class b implements d.b0<d0> {
        public void a(String str, d0 d0Var) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12579, this, str, d0Var);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public void onFailed(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12606, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public /* bridge */ /* synthetic */ void onSuccess(String str, d0 d0Var) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12605, this, str, d0Var);
        }
    }

    public final com.wbl.ad.yzz.network.b.b.b a() {
        return (com.wbl.ad.yzz.network.b.b.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12607, this, null);
    }

    public final void a(com.wbl.ad.yzz.adapter.d.b bVar, FrameLayout frameLayout, TextView textView, a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12602, this, bVar, frameLayout, textView, aVar);
    }

    public final void a(com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12601, this, dVar);
    }

    public final void b(com.wbl.ad.yzz.adapter.d.b bVar, FrameLayout frameLayout, TextView textView, a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12604, this, bVar, frameLayout, textView, aVar);
    }

    public final void b(com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12603, this, dVar);
    }
}
