package com.kwad.components.core.webview.tachikoma.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.proxy.j;
import com.kwad.components.core.webview.tachikoma.k;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.components.l;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class e extends j {
    public com.kwad.components.core.webview.tachikoma.e.c Vf;
    protected StyleTemplate Vh;
    protected com.kwad.components.core.webview.tachikoma.c.b adD;
    protected l adF;
    protected k adG;
    public boolean adH;
    public a adI;
    private com.kwad.components.core.webview.tachikoma.e.e adL;
    private d adO;
    private KSFrameLayout adP;
    protected List<DialogInterface.OnDismissListener> adQ = new CopyOnWriteArrayList();
    public boolean adR = false;
    public AdResultData mAdResultData;
    private Presenter mPresenter;
    public String yP;

    /* renamed from: com.kwad.components.core.webview.tachikoma.c.e$1 */
    public class AnonymousClass1 implements DialogInterface.OnKeyListener {
        public AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
            if (i10 != 4 || keyEvent.getAction() != 0) {
                return false;
            }
            e eVar = e.this;
            if (eVar.adR) {
                return true;
            }
            if (eVar.adO != null) {
                return e.this.adO.onBackPressed();
            }
            return false;
        }
    }

    public interface a {
        boolean gn();
    }

    public static class b {
        private l adF;
        private boolean adH;
        private boolean adR;
        private StyleTemplate adT;
        private k adU;
        private AdResultData mAdResultData;
        private String templateId;

        public final void a(AdResultData adResultData) {
            this.mAdResultData = adResultData;
        }

        public final void aX(boolean z10) {
            this.adH = false;
        }

        public final void aY(boolean z10) {
            this.adR = true;
        }

        public final void aZ(String str) {
            this.templateId = str;
        }

        public final String getTemplateId() {
            return this.templateId;
        }

        public final AdResultData hF() {
            return this.mAdResultData;
        }

        public final boolean kz() {
            return this.adH;
        }

        public final boolean ue() {
            return this.adR;
        }

        public final void a(StyleTemplate styleTemplate) {
            this.adT = styleTemplate;
        }

        public final void c(l lVar) {
            this.adF = lVar;
        }

        public final void a(k kVar) {
            this.adU = kVar;
        }
    }

    private void B(View view) {
        if (this.adD == null) {
            this.adD = jF();
        }
        jH();
        if (this.mPresenter == null) {
            Presenter aG = aG();
            this.mPresenter = aG;
            aG.I(view);
        }
        this.mPresenter.k(this.adD);
    }

    private Presenter aG() {
        Presenter presenter = new Presenter();
        this.mPresenter = presenter;
        if (this.adD.adG != null) {
            presenter.a(ud());
        } else {
            presenter.a(jG());
        }
        return this.mPresenter;
    }

    public static e b(b bVar) {
        e eVar = new e();
        eVar.mAdResultData = bVar.hF();
        eVar.yP = bVar.getTemplateId();
        eVar.adH = bVar.adH;
        eVar.adR = bVar.adR;
        eVar.Vh = bVar.adT;
        eVar.adF = bVar.adF;
        eVar.adG = bVar.adU;
        Bundle bundle = new Bundle();
        bundle.putString("templateId", bVar.getTemplateId());
        eVar.setArguments(bundle);
        return eVar;
    }

    private d ud() {
        if (this.adO == null) {
            this.adO = new d();
        }
        return this.adO;
    }

    public final void d(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.adQ.add(onDismissListener);
        }
    }

    public final void e(DialogInterface.OnDismissListener onDismissListener) {
        this.adQ.remove(onDismissListener);
    }

    public com.kwad.components.core.webview.tachikoma.c.b jF() {
        return new com.kwad.components.core.webview.tachikoma.c.b();
    }

    public c jG() {
        return new c();
    }

    public void jH() {
        this.adD.a(this.mAdResultData);
        this.adD.mActivity = getActivity();
        com.kwad.components.core.webview.tachikoma.c.b bVar = this.adD;
        bVar.abM = this;
        bVar.adE = this.adP;
        bVar.yP = this.yP;
        bVar.Vh = this.Vh;
        bVar.adH = this.adH;
        bVar.adF = this.adF;
        bVar.adG = this.adG;
        bVar.adI = this.adI;
        bVar.Vf = this.Vf;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        Window window;
        Resources resources;
        int identifier;
        try {
            super.onActivityCreated(bundle);
        } catch (Throwable unused) {
        }
        if (getDialog() == null || (window = getDialog().getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.0f;
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        int i10 = 0;
        getDialog().setCanceledOnTouchOutside(false);
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        window.setSoftInputMode(16);
        if (d(getDialog().getOwnerActivity())) {
            window.setFlags(1024, 1024);
        }
        try {
            if (this.adF.isHideNavigationBar()) {
                if (getContext() != null && (resources = getContext().getResources()) != null && (identifier = resources.getIdentifier(com.gyf.immersionbar.b.f10639d, "dimen", "android")) > 0) {
                    i10 = getContext().getResources().getDimensionPixelSize(identifier);
                }
                if (i10 > 0) {
                    getDialog().getWindow().getDecorView().setSystemUiVisibility(5382);
                }
            }
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
        }
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.core.webview.tachikoma.c.e.1
            public AnonymousClass1() {
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i102, KeyEvent keyEvent) {
                if (i102 != 4 || keyEvent.getAction() != 0) {
                    return false;
                }
                e eVar = e.this;
                if (eVar.adR) {
                    return true;
                }
                if (eVar.adO != null) {
                    return e.this.adO.onBackPressed();
                }
                return false;
            }
        });
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.yP = getArguments().getString("templateId");
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
            this.mPresenter = null;
        }
        com.kwad.components.core.webview.tachikoma.c.b bVar = this.adD;
        if (bVar != null) {
            bVar.release();
            this.adD = null;
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDestroyView() {
        try {
            super.onDestroyView();
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.e("TkDialogFragment", "destroy view failed:" + th2);
        }
        KSFrameLayout kSFrameLayout = this.adP;
        if (kSFrameLayout != null && (kSFrameLayout.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.adP.getParent()).removeView(this.adP);
            this.adP = null;
        }
        com.kwad.components.core.webview.tachikoma.e.e eVar = this.adL;
        if (eVar != null) {
            eVar.gt();
        }
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        com.kwad.components.core.webview.tachikoma.e.c cVar = this.Vf;
        if (cVar != null) {
            cVar.gt();
        }
        for (DialogInterface.OnDismissListener onDismissListener : this.adQ) {
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
        }
        l lVar = this.adF;
        if (lVar != null) {
            lVar.callbackDialogDismiss();
        }
    }

    @Override // android.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        B(view);
        com.kwad.components.core.webview.tachikoma.e.c cVar = this.Vf;
        if (cVar != null) {
            cVar.gl();
        }
        com.kwad.components.core.webview.tachikoma.e.e eVar = this.adL;
        if (eVar != null) {
            eVar.gl();
        }
    }

    private static boolean d(Activity activity) {
        return activity != null && (activity.getWindow().getAttributes().flags & 1024) == 1024;
    }

    public final void a(com.kwad.components.core.webview.tachikoma.e.e eVar) {
        this.adL = eVar;
    }

    @Override // com.kwad.components.core.proxy.j
    public final View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        if (this.adP == null) {
            this.adP = (KSFrameLayout) layoutInflater.inflate(R.layout.ksad_video_tk_dialog_layout, viewGroup, false);
        }
        return this.adP;
    }
}
