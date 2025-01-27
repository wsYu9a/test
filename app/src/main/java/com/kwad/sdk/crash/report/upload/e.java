package com.kwad.sdk.crash.report.upload;

/* loaded from: classes3.dex */
public final class e {
    public static e aLU = new e(-11, "Please init.");
    public static e aLV = new e(-12, "error when zip_file");
    public static e aLW = new e(-13, "There is no valid network.");
    public static e aLX = new e(-14, "Token is invalid.");
    public static e aLY = new e(-15, "upload task execute frequence exceed.");
    public static e aLZ = new e(-16, "process request fail.");
    public static e aMa = new e(-17, "sever response error http code");
    public static e aMb = new e(-18, "sever response error result code");
    public static e aMc = new e(-19, "server bad response.");
    private final int aMd;
    private final String aMe;

    private e(int i10, String str) {
        this.aMd = i10;
        this.aMe = str;
    }

    public final String xv() {
        return this.aMe;
    }
}
