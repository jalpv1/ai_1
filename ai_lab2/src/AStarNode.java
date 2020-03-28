public class AStarNode {
    int g;
    int f;
    int h;
 public int heuristic(Node node){
     //розраховуємо наскільки вершина відріхняється від очікуваного нами стану - наскільки вона близька до цілі
     return Math.abs(node.getSmallMonkeysRight()+node.getBigMonkeysRight()+node.getPeopleRight())
             -(node.getSmallMonkeysLeft()+node.getBigMonkeysLeft()+node.getPeopleLeft())  ;

 }
    public void countHeuristic(Node node){
        f = Math.abs(heuristic(node)) ;

    }
}
