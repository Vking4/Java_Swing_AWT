import java.awt.Color;
import java.util.Random;



public class GameModel {
    
    private Color randomColor;
    private Color userColor;
    
    private final Random random;
    
    public GameModel() {
        this.random = new Random();
    }
    
    public void createColors() {
        setRandomColor();
        setUserColor();
    }

    public Color getUserColor() {
        return userColor;
    }

    public void setUserColor() {
        int userRed = 0;
        int userGrn = 0;
        int userBlu = 0;
        this.userColor = new Color(userRed, userGrn, userBlu);
    }
    
    public void setUserColor(int red, int green, int blue) {
        this.userColor = new Color(red, green, blue);
    }

    public Color getRandomColor() {
        return randomColor;
    }

    public void setRandomColor() {
        int randRed = (random.nextInt(17) + 1) * 15;
        int randGrn = (random.nextInt(17) + 1) * 15;
        int randBlu = (random.nextInt(17) + 1) * 15;
        this.randomColor = new Color(randRed, randGrn, randBlu);
    }
}
    