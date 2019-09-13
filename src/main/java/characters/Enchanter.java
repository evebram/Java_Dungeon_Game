package characters;

import behaviours.IAttack;
import behaviours.IDefend;
import items.Familiar;
import items.Spell;

public class Enchanter extends Entity implements IAttack, IDefend {

    private Familiar familiar;
    private Spell spell;

    public Enchanter(String name, String type, int health, Familiar familiar, Spell spell) {
        super(name, type, health);
        this.familiar = familiar;
        this.spell = spell;
    }

    public Familiar getFamiliar() {
        return familiar;
    }

    public int getFamiliarResistance() {
        return familiar.getResistance();
    }

    public Spell getSpell() {
        return spell;
    }

    public int getSpellDamage() {
        return spell.getDamage();
    }

    public void defend(int attackPower){ //int damage
        int postFamiliarDamage = attackPower / familiar.getResistance();
        this.takeDamage(postFamiliarDamage);
    }

    public void attack(IDefend target) { //calls iDefend of attacked
        int attackPower = this.getSpellDamage();
        target.defend(attackPower);
    }
}
