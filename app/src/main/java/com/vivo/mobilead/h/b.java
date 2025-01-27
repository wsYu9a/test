package com.vivo.mobilead.h;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bu;
import com.vivo.mobilead.h.a;
import com.vivo.mobilead.util.a1;
import com.vivo.mobilead.util.h;
import com.vivo.mobilead.util.x0;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: d */
    private static final String f28873d = "b";

    /* renamed from: a */
    private com.vivo.mobilead.h.a f28874a;

    /* renamed from: b */
    private com.vivo.mobilead.h.a f28875b;

    /* renamed from: c */
    private com.vivo.mobilead.h.a f28876c;

    /* renamed from: com.vivo.mobilead.h.b$b */
    private static class C0595b {

        /* renamed from: a */
        private static final b f28877a = new b();
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    public static b a() {
        return C0595b.f28877a;
    }

    private String h(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(bu.f5659a);
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return String.valueOf(str.hashCode());
        } catch (Exception unused2) {
            return String.valueOf(str.hashCode());
        }
    }

    public boolean b(String str, InputStream inputStream) {
        return a(this.f28874a, str, inputStream);
    }

    public boolean c(String str, InputStream inputStream) {
        return a(this.f28876c, str, inputStream);
    }

    public File d(String str) {
        try {
            return this.f28874a.a(h(str), 0);
        } catch (Exception e2) {
            x0.b(f28873d, "getBytes failed: " + e2.getMessage());
            return null;
        } finally {
            com.vivo.mobilead.h.a.a((a.e) null);
        }
    }

    public boolean e(String str) {
        return a(this.f28875b, str);
    }

    public boolean f(String str) {
        return a(this.f28874a, str);
    }

    public boolean g(String str) {
        return a(this.f28876c, str);
    }

    private b() {
    }

    public void a(Context context) {
        a(1, context, "/open_adsdk", 1, 1, 20971520L);
        a(2, context, "/open_adsdk_action", 1, 1, 10485760L);
        a(3, context, "/open_adsdk_style", 1, 1, 10485760L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0103: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:77:0x0103 */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v1, types: [com.vivo.mobilead.h.a$e] */
    /* JADX WARN: Type inference failed for: r9v12, types: [com.vivo.mobilead.h.a$e] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7, types: [com.vivo.mobilead.h.a$e] */
    public int[] b(String str) {
        InputStream inputStream;
        InputStream inputStream2;
        InputStream inputStream3 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (this.f28874a == null) {
                x0.b(f28873d, "disklrucache is null");
                return null;
            }
            try {
                str = this.f28874a.b(h(str));
            } catch (Exception e2) {
                e = e2;
                str = 0;
                inputStream2 = null;
            } catch (Throwable th) {
                th = th;
                str = 0;
            }
            if (str == 0) {
                if (str != 0) {
                    try {
                        str.close();
                    } catch (Exception e3) {
                        x0.b(f28873d, "getBitmap failed: " + e3.getMessage());
                    }
                }
                return null;
            }
            try {
                inputStream2 = str.a(0);
            } catch (Exception e4) {
                e = e4;
                inputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream3 != null) {
                    try {
                        inputStream3.close();
                    } catch (Exception e5) {
                        x0.b(f28873d, "getBitmap failed: " + e5.getMessage());
                    }
                }
                if (str == 0) {
                    throw th;
                }
                try {
                    str.close();
                    throw th;
                } catch (Exception e6) {
                    x0.b(f28873d, "getBitmap failed: " + e6.getMessage());
                    throw th;
                }
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(inputStream2, null, options);
                int[] iArr = {options.outWidth, options.outHeight};
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Exception e7) {
                        x0.b(f28873d, "getBitmap failed: " + e7.getMessage());
                    }
                }
                try {
                    str.close();
                } catch (Exception e8) {
                    x0.b(f28873d, "getBitmap failed: " + e8.getMessage());
                }
                return iArr;
            } catch (Exception e9) {
                e = e9;
                x0.b(f28873d, "get bitmap error, " + e.getMessage());
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Exception e10) {
                        x0.b(f28873d, "getBitmap failed: " + e10.getMessage());
                    }
                }
                if (str != 0) {
                    try {
                        str.close();
                    } catch (Exception e11) {
                        x0.b(f28873d, "getBitmap failed: " + e11.getMessage());
                    }
                }
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream3 = inputStream;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0138 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0119 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] c(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.mobilead.h.b.c(java.lang.String):byte[]");
    }

    private void a(int i2, Context context, String str, int i3, int i4, long j2) {
        File file = new File(context.getCacheDir().getAbsolutePath() + str);
        if (!file.exists()) {
            file.mkdir();
        }
        if (file.exists()) {
            try {
                if (i2 == 1) {
                    this.f28874a = com.vivo.mobilead.h.a.a(file, i3, i4, j2);
                } else if (i2 == 2) {
                    this.f28875b = com.vivo.mobilead.h.a.a(file, i3, i4, j2);
                } else if (i2 != 3) {
                } else {
                    this.f28876c = com.vivo.mobilead.h.a.a(file, i3, i4, j2);
                }
            } catch (IOException e2) {
                x0.b(f28873d, "init disklrucache failed!" + e2.getMessage());
            } catch (Exception e3) {
                x0.b(f28873d, "init disklrucache failed!" + e3.getMessage());
            }
        }
    }

    public boolean a(String str, InputStream inputStream) {
        return a(this.f28875b, str, inputStream);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(com.vivo.mobilead.h.a r9, java.lang.String r10, java.io.InputStream r11) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.mobilead.h.b.a(com.vivo.mobilead.h.a, java.lang.String, java.io.InputStream):boolean");
    }

    public String b(Context context, String str) {
        if (!g(str)) {
            return "";
        }
        try {
            return context.getCacheDir().getAbsolutePath() + "/open_adsdk_style/" + h(str) + ".0";
        } catch (Exception e2) {
            x0.b(f28873d, "get path error: " + e2.getMessage());
            return "";
        }
    }

    public boolean a(com.vivo.mobilead.h.a aVar, String str) {
        String h2;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (aVar == null) {
            x0.b(f28873d, "disklrucache is null");
            return false;
        }
        try {
            try {
                h2 = h(str);
            } catch (IOException e2) {
                x0.b(f28873d, "isDownload: " + e2.getMessage());
            }
        } catch (Exception e3) {
            x0.b(f28873d, "isDownload: " + e3.getMessage());
        }
        if (TextUtils.isEmpty(h2)) {
            return false;
        }
        a.e b2 = aVar.b(h2);
        if (b2 != null) {
            try {
                b2.close();
            } catch (Exception e4) {
                x0.b(f28873d, "snapshot exception: " + e4.getMessage());
            }
            return true;
        }
        if (b2 != null) {
            try {
                b2.close();
            } catch (Exception e5) {
                x0.b(f28873d, "snapshot exception: " + e5.getMessage());
            }
        }
        return false;
    }

    public ArrayList<String> a(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!f(next)) {
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Bitmap a(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.mobilead.h.b.a(java.lang.String):android.graphics.Bitmap");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v12, types: [com.vivo.mobilead.h.a$e] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [com.vivo.mobilead.h.a$e] */
    /* JADX WARN: Type inference failed for: r8v7, types: [com.vivo.mobilead.h.a$e] */
    public int a(String str, float f2, float f3) {
        if (TextUtils.isEmpty(str) || (f2 == 0.0f && f3 == 0.0f)) {
            return 1;
        }
        if (this.f28874a == null) {
            x0.b(f28873d, "disklrucache is null");
            return 1;
        }
        InputStream inputStream = null;
        try {
            try {
                str = this.f28874a.b(h(str));
                if (str != 0) {
                    try {
                        InputStream a2 = str.a(0);
                        try {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inJustDecodeBounds = true;
                            BitmapFactory.decodeStream(a2, null, options);
                            int min = Math.min(f2 == 0.0f ? 1 : (int) Math.floor(options.outWidth / f2), f3 == 0.0f ? 1 : (int) Math.floor(options.outHeight / f3));
                            if (min > 1) {
                                if (a2 != null) {
                                    try {
                                        a2.close();
                                    } catch (Exception e2) {
                                        x0.b(f28873d, "getBitmap failed: " + e2.getMessage());
                                    }
                                }
                                try {
                                    str.close();
                                } catch (Exception e3) {
                                    x0.b(f28873d, "getBitmap failed: " + e3.getMessage());
                                }
                                return min;
                            }
                            inputStream = a2;
                        } catch (Exception e4) {
                            e = e4;
                            inputStream = a2;
                            x0.b(f28873d, "get bitmap error, " + e.getMessage());
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e5) {
                                    x0.b(f28873d, "getBitmap failed: " + e5.getMessage());
                                }
                            }
                            if (str != 0) {
                                try {
                                    str.close();
                                } catch (Exception e6) {
                                    x0.b(f28873d, "getBitmap failed: " + e6.getMessage());
                                }
                            }
                            return 1;
                        } catch (Throwable th) {
                            th = th;
                            inputStream = a2;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e7) {
                                    x0.b(f28873d, "getBitmap failed: " + e7.getMessage());
                                }
                            }
                            if (str != 0) {
                                try {
                                    str.close();
                                    throw th;
                                } catch (Exception e8) {
                                    x0.b(f28873d, "getBitmap failed: " + e8.getMessage());
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e9) {
                        e = e9;
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e10) {
                        x0.b(f28873d, "getBitmap failed: " + e10.getMessage());
                    }
                }
                if (str != 0) {
                    try {
                        str.close();
                    } catch (Exception e11) {
                        x0.b(f28873d, "getBitmap failed: " + e11.getMessage());
                    }
                }
            } catch (Exception e12) {
                e = e12;
                str = 0;
            } catch (Throwable th2) {
                th = th2;
                str = 0;
            }
            return 1;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v5, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.vivo.mobilead.h.a$e] */
    /* JADX WARN: Type inference failed for: r7v12, types: [com.vivo.mobilead.h.a$e] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7, types: [com.vivo.mobilead.h.a$e] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Bitmap a(java.lang.String r7, int r8) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.mobilead.h.b.a(java.lang.String, int):android.graphics.Bitmap");
    }

    public void a(String str, int i2, com.vivo.mobilead.unified.base.callback.c cVar) {
        if ((TextUtils.isEmpty(str) || this.f28874a == null) && cVar != null) {
            cVar.a(str, null);
        }
        a1.e(new h(str, i2, cVar));
    }

    private String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public String a(Context context, String str) {
        if (!e(str)) {
            return "";
        }
        try {
            return context.getCacheDir().getAbsolutePath() + "/open_adsdk_action/" + h(str) + ".0";
        } catch (Exception e2) {
            x0.b(f28873d, "get path error: " + e2.getMessage());
            return "";
        }
    }
}
