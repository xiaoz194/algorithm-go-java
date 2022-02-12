package class04_binary_tree;

/**
 * @Classname Code09_PaperFolding
 * @Description 折纸问题
 * 请把一段纸条竖着放在桌子上，然后从纸条的下边向上方对折1次，压出折痕后展开。此时折痕是凹下去的，
 * 即折痕突起的方向指向纸条的背面。如果从纸条的下边向上方连续对折2次，压出折痕后展开，此时有三条折痕，
 * 从上到下依次是下折痕、下折痕和上折痕。 给定一 个输入参数N，代表纸条都从下边向上方连续对折N次，
 * 请从上到下打印所有折痕的方向。例如：
 * N=1时，打印： down
 * N=2时，打印： down down up
 *
 * 思路：
 * 通过实践发现可以转化成一个二叉树的问题：
 * 假设我们把一张纸最开始的情况比作最开的的根节点时，我们把折纸的情况比作一棵二叉树，
 * 我们会发现此棵二叉树的根节点是down(0)，左节点总是down(0),而它的右节点总是up(1)。
 *                    0
 *                0      1
 *             0    1  0    1
 *         ...
 **/
public class Code09_PaperFolding {
    public static void printAllFolds(int n){
        printProcess(1,n,true);
    }

    //i是节点的层数，n是一共的层数，down=true down down=fasle up
    private static void printProcess(int i, int n, boolean down) {
        if(i > n){
            return;
        }
        printProcess(i+1,n,true);
        System.out.println(down?"down":"up");
        printProcess(i+1,n,false);
    }

    public static void main(String[] args) {
        int n= 2;
        printAllFolds(n);
    }
}
