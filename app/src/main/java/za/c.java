package za;

import java.io.File;
import java.io.FileFilter;

/* loaded from: classes3.dex */
public class c implements FileFilter {

    /* renamed from: a */
    public static String[] f33726a;

    public c(String[] strArr) {
        f33726a = strArr;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        String name;
        int lastIndexOf;
        File[] listFiles;
        if (file.isDirectory()) {
            return (file.getName().charAt(0) == '.' || (listFiles = file.listFiles()) == null || listFiles.length <= 0) ? false : true;
        }
        if (file.isFile() && (lastIndexOf = (name = file.getName()).lastIndexOf(p1.b.f29697h)) >= 0) {
            String substring = name.substring(lastIndexOf + 1);
            for (String str : f33726a) {
                if (str.equalsIgnoreCase(substring)) {
                    return true;
                }
            }
        }
        return false;
    }
}
