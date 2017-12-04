package com.asher.play;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * ģ��������Сè������Ϸ��1-9��
 * �ж�˭�ȳ���˭��ʤ
 * @author AsherTree
 */
public class Poker {
	public static void main(String[] args) {
		Stack<Integer> deskStack = new Stack<>();//�����ϵ��ƣ���ջ���й���
        Queue<Integer> playerA = new LinkedList();//�ö��й���ÿ��ѡ�ֵ���
        Queue<Integer> playerB = new LinkedList();
        int book[] = new int[10];
        Scanner scanner = new Scanner(System.in);
        System.out.println("��A����-->");
        /*��ʼ���ƣ�ÿ��6��*/
        for (int i = 0; i < 6; i++) {
        	System.out.println("��" + Integer.valueOf(i+1) +"��");
            playerA.add(scanner.nextInt());
        }
        System.out.println("��B����-->");
        for (int i = 0; i < 6; i++) {
        	System.out.println("��" + Integer.valueOf(i+1) +"��");
            playerB.add(scanner.nextInt());
        }
        /*���������ж���Ϊ�գ���ʾ��Ϸû�н���*/
        while (!playerA.isEmpty() && !playerB.isEmpty()) {
            int ta = playerA.peek();//A��һ����
            //�ж�A�������ܲ���Ӯ��
            if (book[ta] == 0) {//������û��������
                //A����Ӯ��
                playerA.remove();//������Ƴ�����
                deskStack.add(ta);//���������ջ
                book[ta] = 1;//��Ǵ�����Ƴ�����������
            }else {
            	//A��Ӯ��
                playerA.remove();//������Ƴ�����
                playerA.add(ta);//������������
                while (deskStack.lastElement()!=ta) {
                    book[deskStack.lastElement()] = 0;
                    playerA.add(deskStack.lastElement());
                    deskStack.pop();
                }
            }
            int tb = playerB.peek();//B��һ����
            //�ж�B�������ܲ���Ӯ��
            if (book[tb] == 0) {//������û��������
                //B����Ӯ��
                playerB.remove();//������Ƴ�����
                deskStack.add(tb);//���������ջ
                book[tb] = 1;//��Ǵ�����Ƴ�����������
            }else {//B��Ӯ��
                playerB.remove();//������Ƴ�����
                playerB.add(tb);//������������
                while (deskStack.lastElement()!=tb) {
                    book[deskStack.lastElement()] = 0;
                    playerB.add(deskStack.lastElement());
                    deskStack.pop();
                }
            }
        }
        if (playerA.isEmpty()) {
            System.out.println("BӮ��");
            System.out.print("B���е���Ϊ��");
            while (!playerB.isEmpty()) {
                System.out.print(playerB.peek()+" ");
                playerB.remove();
            }



        }else {
            System.out.println("AӮ��");
            System.out.print("A���е���Ϊ��");
            while (!playerA.isEmpty()) {
                System.out.print(playerA.peek()+" ");
                playerA.remove();
            }
        }
        System.out.println("");
        System.out.print("�����ϵ���Ϊ��");
        while (!deskStack.isEmpty()) {
            System.out.print(deskStack.lastElement()+" ");
            deskStack.pop();
        }

    }

}