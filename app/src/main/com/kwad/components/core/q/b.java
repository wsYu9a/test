package com.kwad.components.core.q;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.tachikoma.c.e;

/* loaded from: classes3.dex */
public final class b extends e {
    protected com.kwad.components.core.webview.tachikoma.e.c Vf;

    public static b a(e.b bVar) {
        b bVar2 = new b();
        bVar2.mAdResultData = bVar.hF();
        bVar2.yP = bVar.getTemplateId();
        Bundle bundle = new Bundle();
        bundle.putString("templateId", bVar.getTemplateId());
        bVar2.setArguments(bundle);
        return bVar2;
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.e
    public final com.kwad.components.core.webview.tachikoma.c.b jF() {
        return super.jF();
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.e
    public final com.kwad.components.core.webview.tachikoma.c.c jG() {
        return new c();
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.e, android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        com.kwad.components.core.webview.tachikoma.e.c cVar = this.Vf;
        if (cVar != null) {
            cVar.gt();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.e, android.app.Fragment
    public final void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        com.kwad.components.core.webview.tachikoma.e.c cVar = this.Vf;
        if (cVar != null) {
            cVar.gl();
        }
    }

    @Nullable
    public static b a(b bVar, Activity activity, com.kwad.components.core.webview.tachikoma.e.c cVar) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        bVar.Vf = cVar;
        bVar.show(activity.getFragmentManager(), "webTKCloseDialog");
        return bVar;
    }
}
