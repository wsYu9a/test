package com.bytedance.android.live.base.api;

import android.view.View;
import com.bytedance.android.live.base.api.callback.EmptyCallback;

/* loaded from: classes.dex */
public interface ILiveOuterPreviewCoverView {
    void cancelAutoEnterGuide(boolean z);

    void onShow();

    void release();

    void setCustomBottomView(View view);

    void setOnDislikeCallback(EmptyCallback emptyCallback);

    void stream(String str);
}
