public abstract class PartyMember {
    protected String characterName;
    protected int health; 
    protected int baseAttack; 
    
    public PartyMember(String characterName, int health, int baseAttack) {
        this.characterName = characterName; 
        this.health = health;
        this.baseAttack = baseAttack;
    }

    public String toString() {
        return "Hello, World";
    }

    public boolean equals(Object o) {
        return true;
    }

    public int questLevel() {
        return -1; 
    }
}