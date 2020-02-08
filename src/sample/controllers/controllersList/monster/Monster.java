package sample.controllers.controllersList.monster;

public class Monster {

   private String name;
    private String type;
    private int hp;
    private int lvl;
    private  String desctiption;
    private  int indexMonster;
      static int indexMonsterCounter =0;

    public Monster(String name, String type, int hp, int lvl, String desctiption) {
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.lvl = lvl;
        this.desctiption = desctiption;
        indexMonster = indexMonsterCounter;
        indexMonsterCounter++;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public String getDesctiption() {
        return desctiption;
    }

    public void setDesctiption(String desctiption) {
        this.desctiption = desctiption;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", hp=" + hp +
                ", lvl=" + lvl +
                ", desctiption='" + desctiption + '\'' +
                ", indexMonster=" + indexMonster +
                '}';
    }
}
