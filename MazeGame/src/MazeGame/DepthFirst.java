package MazeGame;

import java.util.List;

public class DepthFirst {
 public static boolean searchPath (int[][] maze,int x, int y,
		 List<Integer>path) {
	 if (maze[y][x]==9) {
		 path.add(x);
		 path.add(y);
		 return true;
	 }
	 
	 if (maze[y][x] ==0) {
		 maze[y][x]=2;
		 
		 int dx =-1;
		 int dy = 0;
		 if (searchPath(maze,x+dx,y+dy,path)) {
			 path.add(x);
			 path.add(y);
			 return true;
		 }
		 int dx1 =0;
		 int dy1 = -1;
		 if (searchPath(maze,x+dx1,y+dy1,path)) {
			 path.add(x);
			 path.add(y);
			 return true;
	 }
		 int dx11 =0;
		 int dy11 = 1;
		 if (searchPath(maze,x+dx11,y+dy11,path)) {
			 path.add(x);
			 path.add(y);
			 return true;
			 }
		 }
	 return false;
 }
}
