package new0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.g;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
import pi.j;
import rh.d;

/* renamed from: new0.if */
/* loaded from: classes4.dex */
public final class Cif {

    /* renamed from: e */
    public static Cif f28856e;

    /* renamed from: f */
    public static WeakReference<ArrayList<NetworkInterface>> f28857f;

    /* renamed from: g */
    public static WeakReference<JSONArray> f28858g;

    /* renamed from: a */
    public Context f28859a;

    /* renamed from: b */
    public AtomicBoolean f28860b = new AtomicBoolean(false);

    /* renamed from: c */
    public j f28861c = new j();

    /* renamed from: d */
    public pi.a f28862d = new pi.a();

    /* renamed from: new0.if$a */
    public static class a {

        /* renamed from: a */
        public static String f28863a;

        public static String a(String str) {
            try {
                for (NetworkInterface networkInterface : Cif.d()) {
                    if (TextUtils.equals(str, networkInterface.getName())) {
                        byte[] hardwareAddress = networkInterface.getHardwareAddress();
                        StringBuilder sb2 = new StringBuilder();
                        for (byte b10 : hardwareAddress) {
                            sb2.append(String.format("%02X:", Byte.valueOf(b10)));
                        }
                        if (sb2.length() > 0) {
                            sb2.deleteCharAt(sb2.length() - 1);
                        }
                        return sb2.toString();
                    }
                }
                return null;
            } catch (Throwable unused) {
                return "";
            }
        }
    }

    public Cif(Context context) {
        this.f28859a = context.getApplicationContext();
    }

    public static List<NetworkInterface> d() {
        WeakReference<ArrayList<NetworkInterface>> weakReference;
        WeakReference<ArrayList<NetworkInterface>> weakReference2 = f28857f;
        if (weakReference2 == null || weakReference2.get() == null) {
            weakReference = new WeakReference<>(Collections.list(NetworkInterface.getNetworkInterfaces()));
            f28857f = weakReference;
        } else {
            weakReference = f28857f;
        }
        return weakReference.get();
    }

