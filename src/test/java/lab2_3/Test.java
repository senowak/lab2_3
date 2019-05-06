package lab2_3;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;

import edu.iis.mto.similarity.Seacher;
import edu.iis.mto.similarity.SimilarityFinder;

public class Test {

    SimilarityFinder test = new SimilarityFinder(new Seacher());
    private int saq[] = new int[5];
    private int seq[] = new int[10];
    private int emptySeq[] = new int[0];

    @Before
    public void initTest() {
        for (int i = 0; i < 10; i++) {
            seq[i] = i + 1;
        }
        for (int i = 0; i < 5; i++) {
            saq[i] = i + 1;
        }

    }

    @org.junit.Test
    public void sekwencjeSaPuste() {
        double result = test.calculateJackardSimilarity(emptySeq, emptySeq);
        assertThat(result, is(1.0));
    }

    @org.junit.Test
    public void totalnieSieNiePokrywaja() {
        double result = test.calculateJackardSimilarity(emptySeq, seq);
        assertThat(result, is(0.0));
    }

    @org.junit.Test
    public void wPolowieSiePokrywaja() {
        double result = test.calculateJackardSimilarity(saq, seq);
        assertThat(result, is(0.5));
    }

    @org.junit.Test
    public void sekwencjeSiePokrywaja() {
        double result = test.calculateJackardSimilarity(seq, seq);
        assertThat(result, is(1.0));
    }

    @org.junit.Test
    public void DublerSeacherNiePokrywaSie() {
        Seacher szukacz = new Seacher();
        SimilarityFinder test2 = new SimilarityFinder(szukacz);
        double result = test2.calculateJackardSimilarity(emptySeq, seq);
        assertThat(result, is(0.0));
    }

    @org.junit.Test
    public void DublerSeacherPokrywaSie() {
        Seacher szukacz = new Seacher();
        SimilarityFinder test2 = new SimilarityFinder(szukacz);
        double result = test2.calculateJackardSimilarity(seq, seq);
        assertThat(result, is(1.0));
    }

    @org.junit.Test
    public void DublerSeacherWPolowieSiePokrywa() {
        Seacher szukacz = new Seacher();
        SimilarityFinder test2 = new SimilarityFinder(szukacz);
        double result = test2.calculateJackardSimilarity(saq, seq);
        assertThat(result, is(0.5));
    }

    @org.junit.Test
    public void ileRazyZostaloUzyte() {
        Seacher szukacz = new Seacher();
        SimilarityFinder test2 = new SimilarityFinder(szukacz);
        test2.calculateJackardSimilarity(seq, seq);
        int result = szukacz.getLicznik();
        assertThat(result, is(10));
    }

}
