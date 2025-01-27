package cn.vlion.ad.inland.ad.natives;

import cn.vlion.ad.inland.base.javabean.VlionADClickType;

/* loaded from: classes.dex */
public interface VlionCustomsNativeEventListener {
    void isResume(boolean z10);

    void onAdEnter();

    void onClick(VlionADClickType vlionADClickType);

    void onClose();

    void onExposure();
}
