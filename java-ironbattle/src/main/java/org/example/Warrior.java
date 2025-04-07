package org.example;
import java.util.Random;

public class Warrior extends Character implements Attacker {
    private int stamina;
    private int strength;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        setStamina(stamina);
        setStrength(strength);
    }

    public int getStamina() {
        return stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStamina(int stamina) {
        if(stamina > 50){
            System.out.println("La stamina no puede superar 50");
        } else if (stamina <= 0) {
            System.out.println("La stamina no puede ser menor que 1");
        } else {
            this.stamina = stamina;
        }
    }

    public void setStrength(int strength) {
        if(strength > 10){
            System.out.println("La fuerza no puede superar 10");
        }else if (strength <= 0) {
            System.out.println("La fuerza no puede ser menor que 1");
        } else {
        this.strength = strength;
        }
    }

    /*    // Setters
        public void setStamina() {
            this.stamina = ThreadLocalRandom.current().nextInt(10, 51);
        }

        public void setStrength() {
            this.strength = ThreadLocalRandom.current().nextInt(1, 11);
        }
    */
    @Override
    public void attack(Character character) {
        Random random = new Random();
        boolean heavyAttack = random.nextBoolean(); // devuelve true o false random
        int damage = 0;

        if (heavyAttack && stamina >= 5) {
            // sale heavy Attack
            damage = strength;
            stamina -= 5;
            System.out.println(getName() + "hace un HEAVY ATTACK!!!");
        } else if (stamina >= 1) {
            // sale weak Attack
            damage = strength / 2;
            stamina += 1;
            System.out.println(getName() + "hace un WEAK ATTACK!");
        } else {
            // No queda stamina
            stamina += 2;
            System.out.println(getName() + " necesita descansar y recuperar stamina...");
        }

        // Quitar la vida
        int newHp = character.getHp() - damage;
        character.setHp(newHp);

        System.out.println(getName() + " hace " + damage + " puntos de daño a " + character.getName() +
                ". A" + character.getName() + " le quedan " + character.getHp() + " puntos de HP.");
    }

}
