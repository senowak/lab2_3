package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class Seacher implements SequenceSearcher {

    private static int licznik;

    public Seacher() {
        licznik = 0;
    }

    @Override
    public SearchResult search(int key, int[] seq) {
        licznik++;

        return SearchResult.builder()
                           .withFound(true)
                           .build();
    }

    public int getLicznik() {
        return licznik;
    }
}
