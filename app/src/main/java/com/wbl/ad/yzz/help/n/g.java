package com.wbl.ad.yzz.help.n;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.help.e;
import com.wbl.ad.yzz.network.c.e.k;
import java.util.List;
import kotlin.jvm.internal.Ref;

/* loaded from: classes5.dex */
public final class g implements e {

    /* renamed from: a */
    public com.wbl.ad.yzz.manager.f f32720a;

    /* renamed from: b */
    public final String f32721b = "KsDzHandler";

    public static final class a implements k.b {

        /* renamed from: b */
        public final /* synthetic */ boolean f32723b;

        /* renamed from: c */
        public final /* synthetic */ Ref.ObjectRef f32724c;

        /* renamed from: d */
        public final /* synthetic */ int f32725d;

        /* renamed from: e */
        public final /* synthetic */ Context f32726e;

        /* renamed from: f */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f32727f;

        /* renamed from: g */
        public final /* synthetic */ Ref.ObjectRef f32728g;

        /* renamed from: h */
        public final /* synthetic */ f f32729h;

        /* renamed from: com.wbl.ad.yzz.help.n.g$a$a */
        public static final class C0749a implements e.c {
            public C0749a() {
            }

            @Override // com.wbl.ad.yzz.help.e.c
            public void a() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12821, this, null);
            }

            @Override // com.wbl.ad.yzz.help.e.c
            public void b() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12824, this, null);
            }

            @Override // com.wbl.ad.yzz.help.e.c
            public void c() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12823, this, null);
            }
        }

        public a(boolean z, Ref.ObjectRef objectRef, int i2, Context context, com.wbl.ad.yzz.bean.b bVar, Ref.ObjectRef objectRef2, f fVar) {
            this.f32723b = z;
            this.f32724c = objectRef;
            this.f32725d = i2;
            this.f32726e = context;
            this.f32727f = bVar;
            this.f32728g = objectRef2;
            this.f32729h = fVar;
        }

        @Override // com.wbl.ad.yzz.network.c.e.k.b
        public void a(Activity activity, View view, int i2, String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12818, this, activity, view, Integer.valueOf(i2), str);
        }
    }

    public static final /* synthetic */ String a(g gVar) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12817, null, gVar);
    }

    @Override // com.wbl.ad.yzz.help.n.e
    public void a(Context context, com.wbl.ad.yzz.bean.b bVar, View view, List<View> list, int i2, f fVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12820, this, context, bVar, view, list, Integer.valueOf(i2), fVar);
    }

    @Override // com.wbl.ad.yzz.help.n.e
    public void a(FrameLayout frameLayout, Context context, com.wbl.ad.yzz.bean.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12819, this, frameLayout, context, bVar);
    }

    @Override // com.wbl.ad.yzz.help.n.e
    public void a(com.wbl.ad.yzz.manager.f fVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12910, this, fVar);
    }
}
