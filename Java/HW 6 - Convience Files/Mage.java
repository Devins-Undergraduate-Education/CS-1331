public class Mage extends PartyMember {
    private int spellAttack; 
    private int spellSlots;

    public Mage(String characterName, int health, int baseAttack, int spellAttack, int spellSlots) {
        super(characterName, health, baseAttack);
        this.spellAttack = spellAttack;
        this.spellSlots = spellSlots;
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