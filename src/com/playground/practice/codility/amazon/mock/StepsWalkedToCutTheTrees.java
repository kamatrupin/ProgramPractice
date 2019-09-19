package com.playground.practice.codility.amazon.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map:
 *
 * 0 represents the obstacle can't be reached.
 * 1 represents the ground can be walked through.
 * The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the tree's height.
 *
 *
 * You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height first. And after cutting, the original place has the tree will become a grass (value 1).
 *
 * You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. If you can't cut off all the trees, output -1 in that situation.
 *
 * You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [1,2,3],
 *  [0,0,4],
 *  [7,6,5]
 * ]
 * Output: 6
 *
 *
 * Example 2:
 *
 * Input:
 * [
 *  [1,2,3],
 *  [0,0,0],
 *  [7,6,5]
 * ]
 * Output: -1
 *
 *
 * Example 3:
 *
 * Input:
 * [
 *  [2,3,4],
 *  [0,0,5],
 *  [8,7,6]
 * ]
 * Output: 6
 * Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly without walking.
 *
 */
public class StepsWalkedToCutTheTrees {

    private static final int [] xIndex = {0, -1, -1, -1, 0, 1, 1, 1};
    private static final int [] yIndex = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int count = 0;

    public int cutOffTree(List<List<Integer>> forest) {

        // Count number of trees to cut in the forest
        int numberOfTreesToCut = 0;
        for(int i=0; i<forest.size(); i++) {
            for(int j=0; j<forest.get(i).size(); j++) {
                if(!(i == 0 && j == 0) && forest.get(i).get(j) > 1) {
                    numberOfTreesToCut++;
                }
            }
        }

        if(forest.get(0).get(0) > 1) {
            forest.get(0).set(0, 1);
        }

        countSteps(0, 0, forest);

        return numberOfTreesToCut != count ? -1 : count;
    }

    private void countSteps(int i, int j, List<List<Integer>> forest) {
        for(int n=0; n<xIndex.length; n++) {
            if(i + xIndex[n] >= 0 && i + xIndex[n] < forest.get(i).size()
                && j + yIndex[n] >= 0 && j + yIndex[n] < forest.get(i).size()
                && forest.get(i + xIndex[n]).get(j + yIndex[n]) != 0
                && forest.get(i + xIndex[n]).get(j + yIndex[n]) > 1) {
                forest.get(i + xIndex[n]).set(j + yIndex[n], 1);
                count++;
                countSteps(i + xIndex[n], j + yIndex[n], forest);
            }
        }
    }

    public static void main(String[] args) {
        StepsWalkedToCutTheTrees obj = new StepsWalkedToCutTheTrees();

        List<List<Integer>> forest = new ArrayList<>();
        forest.add(Arrays.asList(1,2,3));
        forest.add(Arrays.asList(0,0,4));
        forest.add(Arrays.asList(7,6,5));
        System.out.println(obj.cutOffTree(forest));

        count = 0;
        List<List<Integer>> forest1 = new ArrayList<>();
        forest1.add(Arrays.asList(1,2,3));
        forest1.add(Arrays.asList(0,0,0));
        forest1.add(Arrays.asList(7,6,5));
        System.out.println(obj.cutOffTree(forest1));

        count = 0;
        List<List<Integer>> forest2 = new ArrayList<>();
        forest2.add(Arrays.asList(2,3,4));
        forest2.add(Arrays.asList(0,0,5));
        forest2.add(Arrays.asList(8,7,6));
        System.out.println(obj.cutOffTree(forest2));
    }
}
