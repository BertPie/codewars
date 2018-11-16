public class Ghost {
    private String color;

    public Ghost(){
        this.color = randomColor();
    }

    public String randomColor(){
        String color = "";
        int random = (int) (Math.random()*4);
        switch (random){
            case 0:
                color = "white";
                break;
            case 1:
                color = "yellow";
                break;
            case 2:
                color = "purple";
                break;
            default:
                color = "red";
                break;
        }
        return color;
    }

    public String getColor() {
        return color;
    }
}

/** Create a class Ghost

 Ghost objects are instantiated without any arguments.

 Ghost objects are given a random color attribute of white" or "yellow" or "purple" or "red" when instantiated

 Ghost ghost = new Ghost();
 ghost.getColor(); //=> "white" or "yellow" or "purple" or "red"
*/