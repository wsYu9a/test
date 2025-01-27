package com.martian.mibook.c;

import java.io.File;
import java.io.FileFilter;

/* loaded from: classes3.dex */
public class b implements FileFilter {

    /* renamed from: a, reason: collision with root package name */
    private static String[] f11632a;

    public b(String[] scanTypes) {
        f11632a = scanTypes;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        String name;
        int lastIndexOf;
        File[] listFiles;
        if (file.isDirectory()) {
            return (file.getName().charAt(0) == '.' || (listFiles = file.listFiles()) == null || listFiles.length <= 0) ? false : true;
        }
        if (file.isFile() && (lastIndexOf = (name = file.getName()).lastIndexOf(".")) >= 0) {
            String substring = name.substring(lastIndexOf + 1);
            for (String str : f11632a) {
                if (str.equalsIgnoreCase(substring)) {
                    return true;
                }
            }
        }
        return false;
    }
}
