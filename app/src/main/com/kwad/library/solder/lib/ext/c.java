package com.kwad.library.solder.lib.ext;

import android.os.Build;
import androidx.annotation.NonNull;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public final class c {
    private final int amI;
    private final String amW;
    private final String amX;
    private final String amY;
    private final String amZ;
    private final String ana;
    private final String anb;
    private final String anc;
    private final boolean and;
    private final boolean ane;
    private final boolean anf;
    private ExecutorService ang;
    private String anh;
    private byte[] ani;
    private boolean anj;
    private int ank;

    public static class a {
        private static final String anl;
        private String anc;
        private boolean anf;
        private ExecutorService ang;
        private String anh;
        private byte[] ani;
        private boolean anj;
        private int anm;
        private int amI = 3;
        private String amW = "sodler";
        private String amX = "code-cache";
        private String amY = "lib";
        private String amZ = "temp";
        private String anb = anl;
        private String ana = ".tmp";
        private boolean ane = false;
        private boolean and = false;

        static {
            anl = yR() ? "base-1_apk" : "base-1.apk";
        }

        private static boolean yR() {
            int i10 = Build.VERSION.SDK_INT;
            return i10 == 30 || i10 == 31 || i10 == 32;
        }

        public final a a(ExecutorService executorService) {
            this.ang = executorService;
            return this;
        }

        public final a bR(int i10) {
            if (i10 > 0) {
                this.amI = i10;
            }
            return this;
        }

        public final a bS(int i10) {
            this.anm = i10;
            return this;
        }

        public final a bU(@NonNull String str) {
            this.amW = str;
            return this;
        }

        public final a bi(boolean z10) {
            this.anj = false;
            return this;
        }

        public final a bj(boolean z10) {
            this.anf = z10;
            return this;
        }

        public final c yS() {
            return new c(this.and, this.ane, this.anc, this.amW, this.amX, this.amY, this.amZ, this.ana, this.anb, this.amI, this.anh, this.ani, this.anj, this.anf, this.ang, this.anm, (byte) 0);
        }
    }

    public /* synthetic */ c(boolean z10, boolean z11, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, String str8, byte[] bArr, boolean z12, boolean z13, ExecutorService executorService, int i11, byte b10) {
        this(z10, z11, str, str2, str3, str4, str5, str6, str7, i10, str8, bArr, z12, z13, executorService, i11);
    }

    public final int getRetryCount() {
        return this.amI;
    }

    public final int yH() {
        return this.ank;
    }

    public final String yI() {
        return this.amW;
    }

    public final String yJ() {
        return this.amX;
    }

    public final String yK() {
        return this.amY;
    }

    public final String yL() {
        return this.amZ;
    }

    public final String yM() {
        return this.ana;
    }

    public final String yN() {
        return this.anb;
    }

    public final boolean yO() {
        return this.ane;
    }

    public final boolean yP() {
        return this.anf;
    }

    public final ExecutorService yQ() {
        return this.ang;
    }

    private c(boolean z10, boolean z11, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, String str8, byte[] bArr, boolean z12, boolean z13, ExecutorService executorService, int i11) {
        this.amI = i10;
        this.amW = str2;
        this.amX = str3;
        this.amY = str4;
        this.amZ = str5;
        this.ana = str6;
        this.anb = str7;
        this.anc = str;
        this.and = z10;
        this.ane = z11;
        this.anh = str8;
        this.ani = bArr;
        this.anj = z12;
        this.anf = z13;
        this.ang = executorService;
        this.ank = i11;
    }
}
