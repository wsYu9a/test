package com.bytedance.android.live.base.api;

import com.bytedance.android.live.base.IService;

/* loaded from: classes.dex */
public interface MethodChannelService extends IService {
    String identity();

    Object invokeMethod(String str, Object... objArr);
}
