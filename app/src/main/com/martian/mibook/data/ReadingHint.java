package com.martian.mibook.data;

/* loaded from: classes3.dex */
public class ReadingHint {
    private long fetchTime;
    private String hint;
    private int weight;

    public String getHint() {
        return this.hint;
    }

    public int getWeight() {
        return this.weight;
    }

    public boolean isValid() {
        return System.currentTimeMillis() - this.fetchTime <= 60000;
    }

    public void setFetchTime(long j10) {
        this.fetchTime = j10;
    }

    public ReadingHint setHint(String str) {
        this.hint = str;
        return this;
    }

    public ReadingHint setWeight(int i10) {
        this.weight = i10;
        return this;
    }
}
