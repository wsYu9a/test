package com.kuaishou.weapon.p0;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* loaded from: classes.dex */
public class bj {

    /* renamed from: a */
    private static final String f9120a = "/proc/cpuinfo";

    public static String a() {
        try {
            String str = Build.CPU_ABI;
            String str2 = Build.CPU_ABI2;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (!TextUtils.isEmpty(str2)) {
                sb.append(";" + str2);
            }
            String a2 = bg.a("ro.product.cpu.abilist");
            if (!TextUtils.isEmpty(a2)) {
                sb.append(";" + a2);
            }
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static bi b() {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        String[] split;
        try {
            fileInputStream = new FileInputStream(new File(f9120a));
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        bi biVar = new bi();
                        int i2 = 0;
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                biVar.a(i2);
                                bufferedReader.close();
                                inputStreamReader.close();
                                fileInputStream.close();
                                return biVar;
                            }
                            if (!TextUtils.isEmpty(readLine)) {
                                if (readLine.contains("Processor")) {
                                    String[] split2 = readLine.split(":");
                                    if (split2 != null) {
                                        String trim = split2[1].trim();
                                        if (!TextUtils.isEmpty(trim)) {
                                            biVar.b(trim);
                                        }
                                    }
                                }
                                if (readLine.contains("processor")) {
                                    String[] split3 = readLine.split(":");
                                    if (split3 != null) {
                                        String trim2 = split3[1].trim();
                                        if (!TextUtils.isEmpty(trim2)) {
                                            i2 = Integer.parseInt(trim2) + 1;
                                        }
                                    }
                                }
                                if (readLine.contains("Hardware") && (split = readLine.split(":")) != null) {
                                    String str = split[1];
                                    if (!TextUtils.isEmpty(str)) {
                                        biVar.a(str);
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
