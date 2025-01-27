package com.martian.libsupport.data;

import kotlin.Metadata;
import xi.k;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/martian/libsupport/data/NightModeChangeParams;", "Lcom/martian/libsupport/data/WebParams;", "()V", "isNightMode", "", "()Z", "setNightMode", "(Z)V", "getType", "", "support_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NightModeChangeParams extends WebParams {
    private boolean isNightMode;

    @Override // com.martian.libsupport.data.WebParams
    @k
    public String getType() {
        return "changeNightMode";
    }

    /* renamed from: isNightMode, reason: from getter */
    public final boolean getIsNightMode() {
        return this.isNightMode;
    }

    public final void setNightMode(boolean z10) {
        this.isNightMode = z10;
    }
}
