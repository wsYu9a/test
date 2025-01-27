package com.wbl.ad.yzz.c.c;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.innerconfig.d.d;
import com.wbl.ad.yzz.network.b.b.k;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a */
    public PopupWindow f31764a;

    /* renamed from: com.wbl.ad.yzz.c.c.a$a */
    public interface InterfaceC0697a {
        void a();

        void b();

        void c();
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ boolean f31765a;

        /* renamed from: b */
        public final /* synthetic */ InterfaceC0697a f31766b;

        public b(boolean z, InterfaceC0697a interfaceC0697a) {
            this.f31765a = z;
            this.f31766b = interfaceC0697a;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15262, this, view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC0697a f31767a;

        public c(InterfaceC0697a interfaceC0697a) {
            this.f31767a = interfaceC0697a;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15261, this, view);
        }
    }

    public final String a(k kVar) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15264, this, kVar);
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15263, this, null);
    }

    public final void a(Activity activity, View view, k kVar, InterfaceC0697a interfaceC0697a) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15258, this, activity, view, kVar, interfaceC0697a);
    }

    public final void a(Context context, d dVar, String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15257, this, context, dVar, str);
    }

    public final int[] a(Context context, View view, View view2) {
        return (int[]) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15260, this, context, view, view2);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15259, this, null);
    }

    public final void b(k kVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15254, this, kVar);
    }
}
