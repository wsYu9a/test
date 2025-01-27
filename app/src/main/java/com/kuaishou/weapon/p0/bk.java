package com.kuaishou.weapon.p0;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* loaded from: classes2.dex */
public class bk {

    /* renamed from: a */
    private static final String f10834a = "/proc/cpuinfo";

    public static String a() {
        try {
            String str = Build.CPU_ABI;
            String str2 = Build.CPU_ABI2;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            if (!TextUtils.isEmpty(str2)) {
                sb2.append(";" + str2);
            }
            String a10 = bh.a("ro.product.cpu.abilist");
            if (!TextUtils.isEmpty(a10)) {
                sb2.append(";" + a10);
            }
            return sb2.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static bj b() {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        String[] split;
        try {
            fileInputStream = new FileInputStream(new File(f10834a));
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        bj bjVar = new bj();
                        int i10 = 0;
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                bjVar.a(i10);
                                bufferedReader.close();
                                inputStreamReader.close();
                                fileInputStream.close();
                                return bjVar;
                            }
                            if (!TextUtils.isEmpty(readLine)) {
                                if (readLine.contains("Processor")) {
                                    String[] split2 = readLine.split(":");
                                    if (split2 != null) {
                                        String trim = split2[1].trim();
                                        if (!TextUtils.isEmpty(trim)) {
                                            bjVar.b(trim);
                                        }
                                    }
                                }
                                if (readLine.contains("processor")) {
                                    String[] split3 = readLine.split(":");
                                    if (split3 != null) {
                                        String trim2 = split3[1].trim();
                                        if (!TextUtils.isEmpty(trim2)) {
                                            i10 = Integer.parseInt(trim2) + 1;
                                        }
                                    }
                                }
                                if (readLine.contains("Hardware") && (split = readLine.split(":")) != null) {
                                    String str = split[1];
                                    if (!TextUtils.isEmpty(str)) {
                                        bjVar.a(str);
                                    }
                                }
                            }
                        }
                    } catch (Throwable unused) {
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return null;
                    }
                } catch (Throwable unused2) {
                    bufferedReader = null;
                }
            } catch (Throwable unused3) {
                inputStreamReader = null;
                bufferedReader = null;
            }
        } catch (Throwable unused4) {
            inputStreamReader = null;
            fileInputStream = null;
            bufferedReader = null;
        }
    }
}
