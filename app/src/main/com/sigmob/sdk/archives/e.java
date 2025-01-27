package com.sigmob.sdk.archives;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a */
    public static final d f17517a = new d();

    public static void a(String[] strArr) throws Exception {
        if (strArr.length == 0) {
            a();
            return;
        }
        PrintStream printStream = System.out;
        printStream.println("Analysing " + strArr[0]);
        File file = new File(strArr[0]);
        if (!file.isFile()) {
            System.err.println(file + " doesn't exist or is a directory");
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        c a10 = strArr.length > 1 ? f17517a.a(strArr[1], bufferedInputStream) : f17517a.a(bufferedInputStream);
        printStream.println("Created " + a10.toString());
        while (true) {
            a c10 = a10.c();
            if (c10 == null) {
                a10.close();
                bufferedInputStream.close();
                return;
            }
            System.out.println(c10.d());
        }
    }

    public static void a() {
        System.out.println("Parameters: archive-name [archive-type]");
    }
}
