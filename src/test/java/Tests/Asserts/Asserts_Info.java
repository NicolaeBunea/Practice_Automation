package Tests.Asserts;

import org.junit.Test;

public class Asserts_Info {

    @Test

    //din cate am inteles eu, assert nu il facem ca sa mai afisam ceva, este pentru a oferi junitului informatia
    //ca testul a picat. Presupun ca pe baza assertului intelege programul ca expected-ul nu este ca si actual result
    //fara sa mai afiseze ceva

    public void assertTest(){
        Integer varsta= 120;
        assert (varsta>30 && varsta<110);
        if (varsta>30){
            System.out.println("Varsta este: "+varsta);
        }
        else {
            System.out.println("Varsta este prea mica: "+varsta);
        }
    }



}
