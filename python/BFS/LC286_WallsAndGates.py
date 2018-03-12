You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4

您将获得一个使用这三个可能值初始化的 m×n 2D 网格。
-1 - 墙壁或障碍物。
0 - 门。
INF - Infinity是一个空房间。我们使用值 2 ^ 31 - 1 = 2147483647 来表示INF，您可以假设到门的距离小于 2147483647。
在代表每个空房间的网格中填入到距离最近门的距离。如果不可能到达门口，则应填入 INF。

import Queue
class Solution(object):

    def wallsAndGates(self, rooms):
        """
        :type rooms: List[List[int]]
        :rtype: void Do not return anything, modify rooms in-place instead.
        """
        moves = [(0, -1), (-1, 0), (0, 1), (1, 0)]
        queue = Queue.Queue()
        for i in range(len(rooms)):
            for j in range(len(rooms[i])):
                if rooms[i][j] == 0: queue.put((i, j))
        while not queue.empty():
            pointx, pointy = queue.get()
            for dx, dy in moves:
                # neighbor
                x, y = pointx + dx, pointy + dy
                if not self.inBound(x, y, rooms, pointx, pointy):
                    continue
                rooms[x][y] = rooms[pointx][pointy] + 1
                queue.put((x, y))

    def inBound(self, x, y, rooms, pointx, pointy):
        if x >= 0 and x < len(rooms) and y >= 0 \
        and y < len(rooms[0]) and \
        rooms[x][y] >= rooms[pointx][pointy] + 1:# inf 
            return True
        return False

# dfs recursion
# 0 -> any inf, only increase path level, so it cannot be decreased from last level
# always have neighbor > source, next > curt
class Solution(object):

    def wallsAndGates(self, rooms):
        """
        :type rooms: List[List[int]]
        :rtype: void Do not return anything, modify rooms in-place instead.
        """
        for i in range(len(rooms)):
            for j in range(len(rooms[i])):
                # can be source
                if rooms[i][j] == 0: self.dfs(rooms, i, j, 0)

    def dfs(self, rooms, i, j, val):
        if i < 0 or i >= len(rooms) or j < 0 or j >= len(rooms[i])\
        or rooms[i][j] < val: # -1 
            return 
        rooms[i][j] = val
        moves = [(0, -1), (-1, 0), (0, 1), (1, 0)]
        for dx, dy in moves:
            self.dfs(rooms, i + dx, j + dy, val + 1)









