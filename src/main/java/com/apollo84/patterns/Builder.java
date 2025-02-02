package com.apollo84.patterns;

enum GUN_TYPE { SMOOTH, RIFLED }

class Weapon {
    String caliber;
    Integer minimalExperience;
    GUN_TYPE type;

    public void setCaliber(String caliber) { this.caliber = caliber; }
    public void setMinimalExperience(Integer minimalExperience) { this.minimalExperience = minimalExperience; }
    public void setType(GUN_TYPE type) { this.type = type; }

    @Override
    public String toString() {
        return "Weapon{" + "caliber='" + caliber + '\'' + ", minimalExperience=" + minimalExperience + ", type=" + type + '}';
    }
}

abstract class WeaponBuilder {
    Weapon weapon;

    void createWeapon() { weapon = new Weapon(); }
    Weapon getWeapon() { return weapon; }

    abstract void buildCaliber();
    abstract void buildMinimalYearsOfExperience();
    abstract void buildGunType();
}

class SmoothWeaponBuilder extends WeaponBuilder {
    @Override
    void buildCaliber() { weapon.setCaliber("12 калибр"); }

    @Override
    void buildMinimalYearsOfExperience() { weapon.setMinimalExperience(1); }

    @Override
    void buildGunType() { weapon.setType(GUN_TYPE.SMOOTH); }
}

class RifledWeaponBuilder extends WeaponBuilder {
    @Override
    void buildCaliber() { weapon.setCaliber("7.62x39"); }

    @Override
    void buildMinimalYearsOfExperience() { weapon.setMinimalExperience(5); }

    @Override
    void buildGunType() { weapon.setType(GUN_TYPE.RIFLED); }
}

class Director {
    WeaponBuilder builder;
    public Director(WeaponBuilder builder) { this.builder = builder;}
    void setBuilder(WeaponBuilder builder) {this.builder = builder;}

    Weapon buildWeapon() {
        builder.createWeapon();
        builder.buildCaliber();
        builder.buildGunType();
        builder.buildMinimalYearsOfExperience();
        return builder.getWeapon();
    }
}

final public class Builder implements Demonstator {
    @Override
    public void demonstrate() {
        System.out.println("\n***********************\nПАТТЕРН - СТРОИТЕЛЬ\n***********************\n");
        Director director = new Director(new RifledWeaponBuilder());
        Weapon weapon1 = director.buildWeapon();
        System.out.println(weapon1);
        director.setBuilder(new SmoothWeaponBuilder());
        Weapon weapon2 = director.buildWeapon();
        System.out.println(weapon2);
    }
}