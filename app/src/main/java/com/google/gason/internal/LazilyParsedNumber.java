package com.google.gason.internal;

import java.math.BigInteger;

/* loaded from: classes7.dex */
public final class LazilyParsedNumber extends Number {
    private final String value;

    public LazilyParsedNumber(String str) {
        this.value = str;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.value);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.value);
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            return Integer.parseInt(this.value);
        } catch (NumberFormatException e2) {
            try {
                return (int) Long.parseLong(this.value);
            } catch (NumberFormatException e3) {
                return new BigInteger(this.value).intValue();
            }
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.value);
        } catch (NumberFormatException e2) {
            return new BigInteger(this.value).longValue();
        }
    }

    public String toString() {
        return this.value;
    }
}
