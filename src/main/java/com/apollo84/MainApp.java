package com.apollo84;

import java.util.List;
import java.util.Arrays;
import com.apollo84.patterns.Builder;
import com.apollo84.patterns.ChainResponsibility;
import com.apollo84.patterns.Demonstator;
import com.apollo84.patterns.Strategy;

public class MainApp {
    public static void main(String[] args) {
        List<Demonstator> patterns = Arrays.asList(new Strategy(),
                                                   new ChainResponsibility(),
                                                   new Builder());
        patterns.forEach(Demonstator::demonstrate);
    }
}
