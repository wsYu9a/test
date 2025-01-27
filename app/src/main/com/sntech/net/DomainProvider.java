package com.sntech.net;

import androidx.annotation.Keep;

@Keep
/* loaded from: classes4.dex */
public class DomainProvider {
    @Keep
    public static String baseA4Url() {
        return getProtocol() + DomainManager.get().getDomainByTemplate(DomainConfig.TEMPLATE_A4) + "/";
    }

    @Keep
    public static String baseDeviceActiveUrl() {
        return getProtocol() + DomainManager.get().getDomainByTemplate(DomainConfig.TEMPLATE_DEVICE_ACTIVE) + "/";
    }

    @Keep
    public static String baseDeviceUrl() {
        return getProtocol() + DomainManager.get().getDomainByTemplate(DomainConfig.TEMPLATE_DEVICE) + "/";
    }

    @Keep
    public static String baseUrl() {
        return getProtocol() + DomainManager.get().getDomainByTemplate(DomainConfig.TEMPLATE_X1) + "/";
    }

    @Keep
    public static String baseX2Url() {
        return getProtocol() + DomainManager.get().getDomainByTemplate(DomainConfig.TEMPLATE_X2) + "/";
    }

    private static String getProtocol() {
        return DomainManager.get().mProtocol + "://";
    }
}
