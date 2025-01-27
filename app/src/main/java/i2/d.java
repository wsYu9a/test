package i2;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a */
    public static String f26838a = "";

    /* renamed from: b */
    public static String f26839b = "";

    /* renamed from: c */
    public static String f26840c = "";

    public static synchronized void a(String str) {
        synchronized (d.class) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            d(arrayList);
        }
    }

    public static synchronized void b(String str, String str2, String str3) {
        synchronized (d.class) {
            f26838a = str;
            f26839b = str2;
            f26840c = str3;
        }
    }

    public static synchronized void c(Throwable th2) {
        String str;
        synchronized (d.class) {
            try {
                ArrayList arrayList = new ArrayList();
                if (th2 != null) {
                    StringWriter stringWriter = new StringWriter();
                    th2.printStackTrace(new PrintWriter(stringWriter));
                    str = stringWriter.toString();
                } else {
                    str = "";
                }
                arrayList.add(str);
                d(arrayList);
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public static synchronized void d(List<String> list) {
        synchronized (d.class) {
            try {
                if (!t3.a.c(f26839b) && !t3.a.c(f26840c)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(f26840c);
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        stringBuffer.append(", " + it.next());
                    }
                    stringBuffer.append("\n");
                    try {
                        File file = new File(f26838a);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        File file2 = new File(f26838a, f26839b);
                        if (!file2.exists()) {
                            file2.createNewFile();
                        }
                        FileWriter fileWriter = ((long) stringBuffer.length()) + file2.length() <= 51200 ? new FileWriter(file2, true) : new FileWriter(file2);
                        fileWriter.write(stringBuffer.toString());
                        fileWriter.flush();
                        fileWriter.close();
                    } catch (Exception unused) {
                    }
                }
            } finally {
            }
        }
    }
}
