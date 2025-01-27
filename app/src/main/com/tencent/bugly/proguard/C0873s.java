package com.tencent.bugly.proguard;

import com.tencent.bugly.beta.interfaces.BetaPatchListener;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.ui.HotfixDialog;
import com.tencent.bugly.beta.ui.UiManager;

/* renamed from: com.tencent.bugly.proguard.s */
/* loaded from: classes4.dex */
public class C0873s implements TinkerManager.TinkerListener {

    /* renamed from: a */
    final /* synthetic */ com.tencent.bugly.beta.global.e f22849a;

    public C0873s(com.tencent.bugly.beta.global.e eVar) {
        this.f22849a = eVar;
    }

    @Override // com.tencent.bugly.beta.tinker.TinkerManager.TinkerListener
    public void onApplyFailure(String str) {
        this.f22849a.P = false;
        com.tencent.bugly.beta.global.a.b("PatchResult", false);
        com.tencent.bugly.beta.global.a.b("IS_PATCHING", false);
        X.c("Tinker patch failure, result: " + str, new Object[0]);
        BetaPatchListener betaPatchListener = this.f22849a.Y;
        if (betaPatchListener != null) {
            betaPatchListener.onApplyFailure(str);
        }
    }

    @Override // com.tencent.bugly.beta.tinker.TinkerManager.TinkerListener
    public void onApplySuccess(String str) {
        com.tencent.bugly.beta.global.e eVar = this.f22849a;
        eVar.f22108ea = false;
        eVar.P = true;
        com.tencent.bugly.beta.global.a.b("IS_PATCHING", false);
        com.tencent.bugly.beta.global.a.b("PatchResult", true);
        X.c("Tinker patch success, result: " + str, new Object[0]);
        if (this.f22849a.Z) {
            UiManager.show(new HotfixDialog(), true);
        }
        BetaPatchListener betaPatchListener = this.f22849a.Y;
        if (betaPatchListener != null) {
            betaPatchListener.onApplySuccess(str);
        }
    }

    @Override // com.tencent.bugly.beta.tinker.TinkerManager.TinkerListener
    public void onDownloadFailure(String str) {
        BetaPatchListener betaPatchListener = this.f22849a.Y;
        if (betaPatchListener != null) {
            betaPatchListener.onDownloadFailure(str);
        }
    }

    @Override // com.tencent.bugly.beta.tinker.TinkerManager.TinkerListener
    public void onDownloadSuccess(String str) {
        BetaPatchListener betaPatchListener = this.f22849a.Y;
        if (betaPatchListener != null) {
            betaPatchListener.onDownloadSuccess(str);
        }
    }

    @Override // com.tencent.bugly.beta.tinker.TinkerManager.TinkerListener
    public void onPatchRollback() {
        X.c("patch rollback callback.", new Object[0]);
        BetaPatchListener betaPatchListener = this.f22849a.Y;
        if (betaPatchListener != null) {
            betaPatchListener.onPatchRollback();
        }
        if (TinkerManager.getInstance().getPatchDirectory(this.f22849a.f22126v) == null || TinkerManager.getInstance().getPatchDirectory(this.f22849a.f22126v).exists()) {
            return;
        }
        com.tencent.bugly.beta.global.a.b("IS_PATCH_ROLL_BACK", false);
    }

    @Override // com.tencent.bugly.beta.tinker.TinkerManager.TinkerListener
    public void onPatchStart() {
        this.f22849a.f22108ea = true;
        com.tencent.bugly.beta.global.a.b("IS_PATCHING", true);
    }
}
