package cn.vlion.ad.inland.base.util.init;

/* loaded from: classes.dex */
public enum ConsumeLevel {
    High("high"),
    Middle("middle"),
    Low("low");

    private final String level;

    ConsumeLevel(String str) {
        this.level = str;
    }

    public String getConsumeLevel() {
        return this.level;
    }
}
