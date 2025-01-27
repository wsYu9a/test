package com.yxcorp.kuaishou.addfp.android.a;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.kuaishou.weapon.p0.g;
import com.yxcorp.kuaishou.addfp.android.b.f;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: e */
    private static volatile d f25173e;

    /* renamed from: a */
    private e f25174a;

    /* renamed from: b */
    private ConcurrentHashMap f25175b = new ConcurrentHashMap(10);

    /* renamed from: c */
    private Context f25176c;

    /* renamed from: d */
    private int f25177d;

    private d(Context context) {
        this.f25174a = null;
        this.f25177d = 0;
        try {
            this.f25176c = context;
            this.f25174a = new e(context);
            if (Build.VERSION.SDK_INT >= 30) {
                this.f25177d = this.f25176c.getApplicationInfo().targetSdkVersion;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public synchronized Pair a() {
        byte[] bArr;
        try {
            if (this.f25175b != null) {
                StringBuilder sb2 = new StringBuilder();
                if (!TextUtils.isEmpty((String) this.f25175b.get("cache_e"))) {
                    return Pair.create(Pair.create(Boolean.TRUE, sb2.toString()), this.f25175b);
                }
            }
            this.f25175b.clear();
            String b10 = this.f25174a.b();
            if (!TextUtils.isEmpty(b10)) {
                try {
                    bArr = Base64.decode(b10, 0);
                } catch (Throwable unused) {
                    bArr = null;
                }
                if (bArr == null) {
                    try {
                        bArr = Base64.decode(b10, 8);
                    } catch (Throwable unused2) {
                    }
                }
                try {
                    JSONObject jSONObject = new JSONObject(new String(com.yxcorp.kuaishou.addfp.android.b.b.b(bArr, "20212102sjcudiab".getBytes())));
                    this.f25175b.put("cache_e", jSONObject.optString("cache_e", ""));
                    this.f25175b.put("cache_m", jSONObject.optString("cache_m", ""));
                    this.f25175b.put("c_time", Long.toString(jSONObject.optLong("c_time", 0L)));
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            ConcurrentHashMap concurrentHashMap = this.f25175b;
            if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
                StringBuilder sb3 = new StringBuilder();
                if (!TextUtils.isEmpty((String) this.f25175b.get("cache_e"))) {
                    return Pair.create(Pair.create(Boolean.TRUE, sb3.toString()), this.f25175b);
                }
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
        return Pair.create(Pair.create(Boolean.TRUE, "8"), null);
    }

    public LinkedHashMap b(String str) {
        Throwable th2;
        ObjectInputStream objectInputStream = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                ObjectInputStream objectInputStream2 = new ObjectInputStream(new ByteArrayInputStream(com.yxcorp.kuaishou.addfp.android.b.b.b(Base64.decode(str.getBytes(), 0), "20212102sjcudiab".getBytes())));
                try {
                    LinkedHashMap linkedHashMap = (LinkedHashMap) objectInputStream2.readObject();
                    try {
                        objectInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return linkedHashMap;
                } catch (Throwable th3) {
                    th2 = th3;
                    objectInputStream = objectInputStream2;
                    try {
                        th2.printStackTrace();
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return new LinkedHashMap();
                    } catch (Throwable th4) {
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th4;
                    }
                }
            }
        } catch (Throwable th5) {
            th2 = th5;
        }
        return new LinkedHashMap();
    }

    public static d a(Context context) {
        if (f25173e == null) {
            synchronized (d.class) {
                try {
                    if (f25173e == null) {
                        f25173e = new d(context);
                    }
                } finally {
                }
            }
        }
        return f25173e;
    }

    public boolean b() {
        return this.f25177d >= 30;
    }

    public String a(String str) {
        try {
            File file = new File(com.yxcorp.kuaishou.addfp.android.b.b.a(this.f25176c, false), new String(Base64.decode(str, 0)));
            if (!file.exists()) {
                return "";
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return sb2.toString().trim();
                }
                sb2.append(readLine);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }

    private String a(HashMap hashMap) {
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream = null;
        }
        try {
            objectOutputStream.writeObject(hashMap);
            String str = new String(Base64.encode(com.yxcorp.kuaishou.addfp.android.b.b.c(byteArrayOutputStream.toByteArray(), "20212102sjcudiab".getBytes()), 0));
            try {
                objectOutputStream.close();
            } catch (IOException unused) {
            }
            return str;
        } catch (Throwable th3) {
            th = th3;
            try {
                th.printStackTrace();
                if (objectOutputStream == null) {
                    return "";
                }
                try {
                    objectOutputStream.close();
                    return "";
                } catch (IOException unused2) {
                    return "";
                }
            } catch (Throwable th4) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th4;
            }
        }
    }

    public static void a(Context context, String str) {
        FileWriter fileWriter;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                File file = new File(com.yxcorp.kuaishou.addfp.android.b.b.a(context, false), new String(Base64.decode("Lm91a2R0ZnQ=", 0)));
                new File(file.getParent()).mkdirs();
                fileWriter = new FileWriter(file, false);
            } catch (Throwable unused) {
                fileWriter = null;
            }
            try {
                fileWriter.write(str);
                fileWriter.flush();
                fileWriter.close();
            } catch (Throwable unused2) {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            }
        } catch (IOException unused3) {
        }
    }

    public synchronized void a(String str, String str2) {
        byte[] bArr;
        HashMap hashMap = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.f25175b.put("c_time", Long.toString(currentTimeMillis));
            this.f25175b.put("cache_e", str);
            this.f25175b.put("cache_m", str2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("c_time", currentTimeMillis);
            jSONObject.put("cache_e", str);
            jSONObject.put("cache_m", str2);
            byte[] c10 = com.yxcorp.kuaishou.addfp.android.b.b.c(jSONObject.toString().getBytes(), "20212102sjcudiab".getBytes());
            try {
                bArr = Base64.encode(c10, 0);
            } catch (Throwable unused) {
                bArr = null;
            }
            if (bArr == null) {
                try {
                    bArr = Base64.encode(c10, 8);
                } catch (Throwable unused2) {
                }
            }
            if (bArr != null) {
                this.f25174a.a(new String(bArr));
            }
        } catch (Throwable unused3) {
        }
        try {
            String a10 = com.yxcorp.kuaishou.addfp.c.a.a.a(this.f25176c, "k_w_o_d_out_dtt");
            if (TextUtils.isEmpty(a10) && f.a(this.f25176c, new String[]{g.f11108i, "android.permission.WRITE_EXTERNAL_STORAGE"})) {
                a10 = a("Lm91a2R0ZnQ=");
            }
            if (!TextUtils.isEmpty(a10) && (hashMap = b(a10)) != null) {
                c cVar = b.f25167a;
                String a11 = cVar.a();
                if (!TextUtils.isEmpty(a11)) {
                    if (hashMap.containsKey(a11)) {
                        hashMap.remove(a11);
                    }
                    hashMap.put(cVar.a(), str);
                }
            }
            if (hashMap == null || hashMap.size() == 0) {
                hashMap = new LinkedHashMap();
                hashMap.put(b.f25167a.a(), str);
            }
            String a12 = a(hashMap);
            if (!TextUtils.isEmpty(a12)) {
                try {
                    Settings.System.putString(this.f25176c.getContentResolver(), "k_w_o_d_out_dtt", a12);
                } catch (Throwable unused4) {
                }
                if (f.a(this.f25176c, new String[]{g.f11108i, "android.permission.WRITE_EXTERNAL_STORAGE"})) {
                    a(this.f25176c, a12);
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
