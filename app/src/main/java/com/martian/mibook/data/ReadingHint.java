package com.martian.mibook.data;

/* loaded from: classes3.dex */
public class ReadingHint {
    private long fetchTime;
    private String hint;
    private int weight;

    public long getFetchTime() {
        return this.fetchTime;
    }

    public String getHint() {
        return this.hint;
    }

    public int getWeight() {
        return this.weight;
    }

    public boolean isValid() {
        return System.currentTimeMillis() - this.fetchTime <= 60000;
    }

    public ReadingHint setFetchTime(long fetchTime) {
        this.fetchTime = fetchTime;
        return this;
    }

    public ReadingHint setHint(String hint) {
        this.hint = hint;
        return this;
    }

    public ReadingHint setWeight(int weight) {
        this.weight = weight;
        return this;
    }
}
