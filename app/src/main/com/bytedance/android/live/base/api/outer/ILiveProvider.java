package com.bytedance.android.live.base.api.outer;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.api.outer.ILivePreviewLayout;
import com.bytedance.android.live.base.api.outer.data.RoomInfo;
import java.util.List;

/* loaded from: classes2.dex */
public interface ILiveProvider {
    String getCirculationData();

    ILivePreviewLayout getILivePreviewLayout(ILivePreviewLayout.Builder builder);

    String getIdentity();

    ILiveView getLiveView(Context context, int i10, String str, boolean z10, Bundle bundle);

    @Deprecated
    List<RoomInfo> getRoomInfoList(int i10, int i11, int i12);

    List<RoomInfo> getRoomInfoList(int i10, int i11, int i12, Bundle bundle);

    IStandalonePreviewView makeStandalonePreviewView(Context context, int i10, Bundle bundle);

    void reportShow(int i10, String str, Bundle bundle);

    void startLive(Context context, int i10, String str, Bundle bundle);
}
