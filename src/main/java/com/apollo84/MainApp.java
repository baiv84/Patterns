package com.apollo84;

import java.util.List;
import java.util.Arrays;
import com.apollo84.patterns.*;

public class MainApp {
    public static void main(String[] args) {
        List<Demonstator> patterns = Arrays.asList(new Strategy(),
                                                   new ChainResponsibility(),
                                                   new Builder(),
                                                   new Proxy(),
                                                   new Decorator()
        );
        patterns.forEach(Demonstator::demonstrate);
    }
}
