package com.martian.libsupport.permission;

import androidx.annotation.Nullable;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class TipInfo implements Serializable {
    private static final long serialVersionUID = 1;
    private String cancel;
    private String content;
    private String ensure;
    private String title;

    public TipInfo(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.title = str;
        this.content = str2;
        this.cancel = str3;
        this.ensure = str4;
    }

    public String getCancel() {
        return this.cancel;
    }

    public String getContent() {
        return this.content;
    }

    public String getEnsure() {
        return this.ensure;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCancel(String str) {
        this.cancel = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setEnsure(String str) {
        this.ensure = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
