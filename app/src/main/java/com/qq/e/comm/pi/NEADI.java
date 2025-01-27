package com.qq.e.comm.pi;

import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;

/* loaded from: classes3.dex */
public interface NEADI {
    String getAdNetWorkName();

    void loadAd(int i10);

    void loadAd(int i10, LoadAdParams loadAdParams);

    void setMaxVideoDuration(int i10);

    void setMinVideoDuration(int i10);

    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    void setVideoOption(VideoOption videoOption);
}
