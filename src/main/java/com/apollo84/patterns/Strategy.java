package com.apollo84.patterns;

import java.util.Arrays;

interface AttackStrategy {
    void attack();
}

class BoxingAttackStrategy implements AttackStrategy {
    @Override
    public void attack() { System.out.println("Пробиваю двоечку по корпусу..."); }
}

class KarateAttackStrategy implements AttackStrategy {
    @Override
    public void attack() { System.out.println("Пробиваю маваши гери (круговой удар) в голову"); }
}

class WrestlingAttackStrategy implements AttackStrategy {
    @Override
    public void attack() { System.out.println("Бросаю через спину и добиваю на земле"); }
}

class Fighter {
    protected AttackStrategy strategy;

    public void begin() { System.out.println("\n***********************\nПриветствую соперника, начинаю бой"); }

    public void doFight() { strategy.attack(); }

    public void end() { System.out.println("Благодарю соперника за поединок, делаю поклон судьям"); }
}

class Boxer extends Fighter {
    public Boxer() { this.strategy = new BoxingAttackStrategy(); }
}

class Karateka extends Fighter {
    public Karateka() { this.strategy = new KarateAttackStrategy(); }
}

class Wrestler extends Fighter {
    public Wrestler() { this.strategy = new WrestlingAttackStrategy(); }
}

final public class Strategy implements Demonstator {
    private final Fighter[] fighters = new Fighter[] { new Boxer(), new Karateka(), new Wrestler() };

    @Override
    public void demonstrate() {
        System.out.println("\n***********************\nПАТТЕРН - СТРАТЕГИЯ\n***********************\n");
        Arrays.stream(fighters).forEach(fight -> {
            fight.begin();
            fight.doFight();
            fight.end();
        });
    }
}
