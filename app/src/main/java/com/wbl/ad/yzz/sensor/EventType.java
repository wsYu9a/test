package com.wbl.ad.yzz.sensor;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public enum EventType {
    TRACK("track", true, false),
    TRACK_SIGNUP("track_signup", true, false),
    PROFILE_SET("profile_set", false, true),
    PROFILE_SET_ONCE("profile_set_once", false, true),
    PROFILE_UNSET("profile_unset", false, true),
    PROFILE_INCREMENT("profile_increment", false, true),
    PROFILE_APPEND("profile_append", false, true),
    PROFILE_DELETE("profile_delete", false, true),
    REGISTER_SUPER_PROPERTIES("register_super_properties", false, false);

    private String eventType;
    private boolean profile;
    private boolean track;

    EventType(String str, boolean z, boolean z2) {
        this.eventType = str;
        this.track = z;
        this.profile = z2;
    }

    public static EventType valueOf(String str) {
        return (EventType) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10683, null, str);
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static EventType[] valuesCustom() {
        return (EventType[]) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10678, null, null);
    }

    public String getEventType() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10677, this, null);
    }

    public boolean isProfile() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10680, this, null);
    }

    public boolean isTrack() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10679, this, null);
    }
}
