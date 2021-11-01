package day20211031;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Card{
    private int rank;
    private String suit;
    public Card(int rank,String suit){
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return " [数值: " + rank + "花色: " + suit + "] ";
    }
}

class CardDemo{
    private static final String[] suits = {"♥","♠","♦","♣"};

    public List<Card> buyDesk(){
        List<Card> desk = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                int rank = j;
                String suit = suits[i];
                Card card = new Card(rank,suit);
                desk.add(card);
            }
        }
        return desk;

    }

    public void swap(List<Card> desk,int i,int index){
        //错误写法: Card tmp = desk[i];
        Card tmp = desk.get(i);
        //desk[i] = desk[index];
        desk.set(i,desk.get(index));
        //desk[index] = tmp;
        desk.set(index,tmp);
    }
    public void shuffle(List<Card> desk){
        int len = desk.size();
        for(int i = len-1; i > 0 ; i--){
            Random random = new Random();
            int index = random.nextInt(i);
            swap(desk,i,index);
        }

    }
}
public class TestDemo {
    public static void main(String[] args) {
        CardDemo cardDemo = new CardDemo();
        List<Card> desk = cardDemo.buyDesk();
        System.out.println(desk);
        System.out.println("洗牌: ");
        cardDemo.shuffle(desk);
        System.out.println(desk);

        System.out.println("开始玩: (揭牌)");
        //3个人每个人轮流抓5张牌

        ArrayList<Card> hand1 = new ArrayList<>();
        ArrayList<Card> hand2 = new ArrayList<>();
        ArrayList<Card> hand3 = new ArrayList<>();

        ArrayList< ArrayList<Card> > hand = new ArrayList<>();
        hand.add(hand1);
        hand.add(hand2);
        hand.add(hand3);

        //三个人 每人轮流抓5张牌 若把外层循环为人,这个循环代表,每个人一口气揭五张牌
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                Card card = desk.remove(0);
                hand.get(j).add(card);

            }
        }
        System.out.println("===============");
        for (int i = 0; i < hand.size(); i++) {
            System.out.println(hand.get(i));

        }
        System.out.println("=========剩下的牌=======");
        System.out.println(desk);

    }

}
