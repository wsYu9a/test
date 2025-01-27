package com.alimm.tanx.core.ad.listener.bean;

/* loaded from: classes.dex */
public interface IBidInfo {
    String getAdSource();

    String getAdvLogo();

    long getBidPrice();

    String getCacheCreativeId();

    IClickBean getClickBean();

    String getCreativeId();

    String getCreativeMd5();

    String getCreativeName();

    String getCreativePath();

    int getCreativeType();

    String getCreativeVideoName();

    String getCreativeVideoPath();

    int getId();

    Integer[] getInteractType();

    int getInteractType2Int();

    boolean getInteractType2Shake();

    IMaterialBean getMaterialBean();

    IMonitorBean getMonitorBean();

    int getOpenType();

    long getReleaseEndTime();

    long getReleaseStartTime();

    String getSessionId();

    String getTemplateId();

    void setCreativePath(String str);

    void setCreativeType(int i10);

    void setCreativeVideoPath(String str);
}
