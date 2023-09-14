/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) { return node; }
        if (node.neighbors.isEmpty()) { return copyOf(node); }

        ArrayList<Node> visited = new ArrayList<Node>();
        ArrayList<Node> newNodes = new ArrayList<Node>();
        Queue<Node> q = new ArrayDeque<Node>();
        Node startNode = node;
        q.offer(node);
        while (!q.isEmpty()) {
            Node vertex = q.poll();
            if (!visited.contains(vertex)) {
                for (Node adj : vertex.neighbors) {
                    q.offer(adj);
                }
                visited.add(vertex);
            }
        }
        for (Node n : visited) {
            newNodes.add(copyOf(n));
        }
        for (Node n : newNodes) {
            if (n.val == 1) {
                startNode = n;
            }
            List<Node> newAdjs = new ArrayList<Node>();
            for (Node adj : n.neighbors) {
                for (Node n2 : newNodes) {
                    if (adj.val==n2.val) {
                        newAdjs.add(n2);
                    }
                }
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