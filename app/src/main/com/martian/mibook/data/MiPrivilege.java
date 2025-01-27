package com.martian.mibook.data;

import android.content.Context;
import ba.j;

/* loaded from: classes3.dex */
public class MiPrivilege {
    private String desc;
    private final int iconResId;
    private boolean isUnlocked;
    private String prefName;
    private String title;
    private final int unlockCoins;

    public MiPrivilege(Context context, String str, String str2, String str3, int i10, int i11) {
        this.prefName = str;
        this.title = str2;
        this.desc = str3;
        this.unlockCoins = i10;
        this.iconResId = i11;
        this.isUnlocked = j.d(context, str, false);
    }

    public String getDesc() {
        return this.desc;
    }

    public int getIconResId() {
        return this.iconResId;
    }

    public String getPrefName() {
        return this.prefName;
    }

    public String getTitle() {
        return this.title;
    }

    public int getUnlockCoins() {
        return this.unlockCoins;
    }

    public boolean isUnlocked() {
        return this.isUnlocked;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setPrefName(String str) {
        this.prefName = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUnlocked(Context context, boolean z10) {
        this.isUnlocked = z10;
        j.p(context, this.prefName, z10);
    }
}
