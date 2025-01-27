package com.martian.mibook.lib.model.data;

/* loaded from: classes3.dex */
public class TextInfo {
    private String line;
    private boolean pStart;
    private float widthExtra;

    public String getLine() {
        return this.line;
    }

    public boolean getNeedScale() {
        return this.widthExtra > 0.0f;
    }

    public float getWidthExtra() {
        return this.widthExtra;
    }

    public boolean ispStart() {
        return this.pStart;
    }

    public TextInfo setLine(String str) {
        this.line = str;
        return this;
    }

    public TextInfo setWidthExtra(float f10) {
        this.widthExtra = f10;
        return this;
    }

    public TextInfo setpStart(boolean z10) {
        this.pStart = z10;
        return this;
    }
}
