package androidx.appcompat.app;

/* loaded from: classes.dex */
class TwilightCalculator {
    public static final int DAY = 0;
    public static final int NIGHT = 1;

    /* renamed from: a, reason: collision with root package name */
    private static TwilightCalculator f306a = null;

    /* renamed from: b, reason: collision with root package name */
    private static final float f307b = 0.017453292f;

    /* renamed from: c, reason: collision with root package name */
    private static final float f308c = 9.0E-4f;

    /* renamed from: d, reason: collision with root package name */
    private static final float f309d = -0.10471976f;

    /* renamed from: e, reason: collision with root package name */
    private static final float f310e = 0.0334196f;

    /* renamed from: f, reason: collision with root package name */
    private static final float f311f = 3.49066E-4f;

    /* renamed from: g, reason: collision with root package name */
    private static final float f312g = 5.236E-6f;

    /* renamed from: h, reason: collision with root package name */
    private static final float f313h = 0.4092797f;

    /* renamed from: i, reason: collision with root package name */
    private static final long f314i = 946728000000L;
    public int state;
    public long sunrise;
    public long sunset;

    TwilightCalculator() {
    }

    static TwilightCalculator a() {
        if (f306a == null) {
            f306a = new TwilightCalculator();
        }
        return f306a;
    }

    public void calculateTwilight(long j2, double d2, double d3) {
        float f2 = (j2 - f314i) / 8.64E7f;
        double d4 = (0.01720197f * f2) + 6.24006f;
        double sin = Math.sin(d4) * 0.03341960161924362d;
        Double.isNaN(d4);
        double sin2 = sin + d4 + (Math.sin(2.0f * r4) * 3.4906598739326E-4d) + (Math.sin(r4 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        Double.isNaN(f2 - f308c);
        double round = Math.round(r11 - r9) + f308c;
        Double.isNaN(round);
        double sin3 = round + ((-d3) / 360.0d) + (Math.sin(d4) * 0.0053d) + (Math.sin(2.0d * sin2) * (-0.0069d));
        double asin = Math.asin(Math.sin(sin2) * Math.sin(0.4092797040939331d));
        double d5 = 0.01745329238474369d * d2;
        double sin4 = (Math.sin(-0.10471975803375244d) - (Math.sin(d5) * Math.sin(asin))) / (Math.cos(d5) * Math.cos(asin));
        if (sin4 >= 1.0d) {
            this.state = 1;
            this.sunset = -1L;
            this.sunrise = -1L;
            return;
        }
        if (sin4 <= -1.0d) {
            this.state = 0;
            this.sunset = -1L;
            this.sunrise = -1L;
            return;
        }
        double acos = (float) (Math.acos(sin4) / 6.283185307179586d);
        Double.isNaN(acos);
        this.sunset = Math.round((sin3 + acos) * 8.64E7d) + f314i;
        Double.isNaN(acos);
        long round2 = Math.round((sin3 - acos) * 8.64E7d) + f314i;
        this.sunrise = round2;
        if (round2 >= j2 || this.sunset <= j2) {
            this.state = 1;
        } else {
            this.state = 0;
        }
    }
}
