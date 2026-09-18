package bai07;

import java.util.Arrays;
import java.util.Comparator;

public class Management {

    private Person[] ds;
    private int count;

    public Management(int n) {
        ds = new Person[n];
        count = 0;
    }

    public boolean them(Person p) {

        if (count == ds.length)
            return false;

        ds[count++] = p;
        return true;
    }

    public boolean xoa(String hoTen) {

        for (int i = 0; i < count; i++) {

            if (ds[i].getHoTen()
                    .equalsIgnoreCase(hoTen)) {

                for (int j = i; j < count - 1; j++) {
                    ds[j] = ds[j + 1];
                }

                ds[--count] = null;
                return true;
            }
        }

        return false;
    }

    public void sapXepTheoTen() {

        Arrays.sort(ds, 0, count,
                Comparator.comparing(Person::getHoTen));
    }

    public void xuatDanhSach() {

        for (int i = 0; i < count; i++) {
            System.out.println(ds[i]);
        }
    }
}