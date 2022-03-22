package game;

import game.entities.*;
import game.exceptions.StrikeConditionNotMetException;
import game.exceptions.StrikeFailedException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {

    private final Group m_charactersGroup;
    private final Group m_monstersGroup;

    private float m_charactersLoot;


    public Game() {
        this.m_charactersGroup = new Group();
        this.m_monstersGroup = new Group();
        this.m_charactersLoot = 0;
    }

    public static void main(String[] args) {

        Game game = new Game();

        Archer archer = new Archer("Artemis", 20, 100
                , 22, "Helia",
                10);

        Warrior warrior = new Warrior("Hercule", 10, 200,
                25, "Alfi",
                10);

        Rogue rogue = new Rogue("Loki", 15, 150,
                18, "Veron",
                .2f);

        game.addCharacter(archer);
        game.addCharacter(warrior);
        game.addCharacter(rogue);

        Monster skeleton = new Monster("Skeleton", 15, 100,
                50f);
        Monster goblin = new Monster("Goblin", 50, 25,
                100f);
        Monster goblinB = new Monster(goblin);
        Monster troll = new Monster("Troll", 5, 250,
                25f);

        game.addMonster(skeleton);
        game.addMonster(goblin);
        game.addMonster(goblinB);
        game.addMonster(troll);

        boolean exit = false;
        int choice;
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            game.menu();
            choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    game.sortByHealth();
                    game.doTurn();
                    exit = game.endTurn();
                    break;
                default:
                case 2:
                    game.sortByHealth();
                    game.display();
                    break;
            }
        }

    }

    private void sortByHealth() {

        Collections.sort(this.m_charactersGroup.getGroup());
        Collections.sort(this.m_monstersGroup.getGroup());
    }


    private void display() {

        System.out.println("Characters: ");
        System.out.println("Gold: " + this.m_charactersLoot);
        for (Entity entity : this.m_charactersGroup.getGroup()) {
            System.out.println(entity.toString());
        }

        System.out.println("Monsters: ");
        for (Entity entity : this.m_monstersGroup.getGroup()) {
            System.out.println(entity.toString());
        }
    }

    private void doTurn() {

        try {
            m_charactersGroup.getOneEntity().strikeTarget(m_monstersGroup.getOneEntity());
        } catch (StrikeFailedException | StrikeConditionNotMetException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                m_monstersGroup.getOneEntity().strikeTarget(m_charactersGroup.getOneEntity());
            } catch (StrikeFailedException | StrikeConditionNotMetException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    private boolean endTurn() {

        removeNullHealthEntity(this.m_charactersGroup.getGroup());
        removeNullHealthEntity(this.m_monstersGroup.getGroup());
        boolean exit = false;

        if (this.m_charactersGroup.getGroup().size() == 0) {
            System.out.println("The characters have been defeated");
            exit = true;
        }
        if (this.m_monstersGroup.getGroup().size() == 0) {
            System.out.println("The monsters have been defeated");
            exit = true;
        }

        return exit;

    }

    public void removeNullHealthEntity(ArrayList<Entity> _entities) {
        _entities.removeIf(element -> {

            if (element.getHealth() <= 0) {
                if (element instanceof Monster) {
                    this.addToLoot(((Monster) element).getLoot());
                }

                System.out.println(element.getName() + " has been defeated.");
                return true;
            }
            return false;
        });
    }

    private void menu() {
        System.out.println("Menu");
        System.out.println("0: Exit");
        System.out.println("1: Do Turn");
        System.out.println("2: Display Groups");
        System.out.print("Choice: ");
    }

    public void addCharacter(Entity _entity) {
        this.m_charactersGroup.addToGroup(_entity);
    }

    public void addMonster(Entity _entity) {

        this.m_monstersGroup.addToGroup(_entity);

    }

    public void addToLoot(float _lootToAdd) {
        this.m_charactersLoot += _lootToAdd;
    }

}
