package com.kwad.library.solder.lib.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.library.solder.lib.a.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class e<P extends a> {
    protected String alZ;
    protected int amI;
    protected String amK;
    protected String amL;
    protected boolean amM;
    protected P amN;
    protected com.kwad.library.solder.lib.ext.b amO;
    protected Throwable amP;
    protected String amQ;
    protected boolean amR;
    protected long amS;
    protected String amT;
    protected List<com.kwad.library.solder.lib.c.a> amU;
    protected com.kwad.library.solder.lib.c.b amV;
    protected d amp;
    protected String mDownloadUrl;
    protected String mVersion;
    protected int mState = -1;
    protected int amH = 0;
    private final byte[] amE = new byte[0];
    protected StringBuffer amJ = new StringBuffer(String.valueOf(-1));

    public e(com.kwad.library.solder.lib.c.b bVar) {
        this.amV = bVar;
        this.alZ = bVar.ann;
        this.mVersion = bVar.version;
        this.amT = bVar.anq;
        this.amR = bVar.amR;
        this.amQ = bVar.amQ;
        this.amS = bVar.anp;
        this.mDownloadUrl = bVar.ano;
    }

    private List<com.kwad.library.solder.lib.c.a> b(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(this.amp.yj().bJ(str));
            if (!file.exists()) {
                return arrayList;
            }
            String[] list = file.list();
            if (list != null && list.length != 0) {
                for (String str4 : list) {
                    if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str2) || !str2.equals(str4)) {
                        this.amp.yj().D(str, str4);
                    } else if (this.amp.yj().a(str, str4, str3)) {
                        com.kwad.library.solder.lib.c.a aVar = new com.kwad.library.solder.lib.c.a();
                        aVar.ann = str;
                        aVar.version = str4;
                        aVar.rS = true;
                        arrayList.add(aVar);
                    } else {
                        this.amp.yj().D(str, str4);
                    }
                }
                Collections.sort(arrayList);
            }
        }
        return arrayList;
    }

    public final e a(d dVar) {
        this.amp = dVar;
        return this;
    }

    public final void bN(String str) {
        this.mVersion = str;
    }

    public final e bP(int i10) {
        synchronized (this.amE) {
            this.mState = i10;
        }
        return bQ(String.valueOf(i10));
    }

    public final e bQ(String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuffer stringBuffer = this.amJ;
            stringBuffer.append(" --> ");
            stringBuffer.append(str);
        }
        return this;
    }

    public final void bR(String str) {
        this.amK = str;
    }

    public final void bS(String str) {
        this.amL = str;
    }

    public abstract P bT(String str);

    public final void c(P p10) {
        this.amN = p10;
    }

    public final void cancel() {
        synchronized (this.amE) {
            bP(0);
        }
    }

    @Nullable
    public final String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public final int getState() {
        int i10;
        synchronized (this.amE) {
            i10 = this.mState;
        }
        return i10;
    }

    public final String getVersion() {
        return this.mVersion;
    }

    public final boolean isCanceled() {
        return this.mState == 0;
    }

    public final e j(@NonNull Throwable th2) {
        this.amP = th2;
        return bQ(th2.getLocalizedMessage());
    }

    @NonNull
    public String toString() {
        return "PluginRequest{mId='" + this.alZ + "'}";
    }

    @Nullable
    public final String yA() {
        return !TextUtils.isEmpty(this.amK) ? this.amK : this.amL;
    }

    @Nullable
    public final com.kwad.library.solder.lib.ext.b yB() {
        return this.amO;
    }

    public final boolean yC() {
        return this.amR;
    }

    public final String yD() {
        return this.amQ;
    }

    public final String yE() {
        return this.amT;
    }

    public final com.kwad.library.solder.lib.c.b yF() {
        return this.amV;
    }

    public final List<com.kwad.library.solder.lib.c.a> yG() {
        String yx = yx();
        if (!TextUtils.isEmpty(yx) && this.amU == null) {
            this.amU = b(yx, getVersion(), yE());
        }
        return this.amU;
    }

    public final d yt() {
        return this.amp;
    }

    public final String yu() {
        return this.amJ.toString();
    }

    @Nullable
    public final Throwable yv() {
        return this.amP;
    }

    public final boolean yw() {
        bP(-1);
        this.amU = null;
        int i10 = this.amH + 1;
        this.amH = i10;
        return i10 <= this.amI;
    }

    @Nullable
    public final String yx() {
        return this.alZ;
    }

    public final boolean yy() {
        return this.amM;
    }

    public final int yz() {
        return this.amH;
    }

    public final void a(com.kwad.library.solder.lib.ext.b bVar) {
        this.amO = bVar;
    }

    public final void bQ(int i10) {
        if (i10 > 0) {
            this.amI = i10;
        }
    }
}
