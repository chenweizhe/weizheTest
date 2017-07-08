package weizheTest;

/** 
 * 0-1背包问题 
 * 
 */  
  
  
/** 
 * 子集空间树中结点类型为BBnode 
 * 
 */  
class BBnode{  
    BBnode parent;//父节点  
    boolean leftChild;//左儿子结点标志  
      
    public BBnode(BBnode par,boolean left){  
        parent=par;  
        leftChild=left;  
    }  
}  
  
/** 
 * 优先级队列的结点 
 * 
 */  
class HeapNode implements Comparable<Object>{  
    BBnode liveNode;//活结点  
    double upperProfit;//结点的价值上界  
    double profit;//结点所相应的价值  
    double weight;//结点所相应的重量  
    int level;//活结点在子集树种所处的层序号  
      
    //构造方法  
    HeapNode(BBnode node,double up,double pp,double ww,int lev){  
        liveNode=node;  
        upperProfit=up;  
        profit=pp;  
        weight=ww;  
        level=lev;  
    }  
  
    @Override  
    public int compareTo(Object x) {//降序排列  
        double xs=((HeapNode) x).upperProfit;  
        if(upperProfit>xs) return -1;  
        if(upperProfit==xs) return 0;  
        return 1;  
    }  
}  
  
  
  
/** 
 * 每个背包的类 
 * 
 */  
class Element implements Comparable<Object>{  
    int id;//背包编号  
    double d;//单位重量价值  
      
    public Element(int id,double d){  
        this.id=id;  
        this.d=d;  
    }  
  
    @Override  
    public int compareTo(Object o) {//降序排列  
        double xs=((Element) o).d;  
        if(d>xs) return -1;  
        if(d==xs) return 0;  
        return 1;  
    }  
    public boolean equals(Object o){  
        return d==((Element) o).d;  
    }  
}  
  
  
