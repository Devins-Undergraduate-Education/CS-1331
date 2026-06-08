public class Warrior extends PartyMember {
    private String weapon;
    private int armorClass;

    public Warrior(String characterName, int health, int baseAttack, String weapon, int armorClass) {
        super(characterName, health, baseAttack);
        this.weapon = weapon;
        this.armorClass = armorClass; 
    }

    public String toString() {
        return "Hello, world";
    }

    public boolean equals(Object o) {
        return false;
    }

    public int questLevel() {
        return -1; 
    }
}