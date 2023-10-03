package geekbang.jvm.lec04;

interface Customer1 {
    boolean isVIP();
}

class Merchant1 {
    public Number actionPrice(double price, Customer1 customer) {
        return 0;
    }
}

class NaiveMerchant1 extends Merchant {
    @Override
    public Double actionPrice(double price, Customer1 customer) {
        return 0.0;
    }
}