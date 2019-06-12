import java.util.*;

public class NetworkRoutes {

    int minimumCostIncurred(int numTotalEdgeNodes,
                            int numTotalAvailableNetworkRoutes,
                            List<List<Integer>> networkRoutesAvailable,
                            int numNewNetworkRoutesConstruct,
                            List<List<Integer>> costNewNetworkRoutesConstruct)
    {

//       Current graphs 1,4 4,5 2,3
//        desired count 3
//        connecting price 1,2,5; 1,3,10
        int cost = 0;
        Map<Integer, Set<Integer>> connectd = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for (List<Integer> list : networkRoutesAvailable) {
            for (Integer node : list) {
                if (connectd.get(node).isEmpty()) {
                    connectd.put(node, new HashSet<>(list));
                } else {
                    Set newSet = connectd.get(node);
                    newSet.addAll(list);
                    connectd.put(node, newSet);
                }
            }
        }

        for (Integer node : connectd.keySet()) {
//            Counting cost based onexisting connections
            int localConnectionCost = 0;
            Set<Integer> singleElement = new
            connectd.put(6, new HashSet<>(6));
            for (int i = 0; i< connectd.puget(node)
            }

        }
        return cost;

    }
    int cost countConnectionCost(int nodeNumber,    )
}
