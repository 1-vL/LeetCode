class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) { return node; }
        if (node.neighbors.isEmpty()) { return copyOf(node); }

        Node[] visited = new Node[101];
        Queue<Node> q = new ArrayDeque<Node>();
        Node startNode = node;
        q.offer(node);
        while (!q.isEmpty()) {
            Node vertex = q.poll();
            if (visited[vertex.val] == null) {
                for (Node adj : vertex.neighbors) {
                    q.offer(adj);
                }
                visited[vertex.val] = vertex;
            }
        }
        for (Node n : visited) {
            if (n != null) {
                visited[n.val] = copyOf(n);
            }            
        }
        for (Node n : visited) {
            if (n == null) {
                continue;
            }            
            if (n.val == 1) {
                startNode = n;
            }
            List<Node> newAdjs = new ArrayList<Node>();
            for (Node adj : n.neighbors) {
                newAdjs.add(visited[adj.val]);
            }
            n.neighbors = newAdjs;
        }
        return startNode;
    }

    public Node copyOf(Node origin) {
        Node result = new Node(origin.val);
        result.neighbors.addAll(origin.neighbors);
        return result;
        // return new Node(origin.val, new ArrayList().addAll(origin.neighbors));
    }
}