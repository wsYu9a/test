package com.kwad.components.core.e.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.c.a;
import com.kwad.components.core.proxy.g;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.m;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class b extends g {

    @Nullable
    private static b Mf;

    @NonNull
    private final C0426b Mg;
    private com.kwad.components.core.e.c.a Mj;
    private boolean Mk;

    /* renamed from: com.kwad.components.core.e.c.b$1 */
    public class AnonymousClass1 implements a.InterfaceC0425a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.e.c.a.InterfaceC0425a
        public final void oe() {
            b.this.dismiss();
        }
    }

    public static class a {

        @Nullable
        private DialogInterface.OnShowListener Mm;

        @Nullable
        private DialogInterface.OnDismissListener Mn;
        private AdTemplate adTemplate;
        private String url;

        public final a ag(String str) {
            this.url = str;
            return this;
        }

        public final a at(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        public final C0426b oi() {
            if (com.kwad.components.core.a.ns.booleanValue() && (this.adTemplate == null || TextUtils.isEmpty(this.url))) {
                throw new IllegalArgumentException("param is error, please check it");
            }
            return new C0426b(this, (byte) 0);
        }

        public final a a(@Nullable DialogInterface.OnShowListener onShowListener) {
            this.Mm = onShowListener;
            return this;
        }

        public final a c(@Nullable DialogInterface.OnDismissListener onDismissListener) {
            this.Mn = onDismissListener;
            return this;
        }
    }

    /* renamed from: com.kwad.components.core.e.c.b$b */
    public static class C0426b {

        @Nullable
        protected DialogInterface.OnShowListener Mm;

        @Nullable
        protected DialogInterface.OnDismissListener Mn;
        protected final AdTemplate adTemplate;
        protected String url;

        public /* synthetic */ C0426b(a aVar, byte b10) {
            this(aVar);
        }

        private C0426b(a aVar) {
            this.adTemplate = aVar.adTemplate;
            this.url = aVar.url;
            this.Mm = aVar.Mm;
            this.Mn = aVar.Mn;
        }
    }

    private b(Activity activity, @NonNull C0426b c0426b) {
        super(activity);
        this.Mk = false;
        this.Mg = c0426b;
        if (com.kwad.sdk.c.a.a.d(activity)) {
            getWindow().addFlags(1024);
        }
        setOnShowListener(c0426b.Mm);
        setOnDismissListener(c0426b.Mn);
    }

    public static boolean a(Context context, C0426b c0426b) {
        Activity dH;
        b bVar = Mf;
        if ((bVar == null || !bVar.isShowing()) && context != null && (dH = m.dH(context)) != null && !dH.isFinishing()) {
            com.kwad.sdk.a.a.c.Bg().dismiss();
            try {
                b bVar2 = new b(dH, c0426b);
                Mf = bVar2;
                bVar2.show();
                com.kwad.sdk.core.adlog.c.b(c0426b.adTemplate, 86, (JSONObject) null);
                return true;
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTrace(th2);
            }
        }
        return false;
    }

    public static boolean of() {
        b bVar = Mf;
        if (bVar != null) {
            return bVar.isShowing();
        }
        return false;
    }

    public final void ak(boolean z10) {
        this.Mk = z10;
        dismiss();
    }

    @Override // com.kwad.components.core.proxy.g
    public final ViewGroup cG() {
        com.kwad.components.core.e.c.a aVar = new com.kwad.components.core.e.c.a(this.mContext, this, this.Mg);
        this.Mj = aVar;
        return aVar;
    }

    @Override // com.kwad.components.core.proxy.g, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        Mf = null;
    }

    @Override // com.kwad.components.core.proxy.g
    public final int getLayoutId() {
        return 0;
    }

    @Override // com.kwad.components.core.proxy.g
    public final void h(View view) {
        this.Mj.setChangeListener(new a.InterfaceC0425a() { // from class: com.kwad.components.core.e.c.b.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.e.c.a.InterfaceC0425a
            public final void oe() {
                b.this.dismiss();
            }
        });
    }

    @Override // android.app.Dialog
    public final boolean isShowing() {
        return super.isShowing();
    }

    @Override // com.kwad.components.core.proxy.g
    public final boolean og() {
        return true;
    }

    public final boolean oh() {
        return this.Mk;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        super.onBackPressed();
        com.kwad.sdk.core.adlog.c.bW(this.Mg.adTemplate);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Mf = null;
    }

    @Override // com.kwad.components.core.proxy.g, android.app.Dialog
    public final void onStart() {
        super.onStart();
        b bVar = Mf;
        if (bVar != null) {
            bVar.setTitle((CharSequence) null);
        }
    }

    @Override // android.app.Dialog
    public final void show() {
        Resources resources;
        int identifier;
        try {
            super.show();
            try {
                if (((getContext() == null || (resources = getContext().getResources()) == null || (identifier = resources.getIdentifier(com.gyf.immersionbar.b.f10639d, "dimen", "android")) <= 0) ? 0 : getContext().getResources().getDimensionPixelSize(identifier)) > 0) {
                    getWindow().getDecorView().setSystemUiVisibility(5382);
                }
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            }
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
        }
    }
}
