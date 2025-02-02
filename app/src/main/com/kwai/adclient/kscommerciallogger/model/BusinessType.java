package com.kwai.adclient.kscommerciallogger.model;

/* loaded from: classes3.dex */
public enum BusinessType {
    TACHIKOMA("TACHIKOMA"),
    AD_SPLASH("AD_SPLASH"),
    AD_INTERSTITIAL("AD_INTERSTITIAL"),
    AD_FULLSCREEN("AD_FULLSCREEN"),
    AD_REWARD("AD_REWARD"),
    AD_FEED("AD_FEED"),
    AD_NATIVE("AD_NATIVE"),
    AD_DRAW("AD_DRAW"),
    CU_SLIDE("CU_SLIDE"),
    CU_PROFILE("CU_PROFILE"),
    CU_PROFILE_SLIDE("CU_PROFILE_SLIDE"),
    CU_FEED("CU_FEED"),
    CU_FEED_SLIDE("CU_FEED_SLIDE"),
    CU_HOTSPOT_ENTRY("CU_HOTSPOT_ENTRY"),
    CU_HOTSPOT_SLIDE("CU_HOTSPOT_SLIDE"),
    CU_HORIZONTAL_FEED("CU_HORIZONTAL_FEED"),
    CU_VIDEO_DETAIL("CU_VIDEO_DETAIL"),
    CU_IMAGE_TEXT_FEED("CU_IMAGE_TEXT_FEED"),
    CU_IMAGE_TEXT_DETAIL("CU_IMAGE_TEXT_DETAIL"),
    CU_WALLPAPER_FEED("CU_WALLPAPER_FEED"),
    CU_WALLPAPER_SLIDE("CU_WALLPAPER_SLIDE"),
    EU_LIVE_SLIDE("EU_LIVE_SLIDE"),
    EU_LIVE_REPLAY("EU_LIVE_REPLAY"),
    WEB_CACHE("WEB_CACHE"),
    AD_SDK_INIT("AD_SDK_INIT"),
    AD_WEBVIEW("AD_WEBVIEW"),
    AD_CONVERT("AD_CONVERT"),
    OTHER("OTHER");

    public String value;

    BusinessType(String str) {
        this.value = str;
    }
}
