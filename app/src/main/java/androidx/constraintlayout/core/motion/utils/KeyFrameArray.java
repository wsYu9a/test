package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import java.io.PrintStream;
import java.util.Arrays;

/* loaded from: classes.dex */
public class KeyFrameArray {

    public static class CustomArray {
        private static final int EMPTY = 999;
        int count;
        int[] keys = new int[101];
        CustomAttribute[] values = new CustomAttribute[101];

        public CustomArray() {
            clear();
        }

        public void append(int i10, CustomAttribute customAttribute) {
            if (this.values[i10] != null) {
                remove(i10);
            }
            this.values[i10] = customAttribute;
            int[] iArr = this.keys;
            int i11 = this.count;
            this.count = i11 + 1;
            iArr[i11] = i10;
            Arrays.sort(iArr);
        }

        public void clear() {
            Arrays.fill(this.keys, 999);
            Arrays.fill(this.values, (Object) null);
            this.count = 0;
        }

        public void dump() {
            PrintStream printStream = System.out;
            printStream.println("V: " + Arrays.toString(Arrays.copyOf(this.keys, this.count)));
            printStream.print("K: [");
            int i10 = 0;
            while (i10 < this.count) {
                PrintStream printStream2 = System.out;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i10 == 0 ? "" : ", ");
                sb2.append(valueAt(i10));
                printStream2.print(sb2.toString());
                i10++;
            }
            System.out.println("]");
        }

        public int keyAt(int i10) {
            return this.keys[i10];
        }

        public void remove(int i10) {
            this.values[i10] = null;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                int i13 = this.count;
                if (i11 >= i13) {
                    this.count = i13 - 1;
                    return;
                }
                int[] iArr = this.keys;
                if (i10 == iArr[i11]) {
                    iArr[i11] = 999;
                    i12++;
                }
                if (i11 != i12) {
                    iArr[i11] = iArr[i12];
                }
                i12++;
                i11++;
            }
        }

        public int size() {
            return this.count;
        }

        public CustomAttribute valueAt(int i10) {
            return this.values[this.keys[i10]];
        }
    }

    public static class CustomVar {
        private static final int EMPTY = 999;
        int count;
        int[] keys = new int[101];
        CustomVariable[] values = new CustomVariable[101];

        public CustomVar() {
            clear();
        }

        public void append(int i10, CustomVariable customVariable) {
            if (this.values[i10] != null) {
                remove(i10);
            }
            this.values[i10] = customVariable;
            int[] iArr = this.keys;
            int i11 = this.count;
            this.count = i11 + 1;
            iArr[i11] = i10;
            Arrays.sort(iArr);
        }

        public void clear() {
            Arrays.fill(this.keys, 999);
            Arrays.fill(this.values, (Object) null);
            this.count = 0;
        }

        public void dump() {
            PrintStream printStream = System.out;
            printStream.println("V: " + Arrays.toString(Arrays.copyOf(this.keys, this.count)));
            printStream.print("K: [");
            int i10 = 0;
            while (i10 < this.count) {
                PrintStream printStream2 = System.out;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i10 == 0 ? "" : ", ");
                sb2.append(valueAt(i10));
                printStream2.print(sb2.toString());
                i10++;
            }
            System.out.println("]");
        }

        public int keyAt(int i10) {
            return this.keys[i10];
        }

        public void remove(int i10) {
            this.values[i10] = null;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                int i13 = this.count;
                if (i11 >= i13) {
                    this.count = i13 - 1;
                    return;
                }
                int[] iArr = this.keys;
                if (i10 == iArr[i11]) {
                    iArr[i11] = 999;
                    i12++;
                }
                if (i11 != i12) {
                    iArr[i11] = iArr[i12];
                }
                i12++;
                i11++;
            }
        }

        public int size() {
            return this.count;
        }

        public CustomVariable valueAt(int i10) {
            return this.values[this.keys[i10]];
        }
    }

    public static class FloatArray {
        private static final int EMPTY = 999;
        int count;
        int[] keys = new int[101];
        float[][] values = new float[101][];

        public FloatArray() {
            clear();
        }

        public void append(int i10, float[] fArr) {
            if (this.values[i10] != null) {
                remove(i10);
            }
            this.values[i10] = fArr;
            int[] iArr = this.keys;
            int i11 = this.count;
            this.count = i11 + 1;
            iArr[i11] = i10;
            Arrays.sort(iArr);
        }

        public void clear() {
            Arrays.fill(this.keys, 999);
            Arrays.fill(this.values, (Object) null);
            this.count = 0;
        }

        public void dump() {
            PrintStream printStream = System.out;
            printStream.println("V: " + Arrays.toString(Arrays.copyOf(this.keys, this.count)));
            printStream.print("K: [");
            int i10 = 0;
            while (i10 < this.count) {
                PrintStream printStream2 = System.out;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i10 == 0 ? "" : ", ");
                sb2.append(Arrays.toString(valueAt(i10)));
                printStream2.print(sb2.toString());
                i10++;
            }
            System.out.println("]");
        }

        public int keyAt(int i10) {
            return this.keys[i10];
        }

        public void remove(int i10) {
            this.values[i10] = null;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                int i13 = this.count;
                if (i11 >= i13) {
                    this.count = i13 - 1;
                    return;
                }
                int[] iArr = this.keys;
                if (i10 == iArr[i11]) {
                    iArr[i11] = 999;
                    i12++;
                }
                if (i11 != i12) {
                    iArr[i11] = iArr[i12];
                }
                i12++;
                i11++;
            }
        }

        public int size() {
            return this.count;
        }

        public float[] valueAt(int i10) {
            return this.values[this.keys[i10]];
        }
    }
}
