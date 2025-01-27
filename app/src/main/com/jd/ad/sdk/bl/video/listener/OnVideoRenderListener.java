package com.jd.ad.sdk.bl.video.listener;

import android.view.View;

/* loaded from: classes2.dex */
public interface OnVideoRenderListener {
    void onVideoRenderFailed(int i10, String str);

    void onVideoRenderSuccess(View view);

    void updateMaterialMetaPreload(boolean z10);

    void videoPlayerError(int i10, int i11, int i12, int i13, String str);

    void videoPlayerStatusChanged(int i10, int i11);
}
