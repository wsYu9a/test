package com.martian.mibook.data;

import android.content.Context;
import com.martian.libsupport.h;

/* loaded from: classes3.dex */
public class MiPrivilege {
    private String desc;
    private final int iconResId;
    private boolean isUnlocked;
    private String prefName;
    private String title;
    private final int unlockCoins;

    public MiPrivilege(Context context, String prefName, String title, String desc, int unlockCoins, int iconResId) {
        this.prefName = prefName;
        this.title = title;
        this.desc = desc;
        this.unlockCoins = unlockCoins;
        this.iconResId = iconResId;
        this.isUnlocked = h.d(context, prefName, false);
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

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPrefName(String prefName) {
        this.prefName = prefName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUnlocked(Context context, boolean isUnlocked) {
        this.isUnlocked = isUnlocked;
        h.p(context, this.prefName, isUnlocked);
    }
}
