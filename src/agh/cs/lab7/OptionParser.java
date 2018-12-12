package agh.cs.lab7;

import java.util.Arrays;

public class OptionParser {
    public String[] commands;
    public OptionParser(String[] commands){
        this.commands = commands;
    }

    public MoveDirection[] parse(){
        MoveDirection[] result = new MoveDirection[this.commands.length];
        int j = 0;
        for (int i = 0; i < this.commands.length; i++){
            switch (this.commands[i]) {
                case "forward":
                case "f":
                    result[j++] = MoveDirection.FORWARD;
                    break;
                case "backward":
                case "b":
                    result[j++] = MoveDirection.BACKWARD;
                    break;
                case "right":
                case "r":
                    result[j++] = MoveDirection.RIGHT;
                    break;
                case "left":
                case "l":
                    result[j++] = MoveDirection.LEFT;
                    break;
                default:
                    throw new IllegalArgumentException(commands[i] + " is not legal move specification");

            }
        }
        if (j != this.commands.length)
            result = Arrays.copyOfRange(result,0,j);
        return result;
    }
}

