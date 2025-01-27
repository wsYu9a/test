package com.bykv.vk.openvk.api.proto;

/* loaded from: classes.dex */
public interface Result {
    int code();

    boolean isSuccess();

    String message();

    ValueSet values();
}
