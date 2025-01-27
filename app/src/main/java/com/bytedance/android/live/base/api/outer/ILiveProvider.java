package com.bytedance.android.live.base.api.outer;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.api.outer.ILivePreviewLayout;
import com.bytedance.android.live.base.api.outer.data.RoomInfo;
import java.util.List;

/* loaded from: classes.dex */
public interface ILiveProvider {
    ILivePreviewLayout getILivePreviewLayout(ILivePreviewLayout.Builder builder);

    String getIdentity();

    ILiveView getLiveView(Context context, int i2, String str, boolean z, Bundle bundle);

    List<RoomInfo> getRoomInfoList(int i2, int i3, int i4);

    IStandalonePreviewView makeStandalonePreviewView(Context context, int i2, Bundle bundle);

    void startLive(Context context, int i2, String str, Bundle bundle);
}
