package org.threeten.bp.format;

/* loaded from: classes4.dex */
public enum SignStyle {
    NORMAL,
    ALWAYS,
    NEVER,
    NOT_NEGATIVE,
    EXCEEDS_PAD;

    public boolean parse(boolean z10, boolean z11, boolean z12) {
        int ordinal = ordinal();
        if (ordinal == 0) {
            return (z10 && z11) ? false : true;
        }
        if (ordinal == 1 || ordinal == 4) {
            return true;
        }
        return (z11 || z12) ? false : true;
    }
}
