# Runtime: 5930 ms, faster than 5.03% of Python3 online submissions for Find if Path Exists in Graph.
# Memory Usage: 352.6 MB, less than 5.14% of Python3 online submissions for Find if Path Exists in Graph.

class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        
        if source == destination:
            return True
        
        # build graph
        graph = defaultdict(set)
        for a, b in edges:
            graph[a].add(b)
            graph[b].add(a)
            
        # traverse
        visited = set()
        if self.findPath(graph, visited, source, destination):
            return True
            
        return False
    
    def findPath(self, graph: dict, visited: set, src: int, dest: int):
        if (src, dest) in visited:
            return False

        visited.add((src, dest))    
        
        for node in graph[src]:
            if node == dest:
                return True
            if self.findPath(graph, visited, node, dest):
                return True
            
        return False
