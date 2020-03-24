

import java.util.ArrayList;
import java.util.List;

public class VariantsCreator {
    private void createNode(List<Node> successors, Node newNode, Node parentNode) {
        if (newNode.isValid()) {
            newNode.setParentNode(parentNode);
            successors.add(newNode);
        }
    }

    ArrayList<Node> generate2(Node node) {
        ArrayList<Node> nodes = new ArrayList<>();
        if (node.getPos() == Bank.LEFT) {
//driver person
            createNode(nodes, new Node(node.getPeopleLeft() - 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft(), node.getPeopleRight() + 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight(), Bank.RIGHT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() - 1, node.getSmallMonkeysLeft() - 1, node.getBigMonkeysLeft(), node.getPeopleRight() + 1, node.getSmallMonkeysRight() + 1, node.getBigMonkeysRight(), Bank.RIGHT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() - 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() - 1, node.getPeopleRight() + 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight() + 1, Bank.RIGHT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() - 2, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft(), node.getPeopleRight() + 2, node.getSmallMonkeysRight(), node.getBigMonkeysRight(),Bank.RIGHT, Driver.PERSON), node);

//driver monkey

            //createNode(nodes,new Node(node.getPeopleLeft(),node.getSmallMonkeysLeft(),node.getBigMonkeysLeft(),node.getPeopleRight()+1,node.getSmallMonkeysRight(),node.getBigMonkeysRight(),Bank.LEFT,Driver.PERSON),node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() - 1, node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() + 1,Bank.RIGHT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft() - 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() - 1, node.getPeopleRight() + 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight() + 1,Bank.RIGHT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft() - 1, node.getBigMonkeysLeft() - 1, node.getPeopleRight(), node.getSmallMonkeysRight() + 1, node.getBigMonkeysRight() + 1,Bank.RIGHT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() - 2, node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() + 2,Bank.RIGHT, Driver.MONKEY), node);


            //  createNode(nodes,new Node(),node);
        } else {
//driver person
            createNode(nodes, new Node(node.getPeopleLeft() + 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft(), node.getPeopleRight() - 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight(), Bank.LEFT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft() + 1, node.getSmallMonkeysLeft() + 1, node.getBigMonkeysLeft(), node.getPeopleRight() - 1, node.getSmallMonkeysRight() - 1, node.getBigMonkeysRight(), Bank.LEFT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() + 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() + 1, node.getPeopleRight() - 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight() - 1, Bank.LEFT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() + 2, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft(), node.getPeopleRight() - 2, node.getSmallMonkeysRight(), node.getBigMonkeysRight(), Bank.LEFT, Driver.PERSON), node);

//driver monkey

            //createNode(nodes,new Node(node.getPeopleLeft(),node.getSmallMonkeysLeft(),node.getBigMonkeysLeft(),node.getPeopleRight()+1,node.getSmallMonkeysRight(),node.getBigMonkeysRight(),Bank.LEFT,Driver.PERSON),node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() + 1, node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() - 1, Bank.LEFT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft() + 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() + 1, node.getPeopleRight() - 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight() - 1, Bank.LEFT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft() + 1, node.getBigMonkeysLeft() + 1, node.getPeopleRight(), node.getSmallMonkeysRight() - 1, node.getBigMonkeysRight() - 1, Bank.LEFT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() + 2, node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() - 2, Bank.LEFT, Driver.MONKEY), node);


        }
        return nodes;
    }


