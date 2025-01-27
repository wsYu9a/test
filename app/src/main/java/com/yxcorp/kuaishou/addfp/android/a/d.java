package com.yxcorp.kuaishou.addfp.android.a;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.yxcorp.kuaishou.addfp.android.b.g;
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

/* loaded from: classes5.dex */
public class d {

    /* renamed from: d */
    private static volatile d f34693d;

    /* renamed from: a */
    private e f34694a;

    /* renamed from: b */
    private ConcurrentHashMap f34695b = new ConcurrentHashMap(10);

    /* renamed from: c */
    private Context f34696c;

    private d(Context context) {
        this.f34694a = null;
        try {
            this.f34696c = context;
            this.f34694a = new e(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static d a(Context context) {
        if (f34693d == null) {
            synchronized (d.class) {
                if (f34693d == null) {
                    f34693d = new d(context);
                }
            }
        }
        return f34693d;
    }

    private String a(HashMap hashMap) {
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        } catch (Throwable th) {
            th = th;
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
        } catch (Throwable th2) {
            th = th2;
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
            } catch (Throwable th3) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th3;
            }
        }
    }

    public static void a(Context context, String str) {
        Throwable th;
        FileWriter fileWriter;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                File file = new File(com.yxcorp.kuaishou.addfp.android.b.b.a(context, false), new String(Base64.decode("Lm91a2R0ZnQ=", 0)));
                new File(file.getParent()).mkdirs();
                fileWriter = new FileWriter(file, false);
            } catch (Throwable th2) {
                th = th2;
                fileWriter = null;
            }
            try {
                fileWriter.write(str);
                fileWriter.flush();
                fileWriter.close();
                fileWriter.close();
            } catch (Throwable th3) {
                th = th3;
                try {
                    th.printStackTrace();
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                } catch (Throwable th4) {
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th4;
                }
            }
        } catch (IOException unused2) {
        }
    }

    public synchronized Pair a() {
        byte[] bArr;
        try {
            if (this.f34695b != null) {
                StringBuilder sb = new StringBuilder();
                if (!TextUtils.isEmpty((String) this.f34695b.get("cache_e"))) {
                    return Pair.create(Pair.create(Boolean.TRUE, sb.toString()), this.f34695b);
                }
            }
            this.f34695b.clear();
            String b2 = this.f34694a.b();
            if (!TextUtils.isEmpty(b2)) {
                try {
                    bArr = Base64.decode(b2, 0);
                } catch (Throwable unused) {
                    bArr = null;
                }
                if (bArr == null) {
                    try {
                        bArr = Base64.decode(b2, 8);
                    } catch (Throwable unused2) {
                    }
                }
                try {
                    JSONObject jSONObject = new JSONObject(new String(com.yxcorp.kuaishou.addfp.android.b.b.b(bArr, "20212102sjcudiab".getBytes())));
                    this.f34695b.put("cache_e", jSONObject.optString("cache_e", ""));
                    this.f34695b.put("cache_m", jSONObject.optString("cache_m", ""));
                    this.f34695b.put("c_time", Long.toString(jSONObject.optLong("c_time", 0L)));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            ConcurrentHashMap concurrentHashMap = this.f34695b;
            if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
                StringBuilder sb2 = new StringBuilder();
                if (!TextUtils.isEmpty((String) this.f34695b.get("cache_e"))) {
                    return Pair.create(Pair.create(Boolean.TRUE, sb2.toString()), this.f34695b);
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return Pair.create(Pair.create(Boolean.TRUE, "8"), null);
    }

    public String a(String str) {
        try {
            File file = new File(com.yxcorp.kuaishou.addfp.android.b.b.a(this.f34696c, false), new String(Base64.decode(str, 0)));
            if (!file.exists()) {
                return "";
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return sb.toString().trim();
                }
                sb.append(readLine);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public synchronized void a(String str, String str2) {
        byte[] bArr;
        LinkedHashMap linkedHashMap = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.f34695b.put("c_time", Long.toString(currentTimeMillis));
            this.f34695b.put("cache_e", str);
            this.f34695b.put("cache_m", str2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("c_time", currentTimeMillis);
            jSONObject.put("cache_e", str);
            jSONObject.put("cache_m", str2);
            byte[] c2 = com.yxcorp.kuaishou.addfp.android.b.b.c(jSONObject.toString().getBytes(), "20212102sjcudiab".getBytes());
            try {
                bArr = Base64.encode(c2, 0);
            } catch (Throwable unused) {
                bArr = null;
            }
            if (bArr == null) {
                try {
                    bArr = Base64.encode(c2, 8);
                } catch (Throwable unused2) {
                }
            }
            if (bArr != null) {
                this.f34694a.a(new String(bArr));
            }
        } catch (Throwable unused3) {
        }
        try {
            String a2 = com.yxcorp.kuaishou.addfp.c.a.a.a(this.f34696c, "k_w_o_d_out_dtt");
            if (TextUtils.isEmpty(a2) && g.a(this.f34696c, new String[]{com.kuaishou.weapon.p0.g.f9324i, com.kuaishou.weapon.p0.g.f9325j})) {
                a2 = a("Lm91a2R0ZnQ=");
            }
            if (!TextUtils.isEmpty(a2) && (linkedHashMap = b(a2)) != null) {
                c cVar = b.f34688a;
                String a3 = cVar.a();
                if (!TextUtils.isEmpty(a3)) {
                    if (linkedHashMap.containsKey(a3)) {
                        linkedHashMap.remove(a3);
                    }
                    linkedHashMap.put(cVar.a(), str);
                }
            }
            if (linkedHashMap == null || linkedHashMap.size() == 0) {
                linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(b.f34688a.a(), str);
            }
            String a4 = a(linkedHashMap);
            if (!TextUtils.isEmpty(a4)) {
                try {
                    Settings.System.putString(this.f34696c.getContentResolver(), "k_w_o_d_out_dtt", a4);
                } catch (Throwable unused4) {
                }
                if (g.a(this.f34696c, new String[]{com.kuaishou.weapon.p0.g.f9324i, com.kuaishou.weapon.p0.g.f9325j})) {
                    a(this.f34696c, a4);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public LinkedHashMap b(String str) {
        Throwable th;
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
                } catch (Throwable th2) {
                    th = th2;
                    objectInputStream = objectInputStream2;
                    try {
                        th.printStackTrace();
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return new LinkedHashMap();
                    } catch (Throwable th3) {
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th3;
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
        return new LinkedHashMap();
    }
}
