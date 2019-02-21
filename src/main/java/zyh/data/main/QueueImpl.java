package zyh.data.main;

import zyh.data.service.LinkList;
import zyh.data.service.Queue;

public class QueueImpl implements Queue {

    private LinkList linkList = new LinkListImpl();
    @Override
    public void put(int data) {
        linkList.insert(1,data);
    }

    @Override
    public int pop() {
        int data = linkList.get(linkList.getSize());
        linkList.delete(linkList.getSize());
        return data;
    }
    @Override
    public void display(){
        if(linkList.getSize()==0){
            return;
        }else{
            linkList.display();
        }
    }
}
