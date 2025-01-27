package hj;

/* loaded from: classes4.dex */
public final class d {
    public static int a(int i10, int i11) {
        if (i10 < i11) {
            return -1;
        }
        return i10 > i11 ? 1 : 0;
    }

    public static int b(long j10, long j11) {
        if (j10 < j11) {
            return -1;
        }
        return j10 > j11 ? 1 : 0;
    }

    public static boolean c(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public static int d(int i10, int i11) {
        return i10 >= 0 ? i10 / i11 : ((i10 + 1) / i11) - 1;
    }

    public static long e(long j10, long j11) {
        return j10 >= 0 ? j10 / j11 : ((j10 + 1) / j11) - 1;
    }

    public static int f(int i10, int i11) {
        return ((i10 % i11) + i11) % i11;
    }

    public static int g(long j10, int i10) {
        long j11 = i10;
        return (int) (((j10 % j11) + j11) % j11);
    }

    public static long h(long j10, long j11) {
        return ((j10 % j11) + j11) % j11;
    }

    public static <T> T i(T t10) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException("Value must not be null");
    }

    public static <T> T j(T t10, String str) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(str + " must not be null");
    }

    public static int k(int i10, int i11) {
        int i12 = i10 + i11;
        if ((i10 ^ i12) >= 0 || (i10 ^ i11) < 0) {
            return i12;
        }
        throw new ArithmeticException("Addition overflows an int: " + i10 + " + " + i11);
    }

    public static long l(long j10, long j11) {
        long j12 = j10 + j11;
        if ((j10 ^ j12) >= 0 || (j10 ^ j11) < 0) {
            return j12;
        }
        throw new ArithmeticException("Addition overflows a long: " + j10 + " + " + j11);
    }

    public static int m(int i10, int i11) {
        long j10 = i10 * i11;
        if (j10 >= -2147483648L && j10 <= 2147483647L) {
            return (int) j10;
        }
        throw new ArithmeticException("Multiplication overflows an int: " + i10 + " * " + i11);
    }

    public static long n(long j10, int i10) {
        if (i10 == -1) {
            if (j10 != Long.MIN_VALUE) {
                return -j10;
            }
            throw new ArithmeticException("Multiplication overflows a long: " + j10 + " * " + i10);
        }
        if (i10 == 0) {
            return 0L;
        }
        if (i10 == 1) {
            return j10;
        }
        long j11 = i10;
        long j12 = j10 * j11;
        if (j12 / j11 == j10) {
            return j12;
        }
        throw new ArithmeticException("Multiplication overflows a long: " + j10 + " * " + i10);
    }

    public static long o(long j10, long j11) {
        if (j11 == 1) {
            return j10;
        }
        if (j10 == 1) {
            return j11;
        }
        if (j10 == 0 || j11 == 0) {
            return 0L;
        }
        long j12 = j10 * j11;
        if (j12 / j11 == j10 && ((j10 != Long.MIN_VALUE || j11 != -1) && (j11 != Long.MIN_VALUE || j10 != -1))) {
            return j12;
        }
        throw new ArithmeticException("Multiplication overflows a long: " + j10 + " * " + j11);
    }

    public static int p(int i10, int i11) {
        int i12 = i10 - i11;
        if ((i10 ^ i12) >= 0 || (i10 ^ i11) >= 0) {
            return i12;
        }
        throw new ArithmeticException("Subtraction overflows an int: " + i10 + " - " + i11);
    }

    public static long q(long j10, long j11) {
        long j12 = j10 - j11;
        if ((j10 ^ j12) >= 0 || (j10 ^ j11) >= 0) {
            return j12;
        }
        throw new ArithmeticException("Subtraction overflows a long: " + j10 + " - " + j11);
    }

    public static int r(long j10) {
        if (j10 <= 2147483647L && j10 >= -2147483648L) {
            return (int) j10;
        }
        throw new ArithmeticException("Calculation overflows an int: " + j10);
    }
}