    ArrayList<Node> generate21(Node node) {
        ArrayList<Node> nodes = new ArrayList<>();
        if (node.getPos() == Bank.LEFT) {
//driver person
            createNode(nodes, new Node(node.getPeopleLeft() - 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft(), node.getPeopleRight() , node.getSmallMonkeysRight(), node.getBigMonkeysRight(), Bank.RIGHT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() - 1, node.getSmallMonkeysLeft() - 1, node.getBigMonkeysLeft(), node.getPeopleRight() , node.getSmallMonkeysRight() + 1, node.getBigMonkeysRight(), Bank.RIGHT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() - 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() - 1, node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() + 1, Bank.RIGHT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() - 2, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft(), node.getPeopleRight() + 2, node.getSmallMonkeysRight(), node.getBigMonkeysRight(),Bank.RIGHT, Driver.PERSON), node);

            createNode(nodes, new Node(node.getPeopleLeft() - 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft(), node.getPeopleRight() + 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight(), Bank.RIGHT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() - 1, node.getSmallMonkeysLeft() - 1, node.getBigMonkeysLeft(), node.getPeopleRight() + 1, node.getSmallMonkeysRight() + 1, node.getBigMonkeysRight(), Bank.RIGHT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() - 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() - 1, node.getPeopleRight() + 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight() + 1, Bank.RIGHT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() - 2, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft(), node.getPeopleRight() + 2, node.getSmallMonkeysRight(), node.getBigMonkeysRight(),Bank.RIGHT, Driver.PERSON), node);


//driver monkey

            //createNode(nodes,new Node(node.getPeopleLeft(),node.getSmallMonkeysLeft(),node.getBigMonkeysLeft(),node.getPeopleRight()+1,node.getSmallMonkeysRight(),node.getBigMonkeysRight(),Bank.LEFT,Driver.PERSON),node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() - 1, node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() ,Bank.RIGHT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft() - 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() - 1, node.getPeopleRight() + 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight() ,Bank.RIGHT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft() - 1, node.getBigMonkeysLeft() - 1, node.getPeopleRight(), node.getSmallMonkeysRight() + 1, node.getBigMonkeysRight() ,Bank.RIGHT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() - 2, node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() + 2,Bank.RIGHT, Driver.MONKEY), node);

            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() - 1, node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() + 1,Bank.RIGHT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft() - 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() - 1, node.getPeopleRight() + 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight() + 1,Bank.RIGHT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft() - 1, node.getBigMonkeysLeft() - 1, node.getPeopleRight(), node.getSmallMonkeysRight() + 1, node.getBigMonkeysRight() + 1,Bank.RIGHT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() - 2, node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() + 2,Bank.RIGHT, Driver.MONKEY), node);

