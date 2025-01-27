package cn.vlion.ad.inland.base.adapter;

/* loaded from: classes.dex */
public class TemError {
    private int code;
    private String error;

    public TemError(int i10, String str) {
        this.code = i10;
        this.error = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getError() {
        return this.error;
    }
}
