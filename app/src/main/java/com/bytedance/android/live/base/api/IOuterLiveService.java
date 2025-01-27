package com.bytedance.android.live.base.api;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

/* loaded from: classes.dex */
public interface IOuterLiveService extends IOuterLiveRoomService {
    boolean canHandleScheme(Uri uri);

    void enterLiveRoom(Context context, long j2, Bundle bundle);

    boolean handleSchema(Context context, Uri uri);

    ILiveOuterPreviewCoverView makePreviewCoverView(Context context, Bundle bundle);

    ILiveOuterPreviewFragment makePreviewFragment();
}
