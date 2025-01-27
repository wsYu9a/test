package com.wbl.ad.yzz.wigdet.h;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.ui.f.l;
import java.lang.ref.WeakReference;

/* loaded from: classes5.dex */
public class c extends Dialog {

    /* renamed from: a */
    public TextView f34451a;

    /* renamed from: b */
    public TextView f34452b;

    /* renamed from: c */
    public Context f34453c;

    /* renamed from: d */
    public Button f34454d;

    /* renamed from: e */
    public ImageView f34455e;

    /* renamed from: f */
    public ImageView f34456f;

    /* renamed from: g */
    public d f34457g;

    /* renamed from: h */
    public l f34458h;

    /* renamed from: i */
    public com.wbl.ad.yzz.network.b.a.b f34459i;

    /* renamed from: j */
    public com.wbl.ad.yzz.innerconfig.d.d f34460j;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8526, this, view);
        }
    }

    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ WeakReference f34462a;

        public class a implements l.a {

            /* renamed from: a */
            public final /* synthetic */ Context f34464a;

            public a(Context context) {
                this.f34464a = context;
            }

            @Override // com.wbl.ad.yzz.ui.f.l.a
            public void a(String str) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8525, this, str);
            }
        }

        public b(WeakReference weakReference) {
            this.f34462a = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8528, this, null);
        }
    }

    /* renamed from: com.wbl.ad.yzz.wigdet.h.c$c */
    public class ViewOnClickListenerC0798c implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ boolean f34466a;

        public ViewOnClickListenerC0798c(boolean z) {
            this.f34466a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8527, this, view);
        }
    }

    public interface d {
        void dismiss();
    }

    public c(@NonNull Context context, com.wbl.ad.yzz.innerconfig.d.d dVar, com.wbl.ad.yzz.network.b.a.b bVar, d dVar2) {
        super(context);
        this.f34453c = context;
        this.f34459i = bVar;
        this.f34457g = dVar2;
        this.f34460j = dVar;
    }

    public static /* synthetic */ l a(c cVar, l lVar) {
        return (l) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8522, null, cVar, lVar);
    }

    public static /* synthetic */ d a(c cVar) {
        return (d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8521, null, cVar);
    }

    public static /* synthetic */ l b(c cVar) {
        return (l) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8523, null, cVar);
    }

    public static /* synthetic */ com.wbl.ad.yzz.network.b.a.b c(c cVar) {
        return (com.wbl.ad.yzz.network.b.a.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8518, null, cVar);
    }

    public static /* synthetic */ Context d(c cVar) {
        return (Context) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8517, null, cVar);
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8520, this, null);
    }

    public final void a(Context context) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8519, this, context);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8514, this, null);
    }

    public final void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8513, this, null);
    }

    public final void d() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8516, this, null);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8515, this, bundle);
    }

    @Override // android.app.Dialog
    public void show() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8542, this, null);
    }
}
