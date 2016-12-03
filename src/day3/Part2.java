package day3;

/**
 * Created by oisin on 12/3/16.
 */
public class Part2 extends Part {
    public int[][] getTriangles(String[] commands) {
        int[][] triangles = new int[commands.length][3];
        for(int triangleIndex = 0; triangleIndex < commands.length; triangleIndex++) {
            String command = commands[triangleIndex];
            for(int side = 0; side < 3; side++) {
                int number = Integer.parseInt(command.split(" ")[side]);

                int triangleNumber = ((triangleIndex / 3) * 3) + side;
                int sideNumber = (int)Math.round((((double)triangleIndex / 3.0) - (triangleIndex / 3)) * 3.0);
                triangles[triangleNumber][sideNumber] = number;
            }
        }
        return triangles;
    }
}
