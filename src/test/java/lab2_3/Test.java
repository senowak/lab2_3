package lab2_3;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;

import edu.iis.mto.similarity.SimilarityFinder;

public class Test {

    SimilarityFinder test = new SimilarityFinder(null);
    private int saq[] = new int[50];
    private int seq[] = new int[100];
    private int emptySeq[] = new int[0];

    @Before
    public void initTest() {
        for (int i = 0; i < 100; i++) {
            seq[i] = i + 1;
        }
        for (int i = 0; i < 50; i++) {
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

}
