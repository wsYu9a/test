package com.kwad.components.core.webview.a.b;

import android.content.DialogInterface;
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
import com.kwad.components.core.l.g;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class d extends g {
    public com.kwad.components.core.webview.a.d.c Pv;
    private KSFrameLayout VB;
    protected List<DialogInterface.OnDismissListener> VC = new CopyOnWriteArrayList();
    public boolean VD = false;
    protected com.kwad.components.core.webview.a.b.b Vr;
    public String Vt;
    protected com.kwad.sdk.components.g Vu;
    public boolean Vv;
    public a Vw;
    private com.kwad.components.core.webview.a.d.d Vz;
    public AdTemplate mAdTemplate;
    private Presenter mPresenter;
    protected StyleTemplate mStyleTemplate;

    /* renamed from: com.kwad.components.core.webview.a.b.d$1 */
    final class AnonymousClass1 implements DialogInterface.OnKeyListener {
        AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            return i2 == 4 && keyEvent.getAction() == 0;
        }
    }

    /* renamed from: com.kwad.components.core.webview.a.b.d$2 */
    final class AnonymousClass2 implements DialogInterface.OnKeyListener {
        AnonymousClass2() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            return i2 == 4 && keyEvent.getAction() == 0;
        }
    }

    public interface a {
        boolean ga();
    }

    public static class b {
        private boolean VD;
        private StyleTemplate VF;
        private com.kwad.sdk.components.g Vu;
        private boolean Vv;
        private AdTemplate mAdTemplate;
        private String templateId;

        public final void aP(String str) {
            this.templateId = str;
        }

        public final void aQ(boolean z) {
            this.Vv = false;
        }

        public final void aR(boolean z) {
            this.VD = true;
        }

        public final void c(com.kwad.sdk.components.g gVar) {
            this.Vu = gVar;
        }

        public final AdTemplate getAdTemplate() {
            return this.mAdTemplate;
        }

        public final String getTemplateId() {
            return this.templateId;
        }

        public final boolean rl() {
            return this.Vv;
        }

        public final boolean rm() {
            return this.VD;
        }

        public final void setAdTemplate(AdTemplate adTemplate) {
            this.mAdTemplate = adTemplate;
        }

        public final void setStyleTemplate(StyleTemplate styleTemplate) {
            this.VF = styleTemplate;
        }
    }

    private Presenter an() {
        Presenter presenter = new Presenter();
        this.mPresenter = presenter;
        presenter.a(jg());
        return this.mPresenter;
    }

    public static d b(b bVar) {
        d dVar = new d();
        dVar.mAdTemplate = bVar.getAdTemplate();
        dVar.Vt = bVar.getTemplateId();
        dVar.Vv = bVar.Vv;
        dVar.VD = bVar.VD;
        dVar.mStyleTemplate = bVar.VF;
        dVar.Vu = bVar.Vu;
        Bundle bundle = new Bundle();
        bundle.putString("templateId", bVar.getTemplateId());
        dVar.setArguments(bundle);
        return dVar;
    }

    private void y(View view) {
        if (this.mPresenter == null) {
            Presenter an = an();
            this.mPresenter = an;
            an.E(view);
            this.Vr = jf();
        }
        jh();
        this.mPresenter.f(this.Vr);
    }

    @Override // com.kwad.components.core.l.g
    public final View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        if (this.VB == null) {
            this.VB = (KSFrameLayout) layoutInflater.inflate(R.layout.ksad_video_tk_dialog_layout, viewGroup, false);
        }
        return this.VB;
    }

    public final void a(com.kwad.components.core.webview.a.d.d dVar) {
        this.Vz = dVar;
    }

    public final void d(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.VC.add(onDismissListener);
        }
    }

    public final void e(DialogInterface.OnDismissListener onDismissListener) {
        this.VC.remove(onDismissListener);
    }

    protected com.kwad.components.core.webview.a.b.b jf() {
        return new com.kwad.components.core.webview.a.b.b();
    }

    protected c jg() {
        return new c();
    }

    protected void jh() {
        this.Vr.mActivity = getActivity();
        com.kwad.components.core.webview.a.b.b bVar = this.Vr;
        bVar.mTkDialogFragment = this;
        bVar.Vs = this.VB;
        bVar.mAdTemplate = this.mAdTemplate;
        bVar.Vt = this.Vt;
        bVar.mStyleTemplate = this.mStyleTemplate;
        bVar.Vv = this.Vv;
        bVar.Vu = this.Vu;
        bVar.Vw = this.Vw;
        bVar.Pv = this.Pv;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        Window window;
        try {
            super.onActivityCreated(bundle);
        } catch (Throwable unused) {
        }
        if (getDialog() == null || (window = getDialog().getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.0f;
        window.setAttributes(attributes);
        getDialog().setCanceledOnTouchOutside(false);
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        window.setSoftInputMode(16);
        if (this.VD) {
            getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.core.webview.a.b.d.1
                AnonymousClass1() {
                }

                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                    return i2 == 4 && keyEvent.getAction() == 0;
                }
            });
        }
        window.setFlags(1024, 1024);
        if (this.VD) {
            getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.core.webview.a.b.d.2
                AnonymousClass2() {
                }

                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                    return i2 == 4 && keyEvent.getAction() == 0;
                }
            });
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.Vt = getArguments().getString("templateId");
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
            this.mPresenter = null;
        }
        com.kwad.components.core.webview.a.b.b bVar = this.Vr;
        if (bVar != null) {
            bVar.release();
            this.Vr = null;
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        KSFrameLayout kSFrameLayout = this.VB;
        if (kSFrameLayout != null && (kSFrameLayout.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.VB.getParent()).removeView(this.VB);
            this.VB = null;
        }
        com.kwad.components.core.webview.a.d.d dVar = this.Vz;
        if (dVar != null) {
            dVar.gg();
        }
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        com.kwad.components.core.webview.a.d.c cVar = this.Pv;
        if (cVar != null) {
            cVar.gg();
        }
        for (DialogInterface.OnDismissListener onDismissListener : this.VC) {
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
        }
        com.kwad.sdk.components.g gVar = this.Vu;
        if (gVar != null) {
            gVar.callbackDialogDismiss();
        }
    }

    @Override // android.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        y(view);
        com.kwad.components.core.webview.a.d.c cVar = this.Pv;
        if (cVar != null) {
            cVar.fZ();
        }
        com.kwad.components.core.webview.a.d.d dVar = this.Vz;
        if (dVar != null) {
            dVar.fZ();
        }
    }
}
