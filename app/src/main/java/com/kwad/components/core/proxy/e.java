package com.kwad.components.core.proxy;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.proxy.IFragmentActivityProxy;

/* loaded from: classes3.dex */
public class e extends IFragmentActivityProxy {
    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        finish();
    }
}
