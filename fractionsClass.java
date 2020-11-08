package fractions;

class fractionsClass {
    private int denominator;//分母
    private int molecules;//分子

    //简化分数
    public void simplify() {
        int max_c_f = 1;
        int m = this.getMolecules();
        int d = this.getDenominator();
        if (d >= m) {
            for (int i = 1; i <= m; i++) {
                if (d % i == 0 && m % i == 0) {
                    max_c_f = i;//最大公因数
                }
            }
        } else {
            for (int i = 1; i <= d; i++) {
                if (d % i == 0 && m % i == 0) {
                    max_c_f = i;
                }
            }
        }
        this.setDenominator(d / max_c_f);
        this.setMolecules(m / max_c_f);
    }

    //打印值
    public String getValue() {
        if (this.molecules ==0) {
            return "0";
        }else {
            return this.molecules + "/" + this.denominator;
        }
    }

    //javaBean
    public int getDenominator() {
        return this.denominator;
    }

    public void setDenominator(int d) {
        this.denominator = d;
    }

    public int getMolecules() {
        return this.molecules;
    }

    public void setMolecules(int m) {
        this.molecules = m;
    }

    //构造函数
    public fractionsClass(int m, int d) {
        if (d != 0) {
            this.denominator = d;
        } else {
            this.denominator = 1;
        }
        this.molecules = m;
    }

    //加法
    public fractionsClass addition(fractionsClass f) {
        int d = this.getDenominator() * f.getDenominator();
        int m = this.getMolecules() * f.getDenominator() + f.getMolecules() * this.getDenominator();
        fractionsClass temp = new fractionsClass(m, d);
        temp.simplify();
        return temp;
    }
    //减法
    public fractionsClass subtraction(fractionsClass f) {
        int d = this.getDenominator() * f.getDenominator();
        int m = this.getMolecules() * f.getDenominator() - f.getMolecules() * this.getDenominator();
        fractionsClass temp = new fractionsClass(m, d);
        temp.simplify();
        return temp;
    }
}