            //  createNode(nodes,new Node(),node);
        } else {
//driver person
            createNode(nodes, new Node(node.getPeopleLeft() , node.getSmallMonkeysLeft(), node.getBigMonkeysLeft(), node.getPeopleRight() - 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight(), Bank.LEFT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft() , node.getSmallMonkeysLeft() + 1, node.getBigMonkeysLeft(), node.getPeopleRight() - 1, node.getSmallMonkeysRight() - 1, node.getBigMonkeysRight(), Bank.LEFT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() , node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() + 1, node.getPeopleRight() - 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight() - 1, Bank.LEFT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() + 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft(), node.getPeopleRight() - 2, node.getSmallMonkeysRight(), node.getBigMonkeysRight(), Bank.LEFT, Driver.PERSON), node);


            createNode(nodes, new Node(node.getPeopleLeft() + 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft(), node.getPeopleRight() - 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight(), Bank.LEFT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft() + 1, node.getSmallMonkeysLeft() + 1, node.getBigMonkeysLeft(), node.getPeopleRight() - 1, node.getSmallMonkeysRight() - 1, node.getBigMonkeysRight(), Bank.LEFT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() + 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() + 1, node.getPeopleRight() - 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight() - 1, Bank.LEFT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() + 2, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft(), node.getPeopleRight() - 2, node.getSmallMonkeysRight(), node.getBigMonkeysRight(), Bank.LEFT, Driver.PERSON), node);

//driver monkey

            //createNode(nodes,new Node(node.getPeopleLeft(),node.getSmallMonkeysLeft(),node.getBigMonkeysLeft(),node.getPeopleRight()+1,node.getSmallMonkeysRight(),node.getBigMonkeysRight(),Bank.LEFT,Driver.PERSON),node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() + 1, node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() - 1, Bank.LEFT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft() + 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() + 1, node.getPeopleRight() - 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight() - 1, Bank.LEFT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft() + 1, node.getBigMonkeysLeft() + 1, node.getPeopleRight(), node.getSmallMonkeysRight() - 1, node.getBigMonkeysRight() - 1, Bank.LEFT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() + 2, node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() - 2, Bank.LEFT, Driver.MONKEY), node);

            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() , node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() - 1, Bank.LEFT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft() + 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() , node.getPeopleRight() - 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight() - 1, Bank.LEFT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft() + 1, node.getBigMonkeysLeft(), node.getPeopleRight(), node.getSmallMonkeysRight() - 1, node.getBigMonkeysRight() - 1, Bank.LEFT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() + 1, node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() - 2, Bank.LEFT, Driver.MONKEY), node);

        }
        return nodes;
    }

    ArrayList<Node> generate(Node node) {
        ArrayList<Node> nodes = new ArrayList<>();
        if (node.getPos() == Bank.LEFT) {
//driver person
            createNode(nodes, new Node(node.getPeopleLeft() - 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft(), node.getPeopleRight() , node.getSmallMonkeysRight(), node.getBigMonkeysRight(), Bank.RIGHT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() - 1, node.getSmallMonkeysLeft() - 1, node.getBigMonkeysLeft(), node.getPeopleRight() , node.getSmallMonkeysRight() + 1, node.getBigMonkeysRight(), Bank.RIGHT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() - 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() - 1, node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() + 1, Bank.RIGHT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() - 2, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft(), node.getPeopleRight() + 2, node.getSmallMonkeysRight(), node.getBigMonkeysRight(),Bank.RIGHT, Driver.PERSON), node);

            createNode(nodes, new Node(node.getPeopleLeft() - 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft(), node.getPeopleRight() + 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight(), Bank.RIGHT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() - 1, node.getSmallMonkeysLeft() - 1, node.getBigMonkeysLeft(), node.getPeopleRight() + 1, node.getSmallMonkeysRight() + 1, node.getBigMonkeysRight(), Bank.RIGHT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() - 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() - 1, node.getPeopleRight() + 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight() + 1, Bank.RIGHT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() - 2, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft(), node.getPeopleRight() + 2, node.getSmallMonkeysRight(), node.getBigMonkeysRight(),Bank.RIGHT, Driver.PERSON), node);


//driver monkey

            //createNode(nodes,new Node(node.getPeopleLeft(),node.getSmallMonkeysLeft(),node.getBigMonkeysLeft(),node.getPeopleRight()+1,node.getSmallMonkeysRight(),node.getBigMonkeysRight(),Bank.LEFT,Driver.PERSON),node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() - 1, node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() ,Bank.RIGHT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft() - 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() - 1, node.getPeopleRight() + 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight() ,Bank.RIGHT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft() - 1, node.getBigMonkeysLeft() - 1, node.getPeopleRight(), node.getSmallMonkeysRight() + 1, node.getBigMonkeysRight() ,Bank.RIGHT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() - 2, node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() + 2,Bank.RIGHT, Driver.MONKEY), node);

            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() - 1, node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() + 1,Bank.RIGHT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft() - 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() - 1, node.getPeopleRight() + 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight() + 1,Bank.RIGHT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft() - 1, node.getBigMonkeysLeft() - 1, node.getPeopleRight(), node.getSmallMonkeysRight() + 1, node.getBigMonkeysRight() + 1,Bank.RIGHT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() - 2, node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() + 2,Bank.RIGHT, Driver.MONKEY), node);

            //  createNode(nodes,new Node(),node);
        } else {
//driver person
            createNode(nodes, new Node(node.getPeopleLeft() , node.getSmallMonkeysLeft(), node.getBigMonkeysLeft(), node.getPeopleRight() - 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight(), Bank.LEFT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft() , node.getSmallMonkeysLeft() + 1, node.getBigMonkeysLeft(), node.getPeopleRight() - 1, node.getSmallMonkeysRight() - 1, node.getBigMonkeysRight(), Bank.LEFT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() , node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() + 1, node.getPeopleRight() - 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight() - 1, Bank.LEFT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() + 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft(), node.getPeopleRight() - 2, node.getSmallMonkeysRight(), node.getBigMonkeysRight(), Bank.LEFT, Driver.PERSON), node);


            createNode(nodes, new Node(node.getPeopleLeft() + 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft(), node.getPeopleRight() - 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight(), Bank.LEFT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft() + 1, node.getSmallMonkeysLeft() + 1, node.getBigMonkeysLeft(), node.getPeopleRight() - 1, node.getSmallMonkeysRight() - 1, node.getBigMonkeysRight(), Bank.LEFT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() + 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() + 1, node.getPeopleRight() - 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight() - 1, Bank.LEFT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() + 2, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft(), node.getPeopleRight() - 2, node.getSmallMonkeysRight(), node.getBigMonkeysRight(), Bank.LEFT, Driver.PERSON), node);

//driver monkey

            //createNode(nodes,new Node(node.getPeopleLeft(),node.getSmallMonkeysLeft(),node.getBigMonkeysLeft(),node.getPeopleRight()+1,node.getSmallMonkeysRight(),node.getBigMonkeysRight(),Bank.LEFT,Driver.PERSON),node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() + 1, node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() - 1, Bank.LEFT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft() + 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() + 1, node.getPeopleRight() - 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight() - 1, Bank.LEFT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft() + 1, node.getBigMonkeysLeft() + 1, node.getPeopleRight(), node.getSmallMonkeysRight() - 1, node.getBigMonkeysRight() - 1, Bank.LEFT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() + 2, node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() - 2, Bank.LEFT, Driver.MONKEY), node);

            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() , node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() - 1, Bank.LEFT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft() + 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() , node.getPeopleRight() - 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight() - 1, Bank.LEFT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft() + 1, node.getBigMonkeysLeft(), node.getPeopleRight(), node.getSmallMonkeysRight() - 1, node.getBigMonkeysRight() - 1, Bank.LEFT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() + 1, node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() - 2, Bank.LEFT, Driver.MONKEY), node);

        }
        return nodes;
    }
    ArrayList<Node> generateeMPTY(Node node) {
        ArrayList<Node> nodes = new ArrayList<>();
        if (node.getPos() == Bank.LEFT) {
//driver person
            createNode(nodes, new Node(node.getPeopleLeft() - 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft(), node.getPeopleRight() , node.getSmallMonkeysRight(), node.getBigMonkeysRight(), Bank.RIGHT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() - 1, node.getSmallMonkeysLeft() - 1, node.getBigMonkeysLeft(), node.getPeopleRight() , node.getSmallMonkeysRight() + 1, node.getBigMonkeysRight(), Bank.RIGHT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() - 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() - 1, node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() + 1, Bank.RIGHT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() - 2, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft(), node.getPeopleRight() + 2, node.getSmallMonkeysRight(), node.getBigMonkeysRight(),Bank.RIGHT, Driver.PERSON), node);

            createNode(nodes, new Node(node.getPeopleLeft() - 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft(), node.getPeopleRight() + 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight(), Bank.RIGHT, Driver.PERSON), node);
            /*createNode(nodes, new Node(node.getPeopleLeft() - 1, node.getSmallMonkeysLeft() - 1, node.getBigMonkeysLeft(), node.getPeopleRight() + 1, node.getSmallMonkeysRight() + 1, node.getBigMonkeysRight(), Bank.RIGHT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() - 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() - 1, node.getPeopleRight() + 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight() + 1, Bank.RIGHT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() - 2, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft(), node.getPeopleRight() + 2, node.getSmallMonkeysRight(), node.getBigMonkeysRight(),Bank.RIGHT, Driver.PERSON), node);
*/

//driver monkey

            //createNode(nodes,new Node(node.getPeopleLeft(),node.getSmallMonkeysLeft(),node.getBigMonkeysLeft(),node.getPeopleRight()+1,node.getSmallMonkeysRight(),node.getBigMonkeysRight(),Bank.LEFT,Driver.PERSON),node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() - 1, node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() ,Bank.RIGHT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft() - 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() - 1, node.getPeopleRight() + 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight() ,Bank.RIGHT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft() - 1, node.getBigMonkeysLeft() - 1, node.getPeopleRight(), node.getSmallMonkeysRight() + 1, node.getBigMonkeysRight() ,Bank.RIGHT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() - 2, node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() + 2,Bank.RIGHT, Driver.MONKEY), node);

            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() - 1, node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() + 1,Bank.RIGHT, Driver.MONKEY), node);
           /* createNode(nodes, new Node(node.getPeopleLeft() - 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() - 1, node.getPeopleRight() + 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight() + 1,Bank.RIGHT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft() - 1, node.getBigMonkeysLeft() - 1, node.getPeopleRight(), node.getSmallMonkeysRight() + 1, node.getBigMonkeysRight() + 1,Bank.RIGHT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() - 2, node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() + 2,Bank.RIGHT, Driver.MONKEY), node);
*/
            //  createNode(nodes,new Node(),node);
        } else {
//driver person
            createNode(nodes, new Node(node.getPeopleLeft() , node.getSmallMonkeysLeft(), node.getBigMonkeysLeft(), node.getPeopleRight() - 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight(), Bank.LEFT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft() , node.getSmallMonkeysLeft() + 1, node.getBigMonkeysLeft(), node.getPeopleRight() - 1, node.getSmallMonkeysRight() - 1, node.getBigMonkeysRight(), Bank.LEFT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() , node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() + 1, node.getPeopleRight() - 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight() - 1, Bank.LEFT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() + 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft(), node.getPeopleRight() - 2, node.getSmallMonkeysRight(), node.getBigMonkeysRight(), Bank.LEFT, Driver.PERSON), node);


            createNode(nodes, new Node(node.getPeopleLeft() + 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft(), node.getPeopleRight() - 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight(), Bank.LEFT, Driver.MONKEY), node);
            /*createNode(nodes, new Node(node.getPeopleLeft() + 1, node.getSmallMonkeysLeft() + 1, node.getBigMonkeysLeft(), node.getPeopleRight() - 1, node.getSmallMonkeysRight() - 1, node.getBigMonkeysRight(), Bank.LEFT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() + 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() + 1, node.getPeopleRight() - 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight() - 1, Bank.LEFT, Driver.PERSON), node);
            createNode(nodes, new Node(node.getPeopleLeft() + 2, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft(), node.getPeopleRight() - 2, node.getSmallMonkeysRight(), node.getBigMonkeysRight(), Bank.LEFT, Driver.PERSON), node);
*/
//driver monkey

            //createNode(nodes,new Node(node.getPeopleLeft(),node.getSmallMonkeysLeft(),node.getBigMonkeysLeft(),node.getPeopleRight()+1,node.getSmallMonkeysRight(),node.getBigMonkeysRight(),Bank.LEFT,Driver.PERSON),node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() + 1, node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() - 1, Bank.LEFT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft() + 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() + 1, node.getPeopleRight() - 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight() - 1, Bank.LEFT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft() + 1, node.getBigMonkeysLeft() + 1, node.getPeopleRight(), node.getSmallMonkeysRight() - 1, node.getBigMonkeysRight() - 1, Bank.LEFT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() + 2, node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() - 2, Bank.LEFT, Driver.MONKEY), node);

            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft(), node.getBigMonkeysLeft()+1 , node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() - 1, Bank.LEFT, Driver.MONKEY), node);
            /*createNode(nodes, new Node(node.getPeopleLeft() + 1, node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() , node.getPeopleRight() - 1, node.getSmallMonkeysRight(), node.getBigMonkeysRight() - 1, Bank.LEFT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft() + 1, node.getBigMonkeysLeft(), node.getPeopleRight(), node.getSmallMonkeysRight() - 1, node.getBigMonkeysRight() - 1, Bank.LEFT, Driver.MONKEY), node);
            createNode(nodes, new Node(node.getPeopleLeft(), node.getSmallMonkeysLeft(), node.getBigMonkeysLeft() + 1, node.getPeopleRight(), node.getSmallMonkeysRight(), node.getBigMonkeysRight() - 2, Bank.LEFT, Driver.MONKEY), node);
*/
        }
        return nodes;
    }
}
