package com.bykv.vk.openvk.api.proto;

import android.content.Context;

/* loaded from: classes2.dex */
public interface Manager {
    Loader createLoader(Context context);

    Bridge getBridge(int i10);

    ValueSet values();
}