    public final String a(Context context) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.google.android.gsf.gservices"), null, null, new String[]{"android_id"}, null);
        if (query != null && (!query.moveToFirst() || query.getColumnCount() < 2)) {
            if (!query.isClosed()) {
                query.close();
            }
            return null;
        }
        if (query != null) {
            try {
                String hexString = Long.toHexString(Long.parseLong(query.getString(1)));
                if (!query.isClosed()) {
                    query.close();
                }
                return hexString;
            } catch (NumberFormatException unused) {
                if (!query.isClosed()) {
                    query.close();
                }
            }
        }
        return null;
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("SystemInfo", g(this.f28859a));
        } catch (Throwable th2) {
            if (d.d()) {
                th2.printStackTrace();
            }
        }
        try {
            jSONObject.put("TelephonyManager", e(this.f28859a));
        } catch (Throwable th3) {
            if (d.d()) {
                th3.printStackTrace();
            }
        }
        try {
            jSONObject.put("AllMacAddr", f());
        } catch (Throwable th4) {
            if (d.d()) {
                th4.printStackTrace();
            }
        }
        try {
            jSONObject.put("MsaInfo", this.f28861c.b());
        } catch (Throwable th5) {
            if (d.d()) {
                th5.printStackTrace();
            }
        }
        try {
            jSONObject.put("MsaInfoNew", this.f28862d.a());
        } catch (Throwable th6) {
            if (d.d()) {
                th6.printStackTrace();
            }
        }
        try {
            Context context = this.f28859a;
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("gaid", new0.a.a(context).f28853a);
            } catch (Throwable th7) {
                if (d.d()) {
                    th7.printStackTrace();
                }
            }
            try {
                jSONObject2.put("gsfid", a(context));
            } catch (Throwable th8) {
                if (d.d()) {
                    th8.printStackTrace();
                }
            }
            jSONObject.put("IDs", jSONObject2);
        } catch (Throwable th9) {
            if (d.d()) {
                th9.printStackTrace();
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d6 A[EDGE_INSN: B:27:0x00d6->B:20:0x00d6 BREAK  A[LOOP:0: B:8:0x0078->B:26:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(android.telephony.TelephonyManager r7, org.json.JSONObject r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.f28859a
            boolean r0 = sk.e.a(r0)
            if (r0 == 0) goto Le1
            android.telephony.CellLocation r0 = r7.getCellLocation()
            boolean r0 = r0 instanceof android.telephony.cdma.CdmaCellLocation
            if (r0 == 0) goto L44
            android.telephony.CellLocation r0 = r7.getCellLocation()
            android.telephony.cdma.CdmaCellLocation r0 = (android.telephony.cdma.CdmaCellLocation) r0
            int r1 = r0.getBaseStationId()
            java.lang.String r2 = "CellLocBaseStationId"
            r8.put(r2, r1)
            int r1 = r0.getBaseStationLatitude()
            java.lang.String r2 = "CellLocBaseStationLatitude"
            r8.put(r2, r1)
            int r1 = r0.getBaseStationLongitude()
            java.lang.String r2 = "CellLocBaseStationLongitude"
            r8.put(r2, r1)
            int r1 = r0.getNetworkId()
            java.lang.String r2 = "CellLocNetworkId"
            r8.put(r2, r1)
            int r0 = r0.getSystemId()
            java.lang.String r1 = "CellLocSystemId"
        L40:
            r8.put(r1, r0)
            goto L6b
        L44:
            android.telephony.CellLocation r0 = r7.getCellLocation()
            boolean r0 = r0 instanceof android.telephony.gsm.GsmCellLocation
            if (r0 == 0) goto L6b
            android.telephony.CellLocation r0 = r7.getCellLocation()
            android.telephony.gsm.GsmCellLocation r0 = (android.telephony.gsm.GsmCellLocation) r0
            int r1 = r0.getCid()
            java.lang.String r2 = "CellLocCid"
            r8.put(r2, r1)
            int r1 = r0.getLac()
            java.lang.String r2 = "CellLocLac"
            r8.put(r2, r1)
            int r0 = r0.getPsc()
            java.lang.String r1 = "CellLocPsc"
            goto L40
        L6b:
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            java.util.List r7 = r7.getAllCellInfo()
            java.util.Iterator r7 = r7.iterator()
        L78:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto Ld6
            java.lang.Object r1 = r7.next()
            android.telephony.CellInfo r1 = (android.telephony.CellInfo) r1
            boolean r2 = r1.isRegistered()
            if (r2 == 0) goto L78
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            boolean r2 = r1.isRegistered()
            java.lang.String r3 = "Registered"
            r7.put(r3, r2)
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 30
            if (r2 < r3) goto Lbd
            android.telephony.CellIdentity r3 = pi.e.a(r1)
            java.lang.String r4 = "Identity"
            r7.put(r4, r3)
            android.telephony.CellSignalStrength r3 = pi.f.a(r1)
            int r3 = r3.getLevel()
            java.lang.String r4 = "SignalStrengthLevel"
            r7.put(r4, r3)
            long r3 = pi.g.a(r1)
            java.lang.String r5 = "TimestampMillis"
            r7.put(r5, r3)
        Lbd:
            r3 = 28
            if (r2 < r3) goto Lca
            int r2 = pi.h.a(r1)
            java.lang.String r3 = "CellConnectionStatus"
            r7.put(r3, r2)
        Lca:
            long r1 = r1.getTimeStamp()
            java.lang.String r3 = "TimeStamp"
            r7.put(r3, r1)
            r0.put(r7)
        Ld6:
            int r7 = r0.length()
            if (r7 <= 0) goto Le1
            java.lang.String r7 = "AllCellInfo"
            r8.put(r7, r0)
        Le1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: new0.Cif.c(android.telephony.TelephonyManager, org.json.JSONObject):void");
    }

    @SuppressLint({"MissingPermission"})
    public final JSONObject e(Context context) {
        String str;
        int phoneCount;
        int simCarrierId;
        CharSequence simCarrierIdName;
        int dataNetworkType;
        String networkSpecifier;
        String meid;
        String meid2;
        String meid3;
        JSONObject jSONObject = new JSONObject();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return jSONObject;
        }
        if (context.checkCallingOrSelfPermission(g.f11102c) == 0) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 < 29) {
                if (i10 >= 26) {
                    meid = telephonyManager.getMeid();
                    jSONObject.put("Meid", meid);
                    meid2 = telephonyManager.getMeid(0);
                    jSONObject.put("Meid_0", meid2);
                    meid3 = telephonyManager.getMeid(1);
                    jSONObject.put("Meid_1", meid3);
                }
                jSONObject.put("SimSerialNumber", telephonyManager.getSimSerialNumber());
                jSONObject.put("SubscriberId", telephonyManager.getSubscriberId());
            }
            jSONObject.put("NetworkCountryIso", telephonyManager.getNetworkCountryIso());
            jSONObject.put("NetworkOperator", telephonyManager.getNetworkOperator());
            jSONObject.put("NetworkOperatorName", telephonyManager.getNetworkOperatorName());
            jSONObject.put("NetworkType", telephonyManager.getNetworkType());
            if (i10 >= 26) {
                networkSpecifier = telephonyManager.getNetworkSpecifier();
                jSONObject.put("NetworkSpecifier", networkSpecifier);
            }
            if (i10 >= 24) {
                dataNetworkType = telephonyManager.getDataNetworkType();
                jSONObject.put("DataNetworkType", dataNetworkType);
            }
            if (i10 >= 28) {
                simCarrierId = telephonyManager.getSimCarrierId();
                jSONObject.put("SimCarrierId", simCarrierId);
                simCarrierIdName = telephonyManager.getSimCarrierIdName();
                jSONObject.put("SimCarrierIdName", simCarrierIdName);
            }
            jSONObject.put("SimCountryIso", telephonyManager.getSimCountryIso());
            jSONObject.put("SimOperator", telephonyManager.getSimOperator());
            jSONObject.put("SimOperatorName", telephonyManager.getSimOperatorName());
            jSONObject.put("SimState", telephonyManager.getSimState());
            if (i10 >= 23) {
                phoneCount = telephonyManager.getPhoneCount();
                jSONObject.put("PhoneCount", phoneCount);
            }
            jSONObject.put("PhoneType", telephonyManager.getPhoneType());
            try {
                c(telephonyManager, jSONObject);
            } catch (Throwable th2) {
                str = "getCellInfo Error: " + th2;
            }
            return jSONObject;
        }
        str = "NoPermission";
        jSONObject.put("Error", str);
        return jSONObject;
    }

    public final synchronized JSONArray f() {
        WeakReference<JSONArray> weakReference = f28858g;
        if (weakReference != null && weakReference.get() != null) {
            return f28858g.get();
        }
        JSONArray jSONArray = new JSONArray();
        try {
            for (NetworkInterface networkInterface : d()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("DisplayName", networkInterface.getDisplayName());
                    jSONObject.put("Name", networkInterface.getName());
                    jSONObject.put("MTU", networkInterface.getMTU());
                    jSONObject.put("UP", networkInterface.isUp());
                    jSONObject.put("Index", networkInterface.getIndex());
                    Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                    JSONArray jSONArray2 = new JSONArray();
                    if (inetAddresses != null) {
                        while (inetAddresses.hasMoreElements()) {
                            try {
                                InetAddress nextElement = inetAddresses.nextElement();
                                if (nextElement != null) {
                                    jSONArray2.put(nextElement.getHostAddress());
                                }
                            } catch (Exception e10) {
                                if (d.d()) {
                                    e10.printStackTrace();
                                }
                            }
                        }
                    }
                    jSONObject.put("InetAddresses", jSONArray2);
                    List<InterfaceAddress> interfaceAddresses = networkInterface.getInterfaceAddresses();
                    JSONArray jSONArray3 = new JSONArray();
                    for (InterfaceAddress interfaceAddress : interfaceAddresses) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("Address", interfaceAddress.getAddress() != null ? interfaceAddress.getAddress().getHostAddress() : "");
                        jSONObject2.put("Broadcast", interfaceAddress.getBroadcast() != null ? interfaceAddress.getBroadcast().getHostAddress() : "");
                        jSONObject2.put("NetworkPrefixLength", (int) interfaceAddress.getNetworkPrefixLength());
                        jSONArray3.put(jSONObject2);
                    }
                    jSONObject.put("InterfaceAddresses", jSONArray3);
                    if ("wlan0".equals(networkInterface.getName()) || "eth0".equals(networkInterface.getName())) {
                        byte[] hardwareAddress = networkInterface.getHardwareAddress();
                        StringBuilder sb2 = new StringBuilder(18);
                        if (hardwareAddress != null) {
                            for (byte b10 : hardwareAddress) {
                                if (sb2.length() > 0) {
                                    sb2.append(m5.d.f28378d);
                                }
                                sb2.append(String.format("%02x", Byte.valueOf(b10)));
                            }
                        } else {
                            sb2.append("");
                        }
                        jSONObject.put("HardwareAddress", sb2.toString());
                    }
                    jSONArray.put(jSONObject);
                } catch (Exception e11) {
                    if (d.d()) {
                        e11.printStackTrace();
                    }
                }
            }
        } catch (Exception e12) {
            if (d.d()) {
                e12.printStackTrace();
            }
        }
        f28858g = new WeakReference<>(jSONArray);
        return jSONArray;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(29:0|1|(1:3)|4|(1:6)|7|(1:13)|14|(1:16)(1:135)|17|(1:19)|20|(2:21|22)|(14:129|26|27|28|(19:30|31|32|33|34|(2:38|(1:40)(1:115))(1:116)|41|215|47|(3:66|67|(4:68|(2:70|(1:73)(1:72))|75|76))(0)|49|50|51|52|(1:54)|56|57|(1:59)|61)|120|31|32|33|34|(5:36|38|(0)(0)|41|215)|116|41|215)|25|26|27|28|(0)|120|31|32|33|34|(0)|116|41|215|(3:(0)|(11:78|(10:80|2b4|50|51|52|(0)|56|57|(0)|61)(0)|49|50|51|52|(0)|56|57|(0)|61)|(11:85|(0)|94|50|51|52|(0)|56|57|(0)|61))) */
    /* JADX WARN: Can't wrap try/catch for region: R(30:0|1|(1:3)|4|(1:6)|7|(1:13)|14|(1:16)(1:135)|17|(1:19)|20|21|22|(14:129|26|27|28|(19:30|31|32|33|34|(2:38|(1:40)(1:115))(1:116)|41|215|47|(3:66|67|(4:68|(2:70|(1:73)(1:72))|75|76))(0)|49|50|51|52|(1:54)|56|57|(1:59)|61)|120|31|32|33|34|(5:36|38|(0)(0)|41|215)|116|41|215)|25|26|27|28|(0)|120|31|32|33|34|(0)|116|41|215|(3:(0)|(11:78|(10:80|2b4|50|51|52|(0)|56|57|(0)|61)(0)|49|50|51|52|(0)|56|57|(0)|61)|(11:85|(0)|94|50|51|52|(0)|56|57|(0)|61))) */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01e5, code lost:
    
        r4 = l5.c.f27899e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x019d, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x01a2, code lost:
    
        if (rh.d.d() != false) goto L347;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x01a4, code lost:
    
        r4.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x02a8, code lost:
    
        if (new java.io.File("/system/app/Superuser.apk").exists() != false) goto L415;
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0194 A[Catch: all -> 0x019d, TRY_LEAVE, TryCatch #8 {all -> 0x019d, blocks: (B:28:0x018c, B:30:0x0194), top: B:27:0x018c }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0216 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0308 A[Catch: IOException -> 0x0313, TRY_LEAVE, TryCatch #5 {IOException -> 0x0313, blocks: (B:52:0x02fb, B:54:0x0308), top: B:51:0x02fb }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0320 A[Catch: IOException -> 0x032c, TRY_LEAVE, TryCatch #9 {IOException -> 0x032c, blocks: (B:57:0x0313, B:59:0x0320), top: B:56:0x0313 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02d9 A[Catch: all -> 0x02c9, Exception -> 0x02ec, TryCatch #1 {Exception -> 0x02ec, blocks: (B:85:0x02cf, B:87:0x02d9, B:91:0x02e0, B:98:0x02cc), top: B:97:0x02cc }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.json.JSONObject g(android.content.Context r14) {
        /*
            Method dump skipped, instructions count: 819
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: new0.Cif.g(android.content.Context):org.json.JSONObject");
    }
}
