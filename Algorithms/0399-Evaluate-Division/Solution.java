class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] out = new double[queries.size()];

        for(int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String src = query.get(0), dest = query.get(1);
            out[i] = evaluateQuery(src, dest, graph, new HashMap<>());
        }

        return out;
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for(int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String dividend = equation.get(0), divisor = equation.get(1);
            double value = values[i];

            graph.putIfAbsent(dividend, new HashMap<>());
            graph.putIfAbsent(divisor, new HashMap<>());

            graph.get(dividend).put(divisor, value);
            graph.get(divisor).put(dividend, 1.0 / value);
        }

        return graph;
    }

    private double evaluateQuery(String src, String dest, Map<String, Map<String, Double>> graph, Map<String, Boolean> visited) {
        if(!graph.containsKey(src) || !graph.containsKey(dest))
            return -1.0;
        
        if(src.equals(dest))
            return 1.0;

        visited.put(src, true);
        Map<String, Double> neigh = graph.get(src);

        for(Map.Entry<String, Double> nei : neigh.entrySet()) {
            if(!visited.containsKey(nei.getKey())) {
                double result = evaluateQuery(nei.getKey(), dest, graph, visited);

                if(result != -1.0)
                    return nei.getValue() * result;
            }
        }

        return -1.0;
    }
}
