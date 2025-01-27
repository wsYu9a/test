package bh;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import bh.b;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;
import p002continue.Cimport;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a */
    public static String f1612a;

    /* renamed from: b */
    public static final Map<String, Integer> f1613b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00ce A[Catch: Exception -> 0x00bd, TryCatch #3 {Exception -> 0x00bd, blocks: (B:6:0x0073, B:11:0x00c5, B:13:0x00ce, B:15:0x00dc, B:16:0x00e5, B:50:0x00e1, B:59:0x00ad, B:10:0x00bf), top: B:5:0x0073 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e1 A[Catch: Exception -> 0x00bd, TryCatch #3 {Exception -> 0x00bd, blocks: (B:6:0x0073, B:11:0x00c5, B:13:0x00ce, B:15:0x00dc, B:16:0x00e5, B:50:0x00e1, B:59:0x00ad, B:10:0x00bf), top: B:5:0x0073 }] */
    /* JADX WARN: Type inference failed for: r0v24, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r9v1, types: [bh.j] */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.util.Set] */
    static {
        /*
            Method dump skipped, instructions count: 420
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bh.d.<clinit>():void");
    }

    /* JADX WARN: Type inference failed for: r5v6, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    public static Map<String, List<ZipEntry>> a(ZipFile zipFile) {
        String[] split;
        HashMap hashMap = new HashMap();
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        Pattern compile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            if (!nextElement.isDirectory() && !nextElement.getName().contains("../") && nextElement.getName().startsWith("lib/") && compile.matcher(nextElement.getName()).matches() && (split = nextElement.getName().split(File.separator)) != null && split.length >= 2) {
                String str = split[split.length - 2];
                if (f1613b.containsKey(str)) {
                    if (hashMap.get(str) == null) {
                        hashMap.put(str, new LinkedList());
                    }
                    ((List) hashMap.get(str)).add(nextElement);
                }
            }
        }
        j jVar = b.a.f1608a;
        StringBuilder a10 = nh.b.a("getAllSoZipEntries, zipFile=");
        a10.append(zipFile.getName());
        a10.append(", soEntries=");
        a10.append(hashMap);
        jVar.f("NLibH", a10.toString());
        return hashMap;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    public static void b(@NonNull Cimport cimport, @NonNull File file, @NonNull File file2) {
        ZipFile zipFile;
        char c10;
        try {
            if (cimport.f29this.size() != 0) {
                ArrayList arrayList = new ArrayList(cimport.f29this);
                String str = yk.b.f33564b.getApplicationInfo().nativeLibraryDir;
                if (!TextUtils.isEmpty(str)) {
                    String[] split = str.split(File.pathSeparator);
                    Iterator it = cimport.f29this.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        for (String str3 : split) {
                            File file3 = new File(str3, str2);
                            if (arrayList.contains(str2) && file3.exists()) {
                                a0.j(file3.getAbsolutePath(), new File(file2, str2).getAbsolutePath());
                                b.a.f1608a.k("NLibH", "copySo, hostSoPath=" + file3.getAbsolutePath());
                                arrayList.remove(str2);
                            }
                        }
                    }
                }
            }
            zipFile = new ZipFile(file);
            try {
                Map<String, List<ZipEntry>> a10 = a(zipFile);
                boolean g10 = g(a10, f1612a);
                j jVar = b.a.f1608a;
                jVar.k("NLibH", "copySo matchHostAbi[" + g10 + "], id = " + cimport.f23do);
                if (g10) {
                    LinkedList linkedList = new LinkedList();
                    if (!a10.isEmpty()) {
                        HashSet hashSet = new HashSet();
                        String str4 = f1612a;
                        String str5 = "mips64";
                        switch (str4.hashCode()) {
                            case -1073971299:
                                if (str4.equals("mips64")) {
                                    c10 = 0;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case -806050265:
                                if (str4.equals("x86_64")) {
                                    c10 = 1;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case -738963905:
                                if (str4.equals("armeabi")) {
                                    c10 = 2;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case 117110:
                                if (str4.equals("x86")) {
                                    c10 = 3;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case 3351711:
                                if (str4.equals("mips")) {
                                    c10 = 4;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case 145444210:
                                if (str4.equals("armeabi-v7a")) {
                                    c10 = 5;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case 1431565292:
                                if (str4.equals("arm64-v8a")) {
                                    c10 = 6;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            default:
                                c10 = 65535;
                                break;
                        }
                        switch (c10) {
                            case 0:
                                c(a10, str5, linkedList, hashSet);
                                break;
                            case 1:
                                str5 = "x86_64";
                                c(a10, str5, linkedList, hashSet);
                                break;
                            case 2:
                                c(a10, "armeabi", linkedList, hashSet);
                                str5 = "armeabi-v7a";
                                c(a10, str5, linkedList, hashSet);
                                break;
                            case 3:
                                str5 = "x86";
                                c(a10, str5, linkedList, hashSet);
                                break;
                            case 4:
                                str5 = "mips";
                                c(a10, str5, linkedList, hashSet);
                                break;
                            case 5:
                                c(a10, "armeabi-v7a", linkedList, hashSet);
                                str5 = "armeabi";
                                c(a10, str5, linkedList, hashSet);
                                break;
                            case 6:
                                str5 = "arm64-v8a";
                                c(a10, str5, linkedList, hashSet);
                                break;
                        }
                    }
                    if (linkedList.isEmpty()) {
                        jVar.k("NLibH", "copySo, matchedSoEntries is empty, id = ".concat(cimport.f23do));
                        zipFile.close();
                        return;
                    } else {
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        Iterator it2 = linkedList.iterator();
                        while (it2.hasNext()) {
                            d(zipFile, (ZipEntry) it2.next(), file2);
                        }
                    }
                }
                zipFile.close();
            } catch (Throwable th2) {
                th = th2;
                if (zipFile != null) {
                    zipFile.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            zipFile = null;
        }
    }

    public static void c(Map<String, List<ZipEntry>> map, String str, List<ZipEntry> list, Set<String> set) {
        List<ZipEntry> list2 = map.get(str);
        if (list2 == null || list2.size() == 0) {
            return;
        }
        for (ZipEntry zipEntry : list2) {
            String substring = zipEntry.getName().substring(zipEntry.getName().lastIndexOf(File.separator) + 1);
            if (!set.contains(substring)) {
                list.add(zipEntry);
                set.add(substring);
            }
        }
    }

    public static void d(ZipFile zipFile, ZipEntry zipEntry, File file) {
        String name = zipEntry.getName();
        if (name.contains("..")) {
            return;
        }
        File file2 = new File(file, name.substring(name.lastIndexOf(File.separator) + 1));
        int i10 = 0;
        boolean z10 = false;
        do {
            if (file2.exists()) {
                file2.delete();
            }
            try {
                b.a.f1608a.f("NLibH", "copySoZipEntry, source = " + zipEntry + ", target = " + file2 + ", retryTimes = " + i10);
                InputStream inputStream = zipFile.getInputStream(zipEntry);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                if (inputStream != null) {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    byte[] bArr = new byte[8192];
                    while (true) {
                        try {
                            int read = bufferedInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            } else {
                                bufferedOutputStream.write(bArr, 0, read);
                            }
                        } catch (Throwable th2) {
                            bufferedInputStream.close();
                            bufferedOutputStream.close();
                            throw th2;
                        }
                    }
                    bufferedOutputStream.flush();
                    bufferedInputStream.close();
                    bufferedOutputStream.close();
                }
                z10 = true;
            } catch (IOException e10) {
                if (i10 >= 3) {
                    throw e10;
                }
                i10++;
            }
        } while (!z10);
    }

    public static void e(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }

    public static boolean f(File file) {
        ZipFile zipFile;
        ZipFile zipFile2 = null;
        try {
            try {
                zipFile = new ZipFile(file);
            } catch (IOException e10) {
                e = e10;
            }
            try {
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    Pattern compile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
                    while (entries.hasMoreElements()) {
                        ZipEntry nextElement = entries.nextElement();
                        if (!nextElement.isDirectory() && compile.matcher(nextElement.getName()).matches()) {
                            try {
                                zipFile.close();
                                return true;
                            } catch (IOException unused) {
                                b.a.f1608a.j("NLibH", "hasNativeLib, close sourceApkZipFile error!");
                                return true;
                            }
                        }
                    }
                    try {
                        zipFile.close();
                        return false;
                    } catch (IOException unused2) {
                        b.a.f1608a.j("NLibH", "hasNativeLib, close sourceApkZipFile error!");
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused3) {
                            b.a.f1608a.j("NLibH", "hasNativeLib, close sourceApkZipFile error!");
                        }
                    }
                    throw th;
                }
            } catch (IOException e11) {
                e = e11;
                zipFile2 = zipFile;
                b.a.f1608a.m("NLibH", "hasNativeLib, get sourceApk ZipFile failed!", e);
                if (zipFile2 != null) {
                    try {
                        zipFile2.close();
                        return false;
                    } catch (IOException unused4) {
                        b.a.f1608a.j("NLibH", "hasNativeLib, close sourceApkZipFile error!");
                        return false;
                    }
                }
                return false;
            }
        } catch (Throwable th3) {
            th = th3;
            zipFile = zipFile2;
        }
    }

    public static boolean g(Map<String, List<ZipEntry>> map, String str) {
        return (TextUtils.equals(str, "armeabi") || TextUtils.equals(str, "armeabi-v7a")) ? map.containsKey("armeabi") || map.containsKey("armeabi-v7a") : map.containsKey(str);
    }

    public static Map.Entry<Boolean, Map<String, List<ZipEntry>>> h(File file) {
        ZipFile zipFile;
        String str;
        boolean z10;
        j jVar;
        HashMap hashMap = new HashMap();
        try {
            try {
                zipFile = new ZipFile(file);
            } catch (Throwable th2) {
                th = th2;
                zipFile = null;
            }
            try {
                hashMap.putAll(a(zipFile));
                if (hashMap.isEmpty()) {
                    jVar = b.a.f1608a;
                    str = "NLibH isPluginApkMatchHostAbi [true] soEntries empty, ".concat(String.valueOf(file));
                    z10 = true;
                } else {
                    boolean g10 = g(hashMap, f1612a);
                    str = "NLibH isPluginApkMatchHostAbi [" + g10 + "], " + file;
                    z10 = g10;
                    jVar = b.a.f1608a;
                }
                jVar.f("NLibH", str);
                AbstractMap.SimpleEntry simpleEntry = new AbstractMap.SimpleEntry(Boolean.valueOf(z10), hashMap);
                try {
                    zipFile.close();
                } catch (IOException unused) {
                    b.a.f1608a.f("NLibH", "NLibH isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                }
                return simpleEntry;
            } catch (Throwable th3) {
                th = th3;
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException unused2) {
                        b.a.f1608a.f("NLibH", "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                    }
                }
                throw th;
            }
        } catch (IOException e10) {
            b.a.f1608a.m("NLibH", "NLibH isPluginApkMatchHostAbi, get sourceApk ZipFile failed!", e10);
            return new AbstractMap.SimpleEntry(Boolean.FALSE, hashMap);
        }
    }
}
