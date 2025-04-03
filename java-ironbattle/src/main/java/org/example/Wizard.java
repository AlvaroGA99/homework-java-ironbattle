package org.example;

import java.util.Random;

public class Wizard extends Character implements Attacker {
    private int mana;
    private int intelligence;

    public Wizard(String name, int hp) {
        super(name, hp);
        setMana((int) (Math.random() * (51 - 10)) + 10);
        setIntelligence((int) (Math.random() * (51 - 1)) + 1);
    }

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        setMana(mana);
        setIntelligence(intelligence);
    }


    @Override
    public void setHp(int hp) {
        if (hp < 50 || hp > 100) {
            System.out.println("Error la vida está fuera de rango: 50 - 100");
        } else {
            super.setHp(hp);
        }
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana < 1 || mana > 50) {
            System.out.println("Error mana range must be 1 - 50");
        } else {
            this.mana = mana;
        }
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        if (intelligence < 1 || intelligence > 10) {
            System.out.println("Error mana range must be 1 - 10");
        } else {
            this.intelligence = intelligence;
        }
    }

    @Override
    public void attack(Character target) {
        String[] attacks = {"Fireball", "Staff hit"};
        Random random = new Random();
        int R = random.nextInt(attacks.length);
        String attack = attacks[R];
        System.out.println(getName() + ": va a atacar con " + attack);

        switch (attack) {
            case "Fireball":
                fireballAttack(target);
                break;
            case "Staff hit":
                staffHitAttack(target);
                break;
        }
    }

    private void fireballAttack(Character target) {
        System.out.println("Lanzando ataque de bola de fuego");
        if (this.mana < 0) {
            System.out.println(getName() + ": no tiene suficiente mana, usar el ataque de bola de fuego");
            staffHitAttack(target);
        } else {
            target.setHp(target.getHp() - this.intelligence);
            setMana(getMana() - 5);
        }
    }

    private void staffHitAttack(Character target) {
        System.out.println("Lanzando ataque de bastón");
        if (this.mana <= 0) {
            setMana(getMana() + 2);
        } else {
            target.setHp(target.getHp() - 2);
            setMana(getMana() + 1);
        }
    }
}
