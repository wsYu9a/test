package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;

/* loaded from: classes3.dex */
public final class ag {
    @WorkerThread
    public static String a(String str, a aVar) {
        return (TextUtils.isEmpty(str) || aVar == null) ? str : str.replace("__WIDTH__", ee(aVar.getWidth())).replace("__HEIGHT__", ee(aVar.getHeight())).replace("__DOWN_X__", ee(aVar.NK())).replace("__DOWN_Y__", ee(aVar.NL())).replace("__UP_X__", ee(aVar.NM())).replace("__UP_Y__", ee(aVar.NN()));
    }

    public static String am(Context context, String str) {
        return TextUtils.isEmpty(str) ? str : str.replace("__SCREEN_WIDTH__", String.valueOf(l.getScreenWidth(context))).replace("__SCREEN_HEIGHT__", String.valueOf(l.getScreenHeight(context))).replace("__DEVICE_WIDTH__", String.valueOf(l.ck(context))).replace("__DEVICE_HEIGHT__", String.valueOf(l.cl(context)));
    }

    public static String c(@Nullable Context context, String str, boolean z10) {
        return str.replace("__TS__", String.valueOf(bq.v(context, z10)));
    }

    private static String ee(int i10) {
        return i10 >= 0 ? String.valueOf(i10) : "-999";
    }

    public static class a {
        private int aTM;
        private int aTN;
        private int aTO;
        private int aTP;
        private int mHeight;
        private int mWidth;

        public a() {
            this.mWidth = -1;
            this.mHeight = -1;
            this.aTM = -1;
            this.aTN = -1;
            this.aTO = -1;
            this.aTP = -1;
        }

        public final int NK() {
            return this.aTM;
        }

        public final int NL() {
            return this.aTN;
        }

        public final int NM() {
            return this.aTO;
        }

        public final int NN() {
            return this.aTP;
        }

        public final void f(float f10, float f11) {
            this.aTM = (int) f10;
            this.aTN = (int) f11;
        }

        public final void g(float f10, float f11) {
            this.aTO = (int) f10;
            this.aTP = (int) f11;
        }

        public final int getHeight() {
            return this.mHeight;
        }

        public final int getWidth() {
            return this.mWidth;
        }

        public final String toString() {
            return "TouchCoords{mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", mDownX=" + this.aTM + ", mDownY=" + this.aTN + ", mUpX=" + this.aTO + ", mUpY=" + this.aTP + '}';
        }

        public final void z(int i10, int i11) {
            this.mWidth = i10;
            this.mHeight = i11;
        }

        public a(int i10, int i11) {
            this.aTM = -1;
            this.aTN = -1;
            this.aTO = -1;
            this.aTP = -1;
            this.mWidth = i10;
            this.mHeight = i11;
        }
    }
}
