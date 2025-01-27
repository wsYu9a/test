package com.vivo.ic.dm.util;

import java.io.Closeable;

/* loaded from: classes4.dex */
public class a {
    public static void a(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
