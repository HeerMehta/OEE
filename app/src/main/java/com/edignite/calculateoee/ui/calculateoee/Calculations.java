package com.edignite.calculateoee.ui.calculateoee;

public class Calculations {

    private static int rt;
    private static int at;
    private static int pt;
    private static int et;

    public static double calculateav(int workedhrs, int majortl){
        at = workedhrs*60;
        rt = at - majortl;
        double av = rt*100/at;
        return av;
    }

    public static double calculatepf(int minortl){
        pt = rt - minortl;
        double pf = at*100/rt;
        return pf;
    }

    public static double calculateqv(int rwtime){
        et = pt - rwtime;
        double qv = et*100/pt;
        return qv;
    }
}
