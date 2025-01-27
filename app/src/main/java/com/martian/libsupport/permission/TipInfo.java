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

    public TipInfo(@Nullable String title, @Nullable String content, @Nullable String cancel, @Nullable String ensure) {
        this.title = title;
        this.content = content;
        this.cancel = cancel;
        this.ensure = ensure;
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

    public void setCancel(String cancel) {
        this.cancel = cancel;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setEnsure(String ensure) {
        this.ensure = ensure;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
