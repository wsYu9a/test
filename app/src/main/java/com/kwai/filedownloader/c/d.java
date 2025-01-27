package com.kwai.filedownloader.c;

/* loaded from: classes2.dex */
public final class d {
    public static boolean B(int i2, int i3) {
        if ((i2 != 3 && i2 != 5 && i2 == i3) || dd(i2)) {
            return false;
        }
        if (i2 > 0 && i2 <= 6 && i3 >= 10 && i3 <= 11) {
            return false;
        }
        if (i2 == 1) {
            return i3 != 0;
        }
        if (i2 == 2) {
            return (i3 == 0 || i3 == 1 || i3 == 6) ? false : true;
        }
        if (i2 == 3) {
            return (i3 == 0 || i3 == 1 || i3 == 2 || i3 == 6) ? false : true;
        }
        if (i2 == 5) {
            return (i3 == 1 || i3 == 6) ? false : true;
        }
        if (i2 != 6) {
            return true;
        }
        return (i3 == 0 || i3 == 1) ? false : true;
    }

    public static boolean C(int i2, int i3) {
        if ((i2 != 3 && i2 != 5 && i2 == i3) || dd(i2)) {
            return false;
        }
        if (i3 == -2 || i3 == -1) {
            return true;
        }
        if (i2 == 0) {
            return i3 == 10;
        }
        if (i2 == 1) {
            return i3 == 6;
        }
        if (i2 == 2 || i2 == 3) {
            return i3 == -3 || i3 == 3 || i3 == 5;
        }
        if (i2 == 5 || i2 == 6) {
            return i3 == 2 || i3 == 5;
        }
        if (i2 == 10) {
            return i3 == 11;
        }
        if (i2 != 11) {
            return false;
        }
        return i3 == -4 || i3 == -3 || i3 == 1;
    }

    public static boolean dd(int i2) {
        return i2 < 0;
    }

    public static boolean de(int i2) {
        return i2 > 0;
    }

    public static boolean f(com.kwai.filedownloader.a aVar) {
        return aVar.Gq() == 0 || aVar.Gq() == 3;
    }
}
