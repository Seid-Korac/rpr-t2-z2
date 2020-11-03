package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetnaTacka;
    private double krajnjaTacka;
    private boolean pocetnaPripada;
    private boolean krajnjaPripada;

    public Interval() {
        this.pocetnaTacka = 0;
        this.krajnjaTacka = 0;
        this.pocetnaPripada = false;
        this.krajnjaPripada = false;
    }

    public Interval (double pocetnaTacka, double krajnjaTacka, boolean pocetnaPripada, boolean krajnjaPripada) {
        if(pocetnaTacka > krajnjaTacka) throw  new IllegalArgumentException("Pogresan interval");
        this.pocetnaTacka=pocetnaTacka;
        this.krajnjaTacka=krajnjaTacka;
        this.pocetnaPripada=pocetnaPripada;
        this.krajnjaPripada=krajnjaPripada;
    }

    public double getPocetnaTacka() {
        return pocetnaTacka;
    }

    public void setPocetnaTacka(double pocetnaTacka) {
        this.pocetnaTacka = pocetnaTacka;
    }

    public double getKrajnjaTacka() {
        return krajnjaTacka;
    }

    public void setKrajnjaTacka(double krajnjaTacka) {
        this.krajnjaTacka = krajnjaTacka;
    }

    public boolean isPocetnaPripada() {
        return pocetnaPripada;
    }

    public void setPocetnaPripada(boolean pocetnaPripada) {
        this.pocetnaPripada = pocetnaPripada;
    }

    public boolean isKrajnjaPripada() {
        return krajnjaPripada;
    }

    public void setKrajnjaPripada(boolean krajnjaPripada) {
        this.krajnjaPripada = krajnjaPripada;
    }

    public boolean isNull() {
        return pocetnaTacka == 0 && krajnjaTacka==0 && !pocetnaPripada && !krajnjaPripada;
    }

    public boolean isIn(double a) {
        return a > pocetnaTacka && a < krajnjaTacka || a==pocetnaTacka && pocetnaPripada || a==krajnjaTacka && krajnjaPripada;
    }

    public Interval intersect (Interval b) {
//        double p = this.pocetnaTacka;
//        double k = this.krajnjaTacka;
//        boolean bp = this.pocetnaPripada;
//        boolean bk= this.krajnjaPripada;
//
//        if (b.pocetnaTacka > p) {
//            p = b.pocetnaTacka;
//            bp=b.pocetnaPripada;
//        }else if (b.pocetnaTacka == p) {
//            bp = bp && b.pocetnaPripada;
//        }
//
//        if (b.krajnjaTacka < k) {
//            k = b.krajnjaTacka;
//            bk=b.krajnjaPripada;
//        }else if (b.krajnjaTacka == k) {
//            bk = bk && b.krajnjaPripada;
//        }
//
//        if (p>k) return new Interval();
//        else return new Interval(p,k,bp,bk);
        return intersect(this, b);
    }

    public static Interval intersect(Interval a, Interval b) {
        double p = a.pocetnaTacka;
        double k = a.krajnjaTacka;
        boolean bp = a.pocetnaPripada;
        boolean bk= a.krajnjaPripada;

        if (b.pocetnaTacka > p) {
            p = b.pocetnaTacka;
            bp=b.pocetnaPripada;
        }else if (b.pocetnaTacka == p) {
            bp = bp && b.pocetnaPripada;
        }

        if (b.krajnjaTacka < k) {
            k = b.krajnjaTacka;
            bk=b.krajnjaPripada;
        }else if (b.krajnjaTacka == k) {
            bk = bk && b.krajnjaPripada;
        }

        if (p>k) return new Interval();
        else return new Interval(p,k,bp,bk);
    }

    @Override
    public String toString() {
        String res = new String();
        if(this.isNull()) return "()";
        if (pocetnaPripada) res += "["; else res += "(";
        res += pocetnaTacka;
        res += ",";
        res += krajnjaTacka;
        if (krajnjaPripada) res += "]"; else res += ")";
        return res;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }
        if (!(o instanceof Interval)) {
            return false;
        }
        Interval a = (Interval)o;
        return this.pocetnaTacka == a.pocetnaTacka
                && this.krajnjaTacka==a.krajnjaTacka
                && this.pocetnaPripada == a.pocetnaPripada
                && this.krajnjaPripada==a.krajnjaPripada;
    }
}
