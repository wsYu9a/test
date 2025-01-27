package com.kuaishou.weapon.p0;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public class bn {
    public static int a(Context context) {
        SensorManager sensorManager;
        try {
            if (Build.VERSION.SDK_INT < 23 || (sensorManager = (SensorManager) context.getSystemService(com.umeng.analytics.pro.am.ac)) == null) {
                return 0;
            }
            List<Sensor> sensorList = sensorManager.getSensorList(-1);
            if (sensorList.size() <= 0) {
                return 0;
            }
            ListIterator<Sensor> listIterator = sensorList.listIterator();
            while (listIterator.hasNext()) {
                if (listIterator.next().getType() == 9) {
                    return 0;
                }
            }
            return 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static long a() {
        BufferedReader bufferedReader;
        DataInputStream dataInputStream = null;
        try {
            DataInputStream dataInputStream2 = new DataInputStream(Runtime.getRuntime().exec("cat /proc/uptime").getInputStream());
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream2));
                double d2 = 0.0d;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = a(readLine).split(";");
                        if (split != null && split.length != 0) {
                            d2 = Double.valueOf(split[0]).doubleValue();
                        }
                    } catch (Throwable unused) {
                        dataInputStream = dataInputStream2;
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused3) {
                            }
                        }
                        return -1L;
                    }
                }
                long currentTimeMillis = System.currentTimeMillis() - ((long) (d2 * 1000.0d));
                try {
                    dataInputStream2.close();
                } catch (IOException unused4) {
                }
                try {
                    bufferedReader.close();
                    return currentTimeMillis;
                } catch (IOException unused5) {
                    return currentTimeMillis;
                }
            } catch (Throwable unused6) {
                bufferedReader = null;
            }
        } catch (Throwable unused7) {
            bufferedReader = null;
        }
    }

    public static String a(String str) {
        try {
            return str.replace("      ", ";").replace("     ", ";").replace("    ", ";").replace("   ", ";").replace("  ", ";").replace(" ", ";");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static long b() {
        BufferedReader bufferedReader;
        DataInputStream dataInputStream = null;
        try {
            DataInputStream dataInputStream2 = new DataInputStream(Runtime.getRuntime().exec("cat /proc/uptime").getInputStream());
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream2));
                double d2 = 0.0d;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = a(readLine).split(";");
                        if (split != null && split.length != 0) {
                            d2 = Double.valueOf(split[0]).doubleValue();
                        }
                    } catch (Throwable unused) {
                        dataInputStream = dataInputStream2;
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused3) {
                            }
                        }
                        return -1L;
                    }
                }
                System.currentTimeMillis();
                long j2 = (long) (d2 * 1000.0d);
                try {
                    dataInputStream2.close();
                } catch (IOException unused4) {
                }
                try {
                    bufferedReader.close();
                    return j2;
                } catch (IOException unused5) {
                    return j2;
                }
            } catch (Throwable unused6) {
                bufferedReader = null;
            }
        } catch (Throwable unused7) {
            bufferedReader = null;
        }
    }
}
