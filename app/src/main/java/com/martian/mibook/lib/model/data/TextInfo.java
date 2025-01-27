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

    public TextInfo setLine(String line) {
        this.line = line;
        return this;
    }

    public TextInfo setWidthExtra(float widthExtra) {
        this.widthExtra = widthExtra;
        return this;
    }

    public TextInfo setpStart(boolean pStart) {
        this.pStart = pStart;
        return this;
    }
}
