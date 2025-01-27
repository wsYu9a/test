package com.kwad.sdk.crash;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class c {
    private static final String TAG = "c";
    public final String aDB;
    public final boolean aJA;
    public final com.kwad.sdk.crash.model.c aJD;
    public final com.kwad.sdk.crash.model.a aJE;
    public final h aJF;
    public final String[] aJG;
    public final String[] aJH;
    public final boolean aJI;
    public final f aJJ;
    public final String aJK;
    public final String aJL;
    public final String aJM;
    public final String aJN;
    public final String aJO;
    public final String aJP;
    public final String aJQ;
    public final String aJR;
    public final String aJS;
    public final List<com.kwad.sdk.crash.a> aJT;
    public final double aJu;
    public final boolean aJz;
    public final boolean aol;
    public final String channel;
    public final Context context;
    public final String platform;
    public final String sdkVersion;

    public static class a {
        private String ZC;
        private int ZD;
        private int aCX;
        private String aDB;
        private f aJJ;
        private String aJK;
        private String aJL;
        private String aJM;
        private String aJN;
        private String aJO;
        private String aJU;
        private h aJV;
        private String[] aJW;
        public String[] aJX;
        private String appId;
        private String appName;
        private String appPackageName;
        private String appVersion;
        private String channel;
        private Context context;
        private String platform;
        public int sdkType;
        private String sdkVersion;
        private boolean aJI = false;
        private boolean aJz = false;
        private boolean aJA = false;
        private boolean aol = false;
        private String aJP = "";
        private String aJQ = "";
        private String aJR = "";
        private String aJS = "";
        private List<com.kwad.sdk.crash.a> aJT = new ArrayList();
        private double aJu = 1.0d;

        public final c Jj() {
            return new c(this, (byte) 0);
        }

        public final a bA(boolean z10) {
            this.aJz = z10;
            return this;
        }

        public final a bB(boolean z10) {
            this.aJA = z10;
            return this;
        }

        public final a bC(boolean z10) {
            this.aol = z10;
            return this;
        }

        public final a bM(Context context) {
            this.context = context;
            return this;
        }

        public final a dC(int i10) {
            this.aCX = i10;
            return this;
        }

        public final a dD(int i10) {
            this.ZD = i10;
            return this;
        }

        public final a dE(int i10) {
            this.sdkType = 1;
            return this;
        }

        public final a fA(String str) {
            this.aJM = str;
            return this;
        }

        public final a fB(String str) {
            this.aJR = str;
            return this;
        }

        public final a fC(String str) {
            this.aJS = str;
            return this;
        }

        public final a fl(String str) {
            this.aJP = str;
            return this;
        }

        public final a fm(String str) {
            this.aJQ = str;
            return this;
        }

        public final a fn(String str) {
            this.platform = str;
            return this;
        }

        public final a fo(String str) {
            this.aJK = str;
            return this;
        }

        public final a fp(String str) {
            this.aDB = str;
            return this;
        }

        public final a fq(String str) {
            this.channel = str;
            return this;
        }

        public final a fr(String str) {
            this.aJO = str;
            return this;
        }

        public final a fs(String str) {
            this.aJU = str;
            return this;
        }

        public final a ft(String str) {
            this.sdkVersion = str;
            return this;
        }

        public final a fu(String str) {
            this.ZC = str;
            return this;
        }

        public final a fv(String str) {
            this.appPackageName = str;
            return this;
        }

        public final a fw(String str) {
            this.appId = str;
            return this;
        }

        public final a fx(String str) {
            this.appName = str;
            return this;
        }

        public final a fy(String str) {
            this.appVersion = str;
            return this;
        }

        public final a fz(String str) {
            this.aJL = str;
            return this;
        }

        public final a D(List<String> list) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        com.kwad.sdk.crash.a aVar = new com.kwad.sdk.crash.a();
                        aVar.parseJson(jSONObject);
                        this.aJT.add(aVar);
                    } catch (Exception e10) {
                        com.kwad.sdk.core.d.c.w(c.TAG, Log.getStackTraceString(e10));
                    }
                }
            }
            return this;
        }

        public final a a(f fVar) {
            this.aJJ = fVar;
            return this;
        }

        public final a d(String[] strArr) {
            this.aJW = strArr;
            return this;
        }

        public final a e(String[] strArr) {
            this.aJX = strArr;
            return this;
        }

        public final a m(double d10) {
            this.aJu = d10;
            return this;
        }

        public final a a(h hVar) {
            this.aJV = hVar;
            return this;
        }
    }

    public /* synthetic */ c(a aVar, byte b10) {
        this(aVar);
    }

    public final f Jg() {
        return this.aJJ;
    }

    public final boolean Jh() {
        return this.aJI;
    }

    private c(a aVar) {
        com.kwad.sdk.crash.model.c cVar = new com.kwad.sdk.crash.model.c();
        this.aJD = cVar;
        com.kwad.sdk.crash.model.a aVar2 = new com.kwad.sdk.crash.model.a();
        this.aJE = aVar2;
        ArrayList arrayList = new ArrayList();
        this.aJT = arrayList;
        this.aJI = aVar.aJI;
        this.aJz = aVar.aJz;
        this.aJA = aVar.aJA;
        this.aol = aVar.aol;
        this.aJP = aVar.aJP;
        this.aJQ = aVar.aJQ;
        this.aJR = aVar.aJR;
        this.aJS = aVar.aJS;
        this.context = aVar.context;
        this.aJJ = aVar.aJJ;
        this.platform = aVar.platform;
        this.aJK = aVar.aJK;
        this.aJL = aVar.aJL;
        this.aJM = aVar.aJM;
        this.sdkVersion = aVar.sdkVersion;
        this.aDB = aVar.aDB;
        this.channel = aVar.channel;
        this.aJN = aVar.aJN;
        this.aJO = aVar.aJO;
        aVar2.aKA = aVar.appId;
        aVar2.mAppName = aVar.appName;
        aVar2.aKC = aVar.appVersion;
        aVar2.aKB = aVar.appPackageName;
        cVar.aKM = aVar.ZC;
        cVar.aKN = aVar.ZD;
        cVar.mSdkVersion = aVar.sdkVersion;
        cVar.aKL = aVar.aCX;
        cVar.aKK = aVar.aJU;
        cVar.aKO = aVar.sdkType;
        this.aJF = aVar.aJV;
        this.aJG = aVar.aJW;
        this.aJH = aVar.aJX;
        arrayList.addAll(aVar.aJT);
        this.aJu = aVar.aJu;
    }
}
