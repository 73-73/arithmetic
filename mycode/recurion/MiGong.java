package mycode.recurion;

/**
 * 迷宫问题，利用递归回溯找到到达出口的通路
 *
 * @author pan
 * @create 2019-12-03-9:22
 */
public class MiGong {
    public static void main(String[] args) {
        int[][] map = setMap(6);
        map[2][1] = 1;
        map[2][2] = 1;
        printMap(map);
        findWay(map, 1, 1, 4, 4);
        printMap(map);
    }

    /**
     * 二维数组为1：墙或者障碍物，2：此路已走过，3：不通
     *
     * @param map 迷宫二维数组
     * @param i   起点纵坐标
     * @param j   起点横坐标
     * @param m   终点纵坐标
     * @param n   终点横坐标
     * @return
     */
    public static boolean findWay(int[][] map, int i, int j, int m, int n) {
        if (map[m][n] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) { //按左 下 右 上 策略走
                map[i][j] = 2;
                if (findWay(map, i, j - 1, m, n)) {
                    return true;
                } else if (findWay(map, i + 1, j, m, n)) {
                    return true;
                } else if (findWay(map, i, j + 1, m, n)) {
                    return true;
                } else if (findWay(map, i - 1, j, m, n)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else return false;
        }
    }

    /**
     * 构造地图
     * 1:墙  2：障碍物
     *
     * @return
     */
    public static int[][] setMap(int length) {
        //8*8的二维数组
        int[][] map = new int[length][length];
        for (int i = 0; i < length; i++) {
            map[0][i] = 1;
            map[length - 1][i] = 1;
            map[i][0] = 1;
            map[i][length - 1] = 1;
        }
        return map;
    }

    public static void printMap(int[][] map) {
        System.out.println("***********************************************");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.printf(" %d ", map[i][j]);
            }
            System.out.println();
        }
    }
}
