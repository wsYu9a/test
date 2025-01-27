package com.umeng.ccg;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.ab;
import com.umeng.analytics.pro.ac;
import com.umeng.analytics.pro.ad;
import com.umeng.analytics.pro.ae;
import com.umeng.analytics.pro.af;
import com.umeng.analytics.pro.ag;
import com.umeng.analytics.pro.ah;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.ak;
import com.umeng.analytics.pro.am;
import com.umeng.analytics.pro.ao;
import com.umeng.analytics.pro.aq;
import com.umeng.analytics.pro.as;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.av;
import com.umeng.analytics.pro.aw;
import com.umeng.analytics.pro.ax;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bt;
import com.umeng.ccg.c;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
import p3.i;

/* loaded from: classes4.dex */
public class d implements c.a {

    /* renamed from: a */
    private static final String f24279a = "iucc";

    /* renamed from: b */
    private static final String f24280b = bd.b().b(bd.C);

    /* renamed from: c */
    private static JSONObject f24281c = null;

    /* renamed from: d */
    private static final String[] f24282d = {"screen_on", com.umeng.ccg.a.f24230g, com.umeng.ccg.a.f24231h};

    /* renamed from: e */
    private static final String[] f24283e = {"screen_on", com.umeng.ccg.a.f24230g, com.umeng.ccg.a.f24231h, com.umeng.ccg.a.f24232i};

    /* renamed from: f */
    private static ArrayList<ac> f24284f = null;

    /* renamed from: g */
    private static ArrayList<ac> f24285g = null;

    /* renamed from: h */
    private static ArrayList<ac> f24286h = null;

    /* renamed from: i */
    private static ArrayList<ac> f24287i = null;

    /* renamed from: j */
    private static ab f24288j = null;

    /* renamed from: m */
    private static e f24289m = new e();

    /* renamed from: k */
    private volatile String f24290k = "";

    /* renamed from: l */
    private Map<String, b> f24291l = new HashMap();

    /* renamed from: com.umeng.ccg.d$1 */
    public class AnonymousClass1 implements UMImprintChangeCallback {
        public AnonymousClass1() {
        }

