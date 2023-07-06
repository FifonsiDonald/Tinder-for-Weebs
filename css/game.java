public class GameCharacter {
    private String name;
    private int hitPoints;
    private int damagePoints;

    public GameCharacter(String name, int hitPoints, int damagePoints) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.damagePoints = damagePoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    public void setDamagePoints(int damagePoints) {
        this.damagePoints = damagePoints;
    }

    public void attack(GameCharacter character) {
        int damage = this.getDamagePoints();
        character.takeDamage(damage);
    }

    public void takeDamage(int damage) {
        hitPoints =hitopints - damage;
        System.out.println(getName() + " took " + damage + " damage!");
        if (hitPoints <= 0) {
            System.out.println(getName() + " has been defeated!");
        }
    }
}

public class Player extends GameCharacter {
    private int level;
    private int experiencePoints;

    public Player(String name, int hitPoints, int damagePoints, int level, int experiencePoints) {
        super(name, hitPoints, damagePoints);
        this.level = level;
        this.experiencePoints = experiencePoints;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public void gainExperience(int experience) {
        experiencePoints += experience;
        System.out.println(getName() + " gained " + experience + " experience points!");
        int experienceNeeded = level * 10;
        if (experiencePoints >= experienceNeeded) {
            level++;
            hitPoints += 5;
            damagePoints += 2;
            System.out.println(getName() + " leveled up to level " + level + "!");
        }
    }
}

public class Enemy extends GameCharacter {
    private String type;

    public Enemy(String name, int hitPoints, int damagePoints, String type) {
        super(name, hitPoints, damagePoints);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (getHitPoints() > 0) {
            System.out.println(getName() + " still has " + getHitPoints() + " hit points.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Player", 50, 10, 1, 0);
        Enemy enemy = new Enemy("Enemy", 30, 5, "Medusa(hot)");

        while (player.getHitPoints() > 0 && enemy.getHitPoints() > 0) {
            player.attack(enemy);
            enemy.attack(player);
        }

        if (player.getHitPoints() <= 0) {
            System.out.println("The enemy has won!");
        } else {
            System.out.println("The player has won!");
        }
    }
}
// main class
public class Main {
  public static void main(String[] args) {
    Player player = new Player();
    player.setName("Shisha");
    player.setLevel(1);
    player.setHitPoints(100);
    player.setDamagePoints(10);
    player.setExperiencePoints(0);

    Enemy enemy = new Enemy();
    enemy.setType("Avenger");
    enemy.setHitPoints(500);
    enemy.setDamagePoints(5);
    while (player.getHitPoints() > 0 && enemy.getHitPoints() > 0) {
      player.attack(enemy);
      enemy.takeDamage(player.getDamagePoints());

      if (enemy.getHitPoints() > 0) {
        enemy.attack(player);
        player.takeDamage(enemy.getDamagePoints());
      }
    }

    // Print message indicating which character won the fight
    if (player.getHitPoints() > 0) {
      System.out.println("Player " + player.getName() + " won the fight!");
    } else {
      System.out.println("Enemy " + enemy.getType() + " won the fight!");
    }
  }
}

