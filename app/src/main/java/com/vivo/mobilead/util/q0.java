package com.vivo.mobilead.util;

import java.io.Closeable;

/* loaded from: classes4.dex */
public class q0 {
    public static void a(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Exception unused) {
                }
            }
        }
    }
}
