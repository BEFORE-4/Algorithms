package test.chap1.chap1_3;

import edu.princeton.cs.algs4.StdOut;

public class Test1_3_35 {
    public static void main(String[] args) {
        RandomQueue<Card> cards = getCards();   //所有牌
        RandomQueue<Card>[] persons = new RandomQueue[4];//四个人
        /*
        //测试随机迭代器
        for (int i = 0; i < 3; i++) {
            StdOut.println("==========" + i + "================");
            for (Card card :
                    cards) {
                StdOut.println(card);
            }
        }*/
        for (int i = 0; i < persons.length; i++) {
            persons[i] = new RandomQueue<>();
            for (int j = 0; j < 13; j++) {
                persons[i].enqueue(cards.dequeue());
            }
        }
        for (int i = 0; i < persons.length; i++) {
            StdOut.println("==================person" + (i + 1) + "的牌是=============");
            for (Card card :
                    persons[i]) {
                StdOut.println(card);
            }
        }
    }

    /**
     * 得到所有牌
     * @return 52张牌
     */
    private static RandomQueue<Card> getCards(){
        RandomQueue<Card> cards = new RandomQueue<>();
        for (int i = 0; i < 4; i++) {
            String color = getColor(i);
            for (int j = 0; j < 13; j++) {
                Card card = new Card(j, color);
                cards.enqueue(card);
            }
        }
        return cards;
    }

    /**
     * 通过参数返回牌的花色
     * @param num   获取牌花色的参数
     * @return 牌的花色
     */
    private static String getColor(int num){
        switch (num){
            case 0:
                return "heart";
            case 1:
                return "spade";
            case 2:
                return "diamond";
            default:
                return "club";
        }
    }
}
class Card{
    private int value;
    private String color;

    public Card(int value, String color) {
        this.value = value;
        this.color = color;
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", color='" + color + '\'' +
                '}';
    }
}
