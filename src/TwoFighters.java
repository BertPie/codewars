public class TwoFighters {
    public static void main(String[] args) {

    }

    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        Match match = new Match(fighter1, fighter2, firstAttacker);
        return match.start();
    }

    public static class Match {
        Fighter[] fighters = new Fighter[2];

        public Match(Fighter fighter1, Fighter fighter2, String firstAttacker) {
            if (fighter1.name == firstAttacker) {
                this.fighters[0] = fighter1;
                this.fighters[1] = fighter2;
            } else {
                this.fighters[0] = fighter2;
                this.fighters[1] = fighter1;

            }
        }

        public String start(){
            String winner = "Hello world!";
            boolean gameOver = false;
            while(!gameOver){
                if(attack(0,1)){
                    if(!attack(1,0)){
                        winner = fighters[1].name;
                        gameOver = true;
                    }
                }else{
                    winner = fighters[0].name;
                    gameOver = true;
                }
            }
            return winner;
        }

        private boolean attack(int attacker, int defender){
            fighters[defender].health -= fighters[attacker].damagePerAttack;
            // false is death
            return (fighters[defender].health <= 0) ? false : true;
        }

    }

    public class Fighter {
        public String name;
        public int health, damagePerAttack;

        public Fighter(String name, int health, int damagePerAttack) {
            this.name = name;
            this.health = health;
            this.damagePerAttack = damagePerAttack;
        }

    }
}

/**
 * Create a function that returns the name of the winner in a fight between two fighters.
 * <p>
 * Each fighter takes turns attacking the other and whoever kills the other first is victorious. Death is defined as having health <= 0.
 * <p>
 * Each fighter will be a Fighter object/instance. See the Fighter class below in your chosen language.
 * <p>
 * Both health and damagePerAttack (damage_per_attack for python) will be integers larger than 0. You can mutate the Fighter objects.
 * <p>
 * Example:
 * public class Fighter {
 * public String name;
 * public int health, damagePerAttack;
 * public Fighter(String name, int health, int damagePerAttack) {
 * this.name = name;
 * this.health = health;
 * this.damagePerAttack = damagePerAttack;
 * }
 * }
 */