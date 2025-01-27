package com.kwad.components.offline.c.a;

import android.content.Intent;
import com.kwad.components.offline.api.tk.IOfflineHostActionHandler;
import com.kwad.components.offline.api.tk.IOfflineTKDialog;
import com.kwad.components.offline.api.tk.IOfflineTKNativeIntent;
import com.kwad.sdk.components.l;
import com.kwad.sdk.components.m;
import com.kwad.sdk.components.p;
import com.kwad.sdk.components.q;

/* loaded from: classes3.dex */
public final class c implements IOfflineHostActionHandler {
    private final q acq;

    /* renamed from: com.kwad.components.offline.c.a.c$1 */
    public class AnonymousClass1 implements m {
        final /* synthetic */ IOfflineTKNativeIntent ags;

        public AnonymousClass1(IOfflineTKNativeIntent iOfflineTKNativeIntent) {
            iOfflineTKNativeIntent = iOfflineTKNativeIntent;
        }

        @Override // com.kwad.sdk.components.m
        public final void a(p pVar) {
            iOfflineTKNativeIntent.registerJSCallHandler(new g(pVar));
        }

        @Override // com.kwad.sdk.components.m
        public final void callTKBridge(String str) {
            iOfflineTKNativeIntent.callTKBridge(str);
        }

        @Override // com.kwad.sdk.components.m
        public final void callbackDismiss() {
            iOfflineTKNativeIntent.callbackDismiss();
        }

        @Override // com.kwad.sdk.components.m
        public final void callbackPageStatus(boolean z10, String str) {
            iOfflineTKNativeIntent.callbackPageStatus(z10, str);
        }

        @Override // com.kwad.sdk.components.m
        public final String getClassName() {
            return iOfflineTKNativeIntent.getClassName();
        }

        @Override // com.kwad.sdk.components.m
        public final Intent getIntent() {
            return iOfflineTKNativeIntent.getIntent();
        }

        @Override // com.kwad.sdk.components.m
        public final String getTemplateString() {
            return iOfflineTKNativeIntent.getTemplateString();
        }

        @Override // com.kwad.sdk.components.m
        public final String getUrl() {
            return iOfflineTKNativeIntent.getUrl();
        }

        @Override // com.kwad.sdk.components.m
        public final String getViewKey() {
            return iOfflineTKNativeIntent.getViewKey();
        }
    }

    /* renamed from: com.kwad.components.offline.c.a.c$2 */
    public class AnonymousClass2 implements l {
        final /* synthetic */ IOfflineTKDialog agu;

        public AnonymousClass2(IOfflineTKDialog iOfflineTKDialog) {
            iOfflineTKDialog = iOfflineTKDialog;
        }

        @Override // com.kwad.sdk.components.l
        public final void a(p pVar) {
            iOfflineTKDialog.registerJSCallHandler(new g(pVar));
        }

        @Override // com.kwad.sdk.components.l
        public final void callTKBridge(String str) {
            iOfflineTKDialog.callTKBridge(str);
        }

        @Override // com.kwad.sdk.components.l
        public final void callbackDialogDismiss() {
            iOfflineTKDialog.callbackDialogDismiss();
        }

        @Override // com.kwad.sdk.components.l
        public final void callbackPageStatus(boolean z10, String str) {
            iOfflineTKDialog.callbackPageStatus(z10, str);
        }

        @Override // com.kwad.sdk.components.l
        public final int getDialogId() {
            return iOfflineTKDialog.getDialogId();
        }

        @Override // com.kwad.sdk.components.l
        public final String getStyleTemplate() {
            return iOfflineTKDialog.getStyleTemplate();
        }

        @Override // com.kwad.sdk.components.l
        public final String getViewKey() {
            return iOfflineTKDialog.getViewKey();
        }

        @Override // com.kwad.sdk.components.l
        public final boolean isHideNavigationBar() {
            return iOfflineTKDialog.isHideNavigationBar();
        }
    }

    public c(q qVar) {
        this.acq = qVar;
    }

