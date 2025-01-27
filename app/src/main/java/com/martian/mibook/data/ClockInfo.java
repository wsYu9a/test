package com.martian.mibook.data;

/* loaded from: classes3.dex */
public class ClockInfo {
    private int idx;
    private boolean isChecked;
    private String name;

    public ClockInfo(int index, String name, boolean isChecked) {
        this.idx = index;
        this.name = name;
        this.isChecked = isChecked;
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

    public void setChecked(boolean checked) {
        this.isChecked = checked;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public void setName(String name) {
        this.name = name;
    }
}
