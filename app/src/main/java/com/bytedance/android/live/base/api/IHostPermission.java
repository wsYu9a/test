package com.bytedance.android.live.base.api;

import com.bytedance.android.live.base.IService;

/* loaded from: classes.dex */
public interface IHostPermission extends IService {
    boolean alist();

    String getAndroidID();

    String getDevImei();

    String getDevOaid();

    String getMacAddress();

    LocationProvider getTTLocation();

    boolean isCanGetAndUseAndroidID();

    boolean isCanUseLocation();

    boolean isCanUsePhoneState();

    boolean isCanUseWifiState();

    boolean isCanUseWriteExternal();
}