        @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
        public void onImprintValueChanged(String str, String str2) {
            com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 107, d.a(), str2);
        }
    }

    /* renamed from: com.umeng.ccg.d$2 */
    public class AnonymousClass2 implements AccountManagerCallback<Bundle> {

        /* renamed from: a */
        final /* synthetic */ String f24293a;

        /* renamed from: b */
        final /* synthetic */ int f24294b;

        public AnonymousClass2(String str, int i10) {
            str2 = str;
            optInt = i10;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
            int i10 = 1;
            try {
                accountManagerFuture.getResult();
                i10 = 0;
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> umc_cfg p s!");
            } catch (Throwable unused) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> umc_cfg p f!");
            }
            com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 305, d.a(), d.this.new c(str2, optInt, i10));
        }
    }

    public static class a extends BroadcastReceiver {
        public long a(ArrayList<ac> arrayList) {
            if (arrayList != null && arrayList.size() > 0) {
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    ac acVar = arrayList.get(i10);
                    if (acVar instanceof af) {
                        return ((af) acVar).c();
                    }
                }
            }
            return 0L;
        }

        public boolean b(ArrayList<ac> arrayList) {
            if (arrayList == null || arrayList.size() <= 0) {
                return false;
            }
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                if (arrayList.get(i10).b()) {
                    return false;
                }
            }
            return true;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (action.equals("android.intent.action.SCREEN_ON") && d.f24288j != null && (d.f24288j instanceof ae)) {
                    if (b(d.f24287i)) {
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 304, d.a(), null, a(d.f24287i) * 1000);
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "don't send INVOKE_APPACT_WHEN_SCREEN_ON msg.");
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public class b {

        /* renamed from: b */
        private JSONArray f24297b;

        /* renamed from: c */
        private String f24298c;

        public b(JSONArray jSONArray, String str) {
            this.f24297b = jSONArray;
            this.f24298c = str;
        }

        public JSONArray a() {
            return this.f24297b;
        }

        public String b() {
            return this.f24298c;
        }
    }

    public class c {

        /* renamed from: a */
        public String f24299a;

        /* renamed from: b */
        public int f24300b;

        /* renamed from: c */
        public int f24301c;

        public c(String str, int i10, int i11) {
            this.f24299a = str;
            this.f24300b = i10;
            this.f24301c = i11;
        }
    }

    /* renamed from: com.umeng.ccg.d$d */
    public static class C0670d {

        /* renamed from: a */
        private static final d f24303a = new d();

        private C0670d() {
        }
    }

    public static class e extends BroadcastReceiver {
        public long a(ArrayList<ac> arrayList) {
            if (arrayList != null && arrayList.size() > 0) {
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    ac acVar = arrayList.get(i10);
                    if (acVar instanceof af) {
                        return ((af) acVar).c();
                    }
                }
            }
            return 0L;
        }

        public boolean b(ArrayList<ac> arrayList) {
            if (arrayList == null || arrayList.size() <= 0) {
                return false;
            }
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                if (arrayList.get(i10).b()) {
                    return false;
                }
            }
            return true;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (action.equals("android.intent.action.SCREEN_ON")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_SCREEN_ON");
                    if (b(d.f24284f)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "report screen_on event.");
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 301, d.a(), null, a(d.f24284f) * 1000);
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "don't report screen_on event.");
                    }
                }
                if (action.equals("android.intent.action.SCREEN_OFF")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_SCREEN_OFF");
                    if (b(d.f24285g)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "report screen_off event.");
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 302, d.a(), null, a(d.f24285g) * 1000);
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "don't report screen_off event.");
                    }
                }
                if (action.equals("android.intent.action.USER_PRESENT")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_USER_PRESENT");
                    if (!b(d.f24286h)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "don't report screen_unlock event.");
                        return;
                    }
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "report screen_unlock event.");
                    com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 303, d.a(), null, a(d.f24286h) * 1000);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, String str, BroadcastReceiver broadcastReceiver) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(str);
        context.registerReceiver(broadcastReceiver, intentFilter);
    }

    private boolean g() {
        SharedPreferences a10 = au.a(UMGlobalContext.getAppContext());
        if (a10 != null) {
            String string = a10.getString(au.f23465f, "");
            if (TextUtils.isEmpty(string)) {
                h();
                return false;
            }
            try {
                if (!as.a().keySet().equals(as.a(new JSONObject(string)).keySet())) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private void h() {
        try {
            SharedPreferences a10 = au.a(UMGlobalContext.getAppContext());
            if (a10 != null) {
                a10.edit().putString(au.f23465f, new JSONObject(as.a()).toString()).commit();
            }
        } catch (Throwable unused) {
        }
    }

    private boolean i() {
        try {
            SharedPreferences a10 = au.a(UMGlobalContext.getAppContext());
            if (a10 != null) {
                return !TextUtils.isEmpty(a10.getString(au.f23466g, ""));
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private JSONObject j() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ax.b(UMUtils.genUmc(), byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ax.a(byteArray, UMUtils.genSin());
            String str = new String(byteArray);
            byteArrayOutputStream.reset();
            return new JSONObject(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private long b(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("ts")) {
            try {
                return jSONObject.optLong("ts");
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    private void c(Context context) {
        ImprintHandler.getImprintService(context).registImprintCallback(f24279a, new UMImprintChangeCallback() { // from class: com.umeng.ccg.d.1
            public AnonymousClass1() {
            }

            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 107, d.a(), str2);
            }
        });
    }

    private Long d(Context context) {
        long j10 = 0L;
        try {
            SharedPreferences a10 = au.a(context);
            return a10 != null ? Long.valueOf(a10.getLong(au.f23463d, 0L)) : j10;
        } catch (Throwable unused) {
            return j10;
        }
    }

    private String e(Context context) {
        try {
            SharedPreferences a10 = au.a(context);
            return a10 != null ? a10.getString(au.f23464e, "") : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private void c(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has(com.umeng.ccg.a.f24224a)) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(com.umeng.ccg.a.f24224a);
            ab abVar = null;
            ab a10 = optJSONObject.has(com.umeng.ccg.a.f24225b) ? a(com.umeng.ccg.a.f24225b, optJSONObject.optJSONObject(com.umeng.ccg.a.f24225b)) : null;
            ab a11 = optJSONObject.has(com.umeng.ccg.a.f24226c) ? a(com.umeng.ccg.a.f24226c, optJSONObject.optJSONObject(com.umeng.ccg.a.f24226c)) : null;
            ab a12 = optJSONObject.has(com.umeng.ccg.a.f24227d) ? a(com.umeng.ccg.a.f24227d, optJSONObject.optJSONObject(com.umeng.ccg.a.f24227d)) : null;
            ab a13 = optJSONObject.has(com.umeng.ccg.a.f24228e) ? a(com.umeng.ccg.a.f24228e, optJSONObject.optJSONObject(com.umeng.ccg.a.f24228e)) : null;
            ab a14 = optJSONObject.has("screen_on") ? a("screen_on", optJSONObject.optJSONObject("screen_on")) : null;
            ab a15 = optJSONObject.has(com.umeng.ccg.a.f24230g) ? a(com.umeng.ccg.a.f24230g, optJSONObject.optJSONObject(com.umeng.ccg.a.f24230g)) : null;
            ab a16 = optJSONObject.has(com.umeng.ccg.a.f24231h) ? a(com.umeng.ccg.a.f24231h, optJSONObject.optJSONObject(com.umeng.ccg.a.f24231h)) : null;
            if (optJSONObject.has(com.umeng.ccg.a.f24232i)) {
                abVar = a(com.umeng.ccg.a.f24232i, optJSONObject.optJSONObject(com.umeng.ccg.a.f24232i));
                f24288j = abVar;
            }
            ArrayList arrayList = new ArrayList();
            if (a10 != null) {
                arrayList.add(a10);
            }
            if (a11 != null) {
                arrayList.add(a11);
            }
            if (a12 != null) {
                arrayList.add(a12);
            }
            if (a13 != null) {
                arrayList.add(a13);
            }
            if (a14 != null) {
                arrayList.add(a14);
            }
            if (a15 != null) {
                arrayList.add(a15);
            }
            if (a16 != null) {
                arrayList.add(a16);
            }
            if (abVar != null) {
                arrayList.add(abVar);
            }
            com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 202, a(), arrayList);
        } catch (Throwable unused) {
        }
    }

    public static d a() {
        return C0670d.f24303a;
    }

    public synchronized JSONObject b(Context context) {
        File filesDir;
        String str;
        FileInputStream fileInputStream;
        JSONObject jSONObject = null;
        try {
            filesDir = context.getFilesDir();
            str = f24280b;
        } catch (Throwable unused) {
        }
        if (!new File(filesDir, str).exists()) {
            return null;
        }
        try {
            fileInputStream = context.openFileInput(str);
            try {
                JSONObject jSONObject2 = new JSONObject(new String(ax.a(HelperUtils.readStreamToByteArray(fileInputStream), UMConfigure.sAppkey.getBytes())));
                try {
                    as.a(fileInputStream);
                } catch (Throwable unused2) {
                }
                jSONObject = jSONObject2;
            } catch (Throwable unused3) {
                as.a(fileInputStream);
                return jSONObject;
            }
        } catch (Throwable unused4) {
            fileInputStream = null;
        }
        return jSONObject;
    }

    public void a(Context context) {
        com.umeng.ccg.c.a(context, 105, a(), null);
    }

    private boolean a(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("code")) {
            return false;
        }
        try {
            if (200 == jSONObject.optInt("code") && jSONObject.has(com.umeng.ccg.a.f24224a)) {
                return jSONObject.has("ts");
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private synchronized void a(Context context, JSONObject jSONObject, String str) {
        long b10;
        byte[] a10;
        try {
            b10 = b(jSONObject);
            a10 = ax.a(jSONObject.toString().getBytes(), UMConfigure.sAppkey.getBytes());
        } catch (Throwable unused) {
        }
        if (a10 != null && a10.length > 1) {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(context.getFilesDir(), f24280b));
            try {
                fileOutputStream.write(a10);
                fileOutputStream.flush();
                as.a(fileOutputStream);
                a(context, str, b10);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "saveConfigFile success.");
            } catch (Throwable th2) {
                as.a(fileOutputStream);
                throw th2;
            }
        }
    }

    private void b(String str) {
        String str2 = au.f23461b + str;
        SharedPreferences a10 = au.a(UMGlobalContext.getAppContext());
        if (a10 != null) {
            a10.edit().putLong(str2, System.currentTimeMillis()).commit();
        }
    }

    private void a(String str, ac acVar) {
        if ("screen_on".equalsIgnoreCase(str)) {
            if (f24284f == null) {
                f24284f = new ArrayList<>();
            }
            f24284f.add(acVar);
        }
        if (com.umeng.ccg.a.f24230g.equalsIgnoreCase(str)) {
            if (f24285g == null) {
                f24285g = new ArrayList<>();
            }
            f24285g.add(acVar);
        }
        if (com.umeng.ccg.a.f24231h.equalsIgnoreCase(str)) {
            if (f24286h == null) {
                f24286h = new ArrayList<>();
            }
            f24286h.add(acVar);
        }
        if (com.umeng.ccg.a.f24232i.equalsIgnoreCase(str)) {
            if (f24287i == null) {
                f24287i = new ArrayList<>();
            }
            f24287i.add(acVar);
        }
    }

    private ab a(String str, JSONObject jSONObject) {
        JSONArray optJSONArray;
        String str2;
        ab abVar;
        JSONArray optJSONArray2;
        if (jSONObject != null) {
            try {
                if (jSONObject.has(com.umeng.ccg.a.f24235l) && (optJSONArray = jSONObject.optJSONArray(com.umeng.ccg.a.f24235l)) != null && optJSONArray.length() > 0) {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.get(0);
                    boolean has = jSONObject2.has(com.umeng.ccg.a.f24236m);
                    boolean has2 = jSONObject2.has(com.umeng.ccg.a.f24239p);
                    boolean has3 = jSONObject2.has(com.umeng.ccg.a.f24240q);
                    if (!has || !has2 || !has3) {
                        return null;
                    }
                    try {
                        int optInt = jSONObject2.optInt(com.umeng.ccg.a.f24236m);
                        long optLong = jSONObject2.optLong(com.umeng.ccg.a.f24239p);
                        long optLong2 = jSONObject2.optLong(com.umeng.ccg.a.f24240q);
                        String optString = jSONObject2.optString(com.umeng.ccg.a.f24241r);
                        ArrayList arrayList = new ArrayList();
                        if (!jSONObject2.has(com.umeng.ccg.a.f24237n)) {
                            str2 = "sdk";
                        } else {
                            JSONArray optJSONArray3 = jSONObject2.optJSONArray(com.umeng.ccg.a.f24237n);
                            HashSet hashSet = new HashSet();
                            if (optJSONArray3 == null) {
                                str2 = "sdk";
                            } else {
                                str2 = "sdk";
                                int i10 = 0;
                                for (int length = optJSONArray3.length(); i10 < length; length = length) {
                                    hashSet.add(Integer.valueOf(optJSONArray3.getInt(i10)));
                                    i10++;
                                }
                            }
                            if (hashSet.size() > 0) {
                                am amVar = new am(hashSet);
                                if (Arrays.asList(f24282d).contains(str)) {
                                    a(str, amVar);
                                } else {
                                    arrayList.add(amVar);
                                    if (com.umeng.ccg.a.f24232i.equalsIgnoreCase(str)) {
                                        a(str, amVar);
                                    }
                                }
                            }
                        }
                        if (jSONObject2.has(com.umeng.ccg.a.f24238o)) {
                            String optString2 = jSONObject2.optString(com.umeng.ccg.a.f24238o);
                            if (!TextUtils.isEmpty(optString2)) {
                                ak akVar = new ak(optString2);
                                HashSet hashSet2 = new HashSet();
                                for (int i11 = 1; i11 <= 24; i11++) {
                                    if (akVar.a(i11)) {
                                        hashSet2.add(Integer.valueOf(i11));
                                    }
                                }
                                if (hashSet2.size() > 0) {
                                    ag agVar = new ag(hashSet2);
                                    if (Arrays.asList(f24282d).contains(str)) {
                                        a(str, agVar);
                                    } else {
                                        arrayList.add(agVar);
                                    }
                                    if (com.umeng.ccg.a.f24232i.equalsIgnoreCase(str)) {
                                        a(str, agVar);
                                    }
                                }
                            }
                        }
                        arrayList.add(new ai(optInt));
                        ah ahVar = new ah(str, optLong);
                        String[] strArr = f24282d;
                        if (Arrays.asList(strArr).contains(str)) {
                            a(str, ahVar);
                        } else {
                            arrayList.add(ahVar);
                        }
                        if (com.umeng.ccg.a.f24232i.equalsIgnoreCase(str)) {
                            a(str, ahVar);
                        }
                        af afVar = new af(optLong2);
                        if (Arrays.asList(strArr).contains(str)) {
                            a(str, afVar);
                            arrayList.add(afVar);
                        } else {
                            arrayList.add(afVar);
                        }
                        if (com.umeng.ccg.a.f24232i.equalsIgnoreCase(str)) {
                            a(str, afVar);
                        }
                        if (com.umeng.ccg.a.f24228e.equals(str)) {
                            abVar = new ad(str, arrayList);
                        } else if (com.umeng.ccg.a.f24232i.equals(str)) {
                            abVar = new ae(str, arrayList);
                        } else {
                            abVar = new ab(str, arrayList);
                        }
                        ab abVar2 = abVar;
                        try {
                            abVar2.b(str, jSONObject2);
                            abVar2.a(optString);
                            String str3 = "";
                            String str4 = str2;
                            if (jSONObject.has(str4) && (optJSONArray2 = jSONObject.optJSONArray(str4)) != null) {
                                Map<String, b> map = this.f24291l;
                                if (map != null && !map.containsKey(str)) {
                                    this.f24291l.put(str, new b(new JSONArray(optJSONArray2.toString()), optString));
                                }
                                int length2 = optJSONArray2.length();
                                for (int i12 = 0; i12 < optJSONArray2.length(); i12++) {
                                    str3 = str3 + optJSONArray2.getString(i12);
                                    if (i12 < length2 - 1) {
                                        str3 = str3 + ",";
                                    }
                                }
                            }
                            abVar2.b(str3);
                            return abVar2;
                        } catch (Throwable unused) {
                            return abVar2;
                        }
                    } catch (Throwable unused2) {
                        return null;
                    }
                }
            } catch (Throwable unused3) {
            }
        }
        return null;
    }

    private void a(Context context, String str, long j10) {
        SharedPreferences a10;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] split = str.split("@");
            if (split.length != 4 || (a10 = au.a(context)) == null) {
                return;
            }
            long parseLong = Long.parseLong(split[0]);
            String str2 = split[1];
            SharedPreferences.Editor edit = a10.edit();
            edit.putLong(au.f23462c, j10);
            edit.putLong(au.f23463d, parseLong);
            edit.putString(au.f23464e, str2).commit();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "updateTsS1S2 : ts = " + j10 + "; s1 = " + parseLong + "; s2 = " + str2);
        } catch (Throwable unused) {
        }
    }

    private void a(String str) {
        try {
            String[] split = str.split("@");
            if (split.length != 4) {
                return;
            }
            long parseLong = Long.parseLong(split[0]);
            String str2 = split[1];
            if (!TextUtils.isEmpty(this.f24290k)) {
                String[] split2 = this.f24290k.split("@");
                if (split2.length == 2) {
                    long parseLong2 = Long.parseLong(split2[0]);
                    String str3 = split2[1];
                    if (parseLong2 == parseLong && str3.equalsIgnoreCase(str2)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "重复的iucc S1 and S2, 忽略本次更新，不发起fetch。");
                        return;
                    }
                }
            }
            SharedPreferences a10 = au.a(UMGlobalContext.getAppContext());
            if (a10 != null) {
                if (a10.getLong(au.f23462c, 0L) != parseLong) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "local config ts != iuccS1, send FETCH_NEW_CONFIG msg.");
                    this.f24290k = String.valueOf(parseLong) + "@" + str2;
                    com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 101, a(), str);
                    return;
                }
                d(UMGlobalContext.getAppContext());
                if (e(UMGlobalContext.getAppContext()).equalsIgnoreCase(str2)) {
                    return;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "local S2 != iuccS2, send FETCH_NEW_CONFIG msg.");
                this.f24290k = String.valueOf(parseLong) + "@" + str2;
                com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 101, a(), str);
            }
        } catch (Throwable unused) {
        }
    }

    private void a(boolean z10) {
        try {
            SharedPreferences a10 = au.a(UMGlobalContext.getAppContext());
            if (a10 != null) {
                SharedPreferences.Editor edit = a10.edit();
                if (z10) {
                    edit.putString(au.f23466g, "1").commit();
                } else {
                    edit.putString(au.f23466g, "").commit();
                }
            }
        } catch (Throwable unused) {
        }
    }

    private JSONObject a(String str, int i10, int i11) {
        b bVar;
        JSONObject jSONObject = new JSONObject();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            jSONObject.put("id", "$$_umc_ev1");
            jSONObject.put("ts", currentTimeMillis);
            jSONObject.put("tt", str);
            jSONObject.put(com.umeng.ccg.a.B, i10);
            jSONObject.put(i.f29758c, i11);
            if (!this.f24291l.containsKey(com.umeng.ccg.a.f24232i) || (bVar = this.f24291l.get(com.umeng.ccg.a.f24232i)) == null) {
                return null;
            }
            JSONObject a10 = ao.a(UMGlobalContext.getAppContext(), bVar.a(), bVar.b());
            JSONObject a11 = ao.a(UMGlobalContext.getAppContext(), jSONObject);
            if (a10 == null || a11 == null) {
                return null;
            }
            return ao.a(a10, a11);
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONObject a(String str, String str2, String str3, long j10, boolean z10) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", "$$_umc_ev2");
            jSONObject.put("ts", j10);
            jSONObject.put("tt", str);
            jSONObject.put("flag", str2);
            jSONObject.put("ss", str3);
            if (z10) {
                jSONObject.put("cd", 1);
            } else {
                jSONObject.put("cd", 0);
            }
            JSONObject a10 = ao.a(UMGlobalContext.getAppContext(), new JSONArray(), "");
            JSONObject a11 = ao.a(UMGlobalContext.getAppContext(), jSONObject);
            if (a10 == null || a11 == null) {
                return null;
            }
            return ao.a(a10, a11);
        } catch (Throwable unused) {
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    private void a(Context context, String str, JSONObject jSONObject) {
        JSONObject a10;
        Object a11;
        try {
            b(com.umeng.ccg.a.f24232i);
            String str2 = "";
            if (jSONObject.has("target")) {
                str2 = jSONObject.optString("target");
            }
            if (TextUtils.isEmpty(str2)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> target is empty, ignore umc_cfg process");
                return;
            }
            int optInt = jSONObject.has(com.umeng.ccg.a.B) ? jSONObject.optInt(com.umeng.ccg.a.B) : 0;
            if (optInt == 0) {
                JSONObject j10 = j();
                if (j10 == null || (a11 = aw.a(j10.optString("c"), j10.optString("s"), new Class[]{String.class}, context, new Object[]{j10.optString("a")})) == null || Build.VERSION.SDK_INT < 23) {
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("ss", Base64.encodeToString(ax.a(DeviceConfig.getPackageName(context).getBytes(), UMUtils.genSin()), 0).trim());
                aw.a(j10.optString("m"), j10.optString("x"), new Class[]{String.class, String.class, String[].class, Bundle.class, Activity.class, aw.a(j10.optString(bt.aJ)), Handler.class}, a11, new Object[]{str2, com.umeng.ccg.a.f24234k, null, bundle, null, new AccountManagerCallback<Bundle>() { // from class: com.umeng.ccg.d.2

                    /* renamed from: a */
                    final /* synthetic */ String f24293a;

                    /* renamed from: b */
                    final /* synthetic */ int f24294b;

                    public AnonymousClass2(String str22, int optInt2) {
                        str2 = str22;
                        optInt = optInt2;
                    }

                    @Override // android.accounts.AccountManagerCallback
                    public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
                        int i10 = 1;
                        try {
                            accountManagerFuture.getResult();
                            i10 = 0;
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> umc_cfg p s!");
                        } catch (Throwable unused) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> umc_cfg p f!");
                        }
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 305, d.a(), d.this.new c(str2, optInt, i10));
                    }
                }, null});
                return;
            }
            if (Build.VERSION.SDK_INT < 23 || (a10 = a(str22, optInt2, 0)) == null) {
                return;
            }
            av.a(new aq(aq.f23440b, a10), 0L, TimeUnit.SECONDS);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:193:0x047f, code lost:
    
        if (r6 != null) goto L672;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0481, code lost:
    
        r3.put("config", r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x0499, code lost:
    
        if (0 == 0) goto L673;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11, types: [int] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v14, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r3v15, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r3v17, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r3v42 */
    /* JADX WARN: Type inference failed for: r3v43 */
    /* JADX WARN: Type inference failed for: r3v44 */
    @Override // com.umeng.ccg.c.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.Object r21, int r22) {
        /*
            Method dump skipped, instructions count: 1470
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.ccg.d.a(java.lang.Object, int):void");
    }
}
