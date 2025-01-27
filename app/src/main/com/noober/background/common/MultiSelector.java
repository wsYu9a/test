package com.noober.background.common;

import android.R;

/* loaded from: classes3.dex */
public enum MultiSelector {
    State_Checkable("state_checkable", R.attr.state_checkable),
    State_Checked("state_checked", R.attr.state_checked),
    State_Enabled("state_enabled", R.attr.state_enabled),
    State_Selected("state_selected", R.attr.state_selected),
    State_Pressed("state_pressed", R.attr.state_pressed),
    State_Focused("state_focused", R.attr.state_focused),
    State_Hovered("state_hovered", R.attr.state_hovered),
    State_Activated("state_activated", R.attr.state_activated);


    /* renamed from: id */
    public int f16204id;
    public String value;

    MultiSelector(String str, int i10) {
        this.value = str;
        this.f16204id = i10;
    }

    public static MultiSelector getMultiAttr(String str) {
        str.hashCode();
        switch (str) {
            case "state_selected":
                return State_Selected;
            case "state_focused":
                return State_Focused;
            case "state_pressed":
                return State_Pressed;
            case "state_checked":
                return State_Checked;
            case "state_activated":
                return State_Activated;
            case "state_hovered":
                return State_Hovered;
            case "state_checkable":
                return State_Checkable;
            case "state_enabled":
                return State_Enabled;
            default:
                return null;
        }
    }
}
