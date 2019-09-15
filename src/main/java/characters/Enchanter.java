package characters;

import behaviours.IAttack;
import behaviours.IDefend;
import stats.*;

public class Enchanter extends Entity implements IAttack, IDefend {

    private Familiar familiar;
    private Spell spell;

    public Enchanter(Name name, Race race, int health, Familiar familiar, Spell spell) {
        super(name, race, health);
        this.familiar = familiar;
        this.spell = spell;
    }

    public Familiar getFamiliar() {
        return familiar;
    }

    public void changeFamiliar(Familiar familiar) {
        this.familiar = familiar;
    }

    public int getFamiliarResistance() {
        return familiar.getResistance();
    }

    public Spell getSpell() {
        return spell;
    }

    public void changeSpell(Spell spell) {
        this.spell = spell;
    }

    public int getSpellDamage() {
        return spell.getDamage();
    }

    public void defend(int attackPower){ //int damage
        int postFamiliarDamage = attackPower / familiar.getResistance();
        this.takeDamage(postFamiliarDamage);
    }

    public void attack(Entity target) {
        if(target.isAlive()){
            int attackPower = this.getSpellDamage();
            target.defend(attackPower);
        } else {
            collectReward(target);
        }
    }

}
