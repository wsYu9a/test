package com.martian.mibook.data;

/* loaded from: classes3.dex */
public class ClockInfo {
    private int idx;
    private boolean isChecked;
    private String name;

    public ClockInfo(int i10, String str, boolean z10) {
        this.idx = i10;
        this.name = str;
        this.isChecked = z10;
    }

    public int getIdx() {
        return this.idx;
    }

    public String getName() {
        return this.name;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean z10) {
        this.isChecked = z10;
    }

    public void setIdx(int i10) {
        this.idx = i10;
    }

    public void setName(String str) {
        this.name = str;
    }
}
