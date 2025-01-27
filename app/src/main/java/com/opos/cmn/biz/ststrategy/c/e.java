package com.opos.cmn.biz.ststrategy.c;

import android.content.Context;
import com.martian.mibook.application.MiConfigSingleton;
import com.opos.cmn.biz.ststrategy.entity.STConfigEntity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    private static final String f16834a = "e";

    /* renamed from: b */
    private static final ReentrantReadWriteLock f16835b = new ReentrantReadWriteLock();

    /* renamed from: c */
    private static final ReentrantReadWriteLock f16836c = new ReentrantReadWriteLock();

    /* renamed from: d */
    private static STConfigEntity f16837d = null;

    public static int a(Context context, JSONObject jSONObject) {
        int i2;
        if (context != null && jSONObject != null) {
            try {
            } catch (JSONException e2) {
                com.opos.cmn.an.f.a.c(f16834a, "", e2);
            }
            if (jSONObject.has(MiConfigSingleton.t0) && !jSONObject.isNull(MiConfigSingleton.t0)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(MiConfigSingleton.t0);
                if (jSONObject2.has("currTime") && !jSONObject2.isNull("currTime")) {
                    i2 = jSONObject2.getInt("currTime");
                    com.opos.cmn.an.f.a.b(f16834a, "currTime=" + i2);
                    return i2;
                }
            }
        }
        i2 = 0;
        com.opos.cmn.an.f.a.b(f16834a, "currTime=" + i2);
        return i2;
    }

    public static STConfigEntity a() {
        try {
            ReentrantReadWriteLock reentrantReadWriteLock = f16835b;
            reentrantReadWriteLock.readLock().lock();
            STConfigEntity sTConfigEntity = f16837d;
            reentrantReadWriteLock.readLock().unlock();
            return sTConfigEntity;
        } catch (Throwable th) {
            f16835b.readLock().unlock();
            throw th;
        }
    }

    public static STConfigEntity a(Context context) {
        STConfigEntity a2;
        synchronized (e.class) {
            if (context != null) {
                if (a() == null) {
                    String str = f16834a;
                    com.opos.cmn.an.f.a.b(str, "sSTConfigEntity=null!set it.");
                    STConfigEntity a3 = g.a(context);
                    if (a() != null || a3 == null) {
                        com.opos.cmn.an.f.a.c(str, "getSTConfigEntity != null || tempSTConfigEntity == null");
                    } else {
                        a(a3);
                    }
                }
                a2 = a();
            } else {
                a2 = null;
            }
        }
        return a2;
    }

    public static JSONObject a(Context context, com.opos.cmn.func.b.b.e eVar) {
        InputStream inputStream;
        byte[] a2;
        JSONObject jSONObject = null;
        if (context != null && eVar != null && (inputStream = eVar.f17170c) != null && (a2 = a(inputStream)) != null && a2.length > 0) {
            try {
                JSONObject jSONObject2 = new JSONObject(new String(a2, 0, a2.length, "UTF-8"));
                if (jSONObject2.has("code") && !jSONObject2.isNull("code")) {
                    int i2 = jSONObject2.getInt("code");
                    if (i2 == 0) {
                        try {
                            if (jSONObject2.has(MiConfigSingleton.t0) && !jSONObject2.isNull(MiConfigSingleton.t0)) {
                                JSONObject jSONObject3 = jSONObject2.getJSONObject(MiConfigSingleton.t0);
                                if (jSONObject3.has("strategy") && !jSONObject3.isNull("strategy")) {
                                    JSONObject jSONObject4 = jSONObject3.getJSONObject("strategy");
                                    if (jSONObject4.has("nxLimit") && !jSONObject4.isNull("nxLimit")) {
                                        long j2 = jSONObject4.getLong("nxLimit");
                                        com.opos.cmn.an.f.a.b(f16834a, "set ntLimit=" + j2);
                                        d.a(context, j2);
                                    }
                                    if (jSONObject4.has("dtLimit") && !jSONObject4.isNull("dtLimit")) {
                                        int i3 = jSONObject4.getInt("dtLimit");
                                        com.opos.cmn.an.f.a.b(f16834a, "set dtLimit=" + i3);
                                        d.a(context, i3);
                                    }
                                    if (jSONObject4.has("blackListLimit") && !jSONObject4.isNull("blackListLimit")) {
                                        int i4 = jSONObject4.getInt("blackListLimit");
                                        com.opos.cmn.an.f.a.b(f16834a, "set blaLimit=" + i4);
                                        d.b(context, i4);
                                    }
                                }
                            }
                            d.a(context, com.opos.cmn.biz.a.d.a(context));
                        } catch (Exception e2) {
                            e = e2;
                            jSONObject = jSONObject2;
                            com.opos.cmn.an.f.a.c(f16834a, "", e);
                            com.opos.cmn.an.f.a.b(f16834a, "netResponseToJsonObject result:" + jSONObject);
                            return jSONObject;
                        }
                    } else if (-3 != i2) {
                        String string = jSONObject2.getString("msg");
                        String str = f16834a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("netResponseToJsonObject code=");
                        sb.append(i2);
                        sb.append(",msg=");
                        if (string == null) {
                            string = "";
                        }
                        sb.append(string);
                        sb.append(",json=");
                        sb.append(jSONObject2.toString());
                        com.opos.cmn.an.f.a.b(str, sb.toString());
                    }
                    jSONObject = jSONObject2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
        com.opos.cmn.an.f.a.b(f16834a, "netResponseToJsonObject result:" + jSONObject);
        return jSONObject;
    }

    private static void a(STConfigEntity sTConfigEntity) {
        try {
            ReentrantReadWriteLock reentrantReadWriteLock = f16835b;
            reentrantReadWriteLock.writeLock().lock();
            f16837d = sTConfigEntity;
            reentrantReadWriteLock.writeLock().unlock();
        } catch (Throwable th) {
            f16835b.writeLock().unlock();
            throw th;
        }
    }

    private static boolean a(Context context, byte[] bArr) {
        boolean z = false;
        if (context != null && bArr != null && bArr.length > 0) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    f16836c.writeLock().lock();
                    fileOutputStream = context.openFileOutput(d(context), 0);
                    if (fileOutputStream != null) {
                        fileOutputStream.write(bArr, 0, bArr.length);
                        fileOutputStream.flush();
                        com.opos.cmn.an.f.a.b(f16834a, "fileOutputStream flush!!!");
                        z = true;
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e2) {
                            e = e2;
                            com.opos.cmn.an.f.a.c(f16834a, "", e);
                            f16836c.writeLock().unlock();
                            return z;
                        }
                    }
                } catch (FileNotFoundException e3) {
                    com.opos.cmn.an.f.a.c(f16834a, "", e3);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e = e4;
                            com.opos.cmn.an.f.a.c(f16834a, "", e);
                            f16836c.writeLock().unlock();
                            return z;
                        }
                    }
                } catch (IOException e5) {
                    com.opos.cmn.an.f.a.c(f16834a, "", e5);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e6) {
                            e = e6;
                            com.opos.cmn.an.f.a.c(f16834a, "", e);
                            f16836c.writeLock().unlock();
                            return z;
                        }
                    }
                }
                f16836c.writeLock().unlock();
            } catch (Throwable th) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e7) {
                        com.opos.cmn.an.f.a.c(f16834a, "", e7);
                    }
                }
                f16836c.writeLock().unlock();
                throw th;
            }
        }
        return z;
    }

    private static byte[] a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (-1 == read) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c(f16834a, "", e2);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject b(android.content.Context r8) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.biz.ststrategy.c.e.b(android.content.Context):org.json.JSONObject");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
    
        if (com.opos.cmn.biz.ststrategy.c.c.a(r5, r3, r4) == false) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(android.content.Context r7, org.json.JSONObject r8) {
        /*
            java.lang.Class<com.opos.cmn.biz.ststrategy.c.e> r0 = com.opos.cmn.biz.ststrategy.c.e.class
            monitor-enter(r0)
            java.lang.String r1 = com.opos.cmn.biz.ststrategy.c.e.f16834a     // Catch: java.lang.Throwable -> L7a
            java.lang.String r2 = "saveOrMergeSTConfig begin"
            com.opos.cmn.an.f.a.b(r1, r2)     // Catch: java.lang.Throwable -> L7a
            r2 = 0
            if (r7 == 0) goto L64
            if (r8 == 0) goto L64
            boolean r3 = c(r7)     // Catch: java.lang.Throwable -> L7a
            if (r3 != 0) goto L23
            com.opos.cmn.biz.ststrategy.entity.STConfigEntity r3 = com.opos.cmn.biz.ststrategy.c.g.a(r8)     // Catch: java.lang.Throwable -> L7a
            if (r3 == 0) goto L64
            a(r3)     // Catch: java.lang.Throwable -> L7a
        L1e:
            boolean r2 = c(r7, r8)     // Catch: java.lang.Throwable -> L7a
            goto L64
        L23:
            java.lang.String r3 = "onlineJsonArray getMetaListArray"
            com.opos.cmn.an.f.a.b(r1, r3)     // Catch: java.lang.Throwable -> L7a
            org.json.JSONArray r3 = com.opos.cmn.biz.ststrategy.c.c.a(r7, r8)     // Catch: java.lang.Throwable -> L7a
            if (r3 == 0) goto L57
            int r4 = r3.length()     // Catch: java.lang.Throwable -> L7a
            if (r4 <= 0) goto L57
            java.util.HashSet r4 = com.opos.cmn.biz.ststrategy.c.c.b(r7, r8)     // Catch: java.lang.Throwable -> L7a
            org.json.JSONObject r5 = b(r7)     // Catch: java.lang.Throwable -> L7a
            if (r5 == 0) goto L55
            java.lang.String r6 = "localJsonArray getMetaListArray"
            com.opos.cmn.an.f.a.b(r1, r6)     // Catch: java.lang.Throwable -> L7a
            org.json.JSONArray r5 = com.opos.cmn.biz.ststrategy.c.c.a(r7, r5)     // Catch: java.lang.Throwable -> L7a
            if (r5 == 0) goto L55
            int r6 = r5.length()     // Catch: java.lang.Throwable -> L7a
            if (r6 <= 0) goto L55
            boolean r3 = com.opos.cmn.biz.ststrategy.c.c.a(r5, r3, r4)     // Catch: java.lang.Throwable -> L7a
            if (r3 == 0) goto L57
        L55:
            r3 = 1
            goto L58
        L57:
            r3 = 0
        L58:
            if (r3 == 0) goto L64
            com.opos.cmn.biz.ststrategy.entity.STConfigEntity r3 = com.opos.cmn.biz.ststrategy.c.g.a(r8)     // Catch: java.lang.Throwable -> L7a
            if (r3 == 0) goto L64
            a(r3)     // Catch: java.lang.Throwable -> L7a
            goto L1e
        L64:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7a
            r7.<init>()     // Catch: java.lang.Throwable -> L7a
            java.lang.String r8 = "saveOrMergeSTConfig end result:"
            r7.append(r8)     // Catch: java.lang.Throwable -> L7a
            r7.append(r2)     // Catch: java.lang.Throwable -> L7a
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L7a
            com.opos.cmn.an.f.a.b(r1, r7)     // Catch: java.lang.Throwable -> L7a
            monitor-exit(r0)
            return r2
        L7a:
            r7 = move-exception
            monitor-exit(r0)
            goto L7e
        L7d:
            throw r7
        L7e:
            goto L7d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.biz.ststrategy.c.e.b(android.content.Context, org.json.JSONObject):boolean");
    }

    public static boolean c(Context context) {
        if (context != null) {
            try {
                return new File(context.getFilesDir(), d(context)).exists();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c(f16834a, "", e2);
            }
        }
        return false;
    }

    private static boolean c(Context context, JSONObject jSONObject) {
        byte[] d2;
        boolean a2 = (context == null || jSONObject == null || (d2 = d(context, jSONObject)) == null || d2.length <= 0) ? false : a(context, d2);
        com.opos.cmn.an.f.a.b(f16834a, "savejsonObjectSTConfig to file result: " + a2);
        return a2;
    }

    public static String d(Context context) {
        String str = (context == null || !f.b(context)) ? "acs_st_config_merge.ini" : "acs_st_config_overseas_merge.ini";
        com.opos.cmn.an.f.a.b(f16834a, "getSTConfigFileName=" + str);
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0030  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0017 -> B:20:0x001e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] d(android.content.Context r2, org.json.JSONObject r3) {
        /*
            if (r2 == 0) goto L1e
            if (r3 == 0) goto L1e
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Exception -> L16
            if (r2 == 0) goto L1e
            java.lang.String r3 = "UTF-8"
            byte[] r2 = r2.getBytes(r3)     // Catch: java.lang.Exception -> L11
            goto L1f
        L11:
            byte[] r2 = r2.getBytes()     // Catch: java.lang.Exception -> L16
            goto L1f
        L16:
            r2 = move-exception
            java.lang.String r3 = com.opos.cmn.biz.ststrategy.c.e.f16834a
            java.lang.String r0 = ""
            com.opos.cmn.an.f.a.c(r3, r0, r2)
        L1e:
            r2 = 0
        L1f:
            java.lang.String r3 = com.opos.cmn.biz.ststrategy.c.e.f16834a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "getJsonObjectBytes bytes is null ?"
            r0.append(r1)
            if (r2 != 0) goto L30
            java.lang.String r1 = "true"
            goto L32
        L30:
            java.lang.String r1 = "false"
        L32:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.opos.cmn.an.f.a.b(r3, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.biz.ststrategy.c.e.d(android.content.Context, org.json.JSONObject):byte[]");
    }
}
