package com.playground.practice.codility.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution1 {

    static List<List<Integer>> optimalUtilization(int maxTravelDist,
                                           List<List<Integer>> forwardRouteList,
                                           List<List<Integer>> returnRouteList)
    {
        if(forwardRouteList == null || forwardRouteList.isEmpty() || returnRouteList == null || returnRouteList.isEmpty())
            return new ArrayList<>();

        PriorityQueue<Route> routes = new PriorityQueue<>();
        List<List<Integer>> results = new ArrayList<>();

        for(int i=0; i<forwardRouteList.size(); i++) {

            // If the distance is more than maxTravelDist then all the cartesian products will be more than maxTravelDist. So ignore the item.
            if(forwardRouteList.get(i).get(1) >= maxTravelDist) {
                continue;
            }

            for(int j=0; j<returnRouteList.size(); j++) {

                // If the distance is more than maxTravelDist then all the cartesian products will be more than maxTravelDist. So ignore the item.
                if(returnRouteList.get(j).get(1) >= maxTravelDist) {
                    continue;
                }

                int dist = forwardRouteList.get(i).get(1) + returnRouteList.get(j).get(1);
                if(dist <= maxTravelDist) {
                    routes.add(new Route(forwardRouteList.get(i).get(0),
                            returnRouteList.get(j).get(0),
                            dist));
                }
            }
        }

        while(true) {
            Route route = routes.poll();
            int dist = route.getDistance();
            results.add(Arrays.asList(route.getId1(), route.getId2()));

            route = routes.peek();
            if(route.getDistance() != dist) {
                break;
            }
        }

        return results;
    }

    public static void main(String[] args) {
        List<List<Integer>> resultList = optimalUtilization(10000,
                Arrays.asList(Arrays.asList(1, 3000), Arrays.asList(2, 5000), Arrays.asList(3, 7000), Arrays.asList(4, 10000)),
                Arrays.asList(Arrays.asList(1, 2000), Arrays.asList(2, 3000), Arrays.asList(3, 4000), Arrays.asList(4, 5000)));
        System.out.println();;
    }

    private static class Route implements Comparable<Route> {
        int id1;
        int id2;
        int distance;

        public Route(int id1, int id2, int distance) {
            this.id1 = id1;
            this.id2 = id2;
            this.distance = distance;
        }

        public int getId1() {
            return id1;
        }

        public void setId1(int id1) {
            this.id1 = id1;
        }

        public int getId2() {
            return id2;
        }

        public void setId2(int id2) {
            this.id2 = id2;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        @Override
        public int compareTo(Route o) {
            if(this.distance < o.distance) return 1;
            if(this.distance > o.distance) return -1;
            return 0;
        }
    }
}