    private m a(IOfflineTKNativeIntent iOfflineTKNativeIntent) {
        return new m() { // from class: com.kwad.components.offline.c.a.c.1
            final /* synthetic */ IOfflineTKNativeIntent ags;

            public AnonymousClass1(IOfflineTKNativeIntent iOfflineTKNativeIntent2) {
                iOfflineTKNativeIntent = iOfflineTKNativeIntent2;
            }

            @Override // com.kwad.sdk.components.m
            public final void a(p pVar) {
                iOfflineTKNativeIntent.registerJSCallHandler(new g(pVar));
            }

            @Override // com.kwad.sdk.components.m
            public final void callTKBridge(String str) {
                iOfflineTKNativeIntent.callTKBridge(str);
            }

            @Override // com.kwad.sdk.components.m
            public final void callbackDismiss() {
                iOfflineTKNativeIntent.callbackDismiss();
            }

            @Override // com.kwad.sdk.components.m
            public final void callbackPageStatus(boolean z10, String str) {
                iOfflineTKNativeIntent.callbackPageStatus(z10, str);
            }

            @Override // com.kwad.sdk.components.m
            public final String getClassName() {
                return iOfflineTKNativeIntent.getClassName();
            }

            @Override // com.kwad.sdk.components.m
            public final Intent getIntent() {
                return iOfflineTKNativeIntent.getIntent();
            }

            @Override // com.kwad.sdk.components.m
            public final String getTemplateString() {
                return iOfflineTKNativeIntent.getTemplateString();
            }

            @Override // com.kwad.sdk.components.m
            public final String getUrl() {
                return iOfflineTKNativeIntent.getUrl();
            }

            @Override // com.kwad.sdk.components.m
            public final String getViewKey() {
                return iOfflineTKNativeIntent.getViewKey();
            }
        };
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineHostActionHandler
    public final void dismissDialog(IOfflineTKDialog iOfflineTKDialog) {
        q qVar = this.acq;
        if (qVar != null) {
            qVar.b(a(iOfflineTKDialog));
        }
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineHostActionHandler
    public final void showDialog(IOfflineTKDialog iOfflineTKDialog) {
        q qVar = this.acq;
        if (qVar != null) {
            qVar.a(a(iOfflineTKDialog));
        }
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineHostActionHandler
    public final void startActivity(IOfflineTKNativeIntent iOfflineTKNativeIntent) {
        q qVar = this.acq;
        if (qVar != null) {
            qVar.a(a(iOfflineTKNativeIntent));
        }
    }

    private l a(IOfflineTKDialog iOfflineTKDialog) {
        return new l() { // from class: com.kwad.components.offline.c.a.c.2
            final /* synthetic */ IOfflineTKDialog agu;

            public AnonymousClass2(IOfflineTKDialog iOfflineTKDialog2) {
                iOfflineTKDialog = iOfflineTKDialog2;
            }

            @Override // com.kwad.sdk.components.l
            public final void a(p pVar) {
                iOfflineTKDialog.registerJSCallHandler(new g(pVar));
            }

            @Override // com.kwad.sdk.components.l
            public final void callTKBridge(String str) {
                iOfflineTKDialog.callTKBridge(str);
            }

            @Override // com.kwad.sdk.components.l
            public final void callbackDialogDismiss() {
                iOfflineTKDialog.callbackDialogDismiss();
            }

            @Override // com.kwad.sdk.components.l
            public final void callbackPageStatus(boolean z10, String str) {
                iOfflineTKDialog.callbackPageStatus(z10, str);
            }

            @Override // com.kwad.sdk.components.l
            public final int getDialogId() {
                return iOfflineTKDialog.getDialogId();
            }

            @Override // com.kwad.sdk.components.l
            public final String getStyleTemplate() {
                return iOfflineTKDialog.getStyleTemplate();
            }

            @Override // com.kwad.sdk.components.l
            public final String getViewKey() {
                return iOfflineTKDialog.getViewKey();
            }

            @Override // com.kwad.sdk.components.l
            public final boolean isHideNavigationBar() {
                return iOfflineTKDialog.isHideNavigationBar();
            }
        };
    }
}
